package sheridantrfalga.model;

public class Student {

	// Java POJO (Plain OLd Java Object)
	// Java bean --> All properties need to be lower case
	// TOMCAT J2EE defines a JAVA BEAN lower case properties
	//by Convention (Tomcat will interpret the class as a Bean
	//JAVA BEAN getters are Camel case (first letter)
	private int studentid;
	private String firstname;
	private String lastname;
	private String program;
	private double gpa;
	
	
	public int getStudentid() {
		return studentid;
	}
	
	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [studentid=" + studentid + 
				", firstname=" + firstname + 
				", lastname=" + lastname + 
				", program=" + program + 
				", gpa=" + gpa + "]";
	}
	
	
	
	
	
}
