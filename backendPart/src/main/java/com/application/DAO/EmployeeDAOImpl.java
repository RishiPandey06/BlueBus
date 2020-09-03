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
	
//	//NOTIFICATION AND MODIFY TASKS
//	
//	
//	// Approve Data
//	public void approveData(int emp_id, int sprint_id, int week_id) {
//		String sql = "update modificationflow set sv_status=1, emp_status=1 where emp_id = ? and sprint_id = ? and week_id = ? and sv_status = 0 and emp_status=1";
//		temp.update(sql, new Object[] { emp_id, sprint_id, week_id });
//	}
//
//	// Get modify request data
//	public List<weeklytasks> modifyData(int emp_id, int sprint_id, int week_id) {
//		String pl_sql = "select plan_id from weeklyplan where (emp_id = ? and week_id = ? and sprint_id = ?) ";
//		plan_id p = temp.queryForObject(pl_sql, new Object[] { emp_id, week_id, sprint_id }, new plan_idMapper());
//		String sql = "select * from weeklytasks where plan_id = ?";
//		List<weeklytasks> data = temp.query(sql, new Object[] { p.getPlan_id() }, new weeklytasksMapper());
//			return data;
//		}
//
//	// ALL NOTIFY
//	public ArrayList<notifyData> allNotify(int emp_id) {
//		if (checkRole(emp_id)) {
//			String m_sql = "select * from modificationflow where sv_emp_id = ? and emp_status = 1 and sv_status = 0";
//			List<modificationflow> mf = temp.query(m_sql, new Object[] { emp_id }, new modificationflowMapper());
//			ArrayList<notifyData> nd = new ArrayList<notifyData>();
//			for (int i = 0; i < mf.size(); i++) 
//			{
//				String n_sql = "select * from employee where emp_id = ?";
//				Employee e = temp.queryForObject(n_sql, new Object[] { mf.get(i).getEmp_id() }, new EmployeeMapper());
//				nd.add(new notifyData(mf.get(i).getEmp_id(), e.getEmp_name(), mf.get(i).getSprint_id(),
//						mf.get(i).getWeek_id()));
//			}
//			return nd;
//		} else {
//			return null;
//		}
//	}
//
//	// CHECK_NOTIFY
//	public String checkNotify(int emp_id) {
//		if (checkRole(emp_id)) {
//			String sql = "select * from modificationflow where sv_emp_id = ? and emp_status = 1 and sv_status = 0";
//			List<modificationflow> mf = temp.query(sql, new Object[] { emp_id }, new modificationflowMapper());
//			return mf.size() + "";
//		} else {
//			return "";
//		}
//	}
//	public boolean checkRole(int emp_id) {
//		String sql = "select * from employee where emp_id = ?";
//		Employee e = temp.queryForObject(sql, new Object[] { emp_id }, new EmployeeMapper());
//		if (e.getLog_role() == 1) {
//			return true;
//		} else {
//			return false;
//		}
//	}
//		
//	
//	
//	
//	
//	
//	//PLAN SPRINT APIs 
//	
//	
//	
//	
//	
//	
//	
//
//	// PlanSprintPage Insert Sprint
//		public void setSprint(int sprint_id, int sv_emp_id, Date sprint_start_date, Date sprint_end_date, int no_of_weeks) {
//			String pr_sql = "select * from employee where emp_id = ?";
//			Employee e = temp.queryForObject(pr_sql, new Object[] { sv_emp_id }, new EmployeeMapper());
//			String sql = "insert into sprint(sprint_id,sv_emp_id,project_id,sprint_start_date,sprint_end_date,no_of_weeks,no_of_groups) values (?,?,?,?,?,?,?)";
//			temp.update(sql,
//					new Object[] { 0, sv_emp_id, e.getProject_id(), sprint_start_date, sprint_end_date, no_of_weeks, 0 });
//		}
//		
//	// PlanSprintPage Insert SprintWeek
//	public void setSprintWeek(int sprint_id, int week_id, Date week_start_date, Date week_end_date) {
//		String sql = "insert into sprintweek(sprint_id,week_id,week_start_date,week_end_date) values (?,?,?,?)";
//		temp.update(sql, new Object[] { sprint_id, week_id, week_start_date, week_end_date });
//	}
//	
//	
//	
//	
//	
//	
//	
//	//SPECIFY GROUP APIs
//	
//
//
//	// SpecifyGroupPage GROUP AND GET SPRINT DATA
//	public List<sprint> groupSprint() {
//		String sql = "select * from sprint";
//		List<sprint> s = temp.query(sql, new sprintMapper());
//		return s;
//	}
//
//	// SpecifyGroupPage GET EMPLOYEE DATA
//	public List<Employee> getAllEmployee() {
//		String query = "select * from employee";
//		List<Employee> allEmployees = temp.query(query, new EmployeeMapper());
//		return allEmployees;
//	}
//	
//
//	public void insertGroup(int project_id, int emp_id, int group_id, int sprint_id, int no_of_grp) {
//		System.out.println("InsertGrp-DAO entered");
//		String query = "insert into groupinfo(project_id,emp_id,group_id,sprint_id) values(?,?,?,?)";
//		temp.update(query, new Object[] { project_id, emp_id, group_id, sprint_id });
//
//		System.out.println("InsertGrp-DAO for sprint");
//		String sp_up = "Update sprint SET no_of_groups = ? where sprint_id=?";
//		temp.update(sp_up, new Object[] { no_of_grp, sprint_id });
//		System.out.println("InsertGrp-DAO exiting");
//	}
//	
//
//	
//	
//	
//	//ASSIGN TASK APIs
//	
//	
//	
//	// AssignTaskPage Get Sprint Date Range
//	public sprint getSprint(int sprint_id) {
//		String sql = "select * from sprint where sprint_id = ?";
//		sprint s = temp.queryForObject(sql, new Object[] { sprint_id }, new sprintMapper());
//		return s;
//	}
//
//	// AssignTaskPage Get Week Date Range
//	public sprintweek getWeek(int sprint_id, int week_id) {
//		String sql = "select * from sprintweek where sprint_id = ? and week_id= ?";
//		sprintweek sw = temp.queryForObject(sql, new Object[] { sprint_id, week_id }, new sprintweekMapper());
//		return sw;
//	}
//
//	// AssignTaskPage get All Tasks
//	public List<tasklist> getTasks() {
//		String sql = "select * from tasklist";
//		List<tasklist> tl = temp.query(sql, new tasklistMapper());
//		return tl;
//	}
//
//	// AssignTaskPage Submit Button Response
//	public void assign_task_1(int sprint_id, int group_id, int week_id) 
//		{
//			String grp_sql = "select * from groupinfo where group_id = ? and sprint_id=?";
//			List<Groupinfo> ids = temp.query(grp_sql, new Object[] { group_id, sprint_id }, new GroupinfoMapper());
//			for(int i = 0 ; i < ids.size() ; i++)
//			{
//				//Insert into weeklyPlan
//				String sql = "insert into weeklyplan(plan_id,project_id,sprint_id,week_id,emp_id) values(?,?,?,?,?)";
//				temp.update(sql,new Object[] {0,ids.get(i).getProject_id(),sprint_id,week_id,ids.get(i).getEmp_id()});
//			}
//		}
//	
//	public void assign_task_2(int sprint_id, int group_id, int weekly_task_id, int w_task_hours,
//			int weekly_story_points_assigned, int week_id)
//	{
//		String grp_sql = "select * from groupinfo where group_id = ? and sprint_id=?";
//		List<Groupinfo> ids = temp.query(grp_sql, new Object[] { group_id, sprint_id }, new GroupinfoMapper());
//		ArrayList<plan_id> pids = new ArrayList<plan_id>();
//		for(int i = 0 ; i < ids.size() ; i++)
//		{
//			//Insert into weeklyPlan
//			String p_sql = "select plan_id from weeklyplan where emp_id = ? and sprint_id = ? and week_id = ?";
//			plan_id p = temp.queryForObject(p_sql,new Object[] {ids.get(i).getEmp_id(),sprint_id,week_id},new plan_idMapper());
//			pids.add(p);
//		}
//		for (int j = 0; j < pids.size(); j++) {
//			//insert into weeklytasks
//			String wk_sql = "insert into weeklytasks(plan_id,sprint_id,week_id,w_task_id,w_task_hours,weekly_story_points_assigned) values(?,?,?,?,?,?)";
//			temp.update(wk_sql,new Object[] {pids.get(j).getPlan_id(),sprint_id,week_id,weekly_task_id,w_task_hours,weekly_story_points_assigned});
//			}
//	}
	

//	//AssignTaskPage Get Group Ids
//	public List<Integer> getGroup_IDs(int sprint_id) {
//		String sql = "select distinct(group_id) from groupinfo where sprint_id= ?";
//		List<Groupinfo> groupidsmatched = temp.query(sql, new Object[] { sprint_id }, new GroupinfoMapper());
//		List<Integer> groupids = null;
//		for (Groupinfo grp : groupidsmatched) {
//			groupids.add(grp.getGroup_id());
//		}
//		Collections.sort(groupids);
//		return groupids;
//	}

}
