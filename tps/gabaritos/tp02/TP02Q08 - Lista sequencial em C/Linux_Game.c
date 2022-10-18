/**
 
 * @file Linux_Game.c
 * @author Pedro Lopes
 * @version 1.0
 * @date 2022-10-17
 * @copyright Copyright (c) 2022
 
**/

// -------------------------------------------------------------------------------- //

// Includes
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <math.h>

// -------------------------------------------------------------------------------- //

// Definitions
#define MAX_GAMES               500
#define MAX_FIELD_SIZE          250
#define MAX_STRING_ARRAY_SIZE   100

// -------------------------------------------------------------------------------- //

// Structs
typedef struct {

    int year,
        month;
} Date; 

typedef struct {

    char name[MAX_FIELD_SIZE],
        owners[MAX_FIELD_SIZE],
        website[MAX_FIELD_SIZE], 
        developers[MAX_FIELD_SIZE],
        languages[MAX_STRING_ARRAY_SIZE][30],
        genres[MAX_STRING_ARRAY_SIZE][30];

    Date release_date;
    int app_id, age, dlcs, avg_playtime, count_languages, count_genres;
    float price, upvotes;
    bool windows_os, mac_os, linux_os;

} Game;

// -------------------------------------------------------------------------------- //

// Global variables
Game games[MAX_GAMES];
int n = 0;

Game gamesFull[5000];
int x = 0;

// -------------------------------------------------------------------------------- //

// Functions
bool isFim(char* s) { return s[0] == 'F' && s[1] == 'I' && s[2] == 'M'; }

void substring(char *string, char *string_start, int length) {

    strncpy(string, string_start, length);
    string[length] = '\0';
}

char *getMonthName(int month) {

    switch(month) {

		case 1: return "Jan"; break;
        case 2: return "Feb"; break;
        case 3: return "Mar"; break;
        case 4: return "Apr"; break;
        case 5: return "May"; break;
        case 6: return "Jun"; break;
        case 7: return "Jul"; break;
        case 8: return "Aug"; break;
        case 9: return "Sep"; break;
        case 10: return "Oct"; break;
        case 11: return "Nov"; break;
        case 12: return "Dec"; break;
        
		default: return "N/A"; break;
    }        
}

int getMonthNumber(char* month) {

    if(!strcmp(month, "Jan")) return 1;
    else if(!strcmp(month, "Feb")) return 2;
    else if(!strcmp(month, "Mar")) return 3;
    else if(!strcmp(month, "Apr")) return 4;
    else if(!strcmp(month, "May")) return 5;
    else if(!strcmp(month, "Jun")) return 6;
    else if(!strcmp(month, "Jul")) return 7;
    else if(!strcmp(month, "Aug")) return 8;
    else if(!strcmp(month, "Sep")) return 9;
    else if(!strcmp(month, "Oct")) return 10;
    else if(!strcmp(month, "Nov")) return 11;
    else if(!strcmp(month, "Dec")) return 12;
}

// -------------------------------------------------------------------------------- //

// Class game functions
void game_start(Game *game) {

    strcpy(game -> name, "");
    strcpy(game -> owners, "");
    strcpy(game -> website, "");
    strcpy(game -> developers, "");

    for(int i = 0; i < MAX_STRING_ARRAY_SIZE; i++) {
        
        strcpy(game -> languages[i], "");
        strcpy(game -> genres[i], "");
    }

    game -> release_date.month = -1;
    game -> release_date.year = -1;
    game -> app_id = -1;
    game -> age = -1;
    game -> dlcs = -1;
    game -> avg_playtime = -1;
    game -> price = -1;
    game -> upvotes = -1;
    game -> windows_os = false;
    game -> mac_os = false;
    game -> linux_os = false;

    game -> count_languages = 0;
    game -> count_genres = 0;
}

void game_print(Game *game) {

    int hours = game -> avg_playtime / 60,
        minutes = game -> avg_playtime % 60;

    printf("%i %s %s/%04i %s %i %.2f %i [", game -> app_id, game -> name, getMonthName(game -> release_date.month), game -> release_date.year, game -> owners, game -> age, game -> price, game -> dlcs);

    for(int i = 0; i < game -> count_languages; i++) {

        printf("%s%s", game -> languages[i], i < game -> count_languages - 1 ? ", " : "");
    }

    printf("] %s %s %s %s ", game -> website, game -> windows_os ? "true" : "false", game -> mac_os ? "true" : "false", game -> linux_os ? "true" : "false");

    if(isnan(game -> upvotes)) printf("0.0%% ");
    else printf("%.0f%% ", game -> upvotes);

    if(hours > 0)
    {
        printf("%ih ", hours);

        if(minutes > 0) printf("%im ", minutes);
    }
    else {

        if(minutes > 0) printf("%im ", minutes);
        else printf("null ");
    }

    printf("%s [", game -> developers);

    for(int i = 0; i < game -> count_genres; i++) {

        printf("%s%s", game -> genres[i], i < game -> count_genres - 1 ? ", " : "");
    }

    printf("]\n");
}

