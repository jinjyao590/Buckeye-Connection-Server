package com.bcserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bcserver.model.MomentBean;
//import com.mysql.jdbc.Connection;

public class MomentDao {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public void postMoment(MomentBean mb)
	{
		//connection= ConnectionManager.getCon();
		/*final String SQL= "INSERT INTO momt_tb "
				+ "(username, img, creattime, content) VALUES"
				+ "(?,?,?,?)";*/
		/*final String SQL = "INSERT INTO std_tb(username, password, realname, nation, major,"
				+ " gender, age, credits, interest, photo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";*/
		try {
			connection= ConnectionManager.getCon();
			final String SQL= "INSERT INTO momt_tb"
					+ "(username, img, createtime, content) VALUES"
					+ "(?,?,?,?)";
			pstmt= connection.prepareStatement(SQL);
			System.out.println(mb.getUsername());
			pstmt.setString(1, mb.getUsername());
			pstmt.setString(2, mb.getPhoto());
			//pstmt.setDate(3, mb.getCreatetime());
			//Date incoingvalue= Date(System.)
			/*java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
			java.sql.Date databasevalue= new java.sql.Date(incomingValue.getTime());*/
			java.sql.Timestamp tsp= new java.sql.Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(3, tsp);
			//pstmt.setDate(3, databasevalue);
			pstmt.setString(4, mb.getContent());
			pstmt.executeUpdate();
			ConnectionManager.allClose(connection, pstmt, rs);
		} 
		 catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<MomentBean> getMoments ()
	{
		
		List<MomentBean> mbs= new ArrayList<MomentBean>();
		try {
			connection= ConnectionManager.getCon();
			final String SQL ="SELECT * FROM momt_tb";
			pstmt= connection.prepareStatement(SQL);
			ResultSet rs= pstmt.executeQuery(SQL);
			//List<MomentBean> mbs= new ArrayList<MomentBean>();
			while (rs.next())
			{
			MomentBean mb= new MomentBean();
			mb.setUsername(rs.getString("username"));
			mb.setContent(rs.getString("content"));
			mb.setCreatetime(rs.getDate("createtime"));
			mb.setPhoto(rs.getString("img"));
			System.out.println(rs.getString("content"));
			mbs.add(mb);
			}
			ConnectionManager.allClose(connection, pstmt, rs);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mbs;
		
	}
}
