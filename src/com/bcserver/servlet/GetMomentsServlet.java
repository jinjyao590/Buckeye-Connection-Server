package com.bcserver.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.bcserver.dao.MomentDao;
import com.bcserver.model.MomentBean;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;

public class GetMomentsServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		System.out.println("Get into the server/ getMoments");
		resp.setContentType("text/html;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
		JSONObject jsonObj= new JSONObject();
		//JSONObject jsonObj1= new JSONObject();
		PrintWriter out= resp.getWriter();
		String msg="success";
        int errorcode=0;
		try
		{
			//MomentBean mb= new MomentBean();
			MomentDao md= new MomentDao();
			List<MomentBean> moments= new ArrayList<MomentBean>();
			moments= md.getMoments();
			if (moments.size()>0)
			{
				JSONArray jsonArray= new JSONArray();
				//int i=0;
				for (MomentBean mb: moments)
				{
					//MomentBean mb= new MomentBean();
					JSONObject jsonObj1= new JSONObject();
					//jsonObj1.put("i, value)
					jsonObj1.put("username", mb.getUsername());
					jsonObj1.put("createtime", mb.getCreatetime());
					jsonObj1.put("content", mb.getContent());
					System.out.println("content is (in servlet)"+ jsonObj1.getString("content"));
					jsonArray.put(jsonObj1);
				}
				jsonObj.put("data", jsonArray);
			}
			else
			{
				System.out.println("no data");
				jsonObj.put("data", "");
			}
		}
		catch (Exception e) {
            e.printStackTrace();
            msg = "系统错误";
            errorcode = 10000;
        }
            out.print(jsonObj);
            out.write(jsonObj.toString());
            out.flush();
            out.close();
        }
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
