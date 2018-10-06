package sheridantrafalga.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sheridantrfalga.dao.StudentDAO;
import sheridantrfalga.dao.StudentDAOImplementation;
import sheridantrfalga.model.Student;

public class StudentController extends HttpServlet {

	
	private StudentDAO dao;
	private String gpastr; // (GPA as a String)
	private double gpadbl; // (GPA as a double primitive)
	
	// Tomcat 6 (older Tomcat Implementation was looking for this)
	private static final long serialversionUID = 7878L;
	public static final String LIST_STUDENT ="/liststudent.jsp"; // for only display
	public static final String INSERT_OR_EDIT = "/student.jsp";
	public static final String LIST_STUDENTS_FROM_PROGRAM = "/listStudentsInProgram.jsp";
	public static final String LIST_STUDENTS_WIITH_GPA = "/listStudentsWithGPA.jsp";
	
	public StudentController() {
		dao = new StudentDAOImplementation();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException {
		
		
		
		
		
		String action = req.getParameter("action");
		String forward = "";
		
		
		
		forward = LIST_STUDENT;
		req.setAttribute("students", dao.getAllStudents());
		RequestDispatcher view = req.getRequestDispatcher(forward);
		try {
			view.forward(req, resp);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(req.getParameter("students"));
			
			dao.deleteStudent(studentId);
			req.setAttribute("students", dao.getAllStudents());
			
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int studentId = Integer.parseInt(req.getParameter("students"));
			
			Student student = dao.getStudentById(studentId);
			req.setAttribute("student",	student);
			
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
			int studentId = Integer.parseInt(req.get)
		}
		
		
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doGet(req,resp);
		
	}

	
	
}
