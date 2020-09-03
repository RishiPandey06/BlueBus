package com.application.mapper;
import com.application.model.Employee;
import com.application.model.tstasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class tstasksMapper implements RowMapper<tstasks> {
   public tstasks mapRow(ResultSet rs, int rowNum) throws SQLException {
	   tstasks ts = new tstasks();
	   ts.setTs_date(rs.getString("ts_date"));
	   ts.setEmp_id(rs.getInt("emp_id"));
	   ts.setTs_task_hours(rs.getInt("ts_task_hours"));
	   ts.setTs_task_id(rs.getInt("ts_task_id"));
	   ts.setTs_story_points_achieved(rs.getFloat("ts_story_points_achieved"));
	   ts.setWeek_id(rs.getInt("week_id"));
      
	return ts;
   }
}
