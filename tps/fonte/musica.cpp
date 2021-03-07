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

}

