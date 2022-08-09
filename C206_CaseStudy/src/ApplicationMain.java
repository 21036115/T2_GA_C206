import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Shaun Raj;
 * Student ID: 21038476;
 * Class: W67N;
 * Date/Time created: Monday 01-08-2022 20:42
 */

/**
 * @author 21038476
 *
 */
public class ApplicationMain {

	private static final int ADD_S_TO_CCA = 2;

	private static final int VIEW_ALL = 1;

	public static final int LOGIN_STAFF = 2;

	public static final int LOGIN_PARENT = 1;

	public static final int LOGIN_STUDENT = 3;

	public static final int OPTION_QUIT = 4;


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Parent> parentArr = new ArrayList<Parent>();
		ArrayList<Application> appList = new ArrayList<>();
		ArrayList<Student> studentArr = new ArrayList<Student>();
		appList.add(new Application(21001234, 4321, "BasketBall"));
		parentArr.add(new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 4321));
		studentArr.add(new Student(21002345, "Shaun", 1 ,"Respect 3","Mr Jaden", "Smith", "jadensmith@email.com", 82222222));
		int op = 0;
		while (op != OPTION_QUIT) {
			int counter2 = 0;
			mainMenu();
			op = Helper.readInt("Enter option > ");
			if (op == LOGIN_PARENT) {
				loginThing();
				int loginOp = Helper.readInt("Enter option > ");
				if (loginOp == 1) {
					int sID = Helper.readInt("Enter your childs ID > ");
					int ccaReg = Helper.readInt("Enter CCA registration code >");
					loginParent(sID,ccaReg, parentArr);

				}
			}
			else if (op == LOGIN_STAFF) {
				boolean checkUserName = Helper.readString("Enter staff user > ").equalsIgnoreCase("admin");
				boolean checkIfPassword = Helper.readString("Enter staff password > ").equalsIgnoreCase("admin");
				if (checkUserName && checkIfPassword) {
					staffMenu();
					int staffOp = Helper.readInt("Enter option > ");
					if (staffOp == VIEW_ALL) {
						viewAllApplicants(appList);
					}
					else if(staffOp == ADD_S_TO_CCA) {
						viewAllApplicants(appList);
						acceptApplicant(appList, Helper.readInt("Enter student ID to add into their cca choice > "));		
					}
				}
			}
			if (op == LOGIN_STUDENT) {
				loginThing();
				int loginOp = Helper.readInt("Enter option > ");
				if (loginOp == 1) {
					int sID = Helper.readInt("Enter Student ID > ");
					int grade = Helper.readInt("Enter Grade > ");
					if(grade < 4) {
						counter2 = 0;
					}
					else {
						counter2++;
					}
					if(counter2 != 0) {
						int contactNo = Helper.readInt("Enter Parents Contact >");
						loginStudent(sID, contactNo, grade, studentArr);
					}
					else {
						System.out.println("Use your parents account to login.");
					}
				}
			}
		}	
	}


	public static void mainMenu() {
		System.out.println("LOGIN PAGE");
		Helper.line(50, "=");
		System.out.println("1. Login as Parent");
		System.out.println("2. Login as staff");
		System.out.println("3. Login as Student");
		Helper.line(50, "=");
	}
	public static void staffMenu() {
		Helper.line(50, "=");
		System.out.println("1. View applicants");
		System.out.println("2. Add Student to CCA");
		System.out.println("3. Quit");
		Helper.line(50, "=");
	}

	public static void loginThing() {
		Helper.line(50, "=");
		System.out.println("1. Login");
		System.out.println("2. Quit");
		Helper.line(50, "=");

	}

	//=================================== Viewing All Applicants ====================================//

	public static boolean viewAllApplicants(ArrayList<Application> arrList) {
		boolean flag = false;
		if (arrList.isEmpty()) {
			return flag;
		}
		String output = String.format("%-15s %-20s %-10s %-10s\n", "STUDENT ID", "Registration Code", "STATUS", "CCA SELECTED");
		for (Application a : arrList) {
			output += String.format("%-15d %-20d %-10s %-10s\n", a.getStudentID(),a.getCcaRegistration(),a.getStatus(),a.getCca());
			flag = true;
		}
		System.out.println(output);
		return flag;
	}

	//=================================== Accept/Add a applicant to a CCA ====================================//

	public static boolean acceptApplicant(ArrayList<Application> arrList , int id) {
		for (Application a : arrList) {
			if (a.getStudentID() == id) {
				a.setStatus("Accepted");
				System.out.println("Student ID of " + a.getStudentID() + " has been accepted to CCA -> " + a.getCca());
				return true;
			}
		}
		return false;
	}


	//=================================== Login Parent ====================================//

	public static boolean loginParent(int studentID, int cca, ArrayList<Parent> parentArr) {
		for (Parent x : parentArr) {
			if (x.id == studentID && x.getRegID() == cca) {
				System.out.println("You have logged in!");
				return true;
			}
		}			
		return false;
	}

	//=================================== Login Student ====================================//

	public static boolean loginStudent(int studentID, int contactNo, int grade, ArrayList<Student> studentArr) {
		for (Student s : studentArr) {
			if (s.getId() == studentID && s.getContact() == contactNo && s.getGrade() == grade) {
				System.out.println("You have logged in!");
				return true;
			}
		}			
		return false;
	}





}
