package com.mph.model;

public class PartTime extends Salary {
	private int wages;
	private int hrs;
	private int DailyWage;
	private int MonthlyWage;

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	public int getHrs() {
		return hrs;
	}

	public void setHrs(int hrs) {
		this.hrs = hrs;
	}

	public int getMonthlyWage() {
		return MonthlyWage;
	}

	public void setMonthlyWage() {
		this.MonthlyWage = wages * 12;
		System.out.println("Monthly Wages: " + MonthlyWage);
	}

	public int getDailyWage() {
		return DailyWage;
	}

	public void setDailyWage() {
		this.DailyWage = wages * hrs;
		System.out.println("Daily Wages: " + DailyWage);
	}

	@Override
	public String toString() {
		return "PartTime [wages=" + wages + ", hrs=" + hrs + ", DailyWage=" + DailyWage + ", MonthlyWage=" + MonthlyWage
				+ "]";
	}

}
