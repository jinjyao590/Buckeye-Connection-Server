package com.bcserver.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcserver.dao.EventDao;
import com.bcserver.model.EventBean;

public class JoinEventsServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("do get of join events");
		req.setCharacterEncoding("UTF-8");
		
		String username= req.getParameter("username");
		String activity= req.getParameter("activity");
		EventDao md= new EventDao();
		md.joinEvents(username, activity);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		doGet(request, response);
	}
}
