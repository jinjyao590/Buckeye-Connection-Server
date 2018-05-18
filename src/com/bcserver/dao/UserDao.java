package com.bcserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bcserver.model.UserBean;

public class UserDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void register(UserBean ub) {
		try {
			con = ConnectionManager.getCon();
			final String SQL = "INSERT INTO std_tb(username, password, realname, nation, major,"
					+ " gender, age, credits, interest, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			/*final String SQL= "INSERT INTO momt_tb"
					+ "(username, img, creattime, content) VALUES"
					+ "(?,?,?,?)";*/
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, ub.getUsername());
			pstmt.setString(2, ub.getPassword());
			System.out.println("realname is "+ ub.getRealName() );
			pstmt.setString(3, ub.getRealName());
			pstmt.setInt(4, ub.getNation());
			pstmt.setInt(5, ub.getMajor());
			pstmt.setInt(6, ub.getGender());
			pstmt.setInt(7, ub.getAge());
			pstmt.setInt(8, ub.getCredits());
			pstmt.setString(9, ub.getInterest());
			pstmt.setString(10, ub.getPhoto());
			/*inal String SQL= "INSERT INTO momt_tb"
					+ "(username, img, createtime, content) VALUES"
					+ "(?,?,?,?)";*/
			pstmt.executeUpdate();
			ConnectionManager.allClose(con, pstmt, rs);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public UserBean getUserInfo(String username, String password) {
		UserBean ub = new UserBean();
		try {
			con = ConnectionManager.getCon();
			final String SQL = "SELECT * FROM std_tb WHERE username=? AND password=?";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			// TODO: get the result
			if (rs.next()) {
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setRealName(rs.getString("realName"));
				ub.setNation(rs.getInt("nation"));
				ub.setMajor(rs.getInt("major"));
				ub.setGender(rs.getInt("gender"));
				ub.setAge(rs.getInt("age"));
				ub.setCredits(rs.getInt("credits"));
				ub.setInterest(rs.getString("interest"));
				ub.setPhoto(rs.getString("photo"));
			}
			ConnectionManager.allClose(con, pstmt, rs);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ub;	
	}
	
	public List<UserBean> getPartUsersInfo(String username) {
		List<UserBean> partUsers = new ArrayList<UserBean>();
		try {
			con = ConnectionManager.getCon();
			final String SQL = "SELECT std_tb.* FROM std_tb,fri_tb WHERE fri_tb.username=? AND"+
					" std_tb.username=fri_tb.friname";
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				UserBean ub = new UserBean();
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setRealName(rs.getString("realName"));
				ub.setNation(rs.getInt("nation"));
				ub.setMajor(rs.getInt("major"));
				ub.setGender(rs.getInt("gender"));
				ub.setAge(rs.getInt("age"));
				ub.setCredits(rs.getInt("credits"));
				ub.setInterest(rs.getString("interest"));
				ub.setPhoto(rs.getString("photo"));
				partUsers.add(ub);
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return partUsers;	
	}
}
