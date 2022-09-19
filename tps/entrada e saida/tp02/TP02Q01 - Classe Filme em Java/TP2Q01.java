import java.io.*;
import java.util.*;
import java.text.*;

class Game {

    // atributos privados
    private int app_id, age, dlcs, avg, pt;
    private String name, owners, website, developers;
    private float price, upvotes;
    private boolean windows, mac, linux;
    private String[] languages = new String[100];
    private String[] genres = new String[100];
    private Date release_date = new Date();

    // construtor padrao
    Game() {

    }

    // construtor com parametros
    Game(int app_id, String name, Date release_date, String owners, int age, float price, int dlcs,
            String[] languages, int avg, int pt,
            String website, boolean windows,
            boolean mac, boolean linux, float upvotes, String developers, String[] genres) {
        this.app_id = app_id;
        this.name = name;
        this.release_date = release_date;
        this.owners = owners;
        this.age = age;
        this.price = price;
        this.dlcs = dlcs;
        this.languages = languages;
        this.website = website;
        this.windows = windows;
        this.mac = mac;
        this.linux = linux;
        this.upvotes = upvotes;
        this.avg = avg;
        this.pt = pt;
        this.developers = developers;
        this.genres = genres;

    }

    // metodos set

    void setAppId(int app_id) {
        this.app_id = app_id;
    }

    void setName(String name) {
        this.name = name;
    }

    void setReleaseDate(Date release_date) {
        this.release_date = release_date;
    }

    void setOwners(String owners) {
        this.owners = owners;
    }

    void setAge(int age) {
        this.age = age;
    }

    void setPrice(float price) {
        this.price = price;
    }

    void setDlcs(int dlcs) {
        this.dlcs = dlcs;
    }

    void setLanguages(String[] languages) {
        this.languages = languages;
    }

    void setWebsite(String website) {
        this.website = website;
    }

    void setWindows(Boolean windows) {
        this.windows = windows;
    }

    void setMac(Boolean mac) {
        this.mac = mac;
    }

    void setLinux(Boolean linux) {
        this.linux = linux;
    }

    void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    void setAvg(int avg) {
        this.avg = avg;
    }

    void setPt(int pt) {
        this.pt = pt;
    }

    void setDevelopers(String developers) {
        this.developers = developers;
    }

    void setGenres(String[] genres) {
        this.genres = genres;
    }

    // METODOS GET

    int getAppId() {
        return app_id;
    }

    String getName() {
        return name;
    }

    String getOwners() {
        return owners;
    }

    int getAge() {
        return age;
    }

    float getPrice() {
        return price;
    }

    int getDlcs() {
        return dlcs;
    }

    String[] getLanguages() {

        return languages;

    }

    String getWebsite() {
        return website;
    }

    boolean getWindows() {
        return windows;
    }

    boolean getMac() {
        return mac;
    }

    boolean getLinux() {
        return linux;
    }

    float getUpvotes() {
        return upvotes;
    }

    int getAvg() {
        return avg;
    }

    int getPt() {
        return pt;
    }

    String getDevelopers() {
        return developers;
    }

    String[] getGenres() {
        return genres;
    }

    // METODO DE CLONE
    public Game clone() {
        Game gameClonado = new Game();

        gameClonado.name = this.name;
        gameClonado.owners = this.owners;
        gameClonado.website = this.website;
        gameClonado.developers = this.developers;
        gameClonado.languages = this.languages;
        gameClonado.genres = this.genres;
        gameClonado.app_id = this.app_id;
        gameClonado.age = this.age;
        gameClonado.dlcs = this.dlcs;
        gameClonado.avg = this.avg;
        gameClonado.pt = this.pt;
        gameClonado.price = this.price;
        gameClonado.upvotes = this.upvotes;
        gameClonado.windows = this.windows;
        gameClonado.mac = this.mac;
        gameClonado.linux = this.linux;
        gameClonado.release_date = this.release_date;

        return gameClonado;
    }

    // METODO DE DEFINIÇÃO DOS DADOS

