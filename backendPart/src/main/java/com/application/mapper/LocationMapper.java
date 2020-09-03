package com.application.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.application.model.Locations;

public class LocationMapper implements RowMapper<Locations>{
	public Locations mapRow(ResultSet rs, int rowNum) throws SQLException {
	      Locations loc = new Locations();
	      loc.setCity(rs.getString("city"));
	      loc.setLocation(rs.getString("location"));
	      return loc;
	   }
}
