/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class PalindromoREC{

	/**
	 * checks if the given word is Palindrome using recursion
	 * @param String
	 * @return
	*/
	public static String isPalindrome(String s, int count){
		// Data declaration
		String resp = "SIM";
		int j = s.length() - 1 - count;
		
		if(count < j){
			if(s.charAt(count) == s.charAt(j)){
				resp = isPalindrome(s, 1 + count);
			}else{
				resp = "NAO";
			}
		}
		return resp;
	}


	/**
	 * checks if the read word == "FIM"
	 * @param String
	 * @return
	*/
	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}


	/**
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

		// For each line, it'll print if the given word is Palindrome or not ("SIM" / "NAO)
		for(int i = 0; i < numEntries; i++){
			MyIO.println(isPalindrome(entries[i], 0));
		}
	}	

}// Fim class Palindromo
