/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * 21013910, 4 Aug 2022, 12:00:08 am
 */


import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author 21013910
 *
 */
public class CCATestCases {
	private ccaClass cca1;
	private ccaClass cca2;
	private ccaClass cca3;
	private ccaClass cca4;
	private ccaClass cca5;
	
	private ArrayList<ccaClass> ccaArr;
	
	public CCATestCases() {
		super();
	}

	@Before
	public void setUp() throws Exception {
		
		ccaArr = new ArrayList<ccaClass>();
		ccaArr.add(new ccaClass("BaseketBall","Sport", 3, 6, "Every Friday", "BasketBall Court", "Mr Tan"));
		ccaArr.add(new ccaClass("Ballet","Performing Arts", 3, 6, "Every Wednesday", "Dance Studio", "Mrs Chan"));
		ccaArr.add(new ccaClass("Arts&Craft","Design", 3, 6, "Every Friday", "Design Studio", "Mdm Stella"));
		ccaArr.add(new ccaClass("Boys Bridgade","Unifromed Group", 3, 6, "Every Friday", "BB Room", "Mr Goh"));
		ccaArr.add(new ccaClass("Band","Performing arts", 3, 6, "Every Thursday", "Music Room", "Mr Tei & Mrs Ting"));
		
		ccaArr.clear();
	}
	
	@Test
	public void addCCADetailTest() {
		//Test that there is a ArrayList to add to
		assertNotNull("Test if there is valid CCA arraylist to add to", ccaArr);
		
		//Test that CCAs can be add into the ArrayList
		CCA.addccaClass(ccaArr, cca1);	
		assertEquals("Test if that CCA arraylist size is 1?",1, ccaArr.size());
		
		//Test that the CCAs added into the Array contains all the right information to its respective CCA
		assertSame("Test that CCA is added same as 1st item of the list?", cca1, ccaArr.get(0));
		
		CCA.addccaClass(ccaArr, cca2);
		CCA.addccaClass(ccaArr, cca3);
		CCA.addccaClass(ccaArr, cca4);
		CCA.addccaClass(ccaArr, cca5);
		
		assertEquals("Test if that CCA arraylist size is 5?", 5, ccaArr.size());
		assertSame("Test that CCA is added same as 2rd item of the list?", cca3, ccaArr.get(1));
	}
	
	@Test
	public void viewAllCCATest() {
		
		// Test if  the CCA list is empty and not null, so that a new CCA can be added into it
		assertNotNull("Test if there is valid Student arraylist to add to", ccaArr);
		//test if the list of Students retrieved from the SourceCentre is empty
		String checkCCA = CCA.viewAllCCA(ccaArr);
		String testOutput = ""; 
		assertEquals("Check that ViewAllStudents", testOutput, checkCCA);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		
		CCA.addccaClass(ccaArr,(new ccaClass("Ballet","Performing Arts", 3, 6, "Every Wednesday", "Dance Studio", "Mrs Chan")));
		CCA.addccaClass(ccaArr, (new ccaClass("Arts&Craft","Design", 3, 6, "Every Friday", "Design Studio", "Mdm Stella")));
		assertEquals("Test if that Student arraylist size is 2?", 2, ccaArr.size());

		//test if the expected output string same as the list of Students retrieved from the SourceCentre
		
		checkCCA = CCA.viewAllCCA(ccaArr);
				

		testOutput = String.format("\n %-15s %-20s %-10d %-10d %-10s %-10s %-10s","Ballet","Performing Arts", 3, 6, "Every Wednesday", "Dance Studio", "Mrs Chan");
		testOutput += String.format("\n %-15s %-20s %-10d %-10d %-10s %-10s %-10s","Arts&Craft","Design", 3, 6, "Every Friday", "Design Studio", "Mdm Stella");

		assertEquals("Check that ViewAllCCATest", testOutput, checkCCA);
	}
	
	@Test
	public void deleteCCATest() {
		
		//Clear the List
		ccaArr.clear();
		assertNotNull("Test if there is valid Student arraylist to delete to", ccaArr);
		
		//Test that delete function would work.
		CCA.addccaClass(ccaArr, cca1);
		assertEquals("Test if that Student arraylist size is 1?",1, ccaArr.size());
		CCA.deleteCCANow(ccaArr, cca1);	
		assertEquals("Test if that Student arraylist size is 0?",0, ccaArr.size());
		
		//Test that delete function would delete the right one
		CCA.addccaClass(ccaArr, cca1);
		CCA.addccaClass(ccaArr, cca2);
		CCA.deleteCCANow(ccaArr, cca2);	
		assertEquals("Test if that Student arraylist size is 1?",1, ccaArr.size());
		
		//Test that only 1 parent is deleted
		CCA.addccaClass(ccaArr, cca4);
		CCA.addccaClass(ccaArr, cca5);
		assertEquals("Test if that Student arraylist size is 3?",3, ccaArr.size());
		CCA.deleteCCANow(ccaArr, cca4);	
		assertEquals("Test if that Student arraylist size is 2?",2, ccaArr.size());
	}
	@After
	public void tearDown() throws Exception {
		cca1 = null;
		cca2 = null;
		cca3 = null;
		cca4 = null;
		cca5 = null;
		ccaArr = null;
	}
}
