
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Track {

	// (0)valence,(1)year,(2)acousticness,(3)artists,(4)danceability,(5)duration_ms,(6)energy,
	// (7)explicit,(8)id,(9)instrumentalness,(10)key,(11)liveness,(12)loudness,(13)mode,
	// (14)name,(15)popularity,(16)release_date,(17)speechiness,(18)tempo
	private String nome;
        private String id; // 8
	private String key; // 10
	private String artists; // 3
	private Date realease; // 16
	private double acousticness; // 2
	private double danceability; // 4
	private double energy; // 6
	private int duration; // 5
	private double instrumentalness; // 9
	private double valence; // 0
	private int popularity; // 15
	private float tempo; // 18
	private double liveness; // 11
	private double loudness; // 12
	private double speechiness; // 17
	private int year; // 1

	public Track() {
		this.id = "";
	}

	public Track(String[] values) throws ParseException {
		this.id = values[8]; // 8
		this.nome = values[14]; // 14
		this.key = values[10]; // 10
		this.acousticness = Double.parseDouble(values[2]); // 2
		this.danceability = Double.parseDouble(values[4]); // 4
		this.energy = Double.parseDouble(values[6]); // 6
		this.duration = Integer.parseInt(values[5]); // 5
		this.instrumentalness = Double.parseDouble(values[9]); // 9
		this.valence = Double.parseDouble(values[0]); // 0
		this.popularity = Integer.parseInt(values[15]); // 15
		this.tempo = Float.parseFloat(values[18]); // 18
		this.liveness = Double.parseDouble(values[11]); // 11
		this.loudness = Double.parseDouble(values[12]); // 12
		this.speechiness = Double.parseDouble(values[17]); // 17
		this.year = Integer.parseInt(values[1]); // 1

		String artistsString = "";
		int i = 0;
		while (i < values[3].length()) {
			if (!(values[3].charAt(i) == 39 && (values[3].charAt(i - 1) == 91 || 
					values[3].charAt(i + 1) == 93 || values[3].charAt(i + 1) == 44 || 
					values[3].charAt(i - 2) == 44))) {
				artistsString += values[3].charAt(i);
			}
			i++;
		}
		artists = artistsString; // 3 ;
		
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		if (values[16].length() == 4) {
			realease = formato.parse(values[16] + "-01-01");
		} else if (values[16].length() == 7) {
			realease = formato.parse(values[16] + "-01");
		} else {
			realease = formato.parse(values[16]);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setName(String nome) {
		this.nome = nome;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getArtists() {
		return artists;
	}

	public void setArtists(String artists) {
		this.artists = artists;
	}

	public Date getRealease() {
		return realease;
	}

	public void setRealease(Date realease) {
		this.realease = realease;
	}

	public double getAcousticness() {
		return acousticness;
	}

	public void setAcousticness(double acousticness) {
		this.acousticness = acousticness;
	}

	public double getDanceability() {
		return danceability;
	}

	public void setDanceability(double danceability) {
		this.danceability = danceability;
	}

	public double getEnergy() {
		return energy;
	}

	public void setEnergy(double energy) {
		this.energy = energy;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInstrumentalness() {
		return instrumentalness;
	}

	public void setInstrumentalness(double instrumentalness) {
		this.instrumentalness = instrumentalness;
	}

	public double getValence() {
		return valence;
	}

	public void setValence(double valence) {
		this.valence = valence;
	}

	public int getPopularity() {
		return popularity;
	}

	public void setPopularity(int popularity) {
		this.popularity = popularity;
	}

	public float getTempo() {
		return tempo;
	}

	public void setTempo(float tempo) {
		this.tempo = tempo;
	}

	public double getLiveness() {
		return liveness;
	}

	public void setLiveness(double liveness) {
		this.liveness = liveness;
	}

	public double getLoudness() {
		return loudness;
	}

	public void setLoudness(double loudness) {
		this.loudness = loudness;
	}

	public double getSpeechiness() {
		return speechiness;
	}

	public void setSpeechiness(double speechiness) {
		this.speechiness = speechiness;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	
	public Track clone() {
		Track novo = new Track();
		novo.nome = this.nome;
		novo.id = this.id;
		novo.key = this.key;
		novo.artists = this.artists;
		novo.realease = this.realease;
		novo.acousticness = this.acousticness;
		novo.danceability = this.danceability;
		novo.energy = this.energy;
		novo.duration = this.duration;
		novo.instrumentalness = this.instrumentalness;
		novo.valence = this.valence;
		novo.popularity = this.popularity;
		novo.tempo = this.tempo;
		novo.liveness = this.liveness;
		novo.loudness = this.loudness;
		novo.speechiness = this.speechiness;
		novo.year = this.year;
		return novo;
	}

	
	public void imprimir() throws Exception {
		System.out.println(this.toString());
	}

	
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return id + " ## " + artists.toString() + " ## " + nome + " ## " + sdf.format(realease) + " ## " + acousticness
				+ " ## " + danceability + " ## " + instrumentalness + " ## " + liveness + " ## " + loudness + " ## "
				+ speechiness + " ## " + energy + " ## " + duration;
	}
}
