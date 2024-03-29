package assignment3;

import java.util.List;
import java.util.*;
import java.io.*;

public class MainClass {

	public static void main(String[] args) throws ClassNotFoundException, IOException {

		// create list of byte array
		List<byte[]> studentList = createStudentList();

		// write the list to file
		FileHandler.writeFile(studentList);

		// read file to get the list,
		// then get every byte array in the list,
		// then transfer to Student object,
		// then call the toString method for the objects' info
		for (int i = 0; i < FileHandler.readFile().size(); i++) {
			System.out.println(Student.fromByteArray(FileHandler.readFile().get(i)));
		}
	}

	// method to let user build the list
	public static List<byte[]> createStudentList() throws InputMismatchException, IOException {
		List<byte[]> studentList = new ArrayList<byte[]>();
		boolean cont = true;
		Scanner scan = new Scanner(System.in);

		do {
			Student stu = new Student();

			try {
				System.out.print("Student Id: ");
				stu.setStudentId(scan.nextInt());
				System.out.print("Student name: ");
				stu.setName(scan.next());
				System.out.print("Student gpa: ");
				stu.setGpa(scan.nextDouble());
				scan.nextLine();
				
				// write byte array to the list
				studentList.add(stu.toByteArray());
			} catch (InputMismatchException e) {
				System.out.println("Invalid input");
			}
			
			System.out.println("Input 'exit' to exit. Input anything else to continue...");
			String input = scan.next();

			if (input.equalsIgnoreCase("exit")) {
				cont = false;
			}

		} while (cont);

		scan.close();
		return studentList;
	}
}