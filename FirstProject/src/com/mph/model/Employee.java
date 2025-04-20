package com.mph.model;

import java.util.Comparator;

//import com.mph.Employee;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;

public class Employee implements Comparable<Employee>, Serializable {
	private int empno;
	private String name;
	private Salary sal;
	private FullTime ft;
	private PartTime pt;
	private String t;

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public int getEmpno() {
		return this.empno;
	}

	public String getEname() {
		return this.name;
	}

	public void setEmpno(int empno) {
		this.empno = empno;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String toString() {
//		return empno+ " -- "+name;
//	}
	public Salary getSal() {
		return sal;
	}

	public void setSal(Salary sal) {
		this.sal = sal;
	}
	
	public FullTime getFt() {
		return ft;
	}


	public void setFt(FullTime ft) {
		this.ft = ft;
	}


	public PartTime getPt() {
		return pt;
	}


	public void setPt(PartTime pt) {
		this.pt = pt;
	}


	@Override
	public String toString() {
		return "Employee [empno=" + empno + ", name=" + name + ",sal=" + sal + "]";
	}


	@Override
	public int compareTo(Employee e1) {
		return this.empno - e1.empno;
	}

//	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {
//
//		@Override
//		public int compare(Employee o1, Employee o2) {
//			// TODO Auto-generated method stub
//			return o1.getEname().compareTo(o2.getEname());
//		}
//	};
	
	public static Comparator<Employee> nameComparator = Comparator.comparing(Employee::getEname);

}
