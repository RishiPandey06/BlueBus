package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.application.model.*;

public class customerMapper implements RowMapper<customer> {
	   public customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		   customer cs = new customer();
		   cs.setName(rs.getString("name"));
		   cs.setPhone(rs.getString("phone_number"));
		   cs.setEmail(rs.getString("email"));
		   cs.setGender(rs.getInt("gender"));
		   cs.setFromLoc(rs.getString("from_loc"));
		   cs.setToLoc(rs.getString("to_loc"));
		   cs.setFromPick(rs.getString("from_pick"));
		   cs.setToPick(rs.getString("to_pick"));
		   return cs;
	   }

}
