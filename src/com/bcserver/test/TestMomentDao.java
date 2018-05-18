package com.bcserver.test;

//import java.awt.List;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.bcserver.dao.EventDao;
import com.bcserver.dao.MomentDao;
import com.bcserver.model.MomentBean;

public class TestMomentDao {
	 @Test
	 public void testMomentDao()
	 {
		 MomentDao md= new MomentDao();
		 MomentBean mb= new MomentBean();
		 /*mb.setUsername("DYL");
		 mb.setContent("aaaa");
		 //Date date= new Date();
		 //SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 //java.sql.Date date=  java.sql.Date.valueOf("2013-09-04");
		 //mb.setCreatetime(date);
	//	 Date date= new Date();
	//	 mb.setCreatetime((java.sql.Date) date);
		 md.postMoment(mb);*/
		 List <MomentBean> list= new ArrayList<MomentBean>();
		 list= md.getMoments();
		 for (MomentBean mb_list:list)
			 System.out.println("moment content is "+ mb_list.getContent());
	 }
	 
	 @Test
	 public void testJoinEvent()
	 {
		 String username= "DYL";
		 String activity= "RPAC Training";
		 EventDao ed= new EventDao();
		 ed.joinEvents(username, activity);
	 }
}
