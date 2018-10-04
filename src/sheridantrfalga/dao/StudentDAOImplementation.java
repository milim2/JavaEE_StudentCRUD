package sheridantrfalga.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import sheridantrafalga.util.DBUtil;
import sheridantrfalga.model.Student;

public class StudentDAOImplementation implements StudentDAO {

	
	private Connection conn;
	
	public StudentDAOImplementation() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public List<Student> getAllStudents() {
		
		List<Student> students = new ArrayList<Student>();
		
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
			("select ID, Firstname, Lastname, Program,CAST(gpa as DECIMAL(3, 2)) As gpa from student"));
			
			while(rs.next() {
				Student stu = new Student();
				stu.setStudentid (rs.getInt("ID"));
				stu.setFirstname (rs.getString("Firstname"));
				stu.setLastname (rs.getString("Lastname"));
				stu.setProgram (rs.getString("Program"));
				stu.setGpa (rs.getInt("GPA"));
				
				students.add(stu);
			}
			rs.close();
			stmt.close();
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return students;
		
		
		
	}
	
	
	
	
	

}