Game game_clone(Game *game) {
    
    Game cloned;

    strcpy(cloned.name, game -> name);
    strcpy(cloned.owners, game -> owners);
    strcpy(cloned.website, game -> website);
    strcpy(cloned.developers, game -> developers);

    for(int i = 0; i < game -> count_languages; i++) strcpy(cloned.languages[i], game -> languages[i]);
    for(int i = 0; i < game -> count_genres; i++) strcpy(cloned.genres[i], game -> genres[i]);
    
    cloned.release_date.month = game -> release_date.month;
    cloned.release_date.year = game -> release_date.year;
    cloned.app_id = game -> app_id;
    cloned.age = game -> age;
    cloned.dlcs = game -> dlcs;
    cloned.avg_playtime = game -> avg_playtime;
    cloned.price = game -> price;
    cloned.upvotes = game -> upvotes;
    cloned.windows_os = game -> windows_os;
    cloned.mac_os = game -> mac_os;
    cloned.linux_os = game -> linux_os;
    return cloned;
}

void game_read(Game *game, char *line) {

    char c_search, sub[MAX_FIELD_SIZE];
    int index = 0, atr_index = 0;

    // ------------------------------------------------------------ //

    // Find "AppID"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);

            game -> app_id = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Name"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> name, sub);

                if(c_search == ',') index++;
                else if(c_search == '\"') index += 2;
                
                atr_index = index;
                break;
            }
        }
    }
    else {

        strcpy(game -> name, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find release date
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';

        while(true) {

            index++;

            if(line[index] == c_search) {

                substring(sub, &line[atr_index], index - atr_index);

                char subDate[10];

                substring(subDate, &sub[0], 3);

                game -> release_date.month = getMonthNumber(subDate);

                if(c_search == ',') {
                    
                    substring(subDate, &sub[4], 4);

                    game -> release_date.year = atoi(subDate);

                    index++;
                }
                else if(c_search == '\"') {
                    
                    int nmbSpace = 0;

                    for(int i = 0; ; i++) {

                        if(sub[i] == ' ') nmbSpace++;

                        if(nmbSpace == 2) {

                            i++;

                            substring(subDate, &sub[i], 4);

                            game -> release_date.year = atoi(subDate);
                            break;
                        }
                    }

                    index += 2;
                }

                atr_index = index;
                break;
            }
        }
    }
    else {

        game -> release_date.month = 0;
        game -> release_date.year = 0;

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Owners"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);
            strcpy(game -> owners, sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Age"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            game -> age = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Price"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);
            
            game -> price = atof(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "DLCs"
    while(true) {

        index++;

        if(line[index] == ',') {
            
            substring(sub, &line[atr_index], index - atr_index);

            game -> dlcs = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Languages"
    while(true) {

        index++;

        if(line[index] == ']') {

            index++;
            
            if(line[index] == ',') index++;
            else if(line[index] == '\"') index += 2;

            atr_index = index;
            break;
        }
        else if(line[index] == '\'') {

            int wordStart = index + 1;

            while(true) {

                index++;

                if(line[index] == '\'') {
                    
                    substring(sub, &line[wordStart], index - wordStart);
                    strcpy(game -> languages[game -> count_languages++], sub);
                    break;
                }
            }
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Website"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> website, sub);

                atr_index = ++index;
                break;
            }
        }
    }
    else {

        strcpy(game -> website, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Windows"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> windows_os = true;

            atr_index = ++index;
            break;
        }
    }

    // Find "Mac"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> mac_os = true;

            atr_index = ++index;
            break;
        }
    }

    // Find "Linux"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            if(!strcmp(sub, "True")) game -> linux_os = true;

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Upvotes"
    int positives, negatives;

    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            positives = atoi(sub);
            atr_index = ++index;
            break;
        }
    }

    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            negatives = atoi(sub);
            atr_index = ++index;
            break;
        }
    }

    game -> upvotes = (float)(positives * 100) / (float)(positives + negatives);

    // ------------------------------------------------------------ //
    
    // Find "AVG Playtime"
    while(true) {

        index++;

        if(line[index] == ',') {

            substring(sub, &line[atr_index], index - atr_index);
            
            game -> avg_playtime = atoi(sub);

            atr_index = ++index;
            break;
        }
    }

    // ------------------------------------------------------------ //
    
    // Find "Developers"
    if(line[atr_index] != ',') {

        if(line[atr_index] == '\"') {
            
            atr_index++;
            c_search = '\"';
        }
        else c_search = ',';
        
        while(true) {

            index++;

            if(line[index] == c_search) {
                
                substring(sub, &line[atr_index], index - atr_index);
                strcpy(game -> developers, sub);

                atr_index = ++index;
                break;
            }
        }
    }
    else {

        strcpy(game -> developers, "null");

        atr_index = ++index;
    }

    // ------------------------------------------------------------ //
    
    // Find "Genres"
    if(index < strlen(line) - 1) {

        if(line[index] == ',') atr_index = ++index;                    

        if(line[atr_index] == '\"') {

            atr_index++;
            
            while(true) {

                index++;

                if(line[index] == ',') {
                    
                    substring(sub, &line[atr_index], index - atr_index);
                    strcpy(game -> genres[game -> count_genres++], sub);

                    atr_index = ++index;
                }
                else if(line[index] == '\"') {

                    substring(sub, &line[atr_index], strlen(line) - 1 - atr_index);
            
                    if(sub[strlen(sub) - 2] == '\"') sub[strlen(sub) - 2] = '\0';

                    strcpy(game -> genres[game -> count_genres++], sub);
                    break;
                }
            }
        }
        else {

            substring(sub, &line[atr_index], strlen(line) - 1 - atr_index);
            
            sub[strlen(line) - 2 - atr_index] = '\0';

            strcpy(game -> genres[game -> count_genres++], sub);   
        }
    }
}

