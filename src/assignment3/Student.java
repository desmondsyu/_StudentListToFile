package assignment3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Student implements Serialization {
	
	private int Student_ID;
	private String Name;
	private double GPA;
	
	public Student() {
		Student_ID = 0;
		Name = "TBA";
		GPA = 0.0;
	}
	public Student(int Student_ID, String Name, double GPA) {
		this.Student_ID = Student_ID;
		this.Name = Name;
		this.GPA = GPA;
	}
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getGPA() {
		return GPA;
	}
	public void setGPA(double gPA) {
		GPA = gPA;
	}
	
	public String toString() {
		return "Student ID : " + Student_ID + 
				"/nName : " + Name + 
				"/nGPA : " + GPA;
	}
	public byte[] toByteArray() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static Student fromByteArray(byte[] data) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(data);
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        Student student = (Student) objectInputStream.readObject();
        objectInputStream.close();
        return student;
    }
}


