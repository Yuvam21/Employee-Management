
package com.mph.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import com.mph.model.FullTime;
import com.mph.model.*;
import com.mph.dao.EmployeeDao;

public class EmployeeController {
	Employee emp;
	Salary salary;
	FullTime ft;
	PartTime pt;
	EmployeeDao dao;
	Scanner s = new Scanner(System.in);
	List list = new ArrayList();

	public void addEmp() {
		emp = new Employee();
		ft = new FullTime();
		pt = new PartTime();
		salary = new Salary();
		dao = new EmployeeDao();
		System.out.println("Enter EmpNo: ");
		int eno = s.nextInt();
		emp.setEmpno(eno);
		System.out.println("Enter EmpName: ");
		String str = s.next();
		emp.setName(str);
		System.out.print("1.Full Time ");
		System.out.print("2.Part Time ");
		int a = s.nextInt();
		switch (a) {
		case 1: {
			System.out.println("Enter Basic");
			int bas = s.nextInt();
			ft.setBasic(bas);
			ft.setHra();
			ft.setPf();
			ft.setGross();
			ft.setNet();
			emp.setSal(ft);
			list.add(emp);
			emp.setFt(ft);
			
			dao.createEmp(emp,1);
			break;
		}
		case 2: {
			System.out.print("Wages :");
			int wag = s.nextInt();
			System.out.println("Hours: ");
			int hrs = s.nextInt();
			pt.setWages(wag);
			pt.setHrs(hrs);
			pt.setDailyWage();
			pt.setMonthlyWage();
			emp.setSal(pt);
			list.add(emp);
			emp.setPt(pt);
			dao.createEmp(emp, 2);
			break;
		}
		}

	}

	public void viewEmp() {
//		Iterator iss = list.iterator();
//		while (iss.hasNext()) {
//			System.out.println(iss.next());
//		}
//		list.forEach(System.out::print);
		dao.showEmp();
	}

	public void addEmpToArray() {
		System.out.println("Enter array size");
		int a = s.nextInt();
		String ar[] = new String[a];
		for (int i = 0; i < a; i++) {
			addEmp();
			ar[i] = emp.getEmpno() + " " + emp.getEname() + " " + ft.getBasic() + " " + ft.getHra() + " " + ft.getPf()
					+ " " + ft.getGross() + " " + ft.getNet();
		}
		System.out.println(Arrays.toString(ar));

	}

	public void sortEmpno() {
		Collections.sort(list);
		Iterator iss = list.iterator();
		while (iss.hasNext())
			System.out.println(iss.next());
	}

	public void sortEmpName() {
		Collections.sort(list, Employee.nameComparator);
		Iterator iss = list.iterator();
		while (iss.hasNext())
			System.out.println(iss.next());
	}

	public void serializableEmp() {
		try {
			FileOutputStream fos = new FileOutputStream("myfile.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.print("File Created");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deSerializableEmp() {
		try(FileInputStream fis = new FileInputStream("myfile.txt");
				ObjectInputStream ois = new ObjectInputStream(fis);) {
			
			List e = (List) ois.readObject();
			System.out.println(e);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	public void addWage() {
//		System.out.println("Enter EmpNo: ");
//		int eno = s.nextInt();
//		e.setEmpno(eno);
//		System.out.println("Enter EmpName: ");
//		String str = s.next();
//		e.setName(str);
//		System.out.println("Enter Wages");
//		
//	}

}
