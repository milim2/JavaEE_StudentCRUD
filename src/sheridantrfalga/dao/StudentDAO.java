package sheridantrfalga.dao;

import java.util.List;

import sheridantrfalga.model.Student;

public interface StudentDAO {
	
	// DAO ---> Data Access Object
	// Design pattern (ie, like MVC)
	//CRUD operations + serch/filter operation
	// Studentid is the primary key in this schema
	
	
	// Default webapp operation
//	public List<Student> getAllStudents();
	
	public void addStudent(Student student);
	public void deleteStudent(int studentId);
	public void updateStudent(Student student);
	
	public List<Student> getAllStudents();
	public Student getStudentById(int studentId);
	
	
	
	//Search or Filter (by Program)- 2filters should be proven
	public List<Student> getStudentByProgram(String program);
	public List<Student> getStudentByGPA(double gpa);
	

}


