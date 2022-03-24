
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

// Libraries used:
import java.io.*;
import java.net.*;

class Html{

	/**
	 * receives a HTTPS Address and return it's HTML content
	 * @param String
	 * @return 
	*/
	public static String getHtml(String address){
		// data declaration
		URL url;
		InputStream is = null;
		BufferedReader br;
		String resp = "", line;

		try{
			url = new URL(address);
			is = url.openStream(); // throws an IOException
			br = new BufferedReader(new InputStreamReader(is));

			while((line = br.readLine()) != null){
				resp += line + "\n";
			}// ending while
		} catch (MalformedURLException mue){
			mue.printStackTrace();
		} catch (IOException ioe){
			ioe.printStackTrace();
		} // ending try-catch

		try{
			is.close();
		} catch (IOException ios){
			// nothing to see here
		}// ending try-catch 2
	
		return resp;
	}// ending method
	
	/**
	 * receives a splitted string and checks if it's equals to <br>
	 * @param String
	 * @return 
	*/
	public static boolean isBr(String splitted){
		String toBeEqual = "<br>";
		for(int i = 0; i < toBeEqual.length(); i++){
			if(splitted.charAt(i) != toBeEqual.charAt(i)) return false;
		}
		return true;
	}// ending method

	/**
	 * receives a splitted String and checks if it's equals to <table>
	 * @param String
	 * @return 
	*/
	public static boolean isTable(String splitted){
		//MyIO.println(splitted);

		String toBeEqual = "<table>";
		for(int i = 0; i < splitted.length(); i++){
			if(splitted.charAt(i) != toBeEqual.charAt(i)) return false;
		}
		return true;		
	}// ending method

	/**
	 * receives a HTTPS Address and filters a HTML content
	 * @param String
	 * @param String
	 * @return 
	*/
	public static String filtering(String address, String pageName){
		// data declaration
		String toBeFiltered = "";
		int countAH = 0, countE = 0, countI = 0, countO = 0, countU = 0;
		int countA1 = 0, countE1 = 0, countI1 = 0, countO1 = 0, countU1 = 0;
		int countA2 = 0, countE2 = 0, countI2 = 0, countO2 = 0, countU2 = 0;
		int countADiff = 0, countODiff = 0;
		int countA4 = 0, countE4 = 0, countI4 = 0, countO4 = 0, countU4 = 0;
		int countCons = 0, countBr = 0, countTable = 0;
		char temp = ' ';
		
		String splitter = "", resp = "";

		toBeFiltered = getHtml(address);
		for(int i = 0; i < toBeFiltered.length(); i++){
			splitter = "";
			temp = toBeFiltered.charAt(i);
			// normal vowels
			if(temp == 97){
			       	countAH++;
			}
			if(temp == 101) countE++;
			if(temp == 105) countI++;
			if(temp == 111) countO++;
			if(temp == 117) countU++;
			// á letters
			if(temp == 225) countA1++;
			if(temp == 233) countE1++;
			if(temp == 237) countI1++;
			if(temp == 243) countO1++;
			if(temp == 250) countU1++;
			// à letters
			if(temp == 224) countA2++;
			if(temp == 232) countE2++;
			if(temp == 236) countI2++;
			if(temp == 242) countO2++;
			if(temp == 249) countU2++;
			// ã and õ letters
			if(temp == 227) countADiff++;
			if(temp == 245) countODiff++;
			// â letters
			if(temp == 226) countA4++;
			if(temp == 234) countE4++;
			if(temp == 238) countI4++;
			if(temp == 244) countO4++;
			if(temp == 251) countU4++;
			// consoantes
			if((temp > 97 && temp <= 122) && (temp != 65 && temp != 97) && (temp != 69 && temp != 101) && (temp != 73 && temp != 105) && (temp != 79 && temp != 111) && (temp != 85 && temp != 117)){
				countCons++;
			}
			// <br>
			// <table>
			if(temp == 60){
				for(int j = 0; j < 7; j++){
					splitter += toBeFiltered.charAt(i + j);
				}
				if(isTable(splitter)){
					countTable++;
					i += 7;
				}else if(isBr(splitter)){
					countBr++;
					i += 4;
				}
			}	
		}

		// creating the String that contains the resp
		resp = "a(" + countAH + ") e(" + countE + ") i(" + countI + ") o(" + countO + ") u(" + countU + ") á(" + countA1 + ") é(" + countE1 + ") í(" + countI1 + ") ó(" + countO1 + ") ú(" + countU1 + ") à(" + countA2 + ") è(" + countE2 + ") ì(" + countI2 +
			") ò(" + countO2 + ") ù(" + countU2 + ") ã(" + countADiff + ") õ(" + countODiff + ") â(" + countA4 + ") ê(" + countE4 + ") î(" + countI4 + ") ô(" + countO4 + ") û(" + countU4 + ") consoante(" + countCons + ") <br>(" + countBr + ") <table>(" +
			countTable + ") " + pageName;
			
		return resp;
	}// ending method

	/**
	 * receives a string and checks if it's equals to "FIM"
	 * @param String
	 * @return 
	*/
	public static boolean isFim(String s){
		return (s.length() == 3 && s.charAt(0) == 'F' && s.charAt(1) == 'I' && s.charAt(2) == 'M');
	}// ending method

	/**
	 * (MAIN) receives an input from keyboard and stars the program 
	 * @param String[]
	 * @return 
	*/
	public static void main (String[] args){
	 	// data declaration
		String[] address = new String[1000], name = new String[1000];
		int numEntries = 0;

		do{
			name[numEntries] = MyIO.readLine();
			if(!(isFim(name[numEntries]))){
				address[numEntries] = MyIO.readLine();
			}
		}while(!(isFim(name[numEntries++])));
		numEntries--; // when reads "FIM"
	
		for(int i = 0; i < numEntries; i++){
			MyIO.println(filtering(address[i], name[i]));
		}
	}// ending main

}// ending class
