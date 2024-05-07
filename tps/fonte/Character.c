/**
 * @path TP02Q02 - Classe em C/Character.c
 * @description C file that implements the Character class.
 * @author Pedro Lopes - github.com/httpspedroh
 * @version 2.0
 * @update 2024-04-09
 */

// ---------------------------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// ---------------------------------------------------------------------------------------------------- //

// Constants
#define MAX_CHARACTERS 405
#define FILE_PATH "/tmp/characters.csv"

#define MAX_UUID_SIZE 37
#define MAX_NAME_SIZE 30
#define MAX_ALTERNATE_NAMES 10
#define MAX_ALTERNATE_NAME_SIZE 35
#define MAX_HOUSE_SIZE 15
#define MAX_ANCESTRY_SIZE 15
#define MAX_SPECIES_SIZE 20
#define MAX_PATRONUS_SIZE 25
#define MAX_ACTOR_NAME_SIZE 35
#define MAX_EYE_COLOUR_SIZE 10
#define MAX_GENDER_SIZE 10
#define MAX_HAIR_COLOUR_SIZE 10

#define MAX_LINE_SIZE 300

// ---------------------------------------------------------------------------------------------------- //

// Structs
typedef struct Date {

    int day;
    int month;
    int year;
} Date;

typedef struct Character {

    char *id;
    char *name;
    char *alternateNames[MAX_ALTERNATE_NAMES];
    char *house;
    char *ancestry;
    char *species;
    char *patronus;
    bool hogwartsStaff;
    bool hogwartsStudent;
    char *actorName;
    bool alive;
    Date birthDate;
    int yearOfBirth;
    char *eyeColour;
    char *gender;
    char *hairColour;
    bool wizard;
} Character;

// ---------------------------------------------------------------------------------------------------- //

// Global variables
Character characters[MAX_CHARACTERS];
int charactersLength = 0;

// ---------------------------------------------------------------------------------------------------- //

// Functions 
bool isEnd(char* line) { return line[0] == 'F' && line[1] == 'I' && line[2] == 'M'; }

void substring(char *string, char *stringStart, int length) {

    strncpy(string, stringStart, length);
    string[length] = '\0';
}

void proccess_attribute(char *attribute, char **substringStart, char **substringEnd, bool isFirstAttribute, bool isStringArray) {

    // Skip first comma
    if(!isFirstAttribute) {
        
        if(*substringEnd != NULL) *substringStart = *substringEnd + 1;
        else *substringStart = *substringEnd;
    }

    if(!isStringArray) {

        if((*substringStart)[0] == '"') {
            
            *substringStart = *substringStart + 1;
            *substringEnd = strchr(*substringStart, '"');
        }
        else *substringEnd = strchr(*substringStart, ';');
        
        // Get substring
        if(*substringEnd) {
            
            substring(attribute, *substringStart, *substringEnd - *substringStart);

            if(*substringEnd[0] == '"') *substringEnd = *substringEnd + 1;
        }
        else strcpy(attribute, *substringStart);

        // Set default value if attribute is empty
        if(strcmp(attribute, "") == 0 || attribute[0] == '\n' || attribute[0] == '\r' || attribute[0] == '\0') strcpy(attribute, "N/A");

        // Clean \n from the end of the string
        if(attribute[strlen(attribute) - 1] == '\n' || attribute[strlen(attribute) - 1] == '\r') attribute[strlen(attribute) - 1] = '\0';
    } 
    else {
        
        // Check if the first character is a [
        if((*substringStart)[0] == '[') {

            *substringStart = *substringStart + 1;

            if((*substringStart)[0] == ']') strcpy(attribute, ""); // Case: []
            else {

                char *tempConcat = (char *) calloc(MAX_LINE_SIZE, sizeof(char));

                *substringStart = *substringStart - 1;
         
                while(1) {

                    *substringStart = *substringStart + 1;

                    if((*substringStart)[0] == ';') break;
                    else if((*substringStart)[0] == '\'') { // Case: "['example', 'example']"
                           
                        *substringStart = *substringStart + 1;
                        *substringEnd = strchr(*substringStart, '\'');

                        // Get substring
                        if(*substringEnd) {

                            // Create tmp name
                            char tmp[MAX_LINE_SIZE];
                            substring(tmp, *substringStart, *substringEnd - *substringStart);

                            // Concat tempConcat with tmp
                            strcat(tempConcat, tmp);
                            strcat(tempConcat, ", ");

                            *substringStart = *substringEnd + 1;
                        }
                    }
                }

                // Get substring
                strcpy(attribute, tempConcat);

                // Clean "attribute" removing last 2 characters
                attribute[strlen(attribute) - 2] = '\0';
            }
        } 

        *substringEnd = strchr(*substringStart, ';');
    }
}

