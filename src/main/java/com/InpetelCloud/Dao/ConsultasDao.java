package com.InpetelCloud.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ConsultasInterface;

@Repository
public class ConsultasDao implements ConsultasInterface{

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> Usuarios() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Usuarios");
		return view;
	}
}
