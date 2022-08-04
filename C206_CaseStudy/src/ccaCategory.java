


import java.util.ArrayList;

/**
 * @author 21036115
 *
 */
public class ccaCategory {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Categories> CategoriesList = new ArrayList<Categories>();

		CategoriesList.add(new Categories("Sport Clubs"));
		CategoriesList.add(new Categories("Uniformed Groups"));
		CategoriesList.add(new Categories("Design"));
		CategoriesList.add(new Categories("Performing Arts"));




		int input = 0;

		while(input!= 4) {
			Menu();
			input = Helper.readInt("\nEnter option > ");

			if(input == 1) {


				System.out.println(retrieveAllCategories(CategoriesList));
			}

			else if (input == 2) {

				Categories c = inputAddCategory();
				addCategory(CategoriesList,c);
			}

			else if (input == 3) {
				Categories c = inputremoveCategory(CategoriesList);
				removeCategory(CategoriesList,c);
			}

		}

	}

	public static void Menu() {

		System.out.println("\n1. View all Categories");
		System.out.println("2. Add Category");
		System.out.println("3. Remove Category");
		System.out.println("4. Exit");
	}


	public static Categories inputremoveCategory(ArrayList<Categories> CategoriesList) {

		boolean found = false;
		
		String name = Helper.readString("Enter category name: ");
		Categories c = null;
		for(int i =0;i < CategoriesList.size(); i++) {
			if(name.equals(CategoriesList.get(i).getCategoryName())) {
				
				found = true;
				c = CategoriesList.get(i);
			}
		}
		
		if(found == false) {
			System.out.println("No such category found...");
		}
		
		return c;
	}



	public static Categories inputAddCategory() {

		String cName = Helper.readString("Enter name of category > ");

		Categories c = new Categories(cName);


		return c;



	}


	public static String retrieveAllCategories(ArrayList<Categories> CategoriesList) {
		String output = "";

		for (int i = 0; i < CategoriesList.size(); i++) {

			if(CategoriesList.get(i) != null) {
				output += String.format("%-10s\n", CategoriesList.get(i).getCategoryName());
			}

		}
		return output;
	}

	public static void addCategory(ArrayList<Categories> CategoriesList, Categories C) {

		CategoriesList.add(C);

	}


	public static void removeCategory(ArrayList<Categories> CategoriesList, Categories C) {

		CategoriesList.remove(C);

	}




}
