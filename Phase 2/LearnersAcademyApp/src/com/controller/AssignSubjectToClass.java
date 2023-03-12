package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.SubjectService;

/**
 * Servlet implementation class AssignSubjectToClass
 */
@WebServlet("/AssignSubjectToClass")
public class AssignSubjectToClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignSubjectToClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		PrintWriter pw1 = response.getWriter();
		response.setContentType("text/html");
		int subid = Integer.parseInt(request.getParameter("subid"));
		int classid = Integer.parseInt(request.getParameter("classid"));
		
		
		SubjectService ts = new SubjectService();
		String result  = ts.assignTeacherToSubjects(subid, classid);
		
		pw.println(result);
		

		
		RequestDispatcher rd = request.getRequestDispatcher("assignTeacherSubject.jsp");
		rd.include(request, response);
	}
	}


