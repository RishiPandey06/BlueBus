package com.application.model;

public class sprint {
	private int sprint_id;
	private int sv_emp_id;
	private int project_id;
	private String sprint_start_date;
	private String sprint_end_date;
	private int no_of_weeks;
	private int no_of_groups;
	

	public int getSprint_id() {
		return sprint_id;
	}

	public void setSprint_id(int sprint_d) {
		this.sprint_id = sprint_d;
	}

	public int getSv_emp_id() {
		return sv_emp_id;
	}

	public void setSv_emp_id(int sv_emp_id) {
		this.sv_emp_id = sv_emp_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getSprint_start_date() {
		return sprint_start_date;
	}

	public void setSprint_start_date(String sprint_start_date) {
		this.sprint_start_date = sprint_start_date;
	}

	public String getSprint_end_date() {
		return sprint_end_date;
	}

	public void setSprint_end_date(String sprint_end_date) {
		this.sprint_end_date = sprint_end_date;
	}

	public int getNo_of_weeks() {
		return no_of_weeks;
	}

	public void setNo_of_weeks(int no_of_weeks) {
		this.no_of_weeks = no_of_weeks;
	}

	public int getNo_of_groups() {
		return no_of_groups;
	}

	public void setNo_of_groups(int no_of_groups) {
		this.no_of_groups = no_of_groups;
	}
	
	
}
