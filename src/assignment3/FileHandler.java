package assignment3;

import java.io.*;
import java.util.List;

public class FileHandler implements Serializable{
	
	public static void writeFile(List data) throws IOException{
		
		try(
			ObjectOutputStream output = new ObjectOutputStream(
					new FileOutputStream("src/student.dat"));
		) {
			output.writeObject(data);
		}
	}
	
	public static List<byte[]> readFile() throws ClassNotFoundException, IOException{
		
		try(
			ObjectInputStream input = new ObjectInputStream(
					new FileInputStream("src/student.dat"));
		) {
			List<byte[]> data = (List<byte[]>)(input.readObject());
			return data;
		}
	}
}
