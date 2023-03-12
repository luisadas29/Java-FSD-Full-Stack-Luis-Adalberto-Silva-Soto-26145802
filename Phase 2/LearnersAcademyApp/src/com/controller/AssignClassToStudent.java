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

/**
 * Servlet implementation class AssignClassToStudent
 */
@WebServlet("/AssignClassToStudent")
public class AssignClassToStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignClassToStudent() {
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
			response.setContentType("text/html");
			int classid = Integer.parseInt(request.getParameter("classid"));
			int studentid = Integer.parseInt(request.getParameter("studentid"));
			
			
			StudentsService ts = new StudentsService();
			String result  = ts.assignStudentClass(classid,studentid);
			
			pw.println(result);

			
			RequestDispatcher rd = request.getRequestDispatcher("assignStudentClass.jsp");
			rd.include(request, response);
		}
	}