// -------------------------------------------------------------------------------- //

// Functions - List
void list_insertBegin(Game x) {

    if(n >= MAX_GAMES) {

        printf("Insert error: MAX_GAMES reached");
        exit(1);
    } 

    for(int i = n; i > 0; i--) games[i] = games[i - 1];
   
    games[0] = x;
    n++;
}

void list_insertEnd(Game x) {

    if(n >= MAX_GAMES) {

        printf("Insert error: MAX_GAMES reached");
        exit(1);
    } 

    games[n++] = x;
}

void list_insert(Game x, int pos) {

    if(n >= MAX_GAMES || (pos < 0 || pos > n)) {

        printf("Insert error: %s", n >= MAX_GAMES ? "MAX_GAMES reached" : "Invalid position");
        exit(1);
    }

    for(int i = n; i > pos; i--) games[i] = games[i-1];

    games[pos] = x;
    n++;
}

Game list_removeBegin() {

    Game resp;

    if(n == 0) {

        printf("Remove error: Empty list");
        exit(1);
    }

    resp = games[0];
    n--;

    for(int i = 0; i < n; i++) games[i] = games[i + 1];
    return resp;
}

Game list_removeEnd() {

    if(n == 0) {

        printf("Remove error: Empty list");
        exit(1);
    }
    return games[--n];
}

Game list_remove(int pos) {

    Game resp;

    if(n >= MAX_GAMES || (pos < 0 || pos > n)) {

        printf("Insert error: %s!", n == 0 ? "Empty list" : "Invalid position");
        exit(1);
    }

    resp = games[pos];
    n--;

    for(int i = pos; i < n; i++) games[i] = games[i+1];
    return resp;
}

void list_print() {

    for(int i = 0; i < n; i++) {

        printf("[%i] ", i);
        game_print(&games[i]);
    }
}

Game game_search(int app_id) {

    for(int i = 0; i < x; i++) {

        if(gamesFull[i].app_id == app_id) return gamesFull[i];
    }

    Game game;
    game.app_id = -1;
    return game;
}

// ---------------------------------------------------------------------------------------------------------- //

int main() {

    // ---------------------------------------------------------------------------------------- //
    
    // Fill full games list
    FILE *fp;
    char *line = NULL;
    size_t len = 0;
    size_t read;

    fp = fopen("/tmp/games.csv", "r");

    if(fp == NULL) exit(EXIT_FAILURE);

    // -------------------------------------- //

    while((read = getline(&line, &len, fp)) != -1) {

        Game game;

        game_start(&game);
        game_read(&game, line);
        
        gamesFull[x++] = game;
    }

    fclose(fp);

    if(line) free(line);

    // ---------------------------------------------------------------------------------------- //

    char line_in[100];

    // Fill production games list
    scanf(" %[^\n]", line_in);
        
    while(true) {

        if(isFim(line_in)) break;

        // -------------------------- //

        int app_id = atoi(line_in);

        Game found = game_search(app_id);

        if(found.app_id != -1) list_insertEnd(found);

        // -------------------------- //

        scanf(" %[^\n]", line_in);
    }

    // ---------------------------------------------------------------------------------------- //

    // Execute operations
    int n_ops;
    scanf("%i", &n_ops);
        
    for(int i = 0; i < n_ops; i++) {

        scanf(" %[^\n]", line_in);

        Game game;
        char params[10];

        if(line_in[0] == 'I') {

            substring(params, &line_in[3], strlen(line_in) - 3);

            if(line_in[1] == 'I') list_insertBegin(game_search(atoi(params)));
            else if(line_in[1] == 'F') list_insertEnd(game_search(atoi(params)));
            else if(line_in[1] == '*') {

                char appId[10], pos[10];
                int i = 0;

                while(true) {

                    if(params[i] == ' ') {

                        substring(pos, &params[0], i);
                        substring(appId, &params[i + 1], strlen(params) - i - 1);
                        break;
                    }
                    else i++;
                }

                list_insert(game_search(atoi(appId)), atoi(pos));
            }
        }
        else if(line_in[0] == 'R') {

            if(line_in[1] == 'I') printf("(R) %s\n", list_removeBegin().name);
            else if(line_in[1] == 'F') printf("(R) %s\n", list_removeEnd().name);
            else if(line_in[1] == '*') {

                substring(params, &line_in[3], strlen(line_in) - 3);

                printf("(R) %s\n", list_remove(atoi(params)).name);
            }
        }
    }

    list_print();
    return EXIT_SUCCESS;
}