



import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import c206_Assignment.Categories;
import c206_Assignment.ccaCategory;

/**
 * @author 21036115
 *
 */
public class ccaCategoryTest {

	private Categories C1;
	private Categories C2;
	private Categories C3;



	public ccaCategoryTest(){
		super();
	}

	private ArrayList<Categories> CategoriesList;

	@Before
	public void setUp() throws Exception {
		// prepare test data
		C1 = new Categories("Sports and games");
		C2 = new Categories("Uniformed Groups");
		C3 = new Categories("Performing Arts");


		CategoriesList = new ArrayList<Categories>();

	}



	@Test
	public void testAddCategory() {
		assertNotNull("Check that there is a list to add to",CategoriesList);
		ccaCategory.addCategory(CategoriesList,C1);

		assertEquals("Check that Categories arraylist size is 1", 1, CategoriesList.size());
		assertSame("Check that Categories is added", C1, CategoriesList.get(0));
	}

	@Test 
	public void testRetrieveCategory(){

		assertNotNull("Check that there is a list to retrieve from",CategoriesList);

		//test if the list of categories retrieved from the main is empty - boundary
		String allCategories = ccaCategory.retrieveAllCategories(CategoriesList);
		String testOutput = "";
		assertEquals("Check that ViewAllCategorieslist", testOutput, allCategories);

		ccaCategory.addCategory(CategoriesList,C1);
		ccaCategory.addCategory(CategoriesList,C2);
		ccaCategory.addCategory(CategoriesList,C3);

		assertEquals("Test that Categories arraylist size is 3", 3, CategoriesList.size());

		allCategories = ccaCategory.retrieveAllCategories(CategoriesList);

		testOutput = String.format("%-10s\n","Sports and games");
		testOutput += String.format("%-10s\n","Uniformed Groups");
		testOutput += String.format("%-10s\n","Performing Arts");


		assertEquals("Check that ViewAllCategorieslist", testOutput, allCategories);
	}

	@Test
	public void testRemoveCategory() {

		assertNotNull("Check that there is a list to add to",CategoriesList);
		ccaCategory.addCategory(CategoriesList,C1);

		assertEquals("Check that categories arraylist size is 1", 1, CategoriesList.size());
		assertSame("Check that category is added", C1, CategoriesList.get(0));


		ccaCategory.removeCategory(CategoriesList, C1);
		assertEquals("Check that categories arraylist size is 0", 0, CategoriesList.size());

	}



	@After
	public void tearDown() throws Exception {
		C1 = null;
		C2 = null;
		C3 = null;
		CategoriesList = null;

	}



}
