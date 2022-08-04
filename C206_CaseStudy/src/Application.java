/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Shaun Raj;
 * Student ID: 21038476;
 * Class: W67N;
 * Date/Time created: Monday 01-08-2022 20:35
 */

/**
 * @author 21038476
 *
 */
public class Application {
	private int studentID;
	private int ccaRegistration;
	private String status = "Pending";
	private String cca;
	public Application(int studentID, int ccaRegistration, String cca) {
		this.studentID = studentID;
		this.ccaRegistration = ccaRegistration;
		this.cca = cca;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCca() {
		return cca;
	}
	public void setCca(String cca) {
		this.cca = cca;
	}
	public int getStudentID() {
		return studentID;
	}
	public int getCcaRegistration() {
		return ccaRegistration;
	}
}
