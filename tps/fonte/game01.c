// ------------------------------------------------------------------------------ //
// Author: Vinicius Gabriel dos Santos - https://github.com/ravixr
// Sep/2022
//
// DESCRIPTION:
//     In addition to the game data structure and 
//     the solution to the second question of the assignment, 
//     this file contains a basic implementation of a string type
//     which was extensively used in the game data structure
//     as well as in the solution algorithm.
// ------------------------------------------------------------------------------ //

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <assert.h>
#include <stdint.h>

#define GAME_FIELDS_SIZE 17
#define MAX_FIELD_SIZE 500
#define MAX_LINE_SIZE 1000
#define MAX_GAMES 100

// If on windows remove first slash -> 'tmp/games.csv'
#define FILE_PATH "/tmp/games.csv"

// Assert macro to print custom message when assertion fails
#define assert__(x) for (; !(x); assert(x))

// --------------------------- my_very_basic_string.h --------------------------- //

typedef struct string_t string;

typedef struct strarr_t strarr;

struct string_t {
    char *buf;
    char (*char_at)(const string *, size_t);
    int (*compare)(const string *, const string *);
    void (*delete)(string *);
    size_t (*find)(const string *, const char *);
    size_t (*length)(const string *);
    void (*replace)(string *, const char *, const char *);
    strarr (*split)(const string *, const char *); 
    string (*substr)(const string *, size_t, size_t);
    float (*to_float)(const string *);
    int (*to_int)(const string *);
    void (*trim)(string *);
};

struct strarr_t {
    string *src;
    size_t length;
    void (*delete)(strarr *);
};

// string functions declaration
char str_char_at(const string *, size_t);
int str_compare(const string *, const string *);
void str_delete(string *);
size_t str_find(const string *, const char *);
size_t str_length(const string *);
void str_replace(string *, const char*, const char *);
string new_string(char *);
strarr str_split(const string *, const char *);
string str_substr(const string *, size_t, size_t);
float str_to_float(const string *);
int str_to_int(const string *);
void str_trim(string *);

// strarr functions declaration
strarr new_strarr(string *, size_t);
void strarr_delete(strarr *);

// --------------------------- my_very_basic_string.c --------------------------- //

// Fuction to initialize string type
string new_string(char *src)
{
    string str;
    if (src != NULL) {
        if (strcmp(src, "") != 0) {
            str.buf = malloc(sizeof(char) * (strlen(src) + 1));
            strcpy(str.buf, src);
        } else {
            str.buf = malloc(sizeof(char) * 5);
            strcpy(str.buf, "null");
        }
    } else str.buf = NULL;
    str.char_at = &str_char_at;
    str.compare = &str_compare;
    str.delete = &str_delete;
    str.find = &str_find;
    str.replace = &str_replace;
    str.length = &str_length;
    str.split = &str_split;
    str.substr = &str_substr;
    str.to_float = &str_to_float;
    str.to_int = &str_to_int;
    str.trim = &str_trim;
    return str;
}

// Fuction to deallocate string type
void str_delete(string *self)
{
    free(self->buf);
}

// Returns character present in the specified index of the string
// e.g: "foo" idx: 0 -> 'f'
char str_char_at(const string *self, size_t idx)
{
    // Macro to assert index is in bounds
    assert__(idx < strlen(self->buf)) {
        fprintf(stderr, "String index %ld is out of bounds\n", idx);
    }
    return self->buf[idx];
}

// Allows comparison between string type variables using strcmp in the raw data
int str_compare(const string *self, const string *another_str)
{
    return strcmp(self->buf, another_str->buf);
}

// Searches the string for the first occurrence of the pattern specified.
// Returns the index position of the first character of the pattern
// or the length of the string if the pattern is not found
// e.g.: "foo bar", "bar" -> 4 | "foo bar", "baz" -> 7
size_t str_find(const string *self, const char *lkf)
{
    size_t i = 0, 
    self_len = strlen(self->buf),
    lkf_len = strlen(lkf);

    // Macro to assert pattern string is valid
    assert__((strcmp(lkf, "") != 0) && (lkf_len <= self_len)) {
        fprintf(stderr, "Pattern '%s' is invalid for the specified string\n", lkf);
    }

    // Find algorithm
    for (size_t j = 0; i < self_len; i++) {
        if (self->buf[i] == lkf[j]) {
            j++;
        } else {
            i-= j; j = 0;
        }
        if (j == lkf_len) {
            i -= (j - 1);
            break;
        }
    }
    return i;
}

