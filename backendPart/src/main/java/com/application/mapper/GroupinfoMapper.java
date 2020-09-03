package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.application.model.Groupinfo;

public class GroupinfoMapper implements RowMapper<Groupinfo> {
   public Groupinfo mapRow(ResultSet rs, int rowNum) throws SQLException {
      Groupinfo grp = new Groupinfo();
      grp.setProject_id(rs.getInt("project_id"));
      grp.setEmp_id(rs.getInt("emp_id"));
      grp.setGroup_id(rs.getInt("group_id"));
      grp.setSprint_id(rs.getInt("sprint_id"));
     return grp;
	
   }
}
