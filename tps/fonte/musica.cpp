#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define MAX_LINE_SIZE 860

typedef struct {
    char id[30];
    char name[200];
    char key[15];
    char artists[40][100];
    int num_artists;
    char release_date[12];
    double acousticness;
    double danceability;
    double energy;
    int duration_ms;
    double instrumentalness;
    double valence;
    int popularity;
    float tempo;
    double liveness;
    double loudness;
    double speechiness;
    int year;
} Musica;

Musica clone_music(Musica *music) {
    return *music;
}

char *remove_line_break(char line[]) {
    int size = strlen(line);

    if (line[size - 2] == '\r')
        line[size - 2] = '\0';

    else if (line[size - 1] == '\r' || line[size - 1] == '\n')
        line[size - 1] = '\0';

    return line;
}

char *read_quotted_csv_field(char *field_ptr, char *output) {
    field_ptr++;
    while (*field_ptr != '\0') {
        if (*field_ptr == '"') {
            if (*(field_ptr + 1) == '"') {
                *output++ = '"';
                field_ptr += 2;
            } else {
                field_ptr++;
                break;
            }
        } else {
            *output++ = *field_ptr++;
        }
    }
    *output = '\0';
    return field_ptr;
}

/**
 * @brief Lê uma única célula de um CSV.
 * 
 * @param field_ptr Ponteiro para o primeiro caractere dessa célula.
 * @param output Arranjo que receberá o conteúdo da célula.
 * 
 * @return Ponteiro que aponta para uma posição depois da célula.
 * Geralmente um ponteiro para uma vírgula ou o fim da linha.
 */
char *read_csv_field(char *field_ptr, char *output) {
    if (*field_ptr == '"') return read_quotted_csv_field(field_ptr, output);

    while (*field_ptr != '\0' && *field_ptr != ',') *output++ = *field_ptr++;

    *output = '\0';
    return field_ptr;
}

char *read_artist(char *output, char *artist_ptr) {
    char delimiter = *artist_ptr++;

    while (*artist_ptr != delimiter) {
        if (*artist_ptr == '\\') *output++ = *artist_ptr++;
        *output++ = *artist_ptr++;
    }

    *output = '\0';
    return artist_ptr + 1;
}

/**
 * @brief Lê o campo artists de uma música e preenche o arranjo de artistas dela.
 * 
 * @param music Ponteiro para a struct da música.
 * @param artists_field Ponteiro para o primeiro caractere do campo artists.
 * Um colchete '[' em todos os casos.
 */
void read_artists(Musica *music, char *artists_field) {
    artists_field++;
    int i = 0;
    while (1) {
        artists_field = read_artist(music->artists[i++], artists_field);
        if (*artists_field == ']') break;
        artists_field += 2;
    }
    music->num_artists = i;
}

void read_release_date(Musica *music, char field[]) {
    strcpy(music->release_date, field);
    if (strlen(music->release_date) == 4) strcat(music->release_date, "/01/01");
    music->release_date[4] = '/';
    music->release_date[7] = '/';
}

double handle_percentage(double value) {
    return ceil(value) == value ? value / 100 : value;
}

/**
 * @brief Lê uma linha vinda do CSV e preenche os campos da Música.
 * 
 * @param music Ponteiro para a struct da música.
 * @param line Linha do CSV.
 * 
 * Ex.: read_music(&music, "0.598,2018,0.136,\"['Royce Da 5\\'9""', 'Eminem', 'King Green']\",0.706,283077,0.745,1,6LZe8JfVaqcpq8yjkHtWQe,0.0,10,0.268,-5.97,0,Caterpillar (feat. Eminem & King Green),61,2018-05-04,0.441,91.08")
 */
void read_music(Musica *music, char line[]) {
    char field[MAX_LINE_SIZE];
    remove_line_break(line);

    line = read_csv_field(line, field);
    music->valence = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->year = atoi(field);

    line = read_csv_field(line + 1, field);
    music->acousticness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    read_artists(music, field);

    line = read_csv_field(line + 1, field);
    music->danceability = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->duration_ms = atoi(field);

    line = read_csv_field(line + 1, field);
    music->energy = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field); // Skip 'explicit' column

    line = read_csv_field(line + 1, field);
    strcpy(music->id, field);

    line = read_csv_field(line + 1, field);
    music->instrumentalness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    strcpy(music->key, field);

    line = read_csv_field(line + 1, field);
    music->liveness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->loudness = atof(field);

    line = read_csv_field(line + 1, field); // Skip 'mode' column

    line = read_csv_field(line + 1, field);
    strcpy(music->name, field);

    line = read_csv_field(line + 1, field);
    music->popularity = atoi(field);

    line = read_csv_field(line + 1, field);
    read_release_date(music, field);

    line = read_csv_field(line + 1, field);
    music->speechiness = handle_percentage(atof(field));

    line = read_csv_field(line + 1, field);
    music->tempo = atof(field);
}

void print_artists(Musica *music) {
    printf("[");

    if (music->num_artists > 0) {
        printf("%s", music->artists[0]);

        for (int i = 1; i < music->num_artists; i++)
            printf(", %s", music->artists[i]);
    }

    printf("]");
}

void print_music(Musica *music) {
    printf("%s ## ", music->id);
    print_artists(music);
    printf(" ## %s ## %c%c/%c%c/%c%c%c%c ## %G ## %G ## %G ## %G ## %G ## %G ## %G ## %d\n",
        music->name,
        music->release_date[8],
        music->release_date[9],
        music->release_date[5],
        music->release_date[6],
        music->release_date[0],
        music->release_date[1],
        music->release_date[2],
        music->release_date[3],
        music->acousticness,
        music->danceability,
        music->instrumentalness,
        music->liveness,
        music->loudness,
        music->speechiness,
        music->energy,
        music->duration_ms
    );
}