// Returns the length of the string using strlen in the raw data
size_t str_length(const string *self)
{
    return strlen(self->buf);
}

// Replaces all occurrences of specified pattern in the string with the new specified pattern
// if the string doesn't contains the pattern to be replaced the string is not changed
// e.g.: "foobar", "bar", "" -> "foo" | "foobar", "baz", "" -> "foobar"
void str_replace(string *self, const char *old_val, const char *new_val)
{
    // Saving useful lengths in variables
    size_t old_len = strlen(self->buf),
    nv_len = strlen(new_val),
    ov_len = strlen(old_val);

    // Macro to assert given pattern is valid
    assert__((strcmp(old_val, "") != 0) && (old_len >= ov_len)) {
        fprintf(stderr, "Invalid pattern for argument 'old_val'\n");
    }

    // Calculating the max possible amount of patterns in the string
    // then allocating an array to store their indexes
    size_t idx_sz = (old_len / ov_len),
    *idx = malloc(sizeof(size_t) * (idx_sz + 1)), 
    idx_i = 0, last_idx = 0, skip = 0;

    // Getting all starting indexes of where the pattern is found
    string aux = new_string(NULL);
    aux.buf = (self->buf);
    while ((idx_i <= idx_sz) && (last_idx < old_len)) {
        idx[idx_i] = str_find(&aux, old_val) + skip;
        skip = idx[idx_i++] + ov_len;
        aux.buf = (self->buf + skip);
        last_idx = idx[idx_i - 1];
    }

    // Checking if the pattern is actually on the string
    if (idx[0] != old_len) {
        // Assuring 'idx_i' will not be 0
        idx_i > 1 ? (idx_i -= 1) : (idx_i = 1);

        // Calculating new length of the string then allocating
        size_t new_len = (old_len + ((nv_len - ov_len) * idx_i)); 
        char *tmp = malloc(sizeof(char) * (new_len + 1));

        // Main Replacement algorithm: copies old string char by char, 
        // when the index is equal to the range of the next found pattern
        // starts copying the new pattern char by chat into the string
        if (nv_len == 0) nv_len = 1;
        for (size_t i = 0, j = 0, k = 0, l = 0; i < new_len;) {
            if (k >= idx[l] && k < (idx[l] + ov_len)) {
                if (strcmp(new_val, "") != 0)
                    tmp[i++] = new_val[j];
                j++;
                if (j == nv_len) {
                    k += ov_len;
                    j = 0; l++;
                }
            } else tmp[i++] = self->buf[k++];
        }
        tmp[new_len] = '\0'; // Adding null terminator in the new string
        free(self->buf);     // freeing old string
        self->buf = tmp;     // Pointing to new string
    }
    free(idx); // freeing array of indexes of the old string
}

// Uses strtok to split the raw char array 
// then build new strings with the splitted char arrays
// and bundle all of them in the strarr type
// e.g.: 'foo,bar' ',' -> ['foo', 'bar']
strarr str_split(const string *self, const char *delim)
{
    char *str = malloc(sizeof(char) * (strlen(self->buf) + 1));
    strcpy(str, self->buf);
    char *token = strtok(str, delim);
    size_t count = 0;
    strarr str_arr = new_strarr(NULL, 0);
    string *tmp;
    while(token != NULL) {
        tmp = realloc(str_arr.src, sizeof(string) * (count + 1));
        if (tmp != NULL) {
            tmp[count++] = new_string(token);
            str_arr.src = tmp;
        }
        token = strtok(NULL, delim);
    }
    free(str);
    free(token);
    str_arr.length = count;
    return str_arr;
}

