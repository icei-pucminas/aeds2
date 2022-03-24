
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class Ciframento{

	/**
	 * receives a String and uses the Caesar cipher on it
	 * @param String
	 * @return
	*/	
	public static String caesarCipher(String s){
		// Data declaration
		char[] arr = new char[s.length()];
		char c = ' ';
		int key = 3;
	
		// Looping through "s"
		// Assigning the result to "c"
		// Adding cipher's key to each char
		// Assigning the result on arr[]
		for(int i = 0; i < s.length(); i++){
			c = s.charAt(i);
			c += key;
			arr[i] = c;
		}

		// Creating a new String from the ciphered char[]
		String result = new String(arr);
		return result;
	}

	/**
	 * checks if the read word == "FIM"
	 * @param String
	 * @return
	*/
	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}


	/*
	 * (MAIN) receives entries from keyboard and starts the program
	 * @param String[]
	*/
	public static void main (String[] args){
		// Data declaration
		String[] entries = new String[1000];
		int numEntries = 0;

		// Reading entries
		do{
			entries[numEntries] = MyIO.readLine();
		} while(!(isFim(entries[numEntries++])));
		numEntries--; // When it reads "FIM"

		// For each line, it'll print the Caesar cipher
		for(int i = 0; i < numEntries; i++){
			MyIO.println(caesarCipher(entries[i]));
		}
	}
}// Fim class Ciframento
