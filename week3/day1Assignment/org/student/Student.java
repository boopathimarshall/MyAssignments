package org.student;

import org.department.Department;
import  org.college.College;

public class Student extends Department {

	
	public static void main(String[] args) {
		Student st = new Student();
		st.collegeName();
		st.collegeCode();
		st.collegeRank();
		st.deptName();
		st.studentName();
		st.studentId();
		st.studentDept();
		
		
	}
	
	
	
	
	
	
	
	public void studentName() {
		System.out.println("Student Name");
	}

	public void studentDept() {
		System.out.println("Student Dept");
	}

	public void studentId() {
		System.out.println("Student ID");
	}
}
