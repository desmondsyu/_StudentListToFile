package assignment3;

import java.io.*;

public class Student implements Serializable{
	
	private int studentId;
	private String name;
	private double gpa;
	
	public Student() {
		
	}
	
	public Student(int studentId, String name, double gpa) {
		this.studentId = studentId;
		this.name = name;
		this.gpa = gpa;
	}

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
	
	public byte[] toByteArray(Object obj) throws IOException{
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
		objOut.writeObject(obj);
		return byteOut.toByteArray();
	}
	
	public Object fromByteArray(byte[] data) throws IOException, ClassNotFoundException{
		ByteArrayInputStream byteIn = new ByteArrayInputStream(data);
		ObjectInputStream objIn = new ObjectInputStream(byteIn);
		byteIn.close();
		objIn.close();
		return objIn.readObject();
	}
	
	@Override
	public String toString() {
		return "Student" +
				"/nId: " + getStudentId() +
				"/nName: " + getName() +
				"/nGPA: " + getGpa();	
	}
} 
