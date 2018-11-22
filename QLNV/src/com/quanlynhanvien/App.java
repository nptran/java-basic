package com.quanlynhanvien;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.ChronoUnit.YEARS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import com.quanlynhanvien.model.*;


public class App {
	
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private static void showMenu() {
		
		System.out.println("===============================================");
		System.out.println("1. Add Department");
		System.out.println("2. Add Employee");
		System.out.println("3. View Department");
		System.out.println("4. Move Employee");
		System.out.println("5. Edit Employee");
		System.out.println("6. Delete Department");
		System.out.println("7. Delate Employee");
		System.out.println("8. Exit");
		
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		List<Department> departments = new ArrayList<>();
		
		List<Employee> employees = new ArrayList<>();
		
		showMenu();
		
		do {
			choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			
			case 1: // Add Department
				
				System.out.println("=========Add Department=========");
				System.out.println("New Department:");
				String name = sc.nextLine();
				
				System.out.println("Department CODE:");
				String dpmtcode = sc.nextLine();
				
				Department department = new Department();
				
				department.setName(name);
				department.setCode(dpmtcode.toUpperCase());
				
				departments.add(department);
				System.out.println("========ADDED SUCCESSFULLY========");

				showMenu();
				break;
			
			case 2: // Add Employee
				
				System.out.println("==========Add Employee===========");
				System.out.println("New employee:");
				String eplname = sc.nextLine();
				
				System.out.println("Employee CODE:");
				String eplcode = sc.nextLine();
				
				System.out.println("Date of Birth (dd/MM/yyyy):");
				String dob = sc.nextLine();
				
				
				Employee employee = new Employee();			//tao mot employee 
				employee.setName(eplname);					//set name cho employee la ten vua nhap
				employee.setCode(eplcode.toUpperCase());
				employee.setDob(LocalDate.parse(dob, DATE_FORMATTER));
				
				long age = YEARS.between(employee.getDob(), LocalDate.now());
				System.out.println("Age: " + age);
				int checkAdd = 0;
				do {
				
					System.out.println("NAME or CODE of Department:");
					String addIn = sc.nextLine();				//department dinh them vao
					
						Department foundDepartment = null;		//tao mot department null
						for (Department thisDepartment : departments) {
							if (addIn.equalsIgnoreCase(thisDepartment.getName()) || addIn.equalsIgnoreCase(thisDepartment.getCode()))	{// Kiem tra Department dinh them vao co ton tai khong
								foundDepartment = thisDepartment; 		//gan gia tri cho department null
									++checkAdd;
							}
						}
						
						if (foundDepartment != null) {
							employee.setDepartment(foundDepartment);		//set department cho employee
							employees.add(employee);						//add employee vua tao vao list employees
							System.out.println("========ADDED SUCCESSFULLY========");
												
						} else System.out.println("* NAME or CODE is NOT TRUE. Try again! *");

						
				} while (checkAdd == 0);
				
				showMenu();
				break;
				
			case 3: // View Department
			
				System.out.println("==========Department Details==========");
				System.out.println("Department name/code :");
				String founddepartment = sc.nextLine();
				Department thisDepartment = null;
				
				int check = 0;
				for (Department departmentCheck : departments) { //kiem tra department co ton tai khong
					if (founddepartment.equalsIgnoreCase(departmentCheck.getName()) || founddepartment.equalsIgnoreCase(departmentCheck.getCode()))
						++check;
				}
				
				if (check == 0) System.out.println(" * This department is NOT exist! Press 1 to add this department. *");

				else { //neu department la chinh xac, tiep tuc thuc hien
					for (Department scan : departments) {
						if (founddepartment.equalsIgnoreCase(scan.getName()) || founddepartment.equalsIgnoreCase(scan.getCode())) {	
							//lay ra department co ten/code nhu da nhap					
							thisDepartment = scan;
							
							int counter = 0; // bien dem so employee co trong department
							
							for (Employee employeename : employees) {
								if (founddepartment.equalsIgnoreCase(employeename.getDepartment().getCode()) || founddepartment.equalsIgnoreCase(employeename.getDepartment().getName())) {
								++counter;
								System.out.println("========" + thisDepartment.getName().toUpperCase() + "========"); //In ra ten department vua lay o tren
								System.out.println(counter + ". " + employeename.getName() + " " + employeename.getCode() + " " + employeename.getDob() + " " + employeename.getDepartment().getName());
								
								}
							
							}
							if (counter != 0)
								System.out.printf("Employees number: %d%n", counter);
							
							else System.out.println("No employee in that department!");
				
						} 
					}
				}
				
				showMenu();
				break;
				
			case 4: // Move Employee
				int checkName = 0;
				do {
					System.out.println("Move employee:");
					String foundemployee = sc.nextLine();
					Employee movethisemployee = null;
					
					for (Employee thisemployee : employees) { //kiem tra nhan vien co ton tai khong
						
						if (foundemployee.equalsIgnoreCase(thisemployee.getCode()) || foundemployee.equalsIgnoreCase(thisemployee.getName())) {
							movethisemployee = thisemployee;
							++checkName;
						
						}
					}
					
					if (movethisemployee != null) {
						
						System.out.println("Move this employee? Y/N");
						String tmp = sc.nextLine();
						if (tmp.equalsIgnoreCase("y")) {
							
							int checkIn = 0;
							do {
								System.out.println("Move to:");
								String fDepartment = sc.nextLine();
								Department toDepartment = null;
								
								for (Department departmentCheck : departments) { //kiem tra department co ton tai khong
									if (fDepartment.equalsIgnoreCase(departmentCheck.getName()) || fDepartment.equalsIgnoreCase(departmentCheck.getCode())) //check code hoac name cua department
										toDepartment = departmentCheck;
										++checkIn;
								}
								
								if (toDepartment != null) {
									movethisemployee.setDepartment(toDepartment); //set lai department cho nv
									System.out.println("===========UPDATED SUCESSFULLY===========");
								}
								
							
								if (checkIn == 0) System.out.println(" * This department is NOT exist! Enter again! *");
						
							} while (checkIn == 0);
						
						}
					}
						if (checkName == 0 ) System.out.println("* This employee is NOT exist! Check and try again! *");
					
				} while (checkName == 0);
				
				showMenu();
				break;
				
			case 5: // Edit Employee
								
				String foundname = sc.nextLine();
				Employee edit = null;
				
				for (Employee employeename : employees) {
					if (foundname.equalsIgnoreCase(employeename.getName()) || foundname.equalsIgnoreCase(employeename.getCode())) {
						edit = employeename;
						
					}
				}
				
				if (edit != null) {
					String newname= sc.nextLine();
					edit.setName(newname);
					System.out.println("===========UPDATED SUCESSFULLY===========");
				} else System.out.println("Can't find this employee!");
				
				showMenu();
				break;
				
			case 6: // Delete Department
				
				System.out.println("Deapartment you want delete:");
				String founddpm = sc.nextLine();
				Department delete = null;
				
				for (Department departmentname : departments) {
					if (founddpm.equalsIgnoreCase(departmentname.getName()) || founddpm.equalsIgnoreCase(departmentname.getCode()))
						delete = departmentname;
				}
				
				if (delete != null) {
					System.out.printf("* Are you sure want to delete this department? %n All employee in this department also will be delete. * %n Y/N");
					String tmp = sc.nextLine();
					if (tmp.equalsIgnoreCase("y")) {
						departments.remove(delete);
						System.out.println("===========DELETED SUCESSFULLY==========");
					}
				} else System.out.println("Can't find this department!");	
				
				showMenu();
				break;
				
			case 7: // Delete Employee
				
				String foundepl = sc.nextLine();
				Employee delthisemployee = null;
				
				for (Employee thisemployee : employees) {
					if (foundepl.equalsIgnoreCase(thisemployee.getName()) || foundepl.equalsIgnoreCase(thisemployee.getCode())) {
						delthisemployee = thisemployee;
						
					}
				}
				
				if (delthisemployee != null) {
					System.out.println("Are you sure delete this employee? Y/N");
					String tmp = sc.nextLine();
					if (tmp.equalsIgnoreCase("y")) {
						employees.remove(delthisemployee);
						System.out.println("===========DELETED SUCESSFULLY==========");
					}
					
				} else System.out.println("Can't find this employee!");
				
				showMenu();
				break;
				
			case 8: // Exit
				System.out.println("Are you sure? Y/N");
				String tmp = sc.nextLine();
				
				if (tmp.equalsIgnoreCase("y")) {			
					choice = 9;
					System.out.println("==========CLOSED=========");
				
				} else
					showMenu();
				
				break;
				
			default:
				showMenu();
				break;
	
			}
		}while (choice != 9);
		
		sc.close();
		
	}

}
