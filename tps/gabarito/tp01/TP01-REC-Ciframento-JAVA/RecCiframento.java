/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class RecCiframento{

	/**
	 * receives a String and uses the Caesar Cipher on it (using recursion)
	 * @param String
	 * @param Int
	 * @return
	*/
	public static String caesarCipher(String s, int count){
		// data declaration
		int key = 3;
		char temp = ' ';
		String resp = "";

		if(count < s.length()){
			// Applying the cipher into the current char
			temp = s.charAt(count);
			temp += key; // Key established to be 3 
			
			resp += temp;
			resp += caesarCipher(s, 1 + count);
		}
		return resp;
	} // ending method

	/**
	 * checks if the read word == "FIM"
	 * @param String 
	 * @return 
	*/
	public static boolean isFim(String s){
		return(s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	} // ending method

	/*
	 * (MAIN) receives entries from keyboard and starts the program
	 * @param String[]
	*/
	public static void main(String args[]){
		// data declaration
		String[] entries = new String[1000];
		int numEntries = 0;

		// Reading entries
		do{
			entries[numEntries] = MyIO.readLine();
		}while(!(isFim(entries[numEntries++])));
		numEntries--; // When it reads "FIM"

		// for each line, it'll print the Caesar cipher
		for(int i = 0; i < numEntries; i++){
			MyIO.println(caesarCipher(entries[i], 0));
		}
	} // ending main

} // ending class
