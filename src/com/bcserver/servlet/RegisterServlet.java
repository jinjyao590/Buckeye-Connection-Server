package com.bcserver.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.bcserver.dao.UserDao;
import com.bcserver.model.UserBean;
import com.bcserver.utils.ToJson;


/**
 * Servlet implementation class RegisterServlet
 */

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		// System.out.println("Test in Servlet!");
		System.out.println(request.toString());
		System.out.println("Get into the server!");
		request.setCharacterEncoding("UTF-8");
		// String name = request.getParameter("username");
		// System.out.println(name);

		UserBean ub = new UserBean();
		// JSONObject jsonObject = JSONObject.fromObject(name);

		ub.setUsername(request.getParameter("username"));
		ub.setPassword(request.getParameter("password"));
		ub.setRealName(request.getParameter("realname"));
		ub.setNation(Integer.parseInt(request.getParameter("nation")));
		ub.setGender(Integer.parseInt(request.getParameter("gender")));
		ub.setMajor(Integer.parseInt(request.getParameter("major")));
		
		ub.setRealName("Jinjie Yao");
		ub.setInterest("Nothing");
		ub.setPhoto("url");

		UserDao ud = new UserDao();
		ud.register(ub);
		// PrintWriter out = response.getWriter();
		// out.println("Hello World");
		
		// end
		response.setContentType("application/json");
		response.getWriter().write(ToJson.userToJson(ub));
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
