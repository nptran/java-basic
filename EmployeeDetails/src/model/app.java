package model;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class app {
	
	public static void main(String[] args) {
		
		List<Person> people = new ArrayList<>(); //Tao mot list people voi thuoc tinh Person
		System.out.println("===============EMPLOYEE DETAILS===============");
		showMenu();
		
		int choice = 0;
		Scanner sc = new Scanner(System.in);
		
		do{
			choice = sc.nextInt();	//Nhap vao lua chon
			sc.nextLine();
		
			switch(choice) {
			case 1://Hien thi danh sach cac ho so du lieu
				
				if (people.isEmpty()) { //Neu danh sach trong
				
					System.out.println("Empty List! Press 2 to add a new record!");
				
				} else {
					
					for (Person person : people) { //Duyet va in ra tung doi tuong (person) trong list people
						System.out.printf("%-5s%-8s%-5s%-3d%-8s%s%n", person.getCode(), person.getName(), person.getGender(), person.getAge(), person.getRelationship(), person.getDepartment());
					}
					
				}
				
				showMenu();
				break;
				
			case 2://Tao mot ho so du lieu moi
			{
				Person person = new Person();
				System.out.println("* Enter informations here:");
				
				System.out.print("1. Code: ");
				String code = sc.nextLine();
				person.setCode(code.toUpperCase());
				
				System.out.print("2. Name: ");
				String name = sc.nextLine();
				person.setName(toTitleCase(name));
				
				System.out.print("3. Gender(Male/Female/Gay/Les): ");
				String gender = sc.nextLine();
				person.setGender(toTitleCase(gender));
				
				System.out.print("4. Age: ");
				int age = sc.nextInt();
				sc.nextLine();
				person.setAge(age);
				
				System.out.println("5. Relationship(Single/Married): ");
				String relationship = sc.nextLine();
				person.setRelationship(toTitleCase(relationship));
				
				System.out.println("6. Department: ");
				String department = sc.nextLine();
				person.setDepartment(toTitleCase(department));
				
				people.add(person);
				System.out.println("=====Added Sucessfully!=====");
				
				showMenu();
				break;
			}
			
			case 3://Sua thong tin ho so
			{
				System.out.println("Enter person's code you want to edit: ");
				String code = sc.nextLine();
				Person personedit = null; //Tao mot empty object kieu Person
				
				for (Person person : people) {
					if (code.equalsIgnoreCase(person.getCode()))
						personedit = person;
				}
				
				if (personedit != null) {
					System.out.printf("%-5s%-8s%-5s%-3d%-8s%s%n", personedit.getCode(), personedit.getName(), personedit.getGender(), personedit.getAge(), personedit.getRelationship(), personedit.getDepartment());
					
					for (int counter =1; counter < 100; counter++) { //chay vong lap chinh sua nhieu lan
						System.out.println("Select an item to edit");
						System.out.println("1. Code");
						System.out.println("2. Name");
						System.out.println("3. Gender");
						System.out.println("4. Age");
						System.out.println("5. Relationship");
						System.out.println("6. Department");
						
						int edit = sc.nextInt();
						sc.nextLine();
						
						switch(edit) {	
						case 1: //Chinh sua Code
							System.out.print("New code: ");
							String newcode = sc.nextLine();
							personedit.setCode(newcode);	//Set mot gia tri moi cho doi tuong
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");	//Muon tiep tuc chinh sua them hay khong
							String ans1 = sc.nextLine();
							if (ans1.equalsIgnoreCase("n") || ans1.equals("0"))	{counter = 100; break;}	//out khoi vong for de chinh sua cho doi tuong khac hoac ve Menu
							if (ans1.equalsIgnoreCase("y") || ans1.equals("1"))	break;	//tiep tuc chinh sua cho doi tuong dang chon
							
						case 2:	//Chinh sua Name
							System.out.print("New name: ");
							String newname = sc.nextLine();
							personedit.setName(toTitleCase(newname));
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");
							String ans2 = sc.nextLine();
							if (ans2.equalsIgnoreCase("n") || ans2.equals("0"))	{counter = 100; break;}
							if (ans2.equalsIgnoreCase("y") || ans2.equals("1"))	break;
							
						case 3:	//Chinh sua Gender
							System.out.print("Gender: ");
							String gender = sc.nextLine();
							personedit.setGender(toTitleCase(gender));
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");
							String ans3 = sc.nextLine();
							if (ans3.equalsIgnoreCase("n") || ans3.equals("0"))	{counter = 100; break;}
							if (ans3.equalsIgnoreCase("y") || ans3.equals("1"))	break;
							
						case 4:	//Chinh sua Age
							System.out.print("Age: ");
							int age = sc.nextInt();
							personedit.setAge(age);
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");
							String ans4 = sc.nextLine();
							if (ans4.equalsIgnoreCase("n") || ans4.equals("0"))	{counter = 100; break;}
							if (ans4.equalsIgnoreCase("y") || ans4.equals("1"))	break;
							
						case 5:	//Chinh sua Relationship
							System.out.print("Relationship: ");
							String relationship = sc.nextLine();
							personedit.setRelationship(toTitleCase(relationship));
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");
							String ans5 = sc.nextLine();  
							if (ans5.equalsIgnoreCase("n") || ans5.equals("0"))	{counter = 100; break;}
							if (ans5.equalsIgnoreCase("y") || ans5.equals("1"))	break;
							
						case 6:	//Chinh sua Department
							System.out.println("New department:");
							String department = sc.nextLine();
							personedit.setDepartment(toTitleCase(department));
							System.out.println("=====Updated Successfully!=====");
							
							System.out.println("Continue editing this profile?\t Y/N");
							String ans6 = sc.nextLine();
							if (ans6.equalsIgnoreCase("n") || ans6.equals("0"))	{counter = 100; break;}
							if (ans6.equalsIgnoreCase("y") || ans6.equals("1"))	break;
							
						default:
							System.out.println("Enter a number 1->6");
							break;
						};
					};
					System.out.printf("%-5s%-8s%-5s%-3d%-8s%s%n", personedit.getCode(), personedit.getName(), personedit.getGender(), personedit.getAge(), personedit.getRelationship(), personedit.getDepartment());	
				} else
					System.out.println("Can't find this code!");
				
				showMenu();
				break;
			}
				
			case 4://Xoa mot ho so du lieu
			{
				System.out.println("Enter person's code you want to delete: ");
				String code = sc.nextLine();
				Person persondel = null; //tao mot empty object
				
				for (Person person : people) {	//duyet tung doi tuong trong list people
					if (code.equalsIgnoreCase(person.getCode())) {//tim doi tuong co code da nhap
						persondel = person; //gan doi tuong vua tim thay cho *empty object
					}
				}
				
				if (persondel != null) { //thuc hien sau khi gan *empty object thanh cong
					System.out.printf("%-5s%-8s%-5s%-3d%-8s%s%n", persondel.getCode(), persondel.getName(), persondel.getGender(), persondel.getAge(), persondel.getRelationship(), persondel.getDepartment());
					System.out.println("* Are you sure want to delete? Press Y to delete! *");
					String ans = sc.nextLine();
				
					if (ans.equalsIgnoreCase("Y")) {
						people.remove(persondel); //xoa *empty object
						System.out.println("=====Deleted Sucessfully!=====");
					};
					
				} else
					System.out.println("Can't find this code!");
				
				showMenu();
				break;
			}	
				
			case 5://Tim kiem mot ho so du lieu
				System.out.println("Enter code:");
				Person foundperson = new Person();
				String code = sc.nextLine();
				
				for (Person person : people){
					if (code.equalsIgnoreCase(person.getCode()))
						foundperson = person;
					else
						System.out.println("Can't find this code!");
				}
				
				System.out.printf("%-5s%-8s%-5s%-3d%-8s%s%n", foundperson.getCode(), foundperson.getName(), foundperson.getGender(), foundperson.getAge(), foundperson.getRelationship(), foundperson.getDepartment());
				showMenu();
			break;
				
			case 6://Thoat chuong trinh
				System.out.println("Goodbye!");
				break;
				
			default:
				System.out.println("Please enter a number 1 -> 6!");	showMenu();
				break;
			
			}
			
		}while (choice != 6);
		sc.close();
	
	}
	
	
	private static void showMenu() {
		System.out.println("=====================MENU=====================");
		System.out.println("1. View");
		System.out.println("2. Add");
		System.out.println("3. Edit");
		System.out.println("4. Delete");
		System.out.println("5. Search");
		System.out.println("6. Exit");
	}

	private static String toTitleCase(String input) {//Viet hoa chu cai dau
	    StringBuilder titleCase = new StringBuilder();
	    boolean nextTitleCase = true;

	    for (char c : input.toCharArray()) {
	        if (Character.isSpaceChar(c)) {
	            nextTitleCase = true;
	        } else if (nextTitleCase) {
	            c = Character.toTitleCase(c);
	            nextTitleCase = false;
	        }

	        titleCase.append(c);
	    }

	    return titleCase.toString();
	}
}


