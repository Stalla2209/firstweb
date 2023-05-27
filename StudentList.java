package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbcdao.entity.Student;
import com.app.jdbcdao.service.StudentService;
import com.app.jdbcdao.serviceimpl.StudentServiceImpl;

/**
 * Servlet implementation class StudentList
 */
@WebServlet("/studentlist")
public class StudentList extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		StudentService service = new StudentServiceImpl();
		
		try {
			List<Student> studentList = service.getAllStudents();
			
			String s = "<html> <body> <h3 align='center' >Student List</h3>";
			s = s + "<table align='center' border='2' >";
			s = s + "<tr> <th>Name</th> <th>Mobile No</th> <th>EmailId</th> <th>Password</th>";
			s = s + "<th>Gender</th> <th>Course</th> <th>City</th> <th>UPDATE</th> </tr>";

			for(Student student : studentList) {
				s = s + "<tr> <td>"+student.getName()+"</td>";
				s = s + "<td>"+student.getMobile()+"</td>";
				s = s + "<td>"+student.getEmail()+"</td>";
				s = s + "<td>"+student.getPassword()+"</td>";
				s = s + "<td>"+student.getGender()+"</td>";
				s = s + "<td>"+student.getCourse()+"</td>";
				s = s + "<td>"+student.getCity()+"</td>";
				s = s + " <td> <a href='./studentbyemailid?email="+student.getEmail()+"' > update </td> </tr>";
				
			}
			writer.write(s);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