// ---------------------------------------------------------------------------------------------------- //

// Methods implementations

// Gets
char *character_getId(Character *character) { return character -> id; }
char *character_getName(Character *character) { return character -> name; }
char *character_getHouse(Character *character) { return character -> house; }
char *character_getAncestry(Character *character) { return character -> ancestry; }
char *character_getSpecies(Character *character) { return character -> species; }
char *character_getPatronus(Character *character) { return character -> patronus; }
bool character_getHogwartsStaff(Character *character) { return character -> hogwartsStaff; }
bool character_getHogwartsStudent(Character *character) { return character -> hogwartsStudent; }
char *character_getActorName(Character *character) { return character -> actorName; }
bool character_getAlive(Character *character) { return character -> alive; }
char *character_getEyeColour(Character *character) { return character -> eyeColour; }
char *character_getGender(Character *character) { return character -> gender; }
char *character_getHairColour(Character *character) { return character -> hairColour; }
bool character_getWizard(Character *character) { return character -> wizard; }

char *character_getYearOfBirth(Character *character) { 
    
    // "N/A" if yearOfBirth is -1
    char *yearOfBirth = (char *) calloc(15, sizeof(char));
    strcpy(yearOfBirth, "N/A");

    if(character -> yearOfBirth != -1) sprintf(yearOfBirth, "%d", character -> yearOfBirth);
    return yearOfBirth;
}

char *character_getBirthDate(Character *character) {
    
    // "N/A" if day, month and year are -1
    char *birthDate = (char *) calloc(15, sizeof(char));
    strcpy(birthDate, "N/A");

    if(character -> birthDate.day != -1 && character -> birthDate.month != -1 && character -> birthDate.year != -1) {

        sprintf(birthDate, "%02d-%02d-%04d", character -> birthDate.day, character -> birthDate.month, character -> birthDate.year);
    }

    return birthDate;
}

char *character_getAlternateNames(Character *character) { 
    
    // Concatenate all alternate names with a comma
    char *alternateNames = (char *) calloc(MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES, sizeof(char));

    alternateNames[0] = '{';

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        if(strcmp(character -> alternateNames[i], "") != 0) {

            strcat(alternateNames, character -> alternateNames[i]);
            
            if(strcmp(character -> alternateNames[i + 1], "") != 0) strcat(alternateNames, ", ");
        }
    }

    strcat(alternateNames, "}");

    return alternateNames;
}

// Sets
void character_setId(Character *character, char *id) { strcpy(character -> id, id); }
void character_setName(Character *character, char *name) { strcpy(character -> name, name); }
void character_setHouse(Character *character, char *house) { strcpy(character -> house, house); }
void character_setAncestry(Character *character, char *ancestry) { strcpy(character -> ancestry, ancestry); }
void character_setSpecies(Character *character, char *species) { strcpy(character -> species, species); }
void character_setPatronus(Character *character, char *patronus) { strcpy(character -> patronus, patronus); }
void character_setHogwartsStaff(Character *character, bool hogwartsStaff) { character -> hogwartsStaff = hogwartsStaff; }
void character_setHogwartsStudent(Character *character, bool hogwartsStudent) { character -> hogwartsStudent = hogwartsStudent; }
void character_setActorName(Character *character, char *actorName) { strcpy(character -> actorName, actorName); }
void character_setAlive(Character *character, bool alive) { character -> alive = alive; }
void character_setYearOfBirth(Character *character, int yearOfBirth) { character -> yearOfBirth = yearOfBirth; }
void character_setEyeColour(Character *character, char *eyeColour) { strcpy(character -> eyeColour, eyeColour); }
void character_setGender(Character *character, char *gender) { strcpy(character -> gender, gender); }
void character_setHairColour(Character *character, char *hairColour) { strcpy(character -> hairColour, hairColour); }
void character_setWizard(Character *character, bool wizard) { character -> wizard = wizard; }

void character_setBirthDate(Character *character, char *birthDate) { 

    // Explode birthDate in format DD-MM-YYYY if in format DD-MM-YYYY
    if(strlen(birthDate) >= 8 && strlen(birthDate) <= 10) {

        char *token = strtok(birthDate, "-");

        character -> birthDate.day = atoi(token);
        token = strtok(NULL, "-");
        character -> birthDate.month = atoi(token);
        token = strtok(NULL, "-");
        character -> birthDate.year = atoi(token);
    }
}

