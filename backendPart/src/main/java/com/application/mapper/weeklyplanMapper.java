package com.application.mapper;
import com.application.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class weeklyplanMapper implements RowMapper<weeklyPlan> {
   public weeklyPlan mapRow(ResultSet rs, int rowNum) throws SQLException {
	   weeklyPlan  wp = new weeklyPlan();
	   wp.setPlan_id(rs.getInt("plan_id"));
	      wp.setSprint_id(rs.getInt("sprint_id"));
		  wp.setEmp_id(rs.getInt("emp_id"));
		  wp.setProject_id(rs.getInt("project_id"));
		  wp.setWeek_id(rs.getInt("week_id"));
	      return wp;
   }
}