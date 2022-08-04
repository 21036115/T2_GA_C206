package Use;

import java.util.ArrayList;

public class MainMenu {

	public static void main(String[] args) {

		ArrayList<Parent> parentArr = new ArrayList<Parent>();
		ArrayList<Student> studentArr = new ArrayList<Student>();
		ArrayList<Categories> CategoriesList = new ArrayList<Categories>();
		ArrayList<ccaClass> ccaArr = new ArrayList<ccaClass>();
		ArrayList<Application> appList = new ArrayList<>();

		parentArr.add(new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 0000));
		parentArr.add(new Parent(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222, 1111));
		parentArr.add(new Parent(21003456, "Coby", 1 ,"Respect 5","Mr Pablo", "Emilio", "emilio@email.com", 83333333, 3333));
		parentArr.add(new Parent(21004567, "Jesika", 5 ,"Accountability 4","Mr Luis", "Diaz", "diaz@email.com", 84444444, 4444));
		parentArr.add(new Parent(21007890, "Aidill", 4 ,"Responsibility 6","Mr Pablo", "Escobar", "escobar@email.com", 85555555, 5555));

		ccaArr.add(new ccaClass("BaseketBall","Sports", "3pm to 6pm", "Every Friday", "BasketBall Court", "Mr Tan"));
		ccaArr.add(new ccaClass("Ballet","Performing Arts", "3pm to 6pm", "Every Wednesday", "Dance Studio", "Mrs Chan"));
		ccaArr.add(new ccaClass("Arts&Craft","Design", "3pm to 6pm", "Every Friday", "Design Studio", "Mdm Stella"));
		ccaArr.add(new ccaClass("Boys Bridgade","Unifromed Groups", "3pm to 6pm", "Every Friday", "BB Room", "Mr Goh"));
		ccaArr.add(new ccaClass("Band","Perfomaning Arts", "3pm to 6pm", "Every Thursday", "Music Room", "Mr Tei & Mrs Ting"));
		
		CategoriesList.add(new Categories("Sport Clubs"));
		CategoriesList.add(new Categories("Uniformed Groups"));
		CategoriesList.add(new Categories("Design"));
		CategoriesList.add(new Categories("Performing Arts"));
		
		appList.add(new Application(21001234, 4321, "BasketBall"));

		int option = 0;
		int option2 = 0;

		int cateOption = 0;
		int parentOption = 0;
		int studentOption = 0;
		int ccaOption = 0;
		int appOption = 0;
		int staffOp = 0;
		int counter = 0;

		// LOGIN

		appOption = 0;
		ApplicationMain appCode = new ApplicationMain();

		while (appOption != 4) {
			appCode.mainMenu();
			appOption = Helper.readInt("Enter option > ");
			if (appOption == 1) {
				appCode.loginThing();
				int loginOp = Helper.readInt("Enter option > ");
				if (loginOp == 1) {
					int sID = Helper.readInt("Enter your childs ID > ");
					int ccaReg = Helper.readInt("Enter CCA registration code >");
					if(appCode.loginParent(sID,ccaReg, parentArr)) {
						counter = 2;
						break;
					}
				}
			}
			else if (appOption == 2) {
				boolean checkUserName = Helper.readString("Enter staff user > ").equalsIgnoreCase("admin");
				boolean checkIfPassword = Helper.readString("Enter staff password > ").equalsIgnoreCase("admin");
				if (checkUserName && checkIfPassword) {
					counter = 1;
					break;
				}
			}
		}

