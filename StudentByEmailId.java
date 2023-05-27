package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.jdbcdao.entity.Student;
import com.app.jdbcdao.service.StudentService;
import com.app.jdbcdao.serviceimpl.StudentServiceImpl;

@WebServlet("/studentbyemailid")
public class StudentByEmailId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();

		String id = request.getParameter("email");

		StudentService service = new StudentServiceImpl();

		try {
			Student student = service.getStudentByEmailId(id);

			String s = "<html> <body> <h3 align='center' >Student List</h3>";
			s = s + "<table align='center' border='2' >";
			s = s + "<tr> <th>Name</th> <th>Mobile No</th> <th>EmailId</th> <th>Password</th>";
			s = s + "<th>Gender</th> <th>Course</th> <th>City</th> </tr>";

			s = s + "<tr> <td>" + student.getName() + "</td>";
			s = s + "<td>" + student.getMobile() + "</td>";
			s = s + "<td>" + student.getEmail() + "</td>";
			s = s + "<td>" + student.getPassword() + "</td>";
			s = s + "<td>" + student.getGender() + "</td>";
			s = s + "<td>" + student.getCourse() + "</td>";
			s = s + "<td>" + student.getCity() + "</td></tr>";

			writer.write(s);

			s = "<body>";
			s = s + "<form action='./' method='get'>";

			s = s + "<table align='center'>";
			s = s + "<tr>";
			s = s + "<td align='center' colspan='2'><h3>Registration Form</h3></td>";
			s = s + "<tr>";
			s = s + "<td>Student Name:</td>";
			s = s + "<td><input type='text' name='name' value='" + student.getName() + "'></td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>Mobile Number :</td>";
			s = s + "<td><input type='text' name='mobile' value=" + student.getMobile() + "></td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>E-mail id:</td>";
			s = s + "<td><input type='text' name='emailid' value=" + student.getEmail() + " ><br>";
			s = s + "<br></td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>Password:</td>";
			s = s + "<td><input type='password' name='password' value=" + student.getPassword() + " ></td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>Gender:</td>";
			s = s + "<td>";
			if (student.getGender().equals("Male")) {
				s = s + "<input type='radio' name='gender' id='radiogroup1' checked  value = 'Male'>Male";
				s = s + "<input type='radio' name='gender' value='Female' id='radiogroup2' >Female";
			} else {
				s = s + "<input type='radio' name='gender' id='radiogroup1' value = 'Male'>Male";
				s = s + "<input type='radio' name='gender' value='Female' checked id='radiogroup2' >Female";
			}
			s = s + "</td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>Courses:</td>";
			
			
			s = s + "<td><input type='checkbox' name='course' ";
			if(student.getCourse().contains("Java")) {
				s = s + "checked";
			}
			s = s +" value='Java'>Java";
			s = s + "<input type='checkbox' name='course'";
			if(student.getCourse().contains("Python")) {
				s = s + "checked";
			}
			s = s +  " value='Python'>Python";
			s = s + "<input type='checkbox' name='course'";
			if(student.getCourse().contains("Aws")) {
				s = s + "checked";
			}
			s = s + " value='Aws'>Aws";
			s = s + "</td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td>City:</td>";
			s = s + "<td><select name='city' id='city'>";
			if(student.getCity().equals("Blr")) {
				s = s + "<option selected >Blr</option>";
			} else {
				s = s + "<option>Blr</option>";
			}
			
			if(student.getCity().equals("chennai")) {
				s = s + "<option selected >chennai</option>";
			} else {
				s = s + "<option>chennai</option>";
			}
			
			if(student.getCity().equals("Hyd")) {
				s = s + "<option selected >Hyd</option>";
			} else {
				s = s + "<option>Hyd</option>";
			}
			
			if(student.getCity().equals("Vizag")) {
				s = s + "<option selected >Vizag</option>";
			} else {
				s = s + "<option>Vizag</option>";
			}
			
			
			s = s + "</select></td>";
			s = s + "<tr>";
			s = s + "<tr>";
			s = s + "<td></td>";
			s = s + "<td><input type='submit' value='Update'>";
			s = s + "</td><tr>";
			s = s + "</table>";
			s = s + "</form>";
			s = s + "</body>";

			writer.write(s);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