    void setData(String entrada) throws Exception {
        int contador = 0;
        String[] vet = entrada.split(",");

        this.app_id = Integer.parseInt(vet[contador]);
        contador++;

        this.name = vet[contador];
        contador++;

        String dateAux = "";
        if (vet[contador].contains("\"")) {
            dateAux = vet[contador].substring(1, 4) + " " + vet[contador + 1].substring(1, 5);
            contador += 2;

        } else {
            dateAux = vet[contador];
            contador++;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("MMM yyyy", Locale.US);
        try {
            this.release_date = formatter.parse(dateAux);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.owners = vet[contador];
        contador++;

        this.age = Integer.parseInt(vet[contador]);
        contador++;

        this.price = Float.parseFloat(vet[contador]);
        contador++;

        this.dlcs = Integer.parseInt(vet[contador]);
        contador++;

        int contador2 = 0;

        if (vet[contador].contains("\"")) {
            languages[contador2] = vet[contador];
            languages[contador2] = languages[contador2].replaceAll("\"", "");
            languages[contador2] = languages[contador2].replaceAll("[\\[\\]]", "");
            languages[contador2] = languages[contador2].replaceAll("'", "");
            contador++;
            contador2++;

            while (vet[contador].contains("\"") == false) {
                languages[contador2] = vet[contador];
                languages[contador2] = languages[contador2].replaceAll("'", "");
                contador++;
                contador2++;

            }

            languages[contador2] = vet[contador];
            languages[contador2] = languages[contador2].replaceAll("'", "");
            languages[contador2] = languages[contador2].replaceAll("]", "");
            languages[contador2] = languages[contador2].replaceAll("\"", "");
            contador++;

        } else {
            languages[contador2] = vet[contador];
            languages[contador2] = languages[contador2].replaceAll("\"", "");
            languages[contador2] = languages[contador2].replaceAll("[\\[\\]]", "");
            languages[contador2] = languages[contador2].replaceAll("'", "");
            contador++;
        }

        if (vet[contador].length() == 0) {
            this.website = null;
        } else {
            this.website = vet[contador];
        }
        contador++;

        this.windows = Boolean.parseBoolean(vet[contador]);
        contador++;
        this.mac = Boolean.parseBoolean(vet[contador]);
        contador++;
        this.linux = Boolean.parseBoolean(vet[contador]);
        contador++;

        float val1 = Float.parseFloat(vet[contador]);
        contador++;
        float val2 = Float.parseFloat(vet[contador]);
        contador++;
        upvotes = (val1 * 100) / (val1 + val2);

        float aux = Float.parseFloat(vet[contador]);
        aux /= 60;
        this.avg = (int) aux;
        float min = aux - avg;
        min *= 60;
        this.pt = (int) Math.round(min);
        contador++;

        if (vet[contador].contains("\"")) {
            developers = vet[contador];
            contador++;
            while (vet[contador].contains("\"") == false) {
                developers += vet[contador];
                contador++;
            }
            developers += vet[contador];
            contador++;

        } else {
            developers = vet[contador];
            contador++;
        }
        this.developers = developers.replaceAll("\"", "");

        int contador3 = 0;

        if (vet[contador].contains("\"")) {
            genres[contador3] = vet[contador];
            genres[contador3] = genres[contador3].replaceAll("\"", "");
            contador++;
            contador3++;

            while (vet[contador].contains("\"") == false) {

                genres[contador3] = vet[contador];
                contador3++;
                contador++;
            }
            genres[contador3] = vet[contador];
            genres[contador3] = genres[contador3].replaceAll("\"", "");
        } else {
            genres[contador3] = vet[contador];
        }

    }

    // METODO PARA IMPRIMIR OS DADOS
    public void printData() {
        System.out.print(app_id + " ");
        System.out.print(name + " ");

        SimpleDateFormat newFormat = new SimpleDateFormat("MMM/yyyy", Locale.US);

        String formaterDate = null;
        formaterDate = newFormat.format(release_date);
        System.out.print(formaterDate + " ");

        System.out.print(owners + " ");

        System.out.print(age + " ");

        System.out.print(price + " ");

        System.out.print(dlcs + " ");

        System.out.print("[");
        int i = 0;
        while (languages[i] != null) {
            i++;
        }
        for (int k = 0; k < i - 1; k++) {
            System.out.print(languages[k]);
            System.out.print(",");
        }
        System.out.print(languages[i - 1] + "] ");

        if (website == "") {
            System.out.print("null ");
        } else {
            System.out.print(website + " ");
        }

        System.out.print(windows + " ");

        System.out.print(mac + " ");

        System.out.print(linux + " ");

        System.out.print((int) Math.round(upvotes) + "% ");

        if (avg == 0 && pt == 0) {
            System.out.print("null ");
        } else if (avg == 0) {
            System.out.print(pt + "m ");
        } else if (pt == 0) {
            System.out.print(avg + "h ");
        } else {
            System.out.print(avg + "h " + pt + "m ");
        }

        System.out.print(developers + " ");

        System.out.print("[");
        int j = 0;
        while (genres[j] != null) {
            j++;
        }

        for (int k = 0; k < j - 1; k++) {

            System.out.print(genres[k]);
            System.out.print(", ");
        }
        System.out.print(genres[j - 1] + "]");

        System.out.println();

    }

}

class TP2Q01 {

    public static boolean isFim(String s) {
        return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M'); // verifica se o
                                                                                                    // pub.in chegou ao
                                                                                                    // FIM
    }

    public static void main(String[] args) throws Exception {

        String arquivo = "/tmp/games.csv";
        BufferedReader br = null;
        String linha[] = new String[5000];
        String[] entrada = new String[2000];
        String id[] = new String[5000];
        int numEntrada = 0, i = 0;

        // entrada de dados vinda do games.csv
        try {

            br = new BufferedReader(new FileReader(arquivo));
            while ((linha[i] = br.readLine()) != null) {
                String aux = linha[i];
                String separador[] = aux.split(",");

                id[i] = separador[0];

                i++;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // entrada de dados vinda do pub.in
        do {
            entrada[numEntrada] = MyIO.readLine();

        } while (isFim(entrada[numEntrada++]) == false);
        numEntrada--;
        i--;

        for (int j = 0; j < numEntrada; j++) {
            for (int k = 0; k < i; k++) {
                if (entrada[j].equals(id[k])) {
                    Game game = new Game();
                    game.setData(linha[k]);
                    game.printData();
                    break;
                }
            }
        }

    }

}