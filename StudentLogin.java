package com.app.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentLogin")
public class StudentLogin extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		
		// SELECT * FROM firstweb.student WHERE EMAILID = 'ABC_XYZ@GMAIL.COM' AND PASSWORD = 'ABCXYZ'
		
		
		if(userName.equals("abc") && password.equals("abc")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("studentlist");
			dispatcher.forward(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.forward(request, response);
		}
	}
}
