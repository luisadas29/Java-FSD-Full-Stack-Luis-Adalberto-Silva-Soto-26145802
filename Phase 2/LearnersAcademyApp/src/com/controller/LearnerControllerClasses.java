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
import com.entity.Subject;
import com.service.ClassesService;
import com.service.SubjectService;

/**
 * Servlet implementation class LearnerControllerClasses
 */
@WebServlet("/LearnerControllerClasses")
public class LearnerControllerClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnerControllerClasses() {
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
		ClassesService ps = new ClassesService();
		List<Classes> listOfClasses = ps.findAllClasses();
		pw.println("Number of Classes are "+listOfClasses.size());
		Iterator<Classes> ii = listOfClasses.iterator();
		while(ii.hasNext()) {
			Classes p = ii.next();
			pw.println("<div>");
			pw.println("<span>Classroom ID is "+p.getClassid()+" Classroom Building is "+ p.getClassbuilding()+ " Classroom section is "+p.getClasssection()+ " Students assigned "+ p.getLstofstudents()+" Teachers assigned"+ p.getLstofteachers()+"</span>");
			pw.println("</div>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("viewClasses.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String classBuilding = request.getParameter("classBuilding");
		String classSection = request.getParameter("classSection");

		
		Classes t = new Classes();
		t.setClassbuilding(classBuilding);
		t.setClasssection(classSection);
		
		ClassesService ts = new ClassesService();
		String result  = ts.storeClasses(t);
		
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("addClasses.jsp");
		rd.include(request, response);
	}

}
