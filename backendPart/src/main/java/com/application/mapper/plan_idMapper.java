package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.application.model.*;

public class plan_idMapper implements RowMapper<plan_id> {
	public plan_id mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		plan_id pi = new plan_id();
		pi.setPlan_id(rs.getInt("plan_id"));
		return pi;
	}
}
