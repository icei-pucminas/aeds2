/**
 
 * @file Game.java
 * @author Pedro Lopes
 * @version 1.0
 * @date 2022-10-17
 * @copyright Copyright (c) 2022
 
**/

// ----------------------------------------------------------------------------------------------------------------- //

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

// ----------------------------------------------------------------------------------------------------------------- //

class GameList {

    private Game[] array;
    private int n;
 
    public GameList() {}
 
    public GameList(int size) {

        array = new Game[size];
        n = 0;
    }

    public void print() { 
        
        for(int i = 0; i < n; i++) {
            
            System.out.print("[" + i + "] ");

            array[i].print();
        }
    }

    public void insertBegin(Game game) throws Exception {
 
        if(n >= array.length) throw new Exception("x Insert error: Full list!"); 
 
        for(int i = n; i > 0; i--) array[i] = array[i - 1];
 
        array[0] = game;
        n++;
    }
 
    public void insertEnd(Game game) throws Exception {
 
        if(n >= array.length) throw new Exception("x Insert error: Full list"); 
 
        array[n] = game;
        n++;
    }
 
    public void insert(Game game, int pos) throws Exception {
 
        if(n >= array.length || pos < 0 || pos > n) throw new Exception("x Insert error: Full list / Invalid pos");

        for(int i = n; i > pos; i--) array[i] = array[i - 1];
       
        array[pos] = game;
        n++;
    }
 
    public Game removeBegin() throws Exception {
 
        if(n == 0) throw new Exception("x Remove error: Empty list");
 
        Game resp = array[0];
        n--;
 
        for(int i = 0; i < n; i++) array[i] = array[i + 1];
        return resp;
    }
 
    public Game removeEnd() throws Exception {
 
        if(n == 0) throw new Exception("x Remove error: Empty list");
        return array[--n];
    }
 
    public Game remove(int pos) throws Exception {
 
        if(n == 0 || pos < 0 || pos >= n) throw new Exception("x Remove error: Empty list / Invalid pos");
       
        Game resp = array[pos];
        n--;
 
        for(int i = pos; i < n; i++) array[i] = array[i + 1];
        return resp;
    }
}
 
// ----------------------------------------------------------------------------------------------------------------- //

class Game {

    static SimpleDateFormat default_dateFormat = new SimpleDateFormat("MMM/yyyy", Locale.ENGLISH);

    private String name, owners, website, developers;
    private ArrayList<String> languages, genres;
    private Date release_date;
    private int app_id, age, dlcs, avg_playtime;
    private float price, upvotes;
    private boolean windows, mac, linux;

    public Game() {

        this.name = this.owners = this.website = this.developers = null;
        this.languages = new ArrayList<String>();
        this.genres = new ArrayList<String>();
        this.release_date = null;
        this.app_id = this.age = this.dlcs = this.avg_playtime = -1;
        this.price = this.upvotes = -1;
        this.windows = this.mac = this.linux = false;
    }

    public Game(String name, String owners, String website, String developers, ArrayList<String> languages, ArrayList<String> genres, Date release_date, int app_id, int age, int dlcs, int upvotes, int avg_playtime, float price, boolean windows, boolean mac, boolean linux) {

        this.name = name;
        this.owners = owners;
        this.website = website;
        this.developers = developers;
        this.languages = languages;
        this.genres = genres;
        this.release_date = release_date;
        this.app_id = app_id;
        this.age = age;
        this.dlcs = dlcs;
        this.upvotes = upvotes;
        this.avg_playtime = avg_playtime;
        this.price = price;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
    }

    public void setName(String name) { this.name = name; }
    public void setOwners(String owners) { this.owners = owners; }
    public void setWebsite(String website) { this.website = website; }
    public void setDevelopers(String developers) { this.developers = developers; }
    public void setLanguages(ArrayList<String> languages) { this.languages = languages; }
    public void setGenres(ArrayList<String> genres) { this.genres = genres; }
    public void setReleaseDate(Date release_date) { this.release_date = release_date; }
    public void setAppId(int app_id) { this.app_id = app_id; }
    public void setAge(int age) { this.age = age; }
    public void setDlcs(int dlcs) { this.dlcs = dlcs; }
    public void setAvgPlaytime(int avg_playtime) { this.avg_playtime = avg_playtime; }
    public void setPrice(float price) { this.price = price; }
    public void setUpvotes(float upvotes) { this.upvotes = upvotes; }
    public void setWindows(boolean windows) { this.windows = windows; }
    public void setMac(boolean mac) { this.mac = mac; }
    public void setLinux(boolean linux) { this.linux = linux; }