// Returns a new string that is a copy of the portion of the original string
// that starts at character position 'pos' and spans 'len' characters
// e.g.: "foo bar" pos: 4, len: 3 -> "bar"
string str_substr(const string *self, size_t pos, size_t len)
{
    // Macro to assert pos and len are in bounds
    assert__((pos + len) <= strlen(self->buf)) {
        fprintf(stderr, "String index %ld is out of bounds for '%s'\n", (pos + len), self->buf);
    }
    string substr = new_string(NULL);
    substr.buf = malloc(sizeof(char) * (len + 1));
    for (size_t i = 0, j = 0; i < len; i++, j++) {
        substr.buf[j] = self->buf[pos + i];
    }
    substr.buf[len] = '\0';
    return substr;
}

// Uses atof to convert string to float
float str_to_float(const string *self)
{
    return atof(self->buf);
}

// Uses atoi to convert string to int
int str_to_int(const string *self)
{
    return atoi(self->buf);
}

// Removes all spaces only from the beginning and ending of the string
// e.g.: "    foo  " -> "foo" | "foo bar" -> "foo bar"
void str_trim(string *self)
{
    size_t i = 0, j = (strlen(self->buf) - 1);
    while (self->buf[i] == ' ' || self->buf[j] == ' ') {
        if (self->buf[i] == ' ') i++;
        if (self->buf[j] == ' ') j--;
    }
    string tmp = self->substr(self, i, (j - i) + 1);
    free(self->buf);
    self->buf = tmp.buf;
}

// Fuction to initialize string array type
strarr new_strarr(string *src, size_t src_length)
{
    strarr str_arr;
    if (src != NULL)
        str_arr.src = src;
    else {
        src_length = (src_length > 0 ? src_length : 1);
        str_arr.src = malloc(sizeof(string *));
    }
    str_arr.length = src_length;
    str_arr.delete = &strarr_delete;
    return str_arr;
}

// Fuction to deallocate string array type
void strarr_delete(strarr *self)
{
    for (size_t i = 0; i < self->length; i++) {
        free(self->src[i].buf);
    }
    free(self->src);
}

// ----------------------------------- game.h ----------------------------------- //

typedef struct date_t date;

struct date_t {
    uint8_t day;
    char month[4];
    unsigned year;
    size_t value;
};

date new_date(string *);
unsigned strmon_to_int(const char *);

typedef struct game_t game;

struct game_t {
    unsigned app_id;
    string name;
    date release_date;
    string owners;
    unsigned age;
    float price;
    unsigned dlcs;
    strarr languages;
    string website;
    bool windows;
    bool mac;
    bool linux_;
    float upvotes;
    unsigned avg_pt;
    string developers;
    strarr genres;
};

game empty_game(void);
game new_game(string *);
game str_to_game(string *);
game chararr_to_game(char *);
void game_print(game *);
void game_read_csv(game *, size_t *, size_t);
char *avgpt_to_chararr (unsigned);

// ----------------------------------- game.c ----------------------------------- //

// Converts month abbreviated char array in format 'Mmm' 
// to unsigned int, if unsuccessful returns 0
// e.g.: "Aug" -> 8 | "aug" -> 0
unsigned strmon_to_int(const char *mon)
{
    unsigned i = 0;
    if (strcmp(mon, "Jan") == 0) { i = 1; } 
    else if (strcmp(mon, "Feb") == 0) { i = 2; } 
    else if (strcmp(mon, "Mar") == 0) { i = 3; } 
    else if (strcmp(mon, "Apr") == 0) { i = 4; } 
    else if (strcmp(mon, "May") == 0) { i = 5; } 
    else if (strcmp(mon, "Jun") == 0) { i = 6; } 
    else if (strcmp(mon, "Jul") == 0) { i = 7; } 
    else if (strcmp(mon, "Aug") == 0) { i = 8; } 
    else if (strcmp(mon, "Sep") == 0) { i = 9; } 
    else if (strcmp(mon, "Oct") == 0) { i = 10; } 
    else if (strcmp(mon, "Nov") == 0) { i = 11; } 
    else if (strcmp(mon, "Dec") == 0) { i = 12; }
    return i;
}

