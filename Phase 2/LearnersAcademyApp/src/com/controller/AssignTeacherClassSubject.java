package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.ClassesService;
import com.service.StudentsService;
import com.service.TeacherService;

/**
 * Servlet implementation class AssignTeacherClassSubject
 */
@WebServlet("/AssignTeacherClassSubject")
public class AssignTeacherClassSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignTeacherClassSubject() {
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
		int classid = Integer.parseInt(request.getParameter("classid"));
		int tid = Integer.parseInt(request.getParameter("tid"));
		
		
		TeacherService ts = new TeacherService();
		String result  = ts.assignTeacherClass(classid,tid);
		
		pw.println(result);
		

		
		RequestDispatcher rd = request.getRequestDispatcher("assignTeacherClass.jsp");
		rd.include(request, response);
	}
	}


