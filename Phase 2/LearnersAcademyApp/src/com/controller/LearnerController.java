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

import com.entity.Teacher;

import com.service.TeacherService;

/**
 * Servlet implementation class LearnerController
 */
@WebServlet("/LearnerController")
public class LearnerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnerController() {
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
		TeacherService ps = new TeacherService();
		List<Teacher> listOfTeachers = ps.findAllTeacher();
		pw.println("Number of Teachers are "+listOfTeachers.size());
		Iterator<Teacher> ii = listOfTeachers.iterator();
		while(ii.hasNext()) {
			Teacher p = ii.next();
			pw.println("<div>");
			pw.println("<span>Teacher ID is "+p.getTid()+" Teacher Name is "+ p.getTname()+"  with age "+ p.getAge() + " Subject taught "+p.getLstofsubjects()+"</span>");
			pw.println("</div>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("viewTeacher.jsp");
		rd.include(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String tname = request.getParameter("tname");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Teacher t = new Teacher();
		t.setTname(tname);
		t.setAge(age);
		
		TeacherService ts = new TeacherService();
		String result  = ts.storeTeacher(t);
		
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.include(request, response);
		
	}

}
