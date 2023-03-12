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


import com.entity.Subject;
import com.service.SubjectService;

/**
 * Servlet implementation class LearnerControllerSubject
 */
@WebServlet("/LearnerControllerSubject")
public class LearnerControllerSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LearnerControllerSubject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		SubjectService ps = new SubjectService();
		List<Subject> listOfSubjects = ps.findAllSubject();
		pw.println("Number of Subjects are "+listOfSubjects.size());
		Iterator<Subject> ii = listOfSubjects.iterator();
		while(ii.hasNext()) {
			Subject p = ii.next();
			pw.println("<div>");
			pw.println("<span>Subject ID is "+p.getSubid()+" Subject Name is "+ p.getSubjectname()+"</span>");
			pw.println("</div>");
		}
		RequestDispatcher rd = request.getRequestDispatcher("ViewSubjects.jsp");
		rd.include(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		String subname = request.getParameter("subname");

		
		Subject t = new Subject();
		t.setSubjectname(subname);
		
		SubjectService ts = new SubjectService();
		String result  = ts.storeSubject(t);
		
		pw.println(result);
		
		RequestDispatcher rd = request.getRequestDispatcher("addSubjects.jsp");
		rd.include(request, response);
	}

}
