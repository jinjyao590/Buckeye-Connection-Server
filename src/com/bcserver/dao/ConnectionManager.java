package com.bcserver.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://192.241.179.166:3306/bc_db";
	private static final String UNAME = "yao.590";
	private static final String UPASS = "123456";
	
	public static Connection getCon() throws SQLException, InstantiationException, IllegalAccessException {
		Connection con = null;
		try {
			Class.forName(DRIVER).newInstance();
			con = DriverManager.getConnection(URL, UNAME, UPASS);
			System.out.println("Seccessfully Connected!");
		} catch (ClassNotFoundException e) {
			System.out.println("Failure to connect!");
		}
		return con;	
	}
	
	public static void allClose(Connection con, PreparedStatement pstmt, ResultSet rs) {

		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
