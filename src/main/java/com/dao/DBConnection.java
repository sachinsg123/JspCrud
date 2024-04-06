package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Student;

public class DBConnection {
	private static Connection connection = null;
	public static Connection getConnection() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","1234");
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
   // for adding student
	
	public static int addStudent(Student stud){
		int value = 0;
		try {
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement("insert into student(name, email) values(?,?)");
			pst.setString(1, stud.getName());
			pst.setString(2, stud.getEmail());
			
			value = pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	//update student;
	
	public static int updateStudent(Student stud){
		
		int value = 0;
		try{
			
			connection = getConnection();
			PreparedStatement pst=connection.prepareStatement("UPDATE student SET name=?, email=? WHERE id =?");
			pst.setString(1, stud.getName());
			pst.setString(2, stud.getEmail());
			pst.setInt(3, stud.getId());
			value =pst.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	
	// getAllStudent
	
	public static List<Student> getAllStudent(){
		
		 List<Student> list = new ArrayList<Student>();
		 Student student = null;
		try {
			
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from student");
			ResultSet rs =pst.executeQuery();
			
			while(rs.next()){
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				list.add(student);
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public static int deleteStudent(Student stud){
		int value = 0;
		try {
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement("delete from student where id = ?");
			pst.setInt(1, stud.getId());
			value = pst.executeUpdate();
			
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		return value;
	}
	// get student by id
	
	public static Student getStudentById(int id){
		Student student = null;
		try {
			connection = getConnection();
			PreparedStatement pst = connection.prepareStatement("select * from student where id =?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				
				student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return student;
		
	}
	

}
