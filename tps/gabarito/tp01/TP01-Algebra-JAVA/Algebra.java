/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

class Algebra{

	/**
	 * Receives a splitted string with an already finished logical operation ("result"), and replaces the correct spot ("split") on the first read string ("s")
	 * @param String
	 * @param String
	 * @param String
	 * @return
	*/
	public static String fillingNewSplittedPart(String s, String split, String result){
		String newString = "";
		boolean flag = false;
		int count = 0; 
		for(int i = 0; i < s.length(); i++){
			count = 0; 
			if(s.charAt(i) == split.charAt(0) && flag == false){
				for(int j = 0; j < split.length(); j++){
					if(s.charAt(j + i) == split.charAt(j)) { count++; }
					else { count = 0; }
				}
				if(count == split.length()){
					flag = true;
					newString += resul1t.charAt(0);
					i += count - 1; 
				}else{
					newString += s.charAt(i);
				}

			}else{newString += s.charAt(i);}
			
		}
		return newString;
	} // ending method

	/**
	 * Receives a splitted logical operation, and does the operation
	 * @param String
	 * @return 
	*/
	public static String resolvingOperation(String s){
		String resolved = "1";
		// &&
		if(s.charAt(0) == 38){
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == 48) resolved = "0";
			} 
		}
		// ||
		if(s.charAt(0) == 124){
			int count = 0;
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) != 49) count++;
			}
			if(count == s.length()){
				resolved = "0";
			}
		}
		// !
		if(s.charAt(0) == 33){
			for(int i = 0; i < s.length(); i++){
				if(s.charAt(i) == 49){
					resolved = "0";
				}
				if(s.charAt(i) == 48){
					resolved = "1";
				}
			}
		}
		
		return resolved; // 1
	} // ending method


	/**
	 * receives a String and returns the content between "( )"
	 * @param String
	 * @return
	*/
	public static String getSplittedString(String s){
		String split = "";
		boolean finished = false;
		int i = 0;
		while(!finished){
			if(s.charAt(i) == 41) {
				split += s.charAt(i);
				finished = true; 
			}else{ 
				split+= s.charAt(i); 
			}

			if(i == s.length() - 1) { i = 0; }
			else { i += 1; }
		}
		return split;
	} // ending method

	/**
	 * receives a String and checks if on it's content has more than one "(". 
	 * @param String
	 * @return
	*/
	public static boolean isComplete(String s){
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 40) count++;
			if(count > 1) return false;
		}
		return true;
	} // ending method

	/**
	 * receives a formated String and does the logical operation
	 * @param String
	 * @return 
	*/
	public static String logicalOperations(String s){
		String split = "", result = "";
		boolean resp = false;
		int i = 0;
		while(!resp){ 
			split = "";
			
			// If the read char is == to & , | or !
			if(s.charAt(i) == 38 || s.charAt(i) == 124 || s.charAt(i) == 33) {
			// Then, do the split from the read char until the end of the string
			
				for(int j = i; j < s.length(); j++){
					split += s.charAt(j);
				}
				// Checks if the read string is complete ( If it starts with "(" and ends with ")" without having and "(" between then
				if(isComplete(split)){
				// Splits the "splitted" string, and returns just the piece that we want, e.g: &(1 , 0)
					split = getSplittedString(split);

					// Then, using the above splitted string, it resolves the Boolean expression, e.g: &(1 , 0) == 0
					result = resolvingOperation(split);


					// Then, using the re-splitted string and the result above, the beggining string will be replaced, e.g: Where was &(1 , 0) will be replaced with "0"
					s = fillingNewSplittedPart(s, split, result);


					// Puts the i into the end of the string so it can be re-read 
					i = s.length() - 1; 
				}
			}
			if(i != s.length() - 1){
				i += 1;
			}		
			
			
			if( i == s.length() - 1) { i = 0; }
			if(s.length() == 1) { resp = true; } 
		}
		// Return the finished string
		return s;
	} // ending method

	/**
	 * receives a formated String and changes the written Logical operations into it's sign
	 * @param String
	 * @return
	*/
	public static String replaceLogicalOperations(String s){
		String split = "";
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == 97) { split += "&"; i+= 2; } // and -> &
			else if(s.charAt(i) == 111) { split += "|"; i += 1; } // or -> |
			else if(s.charAt(i) == 110) { split += "!"; i += 2;} // not -> ~
			else if(s.charAt(i) == 32) {  }
			else split += s.charAt(i);
		}
		return split;
	} // ending method

	/**
	 * receives a String and make the initial value changes on it ( Changing values of A B C )
	 * @param String
	 * @return
	*/
	public static String replaceVariableValues(String s){
		String split = "";
		char A = ' ', B = ' ', C = ' ';
		int i = 0;
		if(s.charAt(0) == 51){   
			A = s.charAt(2); 
			B = s.charAt(4);
			C = s.charAt(6);
			i = 8;
		}else if(s.charAt(0) == 50){
			A = s.charAt(2);
			B = s.charAt(4);
			i = 6;
		}else if(s.charAt(0) == 49){
			A = s.charAt(2);
			i = 5;
		}
		for(i = i; i < s.length(); i++){
			if(s.charAt(i) == 65){ split += A; }
			else if(s.charAt(i) == 66) { split += B; }
			else if(s.charAt(i) == 67) { split += C; }
			else split += s.charAt(i);
		}
	
		return split;
	} // ending method


	/**
	 * receives a String and calls other methods to filter the String to create a Logical Operation
	 * @param String
	 * @return 
	*/
	public static String initializer(String s){
		String returned = "";

		returned = replaceVariableValues(s);
		
		returned = replaceLogicalOperations(returned);
		
		returned = logicalOperations(returned);
		return returned;
	} // ending method

	/**
	 * receives a String and checks if it's equals to "0"
	 * @param String
	 * @return
	*/
	public static boolean isFim(String s){
		return (s.length() == 1 && s.charAt(0) == 48); 
	}// ending method



	/**
	 * (MAIN) receives input from keyboard and starts the program
	 * @param String[]
	 * @return 
	*/
	public static void main(String[] args){
		// data declaration
		String[] entries = new String[1000];
		int numEntries = 0;
			
		// Reading entries 
		do{
			entries[numEntries] = MyIO.readLine();		
		}while(!(isFim(entries[numEntries++])));		
		numEntries--; // Decreasing when it reads "FIM"

		// Printing results
		for(int i = 0; i < numEntries; i++){
			MyIO.println(initializer(entries[i]));
		}
	}// ending main

} // ending class
