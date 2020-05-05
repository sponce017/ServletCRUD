package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.model.User;
import com.example.util.DBUtil;

public class UserDAO {

	private Connection connection;
	
	public UserDAO(){
		connection = DBUtil.getConnection();
	}
	
	public void addUser(User user){
		String sql = "insert into users (firstname, lastname, dob,email) values (?,?,?,?)";
		
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			ps.setString(4, user.getEmail());
			ps.executeUpdate();			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId){
		String sql = "delete from users where userid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateUser(User user){
		String sql = "update users set firstname = ?, lastname = ?, dob = ?, email = ? where userid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setDate(3, new java.sql.Date(user.getDob().getTime()));
			ps.setString(4, user.getEmail());
			ps.setInt(5, user.getUserid());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
	}
	
	public List<User> getAllUsers(){
		List<User> users = new ArrayList<User>();
		try {
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery("select * from users");
			while(rs.next()){
				User user = new User();
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
				users.add(user);				
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return users;
	}
	
	public User getUserById(int userId){
		User user = new User();
		String sql = "select * from users where userid = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){				
				user.setUserid(rs.getInt("userid"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setDob(rs.getDate("dob"));
				user.setEmail(rs.getString("email"));
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return user;
	}
	
}
