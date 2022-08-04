/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * yournumber9, 31 Jul 2022 12:36:35 am
 */

/**
 * @author yournumber9
 *
 */


public class Parent {
	
	public int id;
	public String studentName;
	public int grade;
	public String classroom;
	public String teacher;
	public String parentName;
	public String parentEmail;
	public int contact;
	public int regID;
	
	public Parent(int id, String studentName, int grade, String classroom, 
			String teacher, String parentName, String parentEmail,
			int contact, int regID) {
		this.id = id;
		this.studentName = studentName;
		this.grade = grade;
		this.teacher = teacher;
		this.classroom = classroom;
		this.parentName = parentName;
		this.parentEmail = parentEmail;
		this.contact = contact;
		this.regID = regID;
	}

	public int getId() {
		return id;
	}

	public String getStudentName() {
		return studentName;
	}

	public int getGrade() {
		return grade;
	}

	public String getTeacher() {
		return teacher;
	}

	public String getParentName() {
		return parentName;
	}

	public String getParentEmail() {
		return parentEmail;
	}

	public int getContact() {
		return contact;
	}
	
	public String getClassroom() {
		return classroom;
	}

	public int getRegID() {
		return regID;
	}
	
}
