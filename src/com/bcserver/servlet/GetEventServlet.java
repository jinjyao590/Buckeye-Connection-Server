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
import org.json.JSONObject;

import com.bcserver.dao.EventDao;
import com.bcserver.dao.MomentDao;
import com.bcserver.model.EventBean;
import com.bcserver.model.MomentBean;

public class GetEventServlet extends HttpServlet{
	
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
			EventDao ed= new EventDao();
			List<EventBean> events= new ArrayList<EventBean>();
			events= ed.getEvents();
			//JSONArray jsonArray= new JSONArray();
			
			if (events.size()>0)
			{
				JSONArray jsonArray= new JSONArray();
				for (EventBean eb: events)
				{
					JSONObject jObj= new JSONObject();
					jObj.put("event", eb.getEventName());
					System.out.println(jObj.get("event"));
					jObj.put("place", eb.getPlace());
					System.out.println(jObj.get("place"));
					jObj.put("econtent", eb.getContent());
					System.out.println(jObj.get("econtent"));
					jObj.put("club", eb.getClub());
					System.out.println(jObj.get("club"));
					jsonArray.put(jObj);
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
