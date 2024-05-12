/**
 * @path TP02Q01 - Classe em Java/Characters.java 
 * @description Java class of all characters from Harry Potter's saga with heap sort algorithm
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 1.0
 * @update 2024-04-09
 */

// ---------------------------------------------------------------------------------------------------- //

// Imports
import java.util.Scanner;
import java.util.UUID;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;

// ---------------------------------------------------------------------------------------------------- //

public class Character {

    static SimpleDateFormat ddf = new SimpleDateFormat("dd-MM-yyyy");

    // Global variables
    public static final String FILE_PATH = "/tmp/characters.csv";
    public static ArrayList<Character> allCharacters = new ArrayList<Character>();

    // -------------------------- //

    // Attributes
    private UUID id;
    private String name;
    private ArrayList<String> alternateNames;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwartsStudent;
    private String actorName;
    private boolean alive;
    private Date birthDate;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizard;

    // -------------------------- //

    // Empty constructor
    public Character() {

        this.id = UUID.randomUUID();
        this.name = "";
        this.alternateNames = new ArrayList<String>();
        this.house = "";
        this.ancestry = "";
        this.species = "";
        this.patronus = "";
        this.hogwartsStaff = false;
        this.hogwartsStudent = false;
        this.actorName = "";
        this.alive = false;
        this.birthDate = null;
        this.yearOfBirth = 0;
        this.eyeColour = "";
        this.gender = "";
        this.hairColour = "";
        this.wizard = false;
    }

    // Constructor
    public Character(UUID id, String name, ArrayList<String> alternateNames, String house, String ancestry, String species, String patronus, boolean hogwartsStaff, boolean hogwartsStudent, String actorName, boolean alive, Date birthDate, int yearOfBirth, String eyeColour, String gender, String hairColour, boolean wizard) {

        this.id = id;
        this.name = name;
        this.alternateNames = alternateNames;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.birthDate = birthDate;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizard = wizard;
    }

    // -------------------------- //

    // Gets
    public UUID getId() { return this.id; }
    public String getName() { return this.name; }
    public String getHouse() { return this.house; }
    public String getAncestry() { return this.ancestry; }
    public String getSpecies() { return this.species; }
    public String getPatronus() { return this.patronus; }
    public boolean getHogwartsStaff() { return this.hogwartsStaff; }
    public boolean getHogwartsStudent() { return this.hogwartsStudent; }
    public String getActorName() { return this.actorName; }
    public boolean getAlive() { return this.alive; }
    public Date getBirthDate() { return this.birthDate; }
    public int getYearOfBirth() { return this.yearOfBirth; }
    public String getEyeColour() { return this.eyeColour; }
    public String getGender() { return this.gender; }
    public String getHairColour() { return this.hairColour; }
    public boolean getWizard() { return this.wizard; }
   
    public String getAlternateNames() { 
        
        // Construct string e.g. {item1, item2, item3}
        String alternateNames = "{";

        for(int i = 0; i < this.alternateNames.size(); i++) {

            alternateNames += this.alternateNames.get(i);

            if(i < this.alternateNames.size() - 1) alternateNames += ", ";
        }

        alternateNames += "}";

        return alternateNames;
    }

