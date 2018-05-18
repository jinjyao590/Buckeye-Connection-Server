package com.bcserver.test;

import java.sql.SQLException;

import org.junit.Test;

import com.bcserver.dao.ConnectionManager;

public class TestDBConnection {
	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		try {
			ConnectionManager.getCon();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
