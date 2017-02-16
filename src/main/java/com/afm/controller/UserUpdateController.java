package com.afm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.afm.service.UserService;

/**
 * Servlet implementation class UserUpdateController
 */
public class UserUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private UserService us = new UserService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	       int id = Integer.parseInt(request.getParameter("id"));
	       request.setAttribute("id", id);
	       request.getRequestDispatcher("userupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		
		us.userUpdate(id, name, lastName, age);
		request.setAttribute("uList", us.getUserH());
		request.setAttribute("criList", us.getUserCri());		
		request.getRequestDispatcher("user.jsp").forward(request, response);
		
	}

}