    // Sets
    public void setId(UUID id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAlternateNames(ArrayList<String> alternateNames) { this.alternateNames = alternateNames; }
    public void setHouse(String house) { this.house = house; }
    public void setAncestry(String ancestry) { this.ancestry = ancestry; }
    public void setSpecies(String species) { this.species = species; }
    public void setPatronus(String patronus) { this.patronus = patronus; }
    public void setHogwartsStaff(boolean hogwartsStaff) { this.hogwartsStaff = hogwartsStaff; }
    public void setHogwartsStudent(boolean hogwartsStudent) { this.hogwartsStudent = hogwartsStudent; }
    public void setActorNane(String actorName) { this.actorName = actorName; }
    public void setAlive(boolean alive) { this.alive = alive; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public void setEyeColour(String eyeColour) { this.eyeColour = eyeColour; }
    public void setGender(String gender) { this.gender = gender; }
    public void setHairColour(String hairColour) { this.hairColour = hairColour; }
    public void setWizard(boolean wizard) { this.wizard = wizard; }

    // -------------------------- //

    // Clone
    public Character clone() { return new Character(this.id, this.name, this.alternateNames, this.house, this.ancestry, this.species, this.patronus, this.hogwartsStaff, this.hogwartsStudent, this.actorName, this.alive, this.birthDate, this.yearOfBirth, this.eyeColour, this.gender, this.hairColour, this.wizard); }

    // -------------------------- //

    // Print
    public void print() {

        System.out.println("["
            + this.getId() + " ## "
            + this.getName() + " ## "
            + this.getAlternateNames() + " ## "
            + (this.getHouse() == "" ? "N/A" : this.getHouse()) + " ## "
            + (this.getAncestry() == "" ? "N/A" : this.getAncestry()) + " ## "
            + (this.getSpecies() == "" ? "N/A" : this.getSpecies()) + " ## "
            + (this.getPatronus() == "" ? "N/A" : this.getPatronus()) + " ## "
            + (this.getHogwartsStaff() ? "true" : "false") + " ## "
            + (this.getHogwartsStudent() ? "true" : "false") + " ## "
            + (this.getActorName() == "" ? "N/A" : this.getActorName()) + " ## "
            + (this.getAlive() ? "true" : "false") + " ## "
            + (this.getBirthDate() == null ? "N/A" : ddf.format(this.getBirthDate())) + " ## "
            + (this.getYearOfBirth() == 0 ? "N/A" : this.getYearOfBirth()) + " ## "
            + (this.getEyeColour() == "" ? "N/A" : this.getEyeColour()) + " ## "
            + (this.getGender() == "" ? "N/A" : this.getGender()) + " ## "
            + (this.getHairColour() == "" ? "N/A" : this.getHairColour()) + " ## "
            + (this.getWizard() ? "true" : "false") + "]");
    }

    // -------------------------- //

    public static ArrayList<String> extractNames(String input) {

        ArrayList<String> names = new ArrayList<>();

        // Clean input
        String cleanedInput = input.substring(1, input.length() - 1);

        // Check if input contains double quotes
        if (cleanedInput.contains("\"\"")) {

            String[] parts = cleanedInput.split("\", ");

            for (String part : parts) names.add(part.replace("\"", "").replace("'", ""));
        } 
        else {

            // Split input by comma and space
            String[] parts = cleanedInput.split(", ");

            for (String part : parts) names.add(part.replace("'", ""));
        }
        return names;
    }

    // -------------------------- //

    // Read
    public void read(String line) {

        // ---------------------- //

        // Start position
        int positionStart = 0;
        int positionEnd = 0;

        // ---------------------- //

        // Set id
        positionEnd = line.indexOf(";", positionStart);
        this.setId(UUID.fromString(line.substring(positionStart, positionEnd)));

        // ---------------------- //
        
        // Set name
        positionStart = positionEnd + 1;
        positionEnd = line.indexOf(";", positionStart);   

        this.setName(line.substring(positionStart, positionEnd));

        // ---------------------- //
        
        // Set alternate names
        positionStart = positionEnd + 1;

        if(line.charAt(positionStart) == '[') { // If first character is '[', has one or no names

			if(line.charAt(positionStart + 1) == ']') {

                positionEnd = positionStart + 2;

                this.setAlternateNames(new ArrayList<String>());
            }
            else {

                positionEnd = line.indexOf("];", positionStart);
        
                this.setAlternateNames(extractNames(line.substring(positionStart, positionEnd++)));
            }
        }

        // ---------------------- //

        // Set house
        positionStart = positionEnd;
        positionEnd = line.indexOf(";", ++positionStart);

        this.setHouse(line.substring(positionStart, positionEnd));

        // ---------------------- //
        
        // Set ancestry
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setAncestry(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set species
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setSpecies(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set patronus
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setPatronus(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set hogwartsStaff
        positionStart = positionEnd + 1;
        positionEnd = line.indexOf(";", positionStart);

		this.setHogwartsStaff("VERDADEIRO".equals(line.substring(positionStart, positionEnd)));

        // ---------------------- //

        // Set hogwartsStudent
        positionStart = positionEnd + 1;
        positionEnd = line.indexOf(";", positionStart);

		this.setHogwartsStudent("VERDADEIRO".equals(line.substring(positionStart, positionEnd)));

        // ---------------------- //

        // Set actor name
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setActorNane(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set alive
        positionStart = positionEnd + 1;
        positionEnd = line.indexOf(";", positionStart);

		this.setAlive("VERDADEIRO".equals(line.substring(positionStart, positionEnd)));

        // ---------------------- //

        // Set date of birth
        positionStart = positionEnd;
        positionEnd = line.indexOf(";", ++positionStart);

        try { this.setBirthDate(ddf.parse(line.substring(positionStart, positionEnd))); }
        catch(Exception e) { this.setBirthDate(null); }

        // ---------------------- //

        // Set year of birth
        positionStart = positionEnd + 1;
        positionEnd = line.indexOf(";", positionStart);

        try { this.setYearOfBirth(Integer.parseInt(line.substring(positionStart, positionEnd))); }
        catch(Exception e) { this.setYearOfBirth(0); }

        // ---------------------- //

        // Set eye colour
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setEyeColour(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set gender
        positionStart = positionEnd + 1;
 		positionEnd = line.indexOf(";", positionStart);   

        this.setGender(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set hair colour
        positionStart = positionEnd + 1;
	  	positionEnd = line.indexOf(";", positionStart);   

        this.setHairColour(line.substring(positionStart, positionEnd));

        // ---------------------- //

        // Set wizard
        positionStart = positionEnd + 1;

		this.setWizard("VERDADEIRO".equals(line.substring(positionStart, line.length())));

        // ---------------------- //
    }

    // -------------------------- //

    // Compare method
    public int compareTo(Character other) {

        // Compare by hair colour
        int hairComparison = this.hairColour.compareTo(other.hairColour);

        // If hair colour is the same, compare by name
        if(hairComparison != 0) return hairComparison;
        else return this.name.compareTo(other.name);
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Read all characters function
    public static void startCharacters() {

        // Initialize variables
        try {

            FileInputStream fstream = new FileInputStream(FILE_PATH);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            // ---------------------- //

            // Explode CSV file
            String line = br.readLine();
  
            while((line = br.readLine()) != null) {

                // Initialize character
                Character character = new Character();

                // Read line
                character.read(line);

                // Add character to array
                allCharacters.add(character);
            }

            // Close CSV file
            fstream.close();
        }
        catch(IOException e) { e.printStackTrace(); }
    }

    // ---------------------------------------------------------------------------------------------------- //

    // Search by id function
    public static Character searchById(UUID id, ArrayList<Character> characters) {

        // Search for character
        for(int i = 0; i < characters.size(); i++) {

            if(characters.get(i).getId().equals(id)) return characters.get(i);
        }
        return null;
    }

    // Helper method to heapify
    static void heapify(ArrayList<Character> characters, int n, int root, int comparisons) {

        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;
    
        comparisons++;
        if(left < n && characters.get(left).compareTo(characters.get(largest)) > 0) largest = left;
    
        comparisons++;
        if(right < n && characters.get(right).compareTo(characters.get(largest)) > 0) largest = right;
    
        if(largest != root) {
            
            Character swap = characters.get(root);
            characters.set(root, characters.get(largest));
            characters.set(largest, swap);
    
            heapify(characters, n, largest, comparisons);
        }
    }

    // ---------------------------------------------------------------------------------------------------- //

    public static void main(String[] args) {
        
        // ----------------------------------------------------------------- //

        // #1 - Start - Read all characters in CSV file
        startCharacters();

        // ----------------------------------------------------------------- //

        // #2 - Read input and print characters from pub.in id entries and add to mainCharacters array

        // Initialize mainCharacters array
        ArrayList<Character> mainCharacters = new ArrayList<Character>();

        // Initialize scanner
        Scanner inScanner = new Scanner(System.in);

        // Initialize character
        Character character = new Character();

        // Read first line
        String line = inScanner.nextLine();

        // While line is not "FIM"
        while(!line.equals("FIM")) {

            // Get id
            UUID id = UUID.fromString(line);

            // Search for character
            character = searchById(id, allCharacters);

            // Print character
            if(character != null) mainCharacters.add(character);

            // Read line
            line = inScanner.nextLine();
        }

        // ----------------------------------------------------------------- //

        // #3 - Order mainCharacters array by key "hairColour" using insertion sort, in draw case, order by key "name"

        // Start benchmark
        long startTime = System.currentTimeMillis();
        int comparisons = 0;

        // Heap sort
        for(int i = mainCharacters.size() / 2 - 1; i >= 0; i--) heapify(mainCharacters, mainCharacters.size(), i, comparisons);

        for(int i = mainCharacters.size() - 1; i > 0; i--) {

            // Swap the root (maximum element) with the last character
            Character temp = mainCharacters.get(0);
            mainCharacters.set(0, mainCharacters.get(i));
            mainCharacters.set(i, temp);

            // Heapify the reduced heap
            heapify(mainCharacters, i, 0, comparisons);
        }

        // ----------------- //

        // Save benchmark in file
        Arq.openWrite("753045_heapsort.txt");
        Arq.print("753045\t" + (System.currentTimeMillis() - startTime) + "ms\t" + comparisons);
        Arq.close();

        // ----------------- //

        // Print mainCharacters array
        for(int i = 0; i < mainCharacters.size(); i++) mainCharacters.get(i).print();

        // ----------------------------------------------------------------- //

        // Close scanner
        inScanner.close();
    }
}

// ---------------------------------------------------------------------------------------------------- //
