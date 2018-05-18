package com.bcserver.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {

	public static void main(String[] args) {
		//Result result = JUnitCore.runClasses(TestDBConnection.class);		
		Result result = JUnitCore.runClasses(TestUserDao.class);
	}

}
