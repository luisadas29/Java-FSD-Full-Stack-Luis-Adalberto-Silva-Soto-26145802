package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Classes;
import com.entity.Students;
import com.service.ClassesService;
import com.service.StudentsService;


/**
 * Servlet implementation class LearnerControllerStudent
 */
@WebServlet("/LearnerControllerStudent")
public class LearnerControllerStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnerControllerStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		StudentsService ps = new StudentsService();
		List<Students> listOfStudents = ps.findAllStudents();
		pw.println("Number of Students are "+listOfStudents.size());
		
		ClassesService ss = new ClassesService();
		List<Classes> listOfClasses = ss.findAllClasses();
		Iterator<Classes> ll = listOfClasses.iterator();
		Iterator<Students> ii = listOfStudents.iterator();
		
		for(int a=0;a < listOfClasses.size();a++) {
			Classes px = ll.next();
		
		while(ii.hasNext()) {	
			Students p = ii.next();
			pw.println("<div>");
			pw.println("<span>Student ID is "+p.getStudentid()+" Student Name is "+ p.getStudentname()+"  with age "+ p.getStudentage() + "</span>");
			pw.println("</div>");
			if(p.getTstudentid() == px.getTclassid() ) {
			pw.println("<div>");
			pw.println("<span>Assigned to Class " + px.studentsMapped()+ "</span>");
			pw.println("</div>");
			
		}
		}
		}
		RequestDispatcher rd = request.getRequestDispatcher("viewStudent.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
        PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String stname = request.getParameter("stname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Students t = new Students();
		t.setStudentname(stname);
		t.setStudentage(age);
		
		StudentsService ts = new StudentsService();
		String result  = ts.storeStudents(t);
		
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("addStudent.jsp");
		rd.include(request, response);
	}

}
