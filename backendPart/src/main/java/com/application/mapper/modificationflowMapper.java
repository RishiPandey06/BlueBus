package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.model.*;

public class modificationflowMapper implements RowMapper<modificationflow> {
	public modificationflow mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		modificationflow mf = new modificationflow();
		mf.setSv_emp_id(rs.getInt("sv_emp_id"));
		mf.setSprint_id(rs.getInt("sprint_id"));
		mf.setWeek_id(rs.getInt("week_id"));
		mf.setEmp_id(rs.getInt("emp_id"));
		mf.setSv_status(rs.getBoolean("sv_status"));
		mf.setEmp_status(rs.getBoolean("emp_status"));
		return mf;
	}

}
