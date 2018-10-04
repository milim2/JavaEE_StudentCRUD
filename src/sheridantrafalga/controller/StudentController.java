package sheridantrafalga.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentController extends HttpServlet {

	public static final String LIST_STUDENT = "/listStudent.jsp";
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		
		String action = req.getParameter("action");
		String forward = "";
		
		forward = LIST_STUDENT;
		RequestDispatcher view = req.getRequestDispatcher(forward);
		view.forward(req,  resp);
		
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		doGet(req,resp);
		
	}

	
	
}
