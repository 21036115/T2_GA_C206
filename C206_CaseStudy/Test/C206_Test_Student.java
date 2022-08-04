import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * yournumber9, 1 Aug 2022 12:35:13 pm
 */

/**
 * @author yournumber9
 *
 */
public class C206_Test_Student {

	private Student student1;
	private Student student2;
	private Student student3;
	private Student student4;
	private Student student5;
	
	private ArrayList<Student> studentArr;
	
	public C206_Test_Student() {
		super();
	}
	@Before
	public void setUp() throws Exception {
		
		student1 = new Student(21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111);
		student2 = new Student(21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222);
		student3 = new Student(21003456, "Coby", 1 ,"Respect 5","Mr Pablo", "Emilio", "emilio@email.com", 83333333);
		student4 = new Student(21004567, "Jesika", 5 ,"Accountability 4","Mr Luis", "Diaz", "diaz@email.com", 84444444);
		student5 = new Student(21007890, "Aidill", 4 ,"Responsibility 6","Mr Pablo", "Escobar", "escobar@email.com", 85555555);
	
		studentArr= new ArrayList<Student>();
		
		
	}
	
	@Test
	public void addStudentTest() {
		
		//Test that there is a ArrayList to add to.
		assertNotNull("Test if there is valid Student arraylist to add to", studentArr);
		
		//Test that students can be add into the ArrayList.
		C206_StudentCodes.addStudent(studentArr, student1);	
		assertEquals("Test if that Student arraylist size is 1?",1, studentArr.size());
		
		//Test that the student added into the Array contains all the right information.
		assertSame("Test that Student is added same as 1st item of the list?", student1, studentArr.get(0));
		
		C206_StudentCodes.addStudent(studentArr, student2);
		C206_StudentCodes.addStudent(studentArr, student3);
		C206_StudentCodes.addStudent(studentArr, student4);
		C206_StudentCodes.addStudent(studentArr, student5);
		
		assertEquals("Test if that Student arraylist size is 5?", 5, studentArr.size());
		assertSame("Test that Student is added same as 3rd item of the list?", student3, studentArr.get(2));
		
	}
	
	@Test
	public void retrieveAllStudentTest() {
		// Test if Student list is not null but empty, so that can add a new item
		assertNotNull("Test if there is valid Student arraylist to add to", studentArr);

		//Test if the list of Students retrieved from the C206_MainCodes is empty
		String checkStudent= C206_StudentCodes.retrieveAllStudent(studentArr);
		String testOutput = ""; 
		assertEquals("Check that ViewAllStudents", testOutput, checkStudent);

		//Given an empty list, after adding 2 items, test if the size of the list is 2
		C206_StudentCodes.addStudent(studentArr, student1);
		C206_StudentCodes.addStudent(studentArr, student2);
		assertEquals("Test if that Student arraylist size is 2?", 2, studentArr.size());

		//Test if the expected output string same as the list of Students retrieved from the C206_MainCodes
		checkStudent = C206_StudentCodes.retrieveAllStudent(studentArr);

		testOutput = String.format("%-15d %-10s %-5d %-20s %-15s %-15s %-25s %-15d\n",21001234, "Eddie", 6 ,"Innovation 7","Mr Peter", "Parker", "peterparker@email.com", 81111111);
		testOutput += String.format("%-15d %-10s %-5d %-20s %-15s %-15s %-25s %-15d\n",21002345, "Shaun", 1 ,"Respect 3","Mr Smith", "Jaden", "jadensmith@email.com", 82222222);

		assertEquals("Check that ViewAllStudents", testOutput, checkStudent);

	}
	@Test
	public void deleteStudentTest() {
		
		//Clear the List
		studentArr.clear();
		assertNotNull("Test if there is valid Student arraylist to delete to", studentArr);
		
		//Test that delete function would work.
		C206_StudentCodes.addStudent(studentArr, student1);
		assertEquals("Test if that Student arraylist size is 1?",1, studentArr.size());
		C206_StudentCodes.deleteStudent(studentArr, student1);	
		assertEquals("Test if that Student arraylist size is 0?",0, studentArr.size());
		
		//Test that delete function would delete the right one
		C206_StudentCodes.addStudent(studentArr, student1);
		C206_StudentCodes.deleteStudent(studentArr,student2);	
		assertEquals("Test if that Student arraylist size is 1?",1, studentArr.size());
		
		//Test that only 1 student is deleted
		C206_StudentCodes.addStudent(studentArr, student2);
		C206_StudentCodes.addStudent(studentArr, student3);
		assertEquals("Test if that Student arraylist size is 3?",3, studentArr.size());
		C206_StudentCodes.deleteStudent(studentArr, student1);	
		assertEquals("Test if that Student arraylist size is 2?",2, studentArr.size());
	}
		

	@After
		public void tearDown() throws Exception {
			student1 = null;
			student2 = null;
			student3 = null;
			student4 = null;
			student5 = null;
			studentArr = null;

		}

}
