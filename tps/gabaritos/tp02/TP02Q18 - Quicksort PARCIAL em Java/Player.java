/**
 * @path TP02Q18 - Quicksort PARCIAL em Java
 * @description Player class implemented with parcial quicksort
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 1.0
 * @update 2023-09-27
 */

// ---------------------------------------------------------------------------------------------------- //

// Imports
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// ---------------------------------------------------------------------------------------------------- //

public class Player {

    // Global variables
    public static final String FILE_PATH = "/tmp/players.csv";
    public static ArrayList<Player> allPlayers = new ArrayList<Player>();
    public static int comparisons = 0;

    // -------------------------- //

    // Attributes
    private int id;
    private String name;
    private int height;
    private int weight;
    private String college;
    private int yearOfBirth;
    private String birthCity;
    private String birthState;

    // Empty constructor
    public Player() {

        this.id = 0;
        this.name = "";
        this.height = 0;
        this.weight = 0;
        this.college = "";
        this.yearOfBirth = 0;
        this.birthCity = "";
        this.birthState = "";
    }

    // Constructor
    public Player(int id, String name, int height, int weight, String college, int yearOfBirth, String birthCity, String birthState) {

        this.id = id;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.college = college;
        this.yearOfBirth = yearOfBirth;
        this.birthCity = birthCity;
        this.birthState = birthState;
    }

    // Gets
    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getHeight() { return this.height; }
    public int getWeight() { return this.weight; }
    public String getCollege() { return this.college; }
    public int getYearOfBirth() { return this.yearOfBirth; }
    public String getBirthCity() { return this.birthCity; }
    public String getBirthState() { return this.birthState; }

    // Sets
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setCollege(String college) { this.college = college; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setBirthCity(String birthCity) { this.birthCity = birthCity; }
    public void setBirthState(String birthState) { this.birthState = birthState; }

    // Clone
    public Player clone() { return new Player(this.id, this.name, this.height, this.weight, this.college, this.yearOfBirth, this.birthCity, this.birthState); }

    // Print
    public void print() {

        System.out.printf("[%d ## %s ## %d ## %d ## %d ## %s ## %s ## %s]\n",
            this.id, this.name, this.height, this.weight, this.yearOfBirth, this.college, this.birthCity, this.birthState);
    }

    // Read
    public void read(String line) {

        // Split line by ","
        String[] splitted = line.split(",", -1);

        // Fill empty attributes
        for(int i = 0; i < splitted.length; i++) {

            if(splitted[i].equals("")) splitted[i] = "nao informado";
        }

        // Set attributes
        this.id = Integer.parseInt(splitted[0]);
        this.name = splitted[1];
        this.height = Integer.parseInt(splitted[2]);
        this.weight = Integer.parseInt(splitted[3]);
        this.college = splitted[4];
        this.yearOfBirth = Integer.parseInt(splitted[5]);
        this.birthCity = splitted[6];
        this.birthState = splitted[7];
    }

    // CompareTo
    public int compareTo(Player other) {

        // Compare by birthState
        int birthStateComparison = this.birthState.compareTo(other.birthState);

        if(birthStateComparison != 0) return birthStateComparison;
        else return this.name.compareTo(other.name);
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Read all players function
    public static void startPlayers() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();
  
            while((line = br.readLine()) != null) {

                // Initialize player
                Player player = new Player();

                // Read line
                player.read(line);

                // Add player to array
                allPlayers.add(player);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Search by id
    public static Player searchById(int id, ArrayList<Player> players) {

        // Search for player
        for(int i = 0; i < players.size(); i++) {

            if(players.get(i).getId() == id) return players.get(i);
        }
        return null;
    }

    // ---------------------------------------------------------------------------------------------------- //

    public static void main(String[] args) {
        
        // ----------------------------------------------------------------- //

        // #1 - Start - Read all players in CSV file
        startPlayers();

        // ----------------------------------------------------------------- //

        // #2 - Read input and print players from pub.in id entries and add to mainPlayers array

        // Initialize mainPlayers array
        ArrayList<Player> mainPlayers = new ArrayList<Player>();

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Initialize player
        Player player = new Player();

        // Read first line
        String line = inScanner.nextLine();

        // While line is not "FIM"
        while(!line.equals("FIM")) {

            // Get id
            int id = Integer.parseInt(line);

            // Search for player
            player = searchById(id, allPlayers);

            // Print player
            if(player != null) mainPlayers.add(player);

            // Read line
            line = inScanner.nextLine();
        }

        // ----------------------------------------------------------------- //

        // #3 - Order mainPlayers array by key "birthState", in draw case, order by key "name"

        // Start benchmark
        long startTime = System.currentTimeMillis();
        int comparisons = 0;

        // ----------------- //

        // Parcial quicksort with k = 10
        int k = 10;

        for(int i = 0; i < mainPlayers.size() - 1; i++) {

            for(int j = i + 1; j < mainPlayers.size() - 1; j++) {

                comparisons++;

                if(mainPlayers.get(i).compareTo(mainPlayers.get(j)) > 0) {

                    Player temp = mainPlayers.get(i);
                    mainPlayers.set(i, mainPlayers.get(j));
                    mainPlayers.set(j, temp);
                }
                else if(mainPlayers.get(i).compareTo(mainPlayers.get(j)) == 0) {

                    comparisons++;

                    if(mainPlayers.get(i).getName().compareTo(mainPlayers.get(j).getName()) > 0) {

                        Player temp = mainPlayers.get(i);
                        mainPlayers.set(i, mainPlayers.get(j));
                        mainPlayers.set(j, temp);
                    }
                }
            }
        }
    
        // ----------------- //

        // Save benchmark in file
        Arq.openWrite("753045_quicksortParcial.txt");
        Arq.print("753045\t" + (System.currentTimeMillis() - startTime) + "ms\t" + comparisons);
        Arq.close();

        // ----------------- //

        // Print mainPlayers array
        for(int i = 0; i < k; i++) mainPlayers.get(i).print();

        // ----------------------------------------------------------------- //

        // Close scanner
        inScanner.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //