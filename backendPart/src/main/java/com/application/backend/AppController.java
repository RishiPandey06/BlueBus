package com.application.backend;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.application.DAO.EmployeeDAOImpl;
import com.application.mapper.tasklistMapper;
import com.application.model.*;

@RestController
@CrossOrigin
//@RequestMapping("/rest")
public class AppController {

	@Autowired
	private EmployeeDAOImpl DAO;

	// Approve data
	@RequestMapping(value = "/getCity", method = RequestMethod.GET)
	public List<String> getCity() {
		return DAO.getCityData();
	}
	
	@RequestMapping(value = "/getLocation", method = RequestMethod.GET)
	public List<String> getLocation(@RequestParam("city") String city) {
		return DAO.getLocationData(city);
	}
	
	@RequestMapping(value = "/insertCustomers", method = RequestMethod.GET)
	public void insertCustomers(@RequestParam("name") String name, @RequestParam("phone") String phoneNumber,
			@RequestParam("email") String email, @RequestParam("gender") String gender, @RequestParam("fromLoc") String fromLoc,
			@RequestParam("toLoc") String toLoc, @RequestParam("fromPick") String fromPick, @RequestParam("toPick") String toPick) {
		DAO.addCustomers(name, phoneNumber, email, Integer.parseInt(gender), fromLoc, toLoc, fromPick, toPick);
	}
	
	@RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
	public List<customer> get_customers()
	{
		return DAO.getCustomers();
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public void delete_customers(@RequestParam("phone") String phoneNumber)
	{
		DAO.deleteCustomer(phoneNumber);
	}
	
	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public void edit_customer(@RequestParam("name") String name, @RequestParam("phone") String phoneNumber,
			@RequestParam("email") String email, @RequestParam("gender") String gender, @RequestParam("fromLoc") String fromLoc,
			@RequestParam("toLoc") String toLoc, @RequestParam("fromPick") String fromPick, @RequestParam("toPick") String toPick) {
		DAO.editCustomer(name, phoneNumber, email, Integer.parseInt(gender), fromLoc, toLoc, fromPick, toPick);
	}
}