		// LOGIN
		if(counter == 1) {
			while(option != 6) {
				menu();
				option = Helper.readInt("Choose an Option > ");
				if(option == 1) {
					C206_MainCodes studentCode = new C206_MainCodes();

					while (studentOption != 4) {

						C206_MainCodes.menu();
						studentOption = Helper.readInt("Enter an Option > ");

						if (studentOption == 1) {
							// Add a new student
							Student st = studentCode.inputStudent();
							C206_MainCodes.addStudent(studentArr, st);
							System.out.println("Student added");

						} else if (studentOption == 2) {
							// View all students
							C206_MainCodes.viewStudent(studentArr);

						} else if (studentOption == 3) {
							Student st = studentCode.inputremoveStudent(studentArr);
							C206_MainCodes.deleteStudent(studentArr, st);
							System.out.println("Student removed");


						} else if (studentOption == 4) {
							System.out.println("Bye!");
						} else {
							System.out.println("Invalid Option");
						}

					}

				}

				else if(option == 2) {

					ccaOption = 0;
					CCA ccaCode =  new CCA();

					while (ccaOption != 4) {

						ccaCode.menu();
						ccaOption = Helper.readInt("Enter an ccaOption > ");

						if (ccaOption == 1) {
							// Add a new student
							ccaClass cca = ccaCode.addCCADetail(ccaArr);
							if(cca == null) {

							}
							else {
								ccaCode.addccaClass(ccaArr, cca);
							}
						} else if (ccaOption == 2) {
							// View all students
							String output = String.format("%-10s %-15s %-15s %-15s %-10s %-10s", "Name", "Detail", 
									"CCA Time", "CCA Day", "Venue", "Teacher-In-Charge");
							output += ccaCode.viewAllCCA(ccaArr);
							System.out.println(output);

						} else if (ccaOption == 3) {
							ccaClass del = ccaCode.deleteCCA(ccaArr);
							ccaCode.deleteCCANow(ccaArr, del);


						} else if (ccaOption == 4) {
							System.out.println("Bye!");
						} else {
							System.out.println("Invalid Option");
						}
					}
				}

				else if(option == 3) {
					ccaRegistration categoriesCode = new ccaRegistration();

					while(cateOption!= 4) {
						categoriesCode.Menu();
						cateOption = Helper.readInt("\nEnter option > ");

						if(cateOption == 1) {


							System.out.println(categoriesCode.retrieveAllCategories(CategoriesList));
						}

						else if (cateOption == 2) {

							Categories c = categoriesCode.inputAddCategory();
							categoriesCode.addCategory(CategoriesList,c);
						}

						else if (cateOption == 3) {
							Categories c = categoriesCode.inputremoveCategory(CategoriesList);
							categoriesCode.removeCategory(CategoriesList,c);
						}

					}
				}

				else if(option == 4) {
					C206_ParentCodes parentCode = new C206_ParentCodes();

					while (parentOption != 4) {

						parentCode.menu();
						parentOption = Helper.readInt("Choose an Option > ");

						if (parentOption == 1) {
							// Add a new student
							Parent pA = parentCode.input();
							parentCode.addParent(parentArr, pA);
						} else if (parentOption == 2) {
							// View all students
							parentCode.viewParent(parentArr);

						} else if (parentOption == 3) {
							parentCode.inputDeleteParent(parentArr);


						} else if (parentOption == 4) {
							System.out.println("Bye!");
						} else {
							System.out.println("Invalid Option");
						}

					}
				}

				else if(option == 5) {

					while(staffOp != 3) {
						appCode.staffMenu();
						staffOp = Helper.readInt("Enter option > ");
						if (staffOp == 1) {
							appCode.viewAllApplicants(appList);
						}
						else if(staffOp == 2) {
							appCode.viewAllApplicants(appList);
							appCode.acceptApplicant(appList, Helper.readInt("Enter student ID to add into their cca choice > "));		
						}
					}
				}

				else if(option == 6) {
					System.out.println("Bye!");
				}

				else {
					System.out.println("Invalid Option");
				}
			}
		}
		else {
			CCA ccaCode = new CCA();
			while(option2 != 3) {
				menu2();
				option2 = Helper.readInt("Enter an Option");

				if(option2 == 1) {
					String output = String.format("%-10s %-15s %-15s %-15s %-10s %-10s", "Name", "Detail", 
							"CCA Time", "CCA Day", "Venue", "Teacher-In-Charge");
					output += ccaCode.viewAllCCA(ccaArr);
					System.out.println(output);
				}
				else if(option2 == 2) {
					System.out.println("Imagine that you can add here!");
				}
				else if(option2 == 3) {
					System.out.println("Bye!");
				}
				else {
					System.out.println("Invalid Option");
				}
			}
		}


	}



	public static void menu() {
		Helper.line(30, "-");
		System.out.println("Menu");
		System.out.println("1. Manage Students");
		System.out.println("2. Manage CCA Details");
		System.out.println("3. Manage Categories");
		System.out.println("4. Manage Parents");
		System.out.println("5. Manage Applicants");
		System.out.println("6. Quit");
		Helper.line(30, "-");
	}

	public static void menu2() {
		Helper.line(30, "-");
		System.out.println("Menu");
		System.out.println("1. View CCA");
		System.out.println("2. Apply for CCA");
		System.out.println("3. Quit");
		Helper.line(30, "-");
	}
}
