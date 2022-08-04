

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Use.C206_ParentCodes;
import Use.Parent;

public class C206_test_ParentTest {

	private Parent parent1;
	private Parent parent2;
	private Parent parent3;
	private Parent parent4;
	private Parent parent5;
	
	private ArrayList<Parent> parentArr;
	
	public C206_test_ParentTest() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		
		parentArr = new ArrayList<Parent>();
		parentArr.add(new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 0000));
		parentArr.add(new Parent(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222, 1111));
		parentArr.add(new Parent(21003456, "Coby", 1 ,"Respect 5","Mr Pablo", "Emilio", "emilio@email.com", 83333333, 3333));
		parentArr.add(new Parent(21004567, "Jesika", 5 ,"Accountability 4","Mr Luis", "Diaz", "diaz@email.com", 84444444, 4444));
		parentArr.add(new Parent(21007890, "Aidill", 4 ,"Responsibility 6","Mr Pablo", "Escobar", "escobar@email.com", 85555555, 5555));
		
		parentArr.clear();
	}
	
	@Test
	public void addParentTest() {
		
		//Test that there is a ArrayList to add to.
		assertNotNull("Test if there is valid Student arraylist to add to", parentArr);
		
		//Test that stalls can be add into the ArrayList.
		C206_ParentCodes.addParent(parentArr, parent1);	
		assertEquals("Test if that Student arraylist size is 1?",1, parentArr.size());
		
		//Test that the stall added into the Array contains all the right information.
		assertSame("Test that Student is added same as 1st item of the list?", parent1, parentArr.get(0));
		
		C206_ParentCodes.addParent(parentArr, parent2);
		C206_ParentCodes.addParent(parentArr, parent3);
		C206_ParentCodes.addParent(parentArr, parent4);
		C206_ParentCodes.addParent(parentArr, parent5);
		
		assertEquals("Test if that Student arraylist size is 5?", 5, parentArr.size());
		assertSame("Test that Student is added same as 3rd item of the list?", parent3, parentArr.get(2));
		
	}
	
	@Test
	public void retrieveParentTest() {
		
		// Test if Student list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Student arraylist to add to", parentArr);
		//test if the list of Students retrieved from the SourceCentre is empty
		String checkParent = C206_ParentCodes.retrieveParent(parentArr);
		String testOutput = ""; 
		assertEquals("Check that ViewAllStudents", testOutput, checkParent);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		
		C206_ParentCodes.addParent(parentArr, new Parent(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111, 0000));
		C206_ParentCodes.addParent(parentArr, new Parent(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222, 1111));
		assertEquals("Test if that Student arraylist size is 2?", 2, parentArr.size());

		//test if the expected output string same as the list of Students retrieved from the SourceCentre
		
		checkParent = C206_ParentCodes.retrieveParent(parentArr);
				

		testOutput = String.format("%-15d %-10s %-5d %-20s %-15s %-10s %-25s %-15d %-10d\n",21001234, "Eddie" ,6 ,"Innovation 7", "Mr Peter", "Parker","peterparker@email.com" ,81111111 ,0000);
		testOutput += String.format("%-15d %-10s %-5d %-20s %-15s %-10s %-25s %-15d %-10d\n",21002345, "Shaun" ,1 ,"Respect 3", "Mr Smith", "Jaden","jadensmith@email.com" ,82222222 ,1111);

		assertEquals("Check that ViewAllStudents", testOutput, checkParent);

	}
	@Test
	public void deleteParentTest() {
		
		//Clear the List
		parentArr.clear();
		assertNotNull("Test if there is valid Student arraylist to delete to", parentArr);
		
		//Test that delete function would work.
		C206_ParentCodes.addParent(parentArr, parent1);
		assertEquals("Test if that Student arraylist size is 1?",1, parentArr.size());
		C206_ParentCodes.deleteParent(parentArr, parent1);	
		assertEquals("Test if that Student arraylist size is 0?",0, parentArr.size());
		
		//Test that delete function would delete the right one
		C206_ParentCodes.addParent(parentArr, parent1);
		C206_ParentCodes.addParent(parentArr, parent2);
		C206_ParentCodes.deleteParent(parentArr, parent2);	
		assertEquals("Test if that Student arraylist size is 1?",1, parentArr.size());
		
		//Test that only 1 parent is deleted
		C206_ParentCodes.addParent(parentArr, parent4);
		C206_ParentCodes.addParent(parentArr, parent5);
		assertEquals("Test if that Student arraylist size is 3?",3, parentArr.size());
		C206_ParentCodes.deleteParent(parentArr, parent4);	
		assertEquals("Test if that Student arraylist size is 2?",2, parentArr.size());
	}
		
	@After
	public void tearDown() throws Exception {
		parent1 = null;
		parent2 = null;
		parent3 = null;
		parent4 = null;
		parent5 = null;
		parentArr = null;

	}

}
