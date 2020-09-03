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
	
	@RequestMapping(value = "/getLocation", method = RequestMethod.POST)
	public List<String> getLocation(@RequestParam("city") String city) {
		return DAO.getLocationData(city);
	}
	
	@RequestMapping(value = "/insertCustomers", method = RequestMethod.POST)
	public void insertCustomers(@RequestParam("name") String name, @RequestParam("phone") String phoneNumber,
			@RequestParam("email") String email, @RequestParam("gender") int gender, @RequestParam("fromLoc") String fromLoc,
			@RequestParam("toLoc") String toLoc, @RequestParam("fromPick") String fromPick, @RequestParam("toPick") String toPick) {
		DAO.addCustomers(name, phoneNumber, email, gender, fromLoc, toLoc, fromPick, toPick);
	}
	

//	// Get nmodify request data
//	@RequestMapping(value = "/getModifyData", method = RequestMethod.GET)
//	public List<weeklytasks> modifyData(@RequestParam("emp_id") String emp_id,
//			@RequestParam("sprint_id") String sprint_id, @RequestParam("week_id") String week_id) {
//		return DAO.modifyData(Integer.parseInt(emp_id), Integer.parseInt(sprint_id), Integer.parseInt(week_id));
//	}
//
//	// All_NOTIFY
//	@RequestMapping(value = "/all_notify", method = RequestMethod.GET)
//	public ArrayList<notifyData> allNotify(@RequestParam("emp_id") String emp_id) {
//		return DAO.allNotify(Integer.parseInt(emp_id));
//	}
//
//	// CHECK_NOTIFY
//	@RequestMapping(value = "/check_notify", method = RequestMethod.GET)
//	public String checkNotify(@RequestParam("emp_id") String emp_id) {
//		return DAO.checkNotify(Integer.parseInt(emp_id));
//	}
//
//	// PlanSprintPage Insert Sprint
//	@RequestMapping(value = "/set_sprint", method = RequestMethod.GET)
//	public void setSprint(@RequestParam("sprint_id") String sprint_id, @RequestParam("sv_emp_id") String sv_emp_id,
//			@RequestParam("sprint_start_date") String sprint_start_date,
//			@RequestParam("sprint_end_date") String sprint_end_date, @RequestParam("no_of_weeks") String no_of_weeks)
//			throws Exception {
//		// DATE TO STRING TO DATE
//		Date s1 = new SimpleDateFormat("dd-MM-yyyy").parse(sprint_start_date);
//		String s2 = new SimpleDateFormat("yyyy-MM-dd").format(s1);
//		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
//
//		// SAME
//		Date e1 = new SimpleDateFormat("dd-MM-yyyy").parse(sprint_end_date);
//		String e2 = new SimpleDateFormat("yyyy-MM-dd").format(e1);
//		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(e2);
//		DAO.setSprint(Integer.parseInt(sprint_id), Integer.parseInt(sv_emp_id), start, end,
//				Integer.parseInt(no_of_weeks));
//	}
//
//	// PlanSprintPage Insert SprintWeek
//	@RequestMapping(value = "/sprint_dates", method = RequestMethod.GET)
//	public void sprintDates(@RequestParam("sprint_id") String sprint_id, @RequestParam("week_id") String week_id,
//			@RequestParam("week_start_date") String week_start_date,
//			@RequestParam("week_end_date") String week_end_date) throws Exception {
//		// DATE TO STRING TO DATE
//		Date s1 = new SimpleDateFormat("dd-MM-yyyy").parse(week_start_date);
//		String s2 = new SimpleDateFormat("yyyy-MM-dd").format(s1);
//		Date start = new SimpleDateFormat("yyyy-MM-dd").parse(s2);
//
//		// SAME
//		Date e1 = new SimpleDateFormat("dd-MM-yyyy").parse(week_end_date);
//		String e2 = new SimpleDateFormat("yyyy-MM-dd").format(e1);
//		Date end = new SimpleDateFormat("yyyy-MM-dd").parse(e2);
//
//		DAO.setSprintWeek(Integer.parseInt(sprint_id), Integer.parseInt(week_id), start, end);
//	}
//
//	// SpecifyGroupPage GET SPRINT DATA
//	@RequestMapping(value = "/group_sprint", method = RequestMethod.GET)
//	public List<sprint> groupSprint() {
//		return DAO.groupSprint();
//	}
//
//	// SpecifyGroupPage GET EMPLOYEE DATA
//	@RequestMapping(value = "/group_employees", method = RequestMethod.GET)
//	public List<Employee> getAll() {
//		return DAO.getAllEmployee();
//	}
//
////	@RequestMapping(value = "/get_groupids", method = RequestMethod.GET)
////	public List<Integer> getGroupIds(@RequestParam("sprint_id") String sprint_id) {
////		List<Integer> groupIds = DAO.getGroup_IDs(Integer.parseInt(sprint_id));
////		return groupIds;
//
////	}
//
//	// Assign TaskPage GET SPRINT WEEK(START AND END)
//	@RequestMapping(value = "/get_dates", method = RequestMethod.GET)
//	public sprint getSprint(@RequestParam("sprint_id") String sprint_id) {
//		return DAO.getSprint(Integer.parseInt(sprint_id));
//	}
//
//	// AssignTaskPage Get Week Date Range
//	@RequestMapping(value = "/get_week", method = RequestMethod.GET)
//	public sprintweek getWeek(@RequestParam("sprint_id") String sprint_id, @RequestParam("week_id") String week_id) {
//		sprintweek s = DAO.getWeek(Integer.parseInt(sprint_id), Integer.parseInt(week_id));
//		return s;
//	}
//
//	// AssignTaskPage get All Tasks
//	@RequestMapping(value = "/get_tasks", method = RequestMethod.GET)
//	public List<tasklist> getTask() {
//		List<tasklist> tl = DAO.getTasks();
//		return tl;
//	}
//
//	// AssignTaskPage Submit Button
//	@RequestMapping(value = "/assign_tasks_1", method = RequestMethod.GET)
//	public void assigntasks1(@RequestParam("sprint_id") String sprint_id, @RequestParam("group_id") String group_id,@RequestParam("week_id") String week_id) {
//		DAO.assign_task_1(Integer.parseInt(sprint_id), Integer.parseInt(group_id),Integer.parseInt(week_id));
//	}
//	
//	@RequestMapping(value = "/assign_tasks_2", method = RequestMethod.GET)
//	public void assigntasks2(@RequestParam("sprint_id") String sprint_id, @RequestParam("group_id") String group_id,
//			@RequestParam("weekly_task_id") String weekly_task_id, @RequestParam("w_task_hours") String w_task_hours,
//			@RequestParam("weekly_story_points_assigned") String weekly_story_points_assigned,
//			@RequestParam("week_id") String week_id) {
//		System.out.println("---------------------------" + sprint_id + group_id + weekly_task_id + w_task_hours
//				+ weekly_story_points_assigned + week_id);
//		DAO.assign_task_2(Integer.parseInt(sprint_id), Integer.parseInt(group_id), Integer.parseInt(weekly_task_id),
//				Integer.parseInt(w_task_hours), Integer.parseInt(weekly_story_points_assigned),
//				Integer.parseInt(week_id));
//	}
//	@RequestMapping(value = "/insert_group", method = RequestMethod.GET)
//	public void insertGroup(@RequestParam("project_id") String project_id, @RequestParam("emp_id") String emp_id,
//			@RequestParam("group_id") String group_id, @RequestParam("sprint_id") String sprint_id,
//			@RequestParam("no_of_grp") String no_of_grp) {
//		System.out.println("InsertGrp-Controller");
//		DAO.insertGroup(Integer.parseInt(project_id), Integer.parseInt(emp_id), Integer.parseInt(group_id),
//				Integer.parseInt(sprint_id), Integer.parseInt(no_of_grp));
//	}

}
