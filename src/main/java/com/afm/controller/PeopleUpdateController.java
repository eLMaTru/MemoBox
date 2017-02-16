package com.afm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afm.service.PeopleService;

/**
 * Servlet implementation class PeopleUpdateController
 */
public class PeopleUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    PeopleService ps = new PeopleService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeopleUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
            String id = request.getParameter("id");
            request.setAttribute("id", id);
            request.getRequestDispatcher("updatep.jsp").forward(request, response);
            
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt( request.getParameter("id") );
		 String name = request.getParameter("name");
	        String lastName = request.getParameter("lastName");
	        int age = Integer.parseInt(request.getParameter("age"));
         
		ps.updateP(id, name, lastName, age);
		request.setAttribute("pList", ps.getPeople());
		request.getRequestDispatcher("home.jsp").forward(request, response);;
		
         
	}

}