    public String getName() { return this.name; }
    public String getOwners() { return this.owners; }
    public String getWebsite() { return this.website; }
    public String getDevelopers() { return this.developers; }
    public ArrayList<String> getLanguages() { return this.languages; }
    public ArrayList<String> getGenres() { return this.genres; }
    public Date getReleaseDate() { return this.release_date; }
    public int getAppId() { return this.app_id; }
    public int getAge() { return this.age; }
    public int getDlcs() { return this.dlcs; }
    public int getAvgPlaytime() { return this.avg_playtime; }
    public float getPrice() { return this.price; }
    public float getUpvotes() { return this.upvotes; }
    public boolean getWindows() { return this.windows; }
    public boolean getMac() { return this.mac; }
    public boolean getLinux() { return this.linux; }
    
    public Game clone() {

        Game cloned = new Game();

        cloned.name = this.name;
        cloned.owners = this.owners;
        cloned.website = this.website;
        cloned.developers = this.developers;
        cloned.languages = this.languages;
        cloned.genres = this.genres;
        cloned.release_date = this.release_date;
        cloned.app_id = this.app_id;
        cloned.age = this.age;
        cloned.dlcs = this.dlcs;
        cloned.avg_playtime = this.avg_playtime;
        cloned.price = this.price;
        cloned.upvotes = this.upvotes;
        cloned.windows = this.windows;
        cloned.mac = this.mac;
        cloned.linux = this.linux;

        return cloned;
    }

    public static Game gameSearch(ArrayList<Game> games, int app_id) {

        for(Game game : games) if(game.getAppId() == app_id) return game;
        return null;
    }

