package assignment3;

import java.util.List;
import java.util.*;
import java.io.*;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		List<byte[]> studentList = new ArrayList<byte[]>();
		
		Student stu1 = new Student(1001, "Adam", 85.5); 
		Student stu2 = new Student(1002, "Bolt", 78.6);
		Student stu3 = new Student(1003, "Carl", 91.4);
		
		studentList.add(Student.toByteArray(stu1));
		studentList.add(Student.toByteArray(stu2));
		studentList.add(Student.toByteArray(stu3));
		
		FileHandler.writeFile(studentList);
				
		for(int i = 0; i < FileHandler.readFile().size(); i++) {
			System.out.println(Student.fromByteArray(FileHandler.readFile().get(i)));
			;
		}
		
		
	}
	

}
