

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class C206_ParentCodes {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_DELETE = 3;

	private static final int STUDENT = 1;

	public static void main(String[] args) {

		ArrayList<Parent> parentArr = new ArrayList<Parent>();

		parentArr.add(new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 0000));
		parentArr.add(new Parent(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222, 1111));
		parentArr.add(new Parent(21003456, "Coby", 1 ,"Respect 5","Mr Pablo", "Emilio", "emilio@email.com", 83333333, 3333));
		parentArr.add(new Parent(21004567, "Jesika", 5 ,"Accountability 4","Mr Luis", "Diaz", "diaz@email.com", 84444444, 4444));
		parentArr.add(new Parent(21007890, "Aidill", 4 ,"Responsibility 6","Mr Pablo", "Escobar", "escobar@email.com", 85555555, 5555));


		int option = 0;

		while (option != OPTION_QUIT) {

			C206_ParentCodes.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ADD) {
				// Add a new student
				Parent pA = input();
				addParent(parentArr, pA);
			} else if (option == OPTION_VIEW) {
				// View all students
				viewParent(parentArr);

			} else if (option == OPTION_DELETE) {
				inputDeleteParent(parentArr);


			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}

	public static void menu() {
		C206_ParentCodes.setHeader("CCA Registration Website");
		System.out.println("1. Add Parent");
		System.out.println("2. View Registered Parents");
		System.out.println("3. Delete Parent");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//------------------------------------------------------PARENT----------------------------------------------------------------

	//================================= Option 1 Add a Parent (Create) =================================
	public static Parent input() {
		int id = Helper.readInt("Enter Student ID: ");
		String name = Helper.readString("Enter Student Name: ");
		int grade = Helper.readInt("Enter Student Grade: ");
		String classroom = Helper.readString("Enter Student Class Room: ");
		String teacher = Helper.readString("Enter Student Teacher: ");
		String parentname = Helper.readString("Enter Student's Parent Name: ");
		String parentemail = Helper.readString("Enter Student's Parent Email: ");
		int contact = Helper.readInt("Enter Student's Parent Contact No: ");
		Random rand = new Random();
		int upperbound = 100000;
		int int_random = rand.nextInt(upperbound); 

		Parent pa = new Parent(id, name, grade, classroom, teacher, parentname, parentemail, contact, int_random);
		return pa;
	}

	public static void addParent(ArrayList<Parent> parentArr, Parent pA) {
		parentArr.add(pA);		
	}

	//================================= Option 2 View Parents (Read) =================================

	public static String retrieveParent(ArrayList<Parent> parentArr) {

		String output = "";
		for(int i = 0; i < parentArr.size(); i++) {
			output += String.format("%-15d %-10s %-5d %-20s %-15s %-10s %-25s %-15d %-10d\n",parentArr.get(i).getId(), parentArr.get(i).getStudentName() ,parentArr.get(i).getGrade() , parentArr.get(i).getClassroom(),parentArr.get(i).getTeacher(), parentArr.get(i).getParentName(),parentArr.get(i).getParentEmail() ,parentArr.get(i).getContact() ,parentArr.get(i).getRegID());
		}

		return output;
	}

	public static void viewParent(ArrayList<Parent> parentArr) {
		String output = String.format("%-15s %-10s %-5s %-20s %-15s %-10s %-25s %-15s %-10s\n", 
				"ID", "STUDENT NAME", "GRADE", "CLASSROOM", "TEACHER", "PARENT NAME"
				, "PARENT EMAIL", "CONTACT NO", "REGISTRATION ID");
		output += retrieveParent(parentArr);

		System.out.println(output);
	}
	//================================= Option 3 Delete Parent (CRUD- Remove) =================================
	public static Parent inputDeleteParent(ArrayList<Parent> parentArr) {
		String name = Helper.readString("Enter Parent Name: ");
		Parent pA = null;

		for(int i = 0; i < parentArr.size(); i++) {
			if(parentArr.get(i).getParentName().equalsIgnoreCase(name)) {
				pA = parentArr.get(i);
			}
		}
		return pA;
	}

	public static void deleteParent(ArrayList<Parent> parentArr, Parent pA) {
		parentArr.remove(pA);
	}

}
