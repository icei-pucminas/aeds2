#include <string.h>
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

}

