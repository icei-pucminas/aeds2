/**
 * @path TP02Q15 - Ordenação PARCIAL por Seleção em Java
 * @description Player class implemented with parcial selection sort
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

        // Compare by height
        int heightComparison = Integer.compare(this.height, other.height);

        if(heightComparison != 0) return heightComparison;
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

    // Merge sort helper function
    public static int mergeSort(ArrayList<Player> arr, int l, int r) {

        if(l < r) {

            int mid = (l + r) / 2;

            int leftComparisons = mergeSort(arr, l, mid);
            int rightComparisons = mergeSort(arr, mid + 1, r);
            int mergeComparisons = merge(arr, l, mid, r);
            return leftComparisons + rightComparisons + mergeComparisons;
        }
        return 0;
    }

    // Merge function
    public static int merge(ArrayList<Player> arr, int l, int mid, int r) {

        int comparisons = 0;
        int n1 = mid - l + 1;
        int n2 = r - mid;

        ArrayList<Player> leftArr = new ArrayList<Player>();
        ArrayList<Player> rightArr = new ArrayList<Player>();

        for(int i = 0; i < n1; i++) leftArr.add(arr.get(l + i));
        for(int i = 0; i < n2; i++) rightArr.add(arr.get(mid + 1 + i));

        int i = 0, j = 0, k = l;

        while(i < n1 && j < n2) {

            // Compare players and increment comparisons
            comparisons++;

            if(leftArr.get(i).getCollege().compareTo(rightArr.get(j).getCollege()) < 0 ||
                (leftArr.get(i).getCollege().equals(rightArr.get(j).getCollege()) &&
                leftArr.get(i).getName().compareTo(rightArr.get(j).getName()) <= 0)) {
                
                arr.set(k, leftArr.get(i));
                i++;
            } 
            else {

                arr.set(k, rightArr.get(j));
                j++;
            }

            k++;
        }

        while (i < n1) {

            arr.set(k, leftArr.get(i));
            i++;
            k++;
        }

        while (j < n2) {

            arr.set(k, rightArr.get(j));
            j++;
            k++;
        }
        return comparisons;
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

        // #3 - Order mainPlayers array by key "college" using counting sort, in draw case, order by key "name"

        // Start benchmark
        long startTime = System.currentTimeMillis();
        int comparisons = 0;

        // ----------------- //
        
        // Merge sort
        comparisons = mergeSort(mainPlayers, 0, mainPlayers.size() - 1);

        // ----------------- //

        // Save benchmark in file
        Arq.openWrite("753045_mergesort.txt");
        Arq.print("753045\t" + (System.currentTimeMillis() - startTime) + "ms\t" + comparisons);
        Arq.close();

        // ----------------- //

        // Print mainPlayers array
        for(int i = 0; i < mainPlayers.size(); i++) mainPlayers.get(i).print();

        // ----------------------------------------------------------------- //

        // Close scanner
        inScanner.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //