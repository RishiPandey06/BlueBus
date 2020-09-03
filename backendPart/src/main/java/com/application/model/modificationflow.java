package com.application.model;

public class modificationflow {
	private int sv_emp_id;
	private int sprint_id;
	private int week_id;
	private int emp_id;
	private boolean sv_status;
	private boolean emp_status;
	public int getSv_emp_id() {
		return sv_emp_id;
	}
	public void setSv_emp_id(int sv_emp_id) {
		this.sv_emp_id = sv_emp_id;
	}
	public int getSprint_id() {
		return sprint_id;
	}
	public void setSprint_id(int sprint_id) {
		this.sprint_id = sprint_id;
	}
	public int getWeek_id() {
		return week_id;
	}
	public void setWeek_id(int week_id) {
		this.week_id = week_id;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public boolean isSv_status() {
		return sv_status;
	}
	public void setSv_status(boolean sv_status) {
		this.sv_status = sv_status;
	}
	public boolean isEmp_status() {
		return emp_status;
	}
	public void setEmp_status(boolean emp_status) {
		this.emp_status = emp_status;
	}

	
}
