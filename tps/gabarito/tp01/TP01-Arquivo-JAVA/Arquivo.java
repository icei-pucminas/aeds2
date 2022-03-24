
/**
 * @author: Thiago de Campos Ribeiro Nolasco
*/

// Library used:
import java.io.*;

class Arquivo{
	
	/*
	 * @method: receives a int "quantity" to read an archive with size of "quantity"
	 * @param: quantity Int
	*/
	public static void readInput(int quantity)throws Exception {
		// data declaration
		RandomAccessFile raf = new RandomAccessFile("test.txt", "r");
		int transformedInteger;
		double readDouble, temp;

		// moving the File pointer to the initial line (just fo prevent errors)
		raf.seek(0);

		// Looping that will basicaly:
		// -> Put the file pointer into the beginning of the line (backwards)
		// -> Read a double from the archive, and then, transforms it into integer (narrowing conversion)
		// -> Put the file pointer back into the beginning of the line 
		// -> Reads the same double (but without conversion)
		// -> And then do the comparison...
		for(int i = quantity; i > 0; i--){
			raf.seek((9 * (i - 1)));
			temp = raf.readDouble();
			transformedInteger = (int)temp;
			raf.seek((9 * (i - 1)));
			readDouble = raf.readDouble();

			if(transformedInteger == readDouble){
				System.out.println(transformedInteger);
				raf.seek((9 * (i - 1 )) + 4);
			}else{
				System.out.println(readDouble);
			}
			raf.readByte();
		}
		raf.close();
	}

	/*
	 * @method: (MAIN) receives input from keyboard and starts the program
	 * @param: args String[]
	*/
	public static void main(String[] args)throws Exception {
		// data declaration
		RandomAccessFile raf = new RandomAccessFile("test.txt", "rw");

		int value = 0, temp = 0;
		double entries = 0.00;
		
		value = MyIO.readInt();
		temp = value;
		while(temp != 0){
			entries = MyIO.readDouble();
	
			raf.writeDouble(entries);
			raf.writeBytes("\n");
			temp--;
		}
		raf.close();		

		readInput(value);
	}// ending main
}// ending class
