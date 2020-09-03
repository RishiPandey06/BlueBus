package com.application.model;

//@JsonSerialize
public class notifyData {
	public int emp_id;
	public String emp_name;
	public int sprint_id;
	public int week_id;
	
	public notifyData(int emp_id,String emp_name,int sprint_id,int week_id)
	{
		this.emp_id = emp_id;
		this.emp_name = emp_name;
		this.sprint_id = sprint_id;
		this.week_id = week_id;
	}
}
