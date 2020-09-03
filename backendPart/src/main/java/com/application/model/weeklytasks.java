package com.application.model;

public class weeklytasks {
	
	private int plan_id;
	private int week_id;
	private int w_task_id;
	private int w_task_hours;
	private float weekly_story_points_assigned;
	
	
	public int getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	public int getWeek_id() {
		return week_id;
	}
	public void setWeek_id(int week_id) {
		this.week_id = week_id;
	}
	public int getW_task_id() {
		return w_task_id;
	}
	public void setW_task_id(int w_task_id) {
		this.w_task_id = w_task_id;
	}
	public int getW_task_hours() {
		return w_task_hours;
	}
	public void setW_task_hours(int w_task_hours) {
		this.w_task_hours = w_task_hours;
	}
	public float getWeekly_story_points_assigned() {
		return weekly_story_points_assigned;
	}
	public void setWeekly_story_points_assigned(float weekly_story_points_assigned) {
		this.weekly_story_points_assigned = weekly_story_points_assigned;
	}
	
	

}