void character_setAlternateNames(Character *character, char *alternateNames) {

    // Copy names to a temporary variable
    char tempNames[MAX_ALTERNATE_NAME_SIZE * MAX_ALTERNATE_NAMES];
    strcpy(tempNames, alternateNames);

    // Separate names by comma
    char *token = strtok(tempNames, ",");
    int i = 0;

    // Copy names to the character
    while (token != NULL && i < MAX_ALTERNATE_NAMES) {
        
        while (*token == ' ') token++;

        int len = strlen(token);

        while (len > 0 && token[len - 1] == ' ') {

            token[len - 1] = '\0';
            len--;
        }

        strcpy(character -> alternateNames[i++], token);
        token = strtok(NULL, ",");
    }
}

// Class
Character character_newBlank() {

    Character character;

    character.id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(character.id, "");

    character.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(character.name, "");

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        character.alternateNames[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(character.alternateNames[i], "");
    }

    character.house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(character.house, "");

    character.ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(character.ancestry, "");

    character.species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(character.species, "");

    character.patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(character.patronus, "");

    character.hogwartsStaff = false;
    character.hogwartsStudent = false;

    character.actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(character.actorName, "");

    character.alive = false;
    
    character.birthDate.day = -1;
    character.birthDate.month = -1;
    character.birthDate.year = -1;

    character.yearOfBirth = -1;

    character.eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(character.eyeColour, "");

    character.gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(character.gender, "");

    character.hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(character.hairColour, "");

    character.wizard = false;

    return character;
}

Character character_new(char *id, char *name, char *house, char *ancestry, char *species, char *patronus, bool hogwartsStaff, bool hogwartsStudent, char *actorName, bool alive, Date birthDate, int yearOfBirth, char *eyeColour, char *gender, char *hairColour, bool wizard) {

    Character character;

    character.id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(character.id, id);

    character.name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(character.name, name);

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        character.alternateNames[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(character.alternateNames[i], "");
    }

    character.house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(character.house, house);

    character.ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(character.ancestry, ancestry);

    character.species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(character.species, species);

    character.patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(character.patronus, patronus);

    character.hogwartsStaff = hogwartsStaff;
    character.hogwartsStudent = hogwartsStudent;

    character.actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(character.actorName, actorName);

    character.alive = alive;
    character.birthDate = birthDate;
    character.yearOfBirth = yearOfBirth;

    character.eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(character.eyeColour, eyeColour);

    character.gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(character.gender, gender);

    character.hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(character.hairColour, hairColour);

    character.wizard = wizard;

    return character;
}

Character *character_clone(Character *character) {

    Character *clone = (Character *) malloc(sizeof(Character));

    clone -> id = (char *) calloc(MAX_UUID_SIZE, sizeof(char));
    strcpy(clone -> id, character -> id);

    clone -> name = (char *) calloc(MAX_NAME_SIZE, sizeof(char));
    strcpy(clone -> name, character -> name);

    for(int i = 0; i < MAX_ALTERNATE_NAMES; i++) {

        clone -> alternateNames[i] = (char *) calloc(MAX_ALTERNATE_NAME_SIZE, sizeof(char));
        strcpy(clone -> alternateNames[i], character -> alternateNames[i]);
    }

    clone -> house = (char *) calloc(MAX_HOUSE_SIZE, sizeof(char));
    strcpy(clone -> house, character -> house);

    clone -> ancestry = (char *) calloc(MAX_ANCESTRY_SIZE, sizeof(char));
    strcpy(clone -> ancestry, character -> ancestry);

    clone -> species = (char *) calloc(MAX_SPECIES_SIZE, sizeof(char));
    strcpy(clone -> species, character -> species);

    clone -> patronus = (char *) calloc(MAX_PATRONUS_SIZE, sizeof(char));
    strcpy(clone -> patronus, character -> patronus);

    clone -> hogwartsStaff = character -> hogwartsStaff;
    clone -> hogwartsStudent = character -> hogwartsStudent;

    clone -> actorName = (char *) calloc(MAX_ACTOR_NAME_SIZE, sizeof(char));
    strcpy(clone -> actorName, character -> actorName);

    clone -> alive = character -> alive;
    clone -> birthDate = character -> birthDate;
    clone -> yearOfBirth = character -> yearOfBirth;

    clone -> eyeColour = (char *) calloc(MAX_EYE_COLOUR_SIZE, sizeof(char));
    strcpy(clone -> eyeColour, character -> eyeColour);

    clone -> gender = (char *) calloc(MAX_GENDER_SIZE, sizeof(char));
    strcpy(clone -> gender, character -> gender);

    clone -> hairColour = (char *) calloc(MAX_HAIR_COLOUR_SIZE, sizeof(char));
    strcpy(clone -> hairColour, character -> hairColour);

    clone -> wizard = character -> wizard;

    return clone;
}

