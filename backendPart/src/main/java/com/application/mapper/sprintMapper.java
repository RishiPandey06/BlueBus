package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.application.model.sprint;


public class sprintMapper implements RowMapper<sprint> {

	@Override
	public sprint mapRow(ResultSet rs, int arg1) throws SQLException {
		sprint spr = new sprint();
		spr.setSprint_id((Integer.parseInt(rs.getString("sprint_id"))));
		spr.setSv_emp_id((Integer.parseInt(rs.getString("sv_emp_id"))));
		spr.setProject_id((Integer.parseInt(rs.getString("project_id"))));
		spr.setSprint_start_date(rs.getString("sprint_start_date"));
		spr.setSprint_end_date(rs.getString("sprint_end_date"));
		spr.setNo_of_weeks((Integer.parseInt(rs.getString("no_of_weeks"))));
		spr.setNo_of_groups(rs.getInt("no_of_groups"));
		return spr;
	}

}
