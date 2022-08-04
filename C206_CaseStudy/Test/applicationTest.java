/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Shaun Raj;
 * Student ID: 21038476;
 * Class: W67N;
 * Date/Time created: Monday 01-08-2022 20:36
 */

/**
 * @author 21038476

 *
 */




import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
public class applicationTest {
	
	private Parent parent1;
	private Parent parent2;
	private Application a1;
	private Application a2;
	
	private ArrayList<Parent> parentArr;
	private ArrayList<Application> arrList;
	
	public applicationTest() {
		parentArr = new ArrayList<>();
		arrList = new ArrayList<>();
		parent1 = new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 1234);
		parent2 = new Parent(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222, 1111);
		parentArr.add(parent1);
		parentArr.add(parent2);
		a1 = new Application(21001234, 1234, "BasketBall");
		a2 = new Application(21001234, 1111, "BasketBall");
		
		
		
	}	
	

	 @Test 
	 public void testLoginParent() {
		 int inputId = parent1.getId();
		 int ccaReg = parent1.getRegID();
		 
		 assertTrue("Check if the character length is 8", String.valueOf(inputId).length() == 8);
		 assertTrue("Check if the character length is 8", String.valueOf(ccaReg).length() == 4);
		 
		 
		 String pattern = "\\d{8}";
		 String pattern2 = "\\d{4}";
		 assertTrue("Check input if matches a digit within certain amount of characters", Pattern.matches(pattern, "87654321") && Pattern.matches(pattern2, "1234"));
		 
		 assertTrue("Check if login successful", ApplicationMain.loginParent(21001234, 1234, parentArr));

	 }
	
	@Test 
	public void testaddStudentCCA() {
		assertTrue("Check if stack empty",arrList.isEmpty());
		arrList.add(a1);
		assertFalse("Check if stack is NOT empty",arrList.isEmpty());
		
		//Changes status of the student that was selected.
		ApplicationMain.acceptApplicant(arrList, arrList.get(0).getStudentID());
		boolean flag = arrList.get(0).getStatus() == "Accepted" ? true : false;
		assertTrue("Test if student status has changed to accepted",flag);
	} 
	
	@Test 
	public void viewStudents() {
		arrList.add(a1);
		assertNotNull("Test if stack is not empty",arrList);
		assertTrue("Test if stack has an item",arrList.size() >= 1);
		assertTrue("Test if item gets printed out",ApplicationMain.viewAllApplicants(arrList));	
	
	} 
	
	

}
