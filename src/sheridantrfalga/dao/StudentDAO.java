package sheridantrfalga.dao;

import java.util.List;

import sheridantrfalga.model.Student;

public interface StudentDAO {
	
	// DAO ---> Data Access Object
	// Design pattern (ie, like MVC)
	//CRUD operations + serch/filter operation
	// Studentid is the primary key in this schema
	
	
	// Default webapp operation
	public List<Student> getAllStudents();
	
	
	
	
	

}