// Fuction to initialize date type
// Assumes that argument is a string 
// in the format 'mmm dd, yyyy' or 'mmm yyyy'
// or NULL for empty initialization
date new_date(string *fmt)
{
    date d;
    if (fmt != NULL) {
        uint8_t i = 0;
        string aux;
        // If the format is 'mmm dd, yyyy'
        if (strlen(fmt->buf) > 10) {
            // parsing day
            i = fmt->find(fmt, ",") - 4;
            aux = fmt->substr(fmt, 4, i);
            d.day = aux.to_int(&aux);
            aux.delete(&aux);

            // parsing month
            aux = fmt->substr(fmt, 0, 3);
            strcpy(d.month, aux.buf);
            aux.delete(&aux);

            // parsing year
            i = fmt->find(fmt, ",") + 2;
            aux = fmt->substr(fmt, i, (fmt->length(fmt) - i));
            d.year = aux.to_int(&aux);
            aux.delete(&aux);
        } else { // Assuming format is 'mmm yyyy'
            // no day provided in this format
            d.day = 0;

            // parsing month
            i = fmt->find(fmt, " ");
            aux = fmt->substr(fmt, 0, i);
            strcpy(d.month, aux.buf);
            aux.delete(&aux);

            // parsing year
            aux = fmt->substr(fmt, (i + 1), fmt->length(fmt) - (i + 1));
            d.year = aux.to_int(&aux);
            aux.delete(&aux);
        }
        // parsing value
        unsigned mon = strmon_to_int(d.month);
        d.value = ((d.year * 10000) + (mon * 100) + d.day);
    } else {
        d.day = 0;
        strcpy(d.month, "mmm");
        d.year = 0;
        d.value = 0;
    }
    return d;
}

// Function to initialize 
// an 'empty' game struct
game empty_game(void)
{
    game g;
    g.app_id = 0;
    g.name = new_string("");
    g.release_date = new_date(NULL);
    g.owners = new_string("");
    g.age = 0;
    g.price = 0.0f;
    g.dlcs = 0;
    g.languages = new_strarr(NULL, 0);
    g.website = new_string("");
    g.windows = false;
    g.mac = false;
    g.linux_ = false;
    g.upvotes = 0.0f;
    g.avg_pt = 0;
    g.developers = new_string("");
    g.genres = new_strarr(NULL, 0);
    return g;
}

// Function to initialize a new game with
// the retrievd data in the string array
game new_game(string *s_arr)
{
    game g;
    if (s_arr != NULL) {
        // App id
        g.app_id = atoi(s_arr[0].buf);
        // Name
        g.name = new_string(s_arr[1].buf);
        // Release date
        g.release_date = new_date(s_arr + 2);
        // Owners
        g.owners = new_string(s_arr[3].buf);
        // Age, Price, DLCs
        g.age = atoi(s_arr[4].buf);
        g.price = atof(s_arr[5].buf);
        g.dlcs = atoi(s_arr[6].buf);
        // Languages 
        // If string is not empty then splits it into a string array
        if (strcmp(s_arr[7].buf, "[]") != 0) {
            string tmp = s_arr[7].substr(s_arr + 7, 2, strlen(s_arr[7].buf) - 4);
            tmp.replace(&tmp, "', '", "|");
            g.languages = tmp.split(&tmp, "|");
            tmp.delete(&tmp);
        } else {
            g.languages = new_strarr(NULL, 0);
            string *tmp = realloc(g.languages.src, sizeof(string));
            if (tmp != NULL) {
                tmp[0] = new_string("");
                g.languages.src = tmp;
                g.languages.length = 1;
            }
        }
        // Website
        g.website = new_string(s_arr[8].buf);
        // Windows, Mac, Linux
        g.windows = (strcmp(s_arr[9].buf, "True") == 0) ? true : false;
        g.mac = (strcmp(s_arr[10].buf, "True") == 0) ? true : false;
        g.linux_ = (strcmp(s_arr[11].buf, "True") == 0) ? true : false;
        // Upvotes
        float up_votes = atof(s_arr[12].buf);
        float down_votes = atof(s_arr[13].buf);
        g.upvotes = (up_votes / ((up_votes + down_votes) / 100));
        // Avg pt
        g.avg_pt = atoi(s_arr[14].buf);
        // Developers
        g.developers = new_string(s_arr[15].buf);
        // Genres
        // If string is not empty and has a ',' then splits it into a string array
        if ((strcmp(s_arr[16].buf, "") != 0) &&
        (s_arr[16].find(s_arr + 16, ",") != strlen(s_arr[16].buf))) {
                g.genres = s_arr[16].split(s_arr + 16, ",");
        } else {
            g.genres = new_strarr(NULL, 0);
            string *tmp = realloc(g.genres.src, sizeof(string));
            if (tmp != NULL) {
                tmp[0] = new_string(s_arr[16].buf);
                g.genres.src = tmp;
                g.genres.length = 1;
            }
        }
    } else g = empty_game();
    return g;
}

