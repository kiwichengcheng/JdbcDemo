package com.reuters.cc.dao;

import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;

public class SimpleJdbcDaoImpl extends SimpleJdbcDaoSupport {

	
	public int getCircleCount(){
		
		String SQL = "select count(*) from circle";
		
		
		return this.getJdbcTemplate().queryForInt(SQL);
	}
	
}
