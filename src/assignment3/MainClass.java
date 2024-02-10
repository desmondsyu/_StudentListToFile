package assignment3;

import java.util.List;
import java.util.*;
import java.io.*;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		// create list of byte array
		List<byte[]> studentList = new ArrayList<byte[]>();
		
		// create 3 testing student objects
		Student stu1 = new Student(1001, "Adam", 85.5); 
		Student stu2 = new Student(1002, "Bolt", 78.6);
		Student stu3 = new Student(1003, "Carl", 91.4);
		
		// transfer to byte array and add to the list
		studentList.add(Student.toByteArray(stu1));
		studentList.add(Student.toByteArray(stu2));
		studentList.add(Student.toByteArray(stu3));
		
		// write the list to file
		FileHandler.writeFile(studentList);
		
		// read file to get the list, 
		// then get every byte array in the list, 
		// then transfer to Student object,
		// then call the toString method for the objects' info
		for(int i = 0; i < FileHandler.readFile().size(); i++) {
			System.out.println(Student.fromByteArray(FileHandler.readFile().get(i)));
		}	
	}
}
