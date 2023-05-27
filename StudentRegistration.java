package com.app.controller; 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.app.jdbcdao.service.StudentService;
import com.app.jdbcdao.serviceimpl.StudentServiceImpl;

@WebServlet("/studentreg")
public class StudentRegistration extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		
		String name = request.getParameter("name");		
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("emailid");
		String password = request.getParameter("password");
		String gender = request.getParameter("gender");
		String[] course = request.getParameterValues("course");
		String city = request.getParameter("city");
		
		
		String c = "";
		
		for(String s : course) {
			c = c +","+s;
		}
		c = c.replaceFirst(",", "");
		
//		writer.write("name = "+name);
//		writer.write("\nmobile = "+mobile);
//		writer.write("\nemail = "+email);
//		writer.write("\npassword = "+password);
//		writer.write("\ngender = "+gender);
//		writer.write("\ncourse = "+c);
//		writer.write("\ncity = "+city);
		
		StudentService service = new StudentServiceImpl();
		
		int result = 0;
		
		try {
			result = service.insertStudent(name, mobile, email, password, c, city, gender);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(result != 0) {
			writer.write("\n\\nStudent data is inserted");
		} else {
			writer.write("\n\\nStudent data is not inserted");
		}
		
		
	}
}
