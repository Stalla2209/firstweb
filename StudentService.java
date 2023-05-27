
package com.app.jdbcdao.service;

import java.sql.SQLException;
import java.util.List;

import com.app.jdbcdao.entity.Student;

public interface StudentService {

	public int insertStudent(String name, String mobile, String email,
			String password, String course, String city, String gender) throws SQLException;
	
	public List<Student> getAllStudents() throws SQLException;

	public Student getStudentByEmailId(String emailId) throws SQLException;
}
