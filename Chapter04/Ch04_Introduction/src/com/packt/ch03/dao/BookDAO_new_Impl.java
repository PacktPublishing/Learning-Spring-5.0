package com.packt.ch03.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO_new_Impl implements BookDAO_new {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public String getDescription(long ISBN) {
		// TODO Auto-generated method stub
		String GET_DESCRIPTION=" select description from book where ISBN=?";
		String description=jdbcTemplate.queryForObject(GET_DESCRIPTION, new Object[]{ISBN},String.class);
		return description;
	}

}
