/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class RecIs{

	/**
	 * receives a String and checks if it's composed only by integers
	 * @param String
	 * @return 
	*/
	public static boolean isFloat(String s){
		// Data declaration
		int count = 0, countChars = 0;
		
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 44 || s.charAt(i) == 46) count++;
			if(s.charAt(i) >= 48 && s.charAt(i) <= 57) countChars++;
		}
		if((count == 0 || count == 1) && countChars == s.length() - count) return true;
		return false;
	} // ending method



	public static boolean isInt(String s){
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) < 48 || s.charAt(i) > 57) return false;
		}
		return true;
	} // ending method

	/**
	 * receives a String and checks if it's composed only by consonants
	 * @param String
	 * @return
	*/
	public static boolean isConsoante(String s){
		char[] temp = new char[1];
		for(int i = 0; i < s.length(); i++){
			temp[0] = s.charAt(i);
			if((isVogal(temp)) || ((s.charAt(i) < 65 || s.charAt(i) > 90) && (s.charAt(i) < 97 || s.charAt(i) > 122))){
				return false;
			}
		}
		return true;
	} // ending method

	/**
	 * receives a array of char, transform it to String and sends it to isVogal (with diferent signature)
	 * @param char[]
	 * @return
	*/
	public static boolean isVogal(char[] temp){
		String s = new String(temp);
		return isVogal(s);
	} // ending method

	/**
	 * receives a STRING and checks if it's composed only by vowels
	 * @param String
	 * @parma Int
	 * @return
	*/
	public static boolean isVogal(String s){
		for(int i = 0; i < s.length(); i++){
			if((s.charAt(i) != 65) && (s.charAt(i) != 69) && (s.charAt(i) != 73) && (s.charAt(i) != 79) && (s.charAt(i) != 85) &&
		           (s.charAt(i) != 97) && (s.charAt(i) != 101) && (s.charAt(i) != 105) && (s.charAt(i) != 111) && (s.charAt(i) != 117)){
			   	return false;
			   }
		}
		return true;
	} // ending method

	/**
	 * receives a String and checks if it's equals to "FIM"
	 * @param String
	 * @return
	*/
	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	} // ending method

	/**
	 * receives a string, call the other methods using this string as parameter (using recursion)
	 * @param String[]
	 * @param Int
	 * @param Int
	 * @return 
	*/
	public static String getResults(String[] s, int count, int numEntries){
		String returned = "", result = "";

		if(count < numEntries){
			result = "";

			returned = (isVogal(s[count])) ? "SIM" : "NAO";
			result += returned + " ";

			returned = (isConsoante(s[count])) ? "SIM" : "NAO";
			result += returned + " ";

			returned = (isInt(s[count])) ? "SIM" : "NAO";
			result += returned + " ";

			returned = (isFloat(s[count])) ? "SIM" : "NAO";
			result += returned + '\n';
			result += getResults(s, 1 + count, numEntries);
		}
		return result;
	} // ending method
	

	/*
	 * (MAIN) receives input from keyboard and starts the program
	 * @param String[]
	*/
	public static void main(String[] args){
		// data declaration
		//BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		String[] entries = new String[1000];
		int numEntries = 0;

		String returned = "", result = "";

		do{
			entries[numEntries] = MyIO.readLine();
		}while(!(isFim(entries[numEntries++])));
		numEntries--;

		// Printing the result
		MyIO.print(getResults(entries, 0, numEntries));

		//OR: 

		// Creating a hand-made "replace" to delete the last '\n'
		/*for(int i = 0; i < returned.length() - 1; i++){
			result += returned.charAt(i);
		}
		MyIO.println(result);*/


	}// ending main


}// ending class