// function to deallocates all 
// the heap variables inside the game struct
void game_delete(game *g)
{
    if (g != NULL) {
        g->name.delete(&g->name);
        g->owners.delete(&g->owners);
        g->languages.delete(&g->languages);
        g->website.delete(&g->website);
        g->developers.delete(&g->developers);
        g->genres.delete(&g->genres);
    }
}

// Receives a char array that contains 
// the data of the game strut in a csv format
// parses it and returns a game data structure
game chararr_to_game(char *ch_arr)
{
    game g;
    if (ch_arr != NULL) {
        // Initializing static array of strings
        // where each index will be a field of the game data struct
        string s_arr[GAME_FIELDS_SIZE];
        for (int i = 0; i < GAME_FIELDS_SIZE; i++) {
            s_arr[i] = new_string(NULL);
        }

        // Initializing variables for the split algorithm
        string aux = new_string(NULL);
        aux.buf = malloc(sizeof(char) * MAX_LINE_SIZE);
        size_t ch_arr_len = strlen(ch_arr), s_arr_i = 0, aux_i = 0;
        bool is_str_lit = false;

        // Loop to split each csv cell into a string 
        // and adds it to the array of strings
        for (size_t i = 0; i < ch_arr_len; i++) {
            if (ch_arr[i] == '"') {
                is_str_lit = (is_str_lit ? false : true);
            } else if (ch_arr[i] == ',' && !is_str_lit) {
                aux.buf[aux_i] = '\0';
                s_arr[s_arr_i].buf = malloc(sizeof(char) * (strlen(aux.buf) + 1));
                strcpy(s_arr[s_arr_i].buf, aux.buf);
                s_arr_i++; aux_i = 0;
            } else {
                aux.buf[aux_i++] = ch_arr[i];
            }
        }
        // Adding last string cell to the array
        aux.buf[aux_i] = '\0';
        s_arr[s_arr_i].buf = malloc(sizeof(char) * (strlen(aux.buf) + 1));
        strcpy(s_arr[s_arr_i].buf, aux.buf);
        aux.delete(&aux);
        // Creating game with parsed data
        g = new_game(s_arr);

        // Deallocating the string array
        for (size_t i = 0; i < GAME_FIELDS_SIZE; i++) {
            free(s_arr[i].buf);
        }
    } else g = empty_game();
    return g;
}

// Converts avg_pt (int with amount of minutes)
// to a string in format '[x]h [y]m' returns
// a string with 'null' if avg_pt equals zero
char *avgpt_to_chararr (unsigned avg_pt)
{
    char *c_arr = calloc(16, sizeof(char));
    if (avg_pt != 0) {
        unsigned h = avg_pt / 60;
        unsigned m = avg_pt % 60;

        if (h != 0 && m != 0) {
            snprintf(c_arr, 16, "%dh %dm", h, m);
        } else if (h != 0) {
            snprintf(c_arr, 16, "%dh", h);
        } else if (m != 0) {
            snprintf(c_arr, 16, "%dm", m);
        }
    } else {
        strcpy(c_arr, "null");
    }
    return c_arr;
}

