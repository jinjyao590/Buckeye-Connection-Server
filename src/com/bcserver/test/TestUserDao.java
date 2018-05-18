package com.bcserver.test;

import java.sql.SQLException;

import org.junit.Test;

import com.bcserver.dao.UserDao;
import com.bcserver.model.UserBean;

public class TestUserDao {
	@Test
	public void test(){
		UserDao ud = new UserDao();
		UserBean ub = new UserBean();
		ub.setUsername("DYL");
		ub.setPassword("123456");
		ub.setRealName("Jinjie Yao");
		ub.setNation(5);
		ub.setGender(0);
		ub.setMajor(1);
		ud.register(ub);
	}
}
