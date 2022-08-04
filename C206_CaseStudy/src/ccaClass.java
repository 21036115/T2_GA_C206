/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * 21013910, 3 Aug 2022, 10:18:15 pm
 */


/**
 * @author 21013910
 *
 */
public class ccaClass {
	private String CCAName;
	private String CCACategory;
	private int CCAstartTime;
	private int CCAendTime;
	private String CCADay;
	private String CCAVenue;
	private String TeacherInCharge;
		

		public ccaClass(String CCAName, String CCACategory, int CCAstartTime, int CCAendTime, String CCADay, String CCAVenue, String TeacherInCharge) {
			this.CCAName = CCAName;
			this.CCACategory = CCACategory;
			this.CCAstartTime = CCAstartTime;
			this.CCAendTime = CCAendTime;
			this.CCADay = CCADay;
			this.CCAVenue = CCAVenue;
			this.TeacherInCharge = TeacherInCharge;
		}
		
		public String getCCAName() {
			return CCAName;
		}

		public String getCCACategory() {
			return CCACategory;
		}
		
		public int getCCAstartTime() {
			return CCAstartTime;

		}
		
		public int getCCAendTime() {
			return CCAendTime;
		}
		
		public String getCCADay() {
			return CCADay;
		}
		
		public String getCCAvenue() {
			return CCAVenue;
		}
		
		public String getTeacherInCharge() {
			return TeacherInCharge;
		}

}