void character_print(Character *character) {

    printf("[%s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s]\n",

        character_getId(character),
        character_getName(character),
        character_getAlternateNames(character),
        character_getHouse(character),
        character_getAncestry(character),
        character_getSpecies(character),
        character_getPatronus(character),
        character_getHogwartsStaff(character) ? "true" : "false",
        character_getHogwartsStudent(character) ? "true" : "false",
        character_getActorName(character),
        character_getAlive(character) ? "true" : "false",
        character_getBirthDate(character),
        character_getYearOfBirth(character),
        character_getEyeColour(character),
        character_getGender(character),
        character_getHairColour(character),
        character_getWizard(character) ? "true" : "false"
        );
}

Character character_read(char *line) {

    Character character = character_newBlank();

    char *substringStart = line;
    char *substringEnd = NULL;
    char attribute[MAX_LINE_SIZE];

    // Get id
    proccess_attribute(attribute, &substringStart, &substringEnd, true, false);
    character_setId(&character, attribute);

    // Get name
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setName(&character, attribute);

    // Get alternate names
    proccess_attribute(attribute, &substringStart, &substringEnd, false, true);
    character_setAlternateNames(&character, attribute);

    // Get house
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setHouse(&character, attribute);

    // Get ancestry
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setAncestry(&character, attribute);

    // Get species
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setSpecies(&character, attribute);

    // Get patronus
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setPatronus(&character, attribute);

    // Get hogwarts staff
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setHogwartsStaff(&character, strcmp(attribute, "VERDADEIRO") == 0);

    // Get hogwarts student
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setHogwartsStudent(&character, strcmp(attribute, "VERDADEIRO") == 0);

    // Get actor name
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setActorName(&character, attribute);

    // Get alive
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setAlive(&character, strcmp(attribute, "VERDADEIRO") == 0);

    // Get birth date
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setBirthDate(&character, attribute);

    // Get year of birth
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setYearOfBirth(&character, atoi(attribute) == 0 ? -1 : atoi(attribute));

    // Get eye colour
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setEyeColour(&character, attribute);

    // Get gender
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setGender(&character, attribute);

    // Get hair colour
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);
    character_setHairColour(&character, attribute);

    // Get wizard
    proccess_attribute(attribute, &substringStart, &substringEnd, false, false);

    // Clean \n from the end of the string
    if(attribute[strlen(attribute) - 1] == '\n' || attribute[strlen(attribute) - 1] == '\r') attribute[strlen(attribute) - 1] = '\0';

    character_setWizard(&character, strcmp(attribute, "VERDADEIRO") == 0);
    return character;
}

Character *character_searchById(char *id) {

    for(int i = 0; i < charactersLength; i++) {

        if(!strcmp(characters[i].id, id)) return &characters[i];
    }
    return NULL;
}

// General
void startCharacters() {

    // Open file
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    ssize_t read;

    fp = fopen(FILE_PATH, "r");

    if(fp == NULL) {

        perror("x Error opening file");
        exit(EXIT_FAILURE);
    }

    // Skip first line
    getline(&line, &len, fp);

    // Read all lines
    while((read = getline(&line, &len, fp)) != -1) {

        // Read character from line
        Character character = character_read(line);

        characters[charactersLength++] = character;

        if(charactersLength >= MAX_CHARACTERS) {

            perror("x Max characters reached");
            exit(EXIT_FAILURE);
        }
    }

    // Close file and free memory
    fclose(fp);

    if(line) free(line);
}

// ---------------------------------------------------------------------------------------------------- //

// Main
int main() {

    // ----------------------------------------------------------------- //

    // #1 - Start - Read all characters from file
    startCharacters();

    // ----------------------------------------------------------------- //

    // #2 - Read input and print characters from pub.in id entries
    char id[MAX_UUID_SIZE];
    scanf(" %[^\n]s", id);

    while(true) {

        // Clean \n from the end of the string
        if(id[strlen(id) - 1] == '\n' || id[strlen(id) - 1] == '\r') id[strlen(id) - 1] = '\0';

        if(isEnd(id)) break;
        else {
            
            Character *character = character_searchById(id);

            if(character) character_print(character);
            else printf("x Character not found!\n");

            // ------------------------- //
    
            scanf(" %[^\n]s", id);
        }
    }
    return 0;
}