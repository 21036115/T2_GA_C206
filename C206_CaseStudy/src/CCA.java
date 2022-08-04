/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * 21013910, 3 Aug 2022, 10:19:03 pm
 */


import java.util.ArrayList;

/**
 * @author 21013910
 *
 */
public class CCA {

	private static final int OPTION_QUIT = 4;
	private static final int OPTION_VIEW = 2;
	private static final int OPTION_ADD = 1;
	private static final int OPTION_DELETE = 3;


	public static void main(String[] args) {

		ArrayList<ccaClass> ccaArr = new ArrayList<ccaClass>();

		ccaArr.add(new ccaClass("BaseketBall","Sports", 3, 6, "Every Friday", "BasketBall Court", "Mr Tan"));
		ccaArr.add(new ccaClass("Ballet","Performing Arts", 3, 6, "Every Wednesday", "Dance Studio", "Mrs Chan"));
		ccaArr.add(new ccaClass("Arts&Craft","Design", 3, 6, "Every Friday", "Design Studio", "Mdm Stella"));
		ccaArr.add(new ccaClass("Boys Bridgade","Unifromed Groups", 3, 6, "Every Friday", "BB Room", "Mr Goh"));
		ccaArr.add(new ccaClass("Band","Perfomaning Arts", 3, 6, "Every Thursday", "Music Room", "Mr Tei & Mrs Ting"));


		int option = 0;

		while (option != OPTION_QUIT) {

			menu();
			option = Helper.readInt("Enter an option > ");

			if (option == OPTION_ADD) {
				// Add a new student
				ccaClass cca = addCCADetail(ccaArr);
				addccaClass(ccaArr, cca);
			} else if (option == OPTION_VIEW) {
				// View all students
				viewAllCCA(ccaArr);

			} else if (option == OPTION_DELETE) {
				deleteCCA(ccaArr);


			} else if (option == OPTION_QUIT) {
				System.out.println("Bye!");
			} else {
				System.out.println("Invalid option");
			}
		}
	}

	public static void menu() {
		setHeader("CCA Registration Website");
		System.out.println("1. Add CCA");
		System.out.println("2. View CCAs");
		System.out.println("3. Delete CCAs");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	//add cca details
	public static ccaClass addCCADetail(ArrayList<ccaClass> ccaArr) {
		int counter = 0;
		String output = "";
		ccaClass cca = null;
		String CCAName = Helper.readString("Enter CCA Name >");
		String CCACategory = Helper.readString("Enter CCA Category > ");
		int CCAstartTime = Helper.readInt("Enter CCA Start Time > ");
		int CCAendTime = Helper.readInt("Enter CCA End Time > ");
		String CCADay = Helper.readString("Enter CCA Day > ");
		String CCAVenue = Helper.readString("Enter CCA Venue > ");
		String TeacherInCharge = Helper.readString("Enter name of Teacher-In-Charge > ");

		for(int i = 0; i < ccaArr.size(); i++) {
			if(ccaArr.get(i).getCCAName().equalsIgnoreCase(CCAName)) {
				counter = counter + 1;
				break;
			}else {
			}
		}

		if(counter == 0) {
			for(ccaClass c: ccaArr) {
				if(c.getCCAstartTime() == CCAstartTime && c.getCCAendTime() == CCAendTime && c.getCCAvenue().equals(CCAVenue) && c.getCCADay().contains(CCADay)) {
					System.out.println("Clashing with " + c.getCCAName() );
					break;
				}else{
					output = "CCA Detail added succesfully!";		
					cca = new ccaClass(CCAName, CCACategory, CCAstartTime, CCAendTime, CCADay, CCAVenue, TeacherInCharge);
				}
			}
			System.out.println(output);
		}
		else{
			output = "Failed to add CCA Detail.";
		}
		return cca;
	}

	public static void addccaClass(ArrayList<ccaClass> ccaArr, ccaClass cca) {
		ccaArr.add(cca);	
	}


	//view all cca 
	public static String viewAllCCA(ArrayList<ccaClass> ccaArr) {
		String output = "";
		ccaClass e = null;
		String result = String.format("\n %-15s %-20s %-10s %-10s %-10s %-10s %-10s", "CCA NAME", "CATEGORY", "START TIME", "END TIME", "CCA DAY", "VENUE", "TEACHER-IN-CHARGE");
		System.out.println(result);
		for(ccaClass c: ccaArr){
			if(c == null) {
				e = c;
			}
			else {
				output += String .format("\n %-15s %-20s %-10d %-10d %-10s %-10s %-10s", c.getCCAName(), c.getCCACategory(), c.getCCAstartTime(), c.getCCAendTime(), c.getCCADay(), c.getCCAvenue(), c.getTeacherInCharge());	
			}		
		}
		
		if(e == null) {
			ccaArr.remove(e);
		}
		System.out.println(output);
		return output;
	}

	//delete CCA
	public static ccaClass deleteCCA(ArrayList<ccaClass> ccaArr) {
		String output = "";
		ccaClass check = null;
		String delete = Helper.readString("Enter CCA Name to be deleted > ");
		for (int i = 0; i < ccaArr.size(); i++) {
			if(ccaArr.get(i).getCCAName().equalsIgnoreCase(delete)) {
				ccaArr.remove(i);
				output = "CCA has been removed!";
				break;
			}else{
				output = "Failed to remove Category";
			}
		}
		System.out.println(output);
		return check;
	}

	public static void deleteCCANow(ArrayList<ccaClass> ccaArr, ccaClass cca) {
		ccaArr.remove(cca);
	}
}








