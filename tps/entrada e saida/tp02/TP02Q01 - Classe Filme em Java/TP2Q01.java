import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

class Game {

    // atributos privados
    private int app_id, age, dlcs, avg_pt;
    private String name, release_date, owners, website, developers;
    private float price, upvotes;
    private boolean windows, mac, linux;
    private String[] languages = new String[100];
    private String[] genres = new String[100];

    // construtor padrao
    Game() {
        app_id = 1;
        age = 0;
        dlcs = 1;
        avg_pt = 10;

        name = "";
        release_date = "";
        owners = "";
        website = "";
        developers = "";
        price = 0.0f;
        upvotes = 0.0f;

        Arrays.fill(languages, "");
        Arrays.fill(genres, "");

    }

    // construtor com parametros
    Game(int app_id, String name, String release_date, String owners, int age, float price, int dlcs,
            String[] languages,
            String website, boolean windows,
            boolean mac, boolean linux, float upvotes, int avg_pt, String developers, String[] genres) {
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
        this.avg_pt = avg_pt;
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

    void setReleaseDate(String release_date) {
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

    void setWindows(boolean windows) {
        this.windows = windows;
    }

    void setMac(boolean mac) {
        this.mac = mac;
    }

    void setLinux(boolean linux) {
        this.linux = linux;
    }

    void setUpvotes(float upvotes) {
        this.upvotes = upvotes;
    }

    void setAvgPt(int avg_pt) {
        this.avg_pt = avg_pt;
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

    // ARRUMAR A DATA
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
        {
            return languages;

        }
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

    int getAvgPt() {
        return avg_pt;
    }

    String getDevelopers() {
        return developers;
    }

    String[] getGenres() {
        return genres;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();

    }

    // METODO DE IMPRESSAO DOS CAMPOS
    void printData() {
        MyIO.println("" + getAppId() + "" + getName() /* + "" + DATA */ + "" + getOwners() + "" + getAge() + ""
                + getPrice() + "" + getDlcs() + "" + getLanguages() + "" + getWebsite() + "" + getWindows() + ""
                + getMac() + "" + getLinux() + "" + getUpvotes() + "" + getAvgPt() + "" + getDevelopers() + ""
                + getGenres());
    }

    void readData(int info) throws Exception {
        Scanner sc = new Scanner(new File("tmp/games.csv"));
        String[] entrada = new String[1000];
        int numEntrada = 0;

        while (sc.hasNext() == true) {
            entrada[numEntrada] = sc.nextLine();
            numEntrada++;
        }

        for(int i = 0; i < numEntrada; i++)
        {
            if(info == )
            {


            }


        }
        
        
        
        
        /*for (int i = 0; i < numEntrada; i++) {
            int cod = sc.nextInt();

            if (sc.hasNextInt() == true) {
                if () {

                }

            }*/

            // MUDAR PARA BUFFERED READER, FAZER A COMPARAÇÃO ENTRE INFO E INT, SETAR OS
            // VALORES
        }

}



class TP2Q01 {

    public static boolean isFim(int s) {
        return (if()); // verifica se o
                                                                                                    // pub.in chegou
                                                                                                    // ao
                                                                                                    // FIM
    }

    public static void main(String[] args) throws Exception {
        // entrada de dados vinda do arquivo .csv

        // entrada de dados vinda do pub.in
        int[] entradaPub = new int[1000];
        int numEntradaPub = 0;

        do {
            entradaPub[numEntradaPub] = MyIO.readInt();
        } while (isFim(entradaPub[numEntradaPub++]) == false);
        numEntradaPub--; // Desconsidera a ultima linha contendo a palavra FIM

        for (int i = 0; i < numEntradaPub; i++) {
            Game game = new Game();
            game.readData(entradaPub[i]);

        }
        
    }

}