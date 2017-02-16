package com.afm.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.afm.model.User;
import com.afm.service.UserService;

import hibernateutil.HibernateUtil;

/**
 * Servlet implementation class UserController
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private SessionFactory sf = HibernateUtil.getSessionFactory();
    private UserService us = new UserService();
    /* * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
          request.setAttribute("uList", us.getUserH());
          request.setAttribute("criList", us.getUserCri());
          request.getRequestDispatcher("user.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String lastName = request.getParameter("lastName");
		int age = Integer.parseInt(request.getParameter("age"));
		
		us.saveUser(name, lastName, age);
		request.setAttribute("uList", us.getUserH());
		request.setAttribute("criList", us.getUserCri());
		
		request.getRequestDispatcher("user.jsp").forward(request, response);
		
	}

}
