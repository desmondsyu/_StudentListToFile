package assignment3;

import java.io.*;
import java.util.List;

public class FileHandler {
	
	public void writeFile(List data) throws IOException{
		
		try(
			ObjectOutputStream output = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream("src/student.dat")));
		) {
			output.writeObject(data);
		}
	}
	
	public void readFile() throws ClassNotFoundException, IOException{
		
		try(
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("src/student.dat"));
		) {
			Student stu = (Student)input.readObject();
			System.out.println(stu);
		}
	}
}
