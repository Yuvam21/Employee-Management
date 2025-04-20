package com.mph.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import com.mph.exception.*;
import com.mph.controller.EmployeeController;
import java.util.function.BiPredicate;

public class MainClass {

	public static void main(String[] args) throws IOException {
		try {
			String un = null, pwd = null;
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter UserName ");
			un = br.readLine();
			System.out.println("Enter Password ");
			pwd = br.readLine();
			
			BiPredicate<String,String> res = (unn,pwdd)-> unn.equals("Abishek")&& pwdd.equals("000");
			if(res.test(un,pwd)) {
				System.out.println("Hi "+un);
			

//			if (un.equals("Abishek") && pwd.equals("000")) {
//				System.out.println("Hi " + un);
//			} else {
//				throw new UserNotFoundException("Enter Correct Username and Password...");
//			}

			EmployeeController ec = new EmployeeController();
			Scanner s = new Scanner(System.in);
			String c = null;
			do {
				System.out.println("Enter Your Choice");
				System.out.println("1. Add Employee");
				System.out.println("2. View Employee");
				System.out.println("3. Arrays ");
				System.out.println("4. Sort EmpNo");
				System.out.println("5. Sort EmpName");
				System.out.println("6. Serializable Emp");
				System.out.println("7. De-Serializable Emp");

				int ch = s.nextInt();
				switch (ch) {
				case 1: {
					ec.addEmp();
					break;
				}
				case 2: {
					ec.viewEmp();
					break;
				}
				case 3: {
					ec.addEmpToArray();
					break;
				}
				case 4: {
					ec.sortEmpno();
					break;
				}
				case 5: {
					ec.sortEmpName();
					break;
				}
				case 6: {
					ec.serializableEmp();
					break;
				}
				case 7: {
					ec.deSerializableEmp();
					break;
				}

				default:
					System.out.println("Enter the right choice ...");
				}
				System.out.println("Do you want to continue Y | y");
				c = s.next();

			}

			while (c.equals("Y") || c.equals("y"));
			}
			else
				throw new UserNotFoundException("Enter Correct UserName and password");
			
		} catch (UserNotFoundException e) {
			e.printStackTrace();
		}
	}
}
