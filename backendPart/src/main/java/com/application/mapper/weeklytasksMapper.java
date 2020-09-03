package com.application.mapper;
import com.application.model.Employee;
import com.application.model.weeklytasks;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class weeklytasksMapper implements RowMapper<weeklytasks> {
   public weeklytasks mapRow(ResultSet rs, int rowNum) throws SQLException {
      weeklytasks w = new weeklytasks();
      w.setPlan_id(rs.getInt("plan_id"));
      w.setWeek_id(rs.getInt("week_id"));
      w.setW_task_hours(rs.getInt("w_task_hours"));
      w.setW_task_id(rs.getInt("w_task_id"));
      w.setWeekly_story_points_assigned(rs.getFloat("weekly_story_points_assigned"));
      return w;

   }

}
