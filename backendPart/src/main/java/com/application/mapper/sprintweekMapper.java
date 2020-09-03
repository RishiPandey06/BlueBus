package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.application.model.Groupinfo;
import com.application.model.sprintweek;

public class sprintweekMapper implements RowMapper<sprintweek> {
   public sprintweek mapRow(ResultSet rs, int rowNum) throws SQLException {
	   sprintweek spt = new sprintweek();
	   
	      spt.setSprint_id(rs.getInt("sprint_id"));
	      spt.setWeek_id(rs.getInt("week_id"));
	   String startDate = null;
		startDate = rs.getString("week_start_date");
		System.out.println("Start Date is " + startDate);
		spt.setWeek_start_date(startDate);

		String endDate = null;
		endDate = rs.getString("week_end_date");
		System.out.println("End Date is " + endDate);
		spt.setWeek_end_date(endDate);
		
	   return spt;
   }
}
