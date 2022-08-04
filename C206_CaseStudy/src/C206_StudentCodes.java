import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class C206_StudentCodes {
	
	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_DELETE = 3;
	
	private static final int STUDENT = 1;
	
	public static void main(String[] args) {
		
		ArrayList<Student> studentArr = new ArrayList<Student>();
		
		studentArr.add(new Student(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111));
		studentArr.add(new Student(21002345, "Shaun", 1 ,"Respect 3","Mr Jaden", "Smith", "jadensmith@email.com", 82222222));
		studentArr.add(new Student(21003456, "Coby", 1 ,"Respect 5","Mr Pablo", "Emilio", "pabloemilio@email.com", 83333333));
		studentArr.add(new Student(21004567, "Jesika", 5 ,"Accountability 4","Mr Luis", "Diaz", "luisdiaz@email.com", 84444444));
		studentArr.add(new Student(21007890, "Aidill", 4 ,"Responsibility 6","Mr Pablo", "Escobar", "pabloescobar@email.com", 85555555));
	
		
		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ADD) {
				// Add a new student
				Student st = inputStudent();
				addStudent(studentArr, st);
				System.out.println("Student added");
				
			} else if (option == OPTION_VIEW) {
				// View all students
				viewStudent(studentArr);
				
			} else if (option == OPTION_DELETE) {
				Student st = inputremoveStudent(studentArr);
				deleteStudent(studentArr, st);
				System.out.println("Student removed");
				
						
			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}

		}

	}
	
	public static void menu() {
		setHeader("CCA Registration Website");
		System.out.println("1. Add Student");
		System.out.println("2. View Student");
		System.out.println("3. Delete Student");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}


	//------------------------------------------------------STUDENT----------------------------------------------------------------

	//================================= Option 1 Add a student (Create) =================================
	public static Student inputStudent() {
		int id = Helper.readInt("Enter Student ID: ");
		String name = Helper.readString("Enter Student Name: ");
		int grade = Helper.readInt("Enter Student Grade: ");
		String classroom = Helper.readString("Enter Student Class Room: ");
		String classteacher = Helper.readString("Enter Student Class's Teacher: ");
		String parentname = Helper.readString("Enter Student's Parent Name: ");
		String parentemail = Helper.readString("Enter Student's Parent Email: ");
		int contact = Helper.readInt("Enter Student's Parent Contact No: ");
		
		Student st = new Student(id, name, grade, classroom, classteacher, parentname, parentemail, contact);
		return st;
	}
	public static void addStudent(ArrayList<Student>studentArr,Student st) {
		studentArr.add(st);
		
}
	
	//================================= Option 2 View items (Read) =================================
	
	public static String retrieveAllStudent(ArrayList<Student> studentArr) {
		String output = "";

		for (int i = 0; i < studentArr.size(); i++) {

			output += String.format("%-15d %-10s %-5d %-20s %-15s %-15s %-25s %-15d\n",
					studentArr.get(i).getId(), studentArr.get(i).getName(), studentArr.get(i).getGrade(),studentArr.get(i).getClassroom(),studentArr.get(i).getClassteacher(), studentArr.get(i).getParentname(),studentArr.get(i).getParentemail(),studentArr.get(i).getContact());
		}
		return output;
	}
	public static void viewStudent(ArrayList<Student>studentArr) {
		setHeader("STUDENT LIST");
		String output = String.format("%-15s %-10s %-5s %-20s %-15s %-15s %-25s %-15s\n", "ID", "NAME",
				"GRADE", "CLASSROOM","CLASS TEACHER", "PARENT NAME", "PARENT EMAIL", "CONTACT NO.");
		output += retrieveAllStudent(studentArr);	
		System.out.println(output);
	}
	//================================= Option 3 Delete student (CRUD- Remove) =================================
	public static Student inputremoveStudent(ArrayList<Student> studentArr) {
		int id = Helper.readInt("Enter Student ID: ");
		Student st = null;
		for(int i =0;i < studentArr.size(); i++) {
			if(id == studentArr.get(i).getId()) {
				st = studentArr.get(i);
			}
		}
		return st;
	}
	public static void deleteStudent(ArrayList<Student>studentArr,Student st) {

		studentArr.remove(st);
	  }
}