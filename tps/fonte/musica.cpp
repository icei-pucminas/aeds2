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
    Musica clone;
    strcpy(clone.id, music->id);
    strcpy(clone.name, music->name);
    strcpy(clone.key, music->key);
    for (int i = 0; i < music->num_artists; i++)
        strcpy(clone.artists[i], music->artists[i]);
    clone.num_artists = music->num_artists;
    strcpy(clone.release_date, music->release_date);
    clone.acousticness = music->acousticness;
    clone.danceability = music->danceability;
    clone.energy = music->energy;
    clone.duration_ms = music->duration_ms;
    clone.instrumentalness = music->instrumentalness;
    clone.valence = music->valence;
    clone.popularity = music->popularity;
    clone.tempo = music->tempo;
    clone.liveness = music->liveness;
    clone.loudness = music->loudness;
    clone.speechiness = music->speechiness;
    clone.year = music->year;
    return clone;
}

