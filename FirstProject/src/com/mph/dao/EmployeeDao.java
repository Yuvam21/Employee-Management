package com.mph.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mph.model.*;

import com.mph.model.Employee;
import com.mph.util.MyDBConnection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSetMetaData;

public class EmployeeDao {
	Connection con;
	PreparedStatement ps;
	Statement st;
	ResultSet rs;

	public void createEmp(Employee emp, int a) {
		con = MyDBConnection.getMyDbConnection();
		FullTime ft;
		PartTime pt;

		try {
			if (a == 1) {
				ft = new FullTime();
				ps = con.prepareStatement(
						"insert into FTEmployee(empno,name,basic,hra,pf,gross,net) values (?,?,?,?,?,?,?)");
				ps.setInt(1, emp.getEmpno());
				ps.setString(2, emp.getEname());
				ps.setInt(3, emp.getFt().getBasic());
				ps.setDouble(4, emp.getFt().getHra());
				ps.setDouble(5, emp.getFt().getPf());
				ps.setDouble(6, emp.getFt().getGross());
				ps.setDouble(7, emp.getFt().getNet());
				int noofrows = ps.executeUpdate();
				System.out.println(noofrows + "inserted in DB Successfully");
			} else {
				pt = new PartTime();
				ps = con.prepareStatement(
						"insert into PTEmployee(empno,name,wages,hrs,dailywage ,monthlywage) values(?,?,?,?,?,?) ");
				ps.setInt(1, emp.getEmpno());
				ps.setString(2, emp.getEname());
				ps.setInt(3, emp.getPt().getWages());
				ps.setInt(4, emp.getPt().getHrs());
				ps.setInt(5, emp.getPt().getDailyWage());
				ps.setInt(6, emp.getPt().getMonthlyWage());
				int noofrows = ps.executeUpdate();
				System.out.println(noofrows + "inserted in DB Successfully");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void showEmp() {
		con = MyDBConnection.getMyDbConnection();
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from ftemployee");
			FullTime ft = new FullTime();
			while (rs.next()) {
				String T = rs.getString(0);
				if(T=="A ") {
			
				System.out.println("EmpNo" + rs.getInt(1));
				System.out.println("EmpName" + rs.getString(2));
				System.out.println("Basic" + rs.getInt(3));
				System.out.println("Hra" + rs.getDouble(4));
				System.out.println("Pf" + rs.getDouble(5));
				System.out.println("Gross" + rs.getDouble(6));
				System.out.println("Net" + rs.getDouble(7));
				System.out.println("*************************");
			}
			else {
					System.out.println("EmpNo"+rs.getInt(1));
					System.out.println("EmpName"+rs.getString(2));
					System.out.println("Wages"+rs.getInt(3));
				    System.out.println("Hours"+rs.getInt(4));
					System.out.println("Daily Wages"+rs.getInt(5));
					System.out.println("Monthly Wages"+rs.getInt(6));
				}

		}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void resultSetMetaData() {
		con = MyDBConnection.getMyDbConnection();
		ResultSetMetaData rsdata;

		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from ftemployee");
			rsdata = rs.getMetaData();
			System.out.println(rsdata.getColumnCount());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void databaseMetaData() {
		con = MyDBConnection.getMyDbConnection();
		
		try {
			DatabaseMetaData dmdb = con.getMetaData();
			System.out.println(dmdb.getDatabaseProductName());
			System.out.println(dmdb.getDatabaseProductVersion());
			System.out.println(dmdb.getDatabaseMajorVersion());
			System.out.println(dmdb.getDriverName());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