// prints the game structure in the format 
// as is specified in the assignment
void game_print(game *g) 
{
    printf("%u %s %s/%d %s %u %.2f %u [", 
    g->app_id, g->name.buf, 
    g->release_date.month, 
    g->release_date.year, 
    g->owners.buf, g->age, 
    g->price, g->dlcs);
    // languages
    for (size_t i = 0; i < g->languages.length - 1; i++)
        printf("%s, ", g->languages.src[i].buf);
    char *aux = avgpt_to_chararr(g->avg_pt);
    printf("%s] %s %s %s %s %.0f%% %s %s [", 
    g->languages.src[g->languages.length - 1].buf, g->website.buf, 
    (g->windows ? "true" : "false"), (g->mac ? "true" : "false"),
    (g->linux_ ? "true" : "false"), g->upvotes, aux, g->developers.buf);
    free(aux);
    // genres
    for (size_t i = 0; i < g->genres.length - 1; i++)
        printf("%s, ", g->genres.src[i].buf);
    printf("%s]\n", g->genres.src[g->genres.length - 1].buf);
}

// Search for the matching 'app_id' and read the game data 
// from the file 'games.csv' then adds the game to the games array
void game_read_csv(game *games, size_t *ids, size_t ids_len)
{
    // Handling file opening 
    FILE *f = fopen(FILE_PATH, "r");
    assert__(f != NULL) {
        fprintf(stderr, "Failed to open '%s'\n%s", FILE_PATH,
        "Hint: Try adding or removing a '/' in front (OS Dependent)\n");
    }

    char line[MAX_LINE_SIZE + 1];
    size_t cur_id = 0;
    // Searching the desired id then calling the parser function
    for (size_t i = 0; i < ids_len; i++) {
        while (cur_id != ids[i]) {
            // reads line from file
            fgets(line, MAX_LINE_SIZE, f);
            // checking if is a reserved char to then trim it
            if (line[strlen(line) - 2] < ' ') line[strlen(line) - 2] = '\0';
            else if (line[strlen(line) - 1] < ' ') line[strlen(line) - 1] = '\0';
            // atoi will only parse the beginning of the string ;)
            cur_id = atoi(line);
        }
        rewind(f); // Resets file pointer to the beginning of the file
        games[i] = chararr_to_game(line); // calling parser function
    }
    fclose(f); // closing the file
}

// ------------------------------------ main ------------------------------------ //

// Uses strcmp to check if 
// input string equals 'FIM'
// meaning end of input
bool is_fim(char *c_arr) 
{
    return (strcmp(c_arr, "FIM") == 0);
}

// The main function contains the solution to
// the second question of the assignment, which is
// to read 'n' lines of strings containing the 
// desired IDs of games to be read from the file 'games.csv',
// parse the data, store it in a game struct already defined,
// and print all of them in a specified format.
int main(void)
{
    // game array 
    game games[MAX_GAMES];
    size_t games_sz = 0;
    // input variables
    char input[MAX_FIELD_SIZE ];
    size_t ids[MAX_GAMES];

    // Reading input and converting to integer
    // then adding it to the array of ids to be searched
    fgets(input, MAX_LINE_SIZE, stdin);
    input[strlen(input) - 1] = '\0';
    while (!is_fim(input))  {
        ids[games_sz++] = atoi(input);
        fgets(input, MAX_LINE_SIZE, stdin);
        // checking if is a reserved char to then trim it
        if (input[strlen(input) - 2] < ' ') input[strlen(input) - 2] = '\0';
        else if (input[strlen(input) - 1] < ' ') input[strlen(input) - 1] = '\0';
    }
    // If the array of ids is not empty
    if (games_sz > 0) {
        // Calls function to read from file and populate array of games
        game_read_csv(games, ids, games_sz);
        
        // Prints the games read and frees the heap allocated memory
        for (size_t i = 0; i < games_sz; i++) {
            game_print(games + i);
            game_delete(games + i);
        }
    }
    return 0;
}
