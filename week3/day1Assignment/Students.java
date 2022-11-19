package week3.day1.assignments;

public class Students {

	public static void main(String[] args) {
		// getStudentInfo() method by passing id argument alone, by id & name, by email & phoneNumber

		Students st = new Students();
		st.getStudentInfo(56188);
		st.getStudentInfo(56188,"Boopathi");
		st.getStudentInfo("Boopathi",224248);
		
	}
	
	public void getStudentInfo(int id) {
		System.out.println("student Id is "+id);
		
	}
	public void getStudentInfo(int id , String name) {
		System.out.println("student Id and Name is "+id +" : "+name);
	}
	public void getStudentInfo(String email , int phoneNumber ) {
		System.out.println("student email and phoneNumber is "+email +" : "+phoneNumber);
	}
	

}
