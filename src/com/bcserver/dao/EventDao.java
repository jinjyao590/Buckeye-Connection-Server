package com.bcserver.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bcserver.model.EventBean;
import com.bcserver.model.MomentBean;

public class EventDao {
	
	private Connection connection;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public List<EventBean> getEvents()
	{
		List<EventBean> ebs= new ArrayList<EventBean>();
		try {
			connection= ConnectionManager.getCon();
			final String SQL ="SELECT * FROM act_tb";
			pstmt= connection.prepareStatement(SQL);
			ResultSet rs= pstmt.executeQuery(SQL);
			//List<MomentBean> mbs= new ArrayList<MomentBean>();
			//dao corresponds to actual database column name
			while (rs.next())
			{
			EventBean eb= new EventBean();
			eb.setEventName(rs.getString("actname"));
			eb.setPlace(rs.getString("actplace"));
			eb.setClub(rs.getString("clubname"));
			eb.setContent(rs.getString("actcontent"));
			System.out.println("event name "+rs.getString("actname"));
			ebs.add(eb);
			}
			ConnectionManager.allClose(connection, pstmt, rs);
		} catch (InstantiationException | IllegalAccessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ebs;
		
	}
	
	public void joinEvents(String username, String activity)
	{
		try {
			connection= ConnectionManager.getCon();
			final String SQL= "INSERT INTO act_memb_tb"
					+ "(actid, username, jointime) VALUES"
					+ "(?,?,?)";
			pstmt= connection.prepareStatement(SQL);
			//System.out.println(mb.getUsername());
			pstmt.setString(1, activity);
			pstmt.setString(2, username);
			//pstmt.setDate(3, mb.getCreatetime());
			//Date incoingvalue= Date(System.)
			/*java.util.Date incomingValue = new java.util.Date(System.currentTimeMillis());
			java.sql.Date databasevalue= new java.sql.Date(incomingValue.getTime());*/
			java.sql.Timestamp tsp= new java.sql.Timestamp(System.currentTimeMillis());
			pstmt.setTimestamp(3, tsp);
			//pstmt.setDate(3, databasevalue);
			//pstmt.setString(4, mb.getContent());
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

}
