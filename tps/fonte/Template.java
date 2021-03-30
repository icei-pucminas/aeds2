import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;

public class Template {

	// funcao que simula um construtor
	public static Track cadastra(String dadosMusica) throws ParseException {
		String campos[] = new String[19];
		int j = 0;
		String temp = "";
		for (int i = 0; i < 19; i++) {
			temp = "";
			while (j < dadosMusica.length() && ((dadosMusica.charAt(j) != ',')
					|| !(dadosMusica.charAt(j) == ',' && dadosMusica.charAt(j + 1) != ' '))) {
				if (dadosMusica.charAt(j) != '"')
					temp += dadosMusica.charAt(j);
				j++;
			}
			j++;
			campos[i] = temp;
		}
		Track musica = new Track(campos);
		
		return musica;
	}

	/*
	 * leitura das musicas e geracao dos objetos Track
	 */
	public static Track[] inserirPlaylist(int quantidade, String idList[], String totalMusicList[]) throws ParseException {
		Track musicas[] = new Track[quantidade];
		for (int i = 0; i < quantidade; i++) {
			for (int j = 0; j < totalMusicList.length; j++) {
				if (totalMusicList[j].contains(idList[i])) {
					String dadosMusic = totalMusicList[j];
					musicas[i] = cadastra(dadosMusic);
					j = totalMusicList.length;
				}
			}

		}
		return musicas;
	}

	/*
	 * leitura de todas as linhas da entrada padrao
	 */
	public static int entradaPadrao(String idList[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int i = 0;
		// faco a leitura dos ids do pub.in
		String linha = in.readLine();
		while (!(linha.contains("FIM"))) {
			idList[i] = linha;
			i++;
			linha = in.readLine();
		}
		return i;
	}

	/*
	 * leitura de todas as musicas do arquivo de entrada /tmp/data.csv
	 */
	public static String[] ler() throws Exception {
		final int TOTAL_MUSIC_NUMBER = 170625;
		String totalMusicList[] = new String[TOTAL_MUSIC_NUMBER];
		FileReader arquivo = new FileReader("./tmp/data.csv");
		BufferedReader ler = new BufferedReader(arquivo);
		String linha = ler.readLine();
		linha = ler.readLine();
		int i = 0;
		while (linha != null) {
			totalMusicList[i] = linha;
			linha = ler.readLine();
			i++;
		}
		arquivo.close();
		return totalMusicList;
	}

	public static void main(String args[]) throws Exception {
		// vetor que armazena os ids da entrada padrao pub.in
		String idList[] = new String[500];
		int playlistTam = entradaPadrao(idList);
		// leitura de todas as musicas do arquivo de entrada /tmp/data.csv
		String totalMusicList[] = ler();
		Track musicas[] = inserirPlaylist(playlistTam, idList, totalMusicList);
		
		for(Track musica:musicas)
			musica.imprimir();	
	}

}
