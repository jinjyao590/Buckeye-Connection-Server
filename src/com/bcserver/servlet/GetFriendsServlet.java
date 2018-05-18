package com.bcserver.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bcserver.dao.UserDao;
import com.bcserver.model.UserBean;
import com.bcserver.utils.ToJson;

/**
 * Servlet implementation class GetFriendsInfo
 */

public class GetFriendsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String username = req.getParameter("username");
		List<UserBean> partUsers = new ArrayList<UserBean>();
		UserDao ud = new UserDao();
		partUsers = ud.getPartUsersInfo(username);
		resp.setContentType("application/json");
		resp.getWriter().write(ToJson.friendsToJson(partUsers));
		System.out.println(ToJson.friendsToJson(partUsers));
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
