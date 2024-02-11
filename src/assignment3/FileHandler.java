package assignment3;

import java.io.*;
import java.util.*;

public class FileHandler{
	
	// method to write a list of byte array to file
	public static void writeFile(List<byte[]> data) throws IOException{
		
		try(
			ObjectOutputStream output = new ObjectOutputStream(
					new BufferedOutputStream(new FileOutputStream("src/student.dat")));
		) {
			output.writeObject(data);
		}
	}
	
	// method to return a list of byte array from file
	public static List<byte[]> readFile() throws ClassNotFoundException, IOException{
		
		try(
			ObjectInputStream input = new ObjectInputStream(
					new BufferedInputStream(new FileInputStream("src/student.dat")));
		) {	
			List<byte[]> data = (List<byte[]>)(input.readObject());
			return data;
		}
	}
}
