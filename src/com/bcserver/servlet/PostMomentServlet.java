package com.bcserver.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcserver.dao.MomentDao;
import com.bcserver.model.MomentBean;

public class PostMomentServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostMomentServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException
	{
		System.out.println(request.toString());
		System.out.println("Get into the server/ PostMoment DoGet");
		request.setCharacterEncoding("UTF-8");
		
		MomentBean mb= new MomentBean();
		mb.setUsername(request.getParameter("username"));
		mb.setContent(request.getParameter("content"));
		//mb.setPhoto(re);
		//java.util.Date utilDate= new java.util.Date();
		//java.sql.Date sqlDate= new java.sql.Date(utilDate.getTime());
		
		MomentDao md= new MomentDao();
		md.postMoment(mb);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
