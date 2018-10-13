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
	
	public static final String LIST_STUDENT = "/liststudent.jsp"; // for only display
	public static final String INSERT_OR_EDIT = "/student.jsp";
	public static final String LIST_STUDENTS_FROM_PROGRAM = "/listStudentsInProgram.jsp";
	public static final String LIST_STUDENTS_WITH_GPA = "/listStudentsWithGPA.jsp";

	public StudentController() {
		dao = new StudentDAOImplementation();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		String action = req.getParameter("action");
		String forward = "";

		if (action.equalsIgnoreCase("delete")) {
			forward = LIST_STUDENT;
			int studentId = Integer.parseInt(req.getParameter("studentId"));

			dao.deleteStudent(studentId);
			
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			int studentId = Integer.parseInt(req.getParameter("studentId"));

			Student student = dao.getStudentById(studentId);
			req.setAttribute("student", student);
		} else if (action.equalsIgnoreCase("insert")) {
			forward = INSERT_OR_EDIT;
		} else if (action.equalsIgnoreCase("searchstudentsfromprogram")) {

			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_FROM_PROGRAM;
			String programRequest = req.getParameter("program");

			req.setAttribute("students", dao.getStudentByProgram(programRequest));
			
		} else if (action.equalsIgnoreCase("searchstudentswithgpa")) {

			// LIST ALL RECORDS or Students that are part of a particular program
			forward = LIST_STUDENTS_WITH_GPA;
			String gpaRequest = req.getParameter("gpa");
			double gpadblRequest = Double.parseDouble(gpaRequest);
			req.setAttribute("students", dao.getStudentByGPA(gpadblRequest));
			
		} else {

			// LIST ALL RECORDS or Students
			forward = LIST_STUDENT;
			req.setAttribute("students", dao.getAllStudents());
		}

		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws IOException, ServletException {

		Student student = new Student();

		// takes an Integer primitive
		// student.setStudentid(req.getParameter("studentId"));

		student.setFirstname(req.getParameter("firstname"));
		student.setLastname(req.getParameter("lastname"));
		student.setProgram(req.getParameter("program"));

		// valueOf or try-catch block
		gpastr = req.getParameter("gpa");

		// double gpadbl = Double.parseDouble(gpastr);

		try {
			gpadbl = Double.parseDouble(gpastr);
		} catch (NumberFormatException e) {
			throw new RuntimeException(gpadbl + " is not a number");
		}

		// double gpadbl = Double.parseDouble(gpastr);
		student.setGpa(gpadbl);

		// String studentId = req.getParameter("ID");
		String studentId = req.getParameter("studentId");

		if (studentId == null || studentId.isEmpty())
			dao.updateStudent(student);
		else {
			student.setStudentid(Integer.parseInt(studentId));
			dao.updateStudent(student);
		}

		
		
		RequestDispatcher view = req.getRequestDispatcher(LIST_STUDENT);
		req.setAttribute("students", dao.getAllStudents());
		
		view.forward(req, resp);

	}

}
