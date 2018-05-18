package com.bcserver.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.bcserver.model.UserBean;

public class ToJson {
	public static String userToJson(UserBean ub) {
		JSONObject json = new JSONObject();
		Map userInfo;
		userInfo = new HashMap();
		userInfo.put("username", ub.getUsername());
		userInfo.put("password", ub.getPassword());
		userInfo.put("realname", ub.getRealName());
		userInfo.put("nation", ub.getNation());
		userInfo.put("major", ub.getMajor());
		userInfo.put("gender", ub.getGender());
		userInfo.put("age", ub.getAge());
		userInfo.put("credits", ub.getCredits());
		userInfo.put("interest", ub.getInterest());
		userInfo.put("photo", ub.getPhoto());
		try {
			json.put("userInfo", userInfo);
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
	
	public static String friendsToJson(List<UserBean> partUsers) {
		JSONObject json = new JSONObject();
		int i = 0;
		for (UserBean ub : partUsers) {
			Map userInfo;
			userInfo = new HashMap();
			userInfo.put("username", ub.getUsername());
			userInfo.put("password", ub.getPassword());
			userInfo.put("realname", ub.getRealName());
			userInfo.put("nation", ub.getNation());
			userInfo.put("major", ub.getMajor());
			userInfo.put("gender", ub.getGender());
			userInfo.put("age", ub.getAge());
			userInfo.put("credits", ub.getCredits());
			userInfo.put("interest", ub.getInterest());
			userInfo.put("photo", ub.getPhoto());
			try {
				json.put("friendInfo_"+i, userInfo);			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		try {
			json.put("count_friends", i);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return json.toString();
	}
}
