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
public class Student {
	private int id;
	private String name;
	private int grade;
	private String classroom;
	private String classteacher;
	private String parentname;
	private String parentemail;
	private int contact;
	/**
	 * @param id
	 * @param name
	 * @param grade
	 * @param classroom
	 * @param classteacher
	 * @param parentname
	 * @param parentemail
	 * @param contact
	 */
	public Student(int id, String name, int grade, String classroom, String classteacher, String parentname,
			String parentemail, int contact) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.classroom = classroom;
		this.classteacher = classteacher;
		this.parentname = parentname;
		this.parentemail = parentemail;
		this.contact = contact;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the grade
	 */
	public int getGrade() {
		return grade;
	}
	/**
	 * @return the classroom
	 */
	public String getClassroom() {
		return classroom;
	}
	/**
	 * @return the classteacher
	 */
	public String getClassteacher() {
		return classteacher;
	}
	/**
	 * @return the parentname
	 */
	public String getParentname() {
		return parentname;
	}
	/**
	 * @return the parentemail
	 */
	public String getParentemail() {
		return parentemail;
	}
	/**
	 * @return the contact
	 */
	public int getContact() {
		return contact;
	}
}
