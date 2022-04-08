import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Thiago de Campos Ribeiro Nolasco
 */
public class Film {
    // Attributes
    private String name;
    private String ogTitle;
    private Date releaseDate;
    private Integer duration;
    private String genre;
    private String ogLanguage;
    private String situation;
    private Float budget;
    private String[] arrKeyWds;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    // Constructors
    public Film() {
        this(null, null, null, null, null, null, null, null);
    }

    /**
     * @param name
     * @param ogTitle
     * @param releaseDate
     * @param duration
     * @param genre
     * @param ogLanguage
     * @param situation
     * @param budget
     */
    public Film(String name, String ogTitle, Date releaseDate, Integer duration, String genre, String ogLanguage, String situation, Float budget) {
        this.name = name;
        this.ogTitle = ogTitle;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.genre = genre;
        this.ogLanguage = ogLanguage;
        this.situation = situation;
        this.budget = budget;
        this.arrKeyWds = null;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOgTitle() {
        return ogTitle;
    }

    public void setOgTitle(String ogTitle) {
        this.ogTitle = ogTitle;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getOgLanguage() {
        return ogLanguage;
    }

    public void setOgLanguage(String ogLanguage) {
        this.ogLanguage = ogLanguage;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    public String[] getArrKeyWds() {
        return arrKeyWds;
    }

    public void setArrKeyWds(String[] arrKeyWds) {
        this.arrKeyWds = arrKeyWds;
    }

    public Film clone(){
        Film cloned = new Film();

        cloned.name = this.name;
        cloned.ogTitle = this.ogTitle;
        cloned.releaseDate = this.releaseDate;
        cloned.duration = this.duration;
        cloned.genre = this.genre;
        cloned.ogLanguage = this.ogLanguage;
        cloned.situation = this.situation;
        cloned.budget = this.budget;
        cloned.arrKeyWds = this.arrKeyWds;

        return cloned;
    }


    /**
     * @param fileName
     */
    public void ler(String fileName){
        // Getting the right path for each read file
        String path = "./filmes/" + fileName;

        // Method that will split chunks of the read HTML and will assign the value to each Film's attribute
        splittingString(path);
    }

    private void splittingString(String path){
        // Data declaration
        String line = "";

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"))) {

            // Film name
            while(!reader.readLine().contains("title ott"));
            while(!reader.readLine().contains("h2"));
            this.name = removeTags(reader.readLine().trim());

            // Film release date
            while(!reader.readLine().contains("\"release\""));
            this.releaseDate = sdf.parse(removeTags(reader.readLine().trim()));

            // Film genre
            while(!reader.readLine().contains("genres"));
                // In this case, will use "line" because the last readLine will have the content that we want
            while(!(line = reader.readLine()).contains("<a href"));
            this.genre = removeTags(line).trim();

            // Film duration
            while(!reader.readLine().contains("runtime"));
            reader.readLine(); // Needed because an empty line was found
            this.duration = hoursToMinutes(reader.readLine().trim());

            // Film original title (if there is) & situation
            this.ogTitle = this.name;
            while( !(line = reader.readLine()).contains("Situação</bdi>") ) {
                if(line.contains("Título original")){
                    this.ogTitle = removeTags(line.replace("Título original", " ")).trim();
                }
            }
            this.situation = removeTags(line.replace("Situação", " ")).trim();

            // Film original language
            while( !(line = reader.readLine()).contains("Idioma original</bdi>") );
            this.ogLanguage = removeTags(line.replace("Idioma original", " ")).trim();

            // Film budget
            while( !(line = reader.readLine()).contains("Orçamento</bdi>") );
            String aux = removeTags(line.replace("Orçamento", " ")).trim();
            this.budget = (aux.equals("-")) ? 0.0F : convertBudget(aux);

            // Film key-words
            line = "";
            while( !reader.readLine().contains("Palavras-chave</bdi>") );
            while( !(line += reader.readLine().trim() + " ").contains("</ul>") );
            if(!line.contains("Nenhuma palavra-chave foi adicionada")){
                arrKeyWds = removeTags(line).trim().split("  ");
            }


        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("File cannot be read");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Receives a line that contains an HTML content and removes its tags
     * @param line
     * @return
     */
    private String removeTags(String line){
        // Data declaration
        String resp = "";
        int i = 0;

        /*
           The main idea here is to check if the char is equals to '<', if it's, it means that an HTML tag has opened
           So, CAN'T read anything until the tag is closed, '>' is found.

           It's also checking if any HTML special character (&....;) or if any "()" is found
           IF found, don't read anything until it has ended.
         */
        while (i < line.length()) {
            if (line.charAt(i) == '<') {
                i++;
                while (line.charAt(i) != '>') i++;
            }else {
                resp += line.charAt(i);
            }
            i++;
        }
        // Returning cleaned line
        return resp.replace("&nbsp;", "");
    }

    /**
     * Receives a String that contains hours, and convert it to minutes (Integer)
     * @param value
     * @return
     */
    private int hoursToMinutes(String value){
        // Data declaration
        value = removeLetters(value);
        int result = 0, minutes = 0;

        String[] splitValue = value.split(" ");
        if(splitValue.length > 1) {
            int hour = Integer.parseInt(splitValue[0]);
            minutes = Integer.parseInt(splitValue[1]);
            result = (60 * hour) + minutes;
        } else {
            minutes = Integer.parseInt(splitValue[0]);
            result = minutes;
        }

        return result;
    }

    /**
     * Receives a String that contains hours, and leave only the numbers (ex: 1h 49m = 1 49)
     * @param value
     * @return
     */
    private String removeLetters(String value){
        // Data declaration
        String result = "";

        for(int i = 0; i < value.length(); i++){
            // If char is a number, a blank space, or a '.' (Used on convertBudget), will be stored into "result"
            if( (value.charAt(i) >= 48 && value.charAt(i) <= 57) || value.charAt(i) == ' ' || value.charAt(i) == '.')
                result += value.charAt(i);
        }
        return result;
    }

    /**
     * Receives a String that contains a FLOAT number, and converts it to a FLOAT number
     * (PS: It's necessary to remove few characters because String has ',' on it)
     * @param value
     * @return
     */
    private Float convertBudget(String value){
        return Float.parseFloat(removeLetters(value));
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append(name);
        sb.append(" ").append(ogTitle);
        sb.append(" ").append(sdf.format(getReleaseDate()));
        sb.append(" ").append(duration);
        sb.append(" ").append(genre);
        sb.append(" ").append(ogLanguage);
        sb.append(" ").append(situation);
        sb.append(" ").append(budget);
        sb.append(" ").append(arrKeyWds == null ? "[]" : Arrays.asList(arrKeyWds).toString());
        return sb.toString();
    }

    public void imprimir(){
        System.out.println(this.toString());
    }
}
