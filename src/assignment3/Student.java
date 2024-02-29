package assignment3;

import java.io.*;

public class Student implements Serializable {

	// declare variables
	private int studentId;
	private String name;
	private double gpa;

	// no-arg constructor
	public Student() {

	}

	// arg constructor
	public Student(int studentId, String name, double gpa) {
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
	}

	// accessor and mutator for each variable
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	// method to convert the object to a byte array
	public byte[] toByteArray() throws IOException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
		objOut.writeObject(this);
		return byteOut.toByteArray();
	}

	// method to convert byte array to object
	public static Object fromByteArray(byte[] data) throws IOException, ClassNotFoundException {
		ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
		ObjectInputStream objIn = new ObjectInputStream(byteIn);
		Object obj = objIn.readObject();
		byteIn.close();
		objIn.close();
		// casting the return object
		return (Student) obj;
	}

	// toString method printing information of object
	@Override
	public String toString() {
		return "\nassignment3.Student" +
				"\nId: " + getStudentId() +
				"\nName: " + getName() +
				"\nGPA: " + getGpa();
	}
}