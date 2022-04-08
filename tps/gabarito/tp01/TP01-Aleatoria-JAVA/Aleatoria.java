import java.util.Random;

/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class Aleatoria{

	/**
	 * receives a String and changes certain char (seek) to other (change)
	 * @param String
	 * @param char
	 * @param char
	 * @return
	*/
	public static String changeChar(String s, char seek, char change){
		// Data declaration
		String result = "";

		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == seek){
				result += change;
			}else{
				result += s.charAt(i);
			}
		}
		return result;
	}// ending method


	/**
	 * receives a String and checks if it's equals to "FIM"
	 * @param String
	 * @return
	*/
	public static boolean isFim(String s){
		return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}// ending method


	/**
	 * (Main) receives input from keyboard and starts the program
	 * @param String[]
	*/
	public static void main(String[] args){
		// Data declaration 
		String[] entries = new String[1000];
		int numEntries = 0;
		char letra1, letra2;

		// Randomizer
		Random gerador = new Random();
		gerador.setSeed(4);

		// Reading entries 
		do{
			entries[numEntries] = MyIO.readLine();
		}while(!(isFim(entries[numEntries++])));
		numEntries--;
		
		for(int i = 0; i < numEntries; i++){
			// Get two "random" chars
			letra1 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));
			letra2 = (char)('a' + (Math.abs(gerador.nextInt()) % 26));

			// And send them to "changeChar"
			MyIO.println(changeChar(entries[i], letra1, letra2)); 
		}

	}// ending main


}// ending class Aleatoria
