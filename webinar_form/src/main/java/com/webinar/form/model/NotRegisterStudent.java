package com.webinar.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="tbl_not_Regi_student")
public class NotRegisterStudent {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	   
	private int studentId;
	
	@Column(length = 50)
	private String studentMobileNumber;
	
	@Column(length = 100) 	
	private String studentName;	
	
	@Column(length = 200) 
	private String studentCollegeName;
	
	@Column(length = 50)
	private String studentCity;
	
	@Column(length = 50)
	private String registrationDatetime;
	
	@Column
	private int enrollStatus;

	public int getStudentId() {
		return studentId;
	}

	public String getStudentMobileNumber() {
		return studentMobileNumber;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getStudentCollegeName() {
		return studentCollegeName;
	}

	public String getStudentCity() {
		return studentCity;
	}

	public String getRegistrationDatetime() {
		return registrationDatetime;
	}

	public int getEnrollStatus() {
		return enrollStatus;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public void setStudentMobileNumber(String studentMobileNumber) {
		this.studentMobileNumber = studentMobileNumber;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public void setStudentCollegeName(String studentCollegeName) {
		this.studentCollegeName = studentCollegeName;
	}

	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}

	public void setRegistrationDatetime(String registrationDatetime) {
		this.registrationDatetime = registrationDatetime;
	}

	public void setEnrollStatus(int enrollStatus) {
		this.enrollStatus = enrollStatus;
	}

	@Override
	public String toString() {
		return "NotRegisterStudent [studentId=" + studentId + ", studentMobileNumber=" + studentMobileNumber
				+ ", studentName=" + studentName + ", studentCollegeName=" + studentCollegeName + ", studentCity="
				+ studentCity + ", registrationDatetime=" + registrationDatetime + ", enrollStatus=" + enrollStatus
				+ "]";
	}
}
