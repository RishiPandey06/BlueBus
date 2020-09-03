package com.application.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.jdbc.core.JdbcTemplate;

import com.application.model.*;
import com.application.mapper.*;

@Repository
public class EmployeeDAOImpl {

	@Autowired
	JdbcTemplate temp;
	
	//GetCity
	public List<String> getCityData(){
		String sql = "select * from locations";
		List<Locations> data = temp.query(sql, new Object[] {}, new LocationMapper());
		List<String> cities = new ArrayList<>();
		for(int i=0;i<data.size();i++) {
			cities.add(data.get(i).getCity());
		}
		return cities;
	}
	
	//GetLocation
	public List<String> getLocationData(String city){
		String sql = "select * from locations where city=?";
		List<Locations> data = temp.query(sql, new Object[] {city}, new LocationMapper());
		List<String> locations = new ArrayList<>();
		for(int i=0;i<data.size();i++) {
			locations.add(data.get(i).getLocation());
		}
		return locations;
	}
	
	public void addCustomers(String name, String phone, String email, int gender, String fromLoc, String toLoc, String fromPick, String toPick) {
		String sql ="insert into customers values(?,?,?,?,?,?,?,?)";
		temp.update(sql, new Object[] {name, phone, email, gender, fromLoc, toLoc, fromPick, toPick});
	}
	
	public List<customer> getCustomers()
	{
		String sql = "select * from customers";
		List<customer> cs = temp.query(sql,new customerMapper());
		return cs;
	}
	
	public void deleteCustomer(String phone_number)
	{
		String sql = "delete from customers where phone_number = ? ";
		temp.update(sql,new Object[] {phone_number});
	}
	public void editCustomer(String name, String phone, String email, int gender, String fromLoc, String toLoc, String fromPick, String toPick)
	{
		String sql = "update customers set name = ?, email = ?, gender = ?, from_loc = ?, to_loc = ?, from_pick = ?, to_pick = ? where phone_number = ?";
		temp.update(sql, new Object[] {name,email, gender, fromLoc, toLoc, fromPick, toPick,phone});
	}

}
