
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

import java.io.*;
class Is{

	/**
	 * receives a String and checks if it's composed only by integers
	 * @param String
	 * @return 
	*/
	public static boolean isFloat(String s){
		int count = 0, countChars = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 44 || s.charAt(i) == 46) count++;
			if(s.charAt(i) >= 48 && s.charAt(i) <= 57) countChars++;
		}
//		if(count != 1 || countChars != s.length()) return false;
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
	 * (MAIN) receives input from keyboard and starts the program
	 * @param: args String[]
	*/
	public static void main(String[] args) throws Exception{
		// data declaration
		BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
		String[] entries = new String[1000];
		int numEntries = 0;
		String returned = "", result = ""; 

		// Reading entries
		do{
			entries[numEntries] = leitor.readLine();
		}while(!(isFim(entries[numEntries++])));
		numEntries--;

		for(int i = 0; i < numEntries; i++){
			result = "";

			returned = (isVogal(entries[i]))? "SIM" : "NAO";
			result += returned + " ";

			returned = (isConsoante(entries[i]))? "SIM" : "NAO";
			result += returned + " ";

			returned = (isInt(entries[i]))? "SIM" : "NAO";
			result += returned + " ";

			returned = (isFloat(entries[i]))? "SIM" : "NAO";
			result += returned;

			System.out.println(result);
		}

	}// ending main
		

}// ending class 
