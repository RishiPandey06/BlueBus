package com.application.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.application.model.Groupinfo;
import com.application.model.tasklist;

public class tasklistMapper implements RowMapper<tasklist> {
   public tasklist mapRow(ResultSet rs, int rowNum) throws SQLException {
      tasklist list = new tasklist();
      list.setTask_id(rs.getInt("task_id"));
      list.setTask_name(rs.getString("task_name"));
      
      return list;
   }
}