    public void read(String line) {

        char c_search;
        int index = 0, atr_index = 0;

        // ---------------------------------- //

        // Find "AppID"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.app_id = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Name"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.name = line.substring(atr_index, index);

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find release date
        if(line.charAt(atr_index) != ',') {

            SimpleDateFormat df;
            
            if(line.charAt(atr_index) == '\"') {
                
                df = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);

                atr_index++;
                c_search = '\"';
            }
            else {
                
                df = new SimpleDateFormat("MMM yyyy", Locale.ENGLISH);

                c_search = ',';
            }

            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    try { this.release_date = df.parse(line.substring(atr_index, index)); } 
                    catch (java.text.ParseException e) { e.printStackTrace(); }

                    if(c_search == ',') index++;
                    else if(c_search == '\"') index += 2;
                    
                    atr_index = index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Owners"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.owners = line.substring(atr_index, index);

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Age"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.age = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Price"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.price = Float.parseFloat(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "DLCs"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {
                
                this.dlcs = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Languages"
        while(true) {

            index++;

            if(line.charAt(index) == ']') {

                index++;
                
                if(line.charAt(index) == ',') index++;
                else if(line.charAt(index) == '\"') index += 2;

                atr_index = index;
                break;
            }
            else if(line.charAt(index) == '\'') {

                int wordStart = index + 1;

                while(true) {

                    index++;

                    if(line.charAt(index) == '\'') {
                        
                        this.languages.add(line.substring(wordStart, index));
                        break;
                    }
                }
            }
        }

        // ---------------------------------- //
        
        // Find "Website"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.website = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;

        // ---------------------------------- //
        
        // Find "Windows"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.windows = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Mac"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.mac = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // Find "Linux"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.linux = Boolean.parseBoolean(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Upvotes"
        int positives, negatives;

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                positives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                negatives = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        this.upvotes = (float)(positives * 100) / (float)(positives + negatives);

        // ---------------------------------- //
        
        // Find "AVG Playtime"
        while(true) {

            index++;

            if(line.charAt(index) == ',') {

                this.avg_playtime = Integer.parseInt(line.substring(atr_index, index));

                atr_index = ++index;
                break;
            }
        }

        // ---------------------------------- //
        
        // Find "Developers"
        if(line.charAt(atr_index) != ',') {

            if(line.charAt(atr_index) == '\"') {
                
                atr_index++;
                c_search = '\"';
            }
            else c_search = ',';
            
            while(true) {

                index++;

                if(line.charAt(index) == c_search) {
                    
                    this.developers = line.substring(atr_index, index);

                    atr_index = ++index;
                    break;
                }
            }
        }
        else atr_index = ++index;
       
        // ---------------------------------- //
        
        // Find "Genres"
        if(index < line.length() - 1) {

            if(line.charAt(index) == ',') atr_index = ++index;                    
            if(line.charAt(atr_index) == '\"') {

                atr_index++;
                
                while(true) {

                    index++;

                    if(line.charAt(index) == ',') {
                        
                        this.genres.add(line.substring(atr_index, index));

                        atr_index = ++index;
                    }
                    else if(line.charAt(index) == '\"') {

                        this.genres.add(line.substring(atr_index, line.length() - 1));
                        break;
                    }
                }
            }
            else this.genres.add(line.substring(atr_index, line.length()));
        }

        // -------------------------------------------------------------------------------- //
    }

    public void print() {

        String avg_pt = null;

        if(this.avg_playtime == 0) avg_pt = "null ";
        else if(this.avg_playtime < 60) avg_pt = this.avg_playtime + "m ";
        else {

            if(this.avg_playtime % 60 == 0) avg_pt = this.avg_playtime / 60 + "h ";
            else avg_pt = (this.avg_playtime / 60) + "h " + (this.avg_playtime % 60) + "m ";
        }

        DecimalFormat df = new DecimalFormat("##");

        System.out.println(this.app_id + " " + this.name + " " + default_dateFormat.format(this.release_date) + " " + this.owners + " " + this.age + " " + String.format(Locale.ENGLISH, "%.2f", this.price) + " " + this.dlcs + " " + this.languages + " " + this.website + " " + this.windows + " " + this.mac + " " + this.linux + " " + (Float.isNaN(this.upvotes) ? "0% " : df.format(this.upvotes) + "% ") + avg_pt + this.developers + " " + this.genres);
    }
    
    public static String getGameData(String csvFile, int app_id) throws Exception {

        try {
    
            // Read CSV file
            FileInputStream fstream = new FileInputStream(csvFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    
            // ------------------------------------ //
    
            // Start to explode CSV file
            String line;
    
            while((line = br.readLine()) != null) {
    
                String id_s = Integer.toString(app_id);
    
                if(line.substring(0, line.indexOf(',')).equals(id_s)) {
    
                    fstream.close();
                    br.close();
                    return line;
                }
            }
    
            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
        return null;
    }
    
    // -------------------------------------------------------------------------------------- //
    
    public static void main(String[] args) throws Exception {
    
        Scanner scr = new Scanner(System.in);
        ArrayList<Game> gamesFull = new ArrayList<Game>();
        String line;
                
        // ------------------------------------------------------------------------------ //

        // Fill full games list
        try {

            // Read CSV file
            FileInputStream fstream = new FileInputStream("/tmp/games.csv");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ------------------------------------ //

            // Start to explode CSV file
            while((line = br.readLine()) != null) {

                Game game = new Game();

                game.read(line);
                gamesFull.add(game);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }

        // ---------------------------------------------------------------------------------------------- //
    
        // Fill production games list
        GameList games = new GameList(500);

        line = scr.nextLine();

        while(true) {

            if(line.compareTo("FIM") == 0) break;

            // ------------------------------------ //

            Game found = gameSearch(gamesFull, Integer.parseInt(line));

            if(found != null) games.insertEnd(found);

            // ------------------------------------ //

            line = scr.nextLine();
        }

        // ---------------------------------------------------------------------------------------------- //
    
        // Execute operations
        int n_ops = Integer.parseInt(scr.nextLine());

        for(int x = 0; x < n_ops; x++) {

            line = scr.nextLine();
        
            String op = line.substring(0, 2);
            int app_id;
                
            // -------------------------------- //
    
            // Identify operation
            if(op.equals("II")) {
    
                app_id = Integer.parseInt(line.substring(3, line.length()));

                games.insertBegin(gameSearch(gamesFull, app_id));
            }
            else if(op.equals("IF")) {
    
                app_id = Integer.parseInt(line.substring(3, line.length()));
                
                games.insertEnd(gameSearch(gamesFull, app_id));
            }
            else if(op.equals("I*")) {
    
                int pos = Integer.parseInt(line.substring(3, line.indexOf(" ", 3)));
                app_id = Integer.parseInt(line.substring(line.indexOf(" ", 3) + 1, line.length()));
    
                games.insert(gameSearch(gamesFull, app_id), pos);
            }
            else if(op.equals("RI")) System.out.println("(R) " + games.removeBegin().getName());
            else if(op.equals("RF")) System.out.println("(R) " + games.removeEnd().getName()); 
            else if(op.equals("R*")) {
                
                int pos = Integer.parseInt(line.substring(3, line.length()));
                
                System.out.println("(R) " + games.remove(pos).getName());
            }
        }
    
        games.print();
    
        // ---------------------------------------------------------------------------------------------- //
    
        scr.close();
    }
    
    // ------------------------------------------------------------------------------ //
}