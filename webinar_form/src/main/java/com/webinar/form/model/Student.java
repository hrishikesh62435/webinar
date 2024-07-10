package com.webinar.form.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.transaction.Transactional;

@Entity
@Table(name ="tbl_student")
public class Student {	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	   
	private int studentId;	
	
	@Column(length = 50)
	private String studentMobileNumber;
	
	@Column(length = 100) 	
	private String studentName;	
	
	@Column(length = 200) 
	private String studentCollegeName;
	
	@Column
	private int studentStatus;
	
	@Column(length = 50)
	private String studentCity;	
	
	@Column(length = 50)
	private String registrationDatetime;
	
	@Column
	private int certificateStatus;
	
	@Column
	private int eBookStatus;
	
	@Column
	private int sourceCodeStatus;
	
	@Column
	private int enrollStatus;
	
	@Transient
	private int status;
	
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getEnrollStatus() {
		return enrollStatus;
	}
	public void setEnrollStatus(int enrollStatus) {
		this.enrollStatus = enrollStatus;
	}
	public int getCertificateStatus() {
		return certificateStatus;
	}
	public int geteBookStatus() {
		return eBookStatus;
	}
	public int getSourceCodeStatus() {
		return sourceCodeStatus;
	}
	public void setCertificateStatus(int certificateStatus) {
		this.certificateStatus = certificateStatus;
	}
	public void seteBookStatus(int eBookStatus) {
		this.eBookStatus = eBookStatus;
	}
	public void setSourceCodeStatus(int sourceCodeStatus) {
		this.sourceCodeStatus = sourceCodeStatus;
	}
	public String getRegistrationDatetime() {
		return registrationDatetime;
	}
	public void setRegistrationDatetime(String registrationDatetime) {
		this.registrationDatetime = registrationDatetime;
	}
	public String getStudentCity() {
		return studentCity;
	}
	public void setStudentCity(String studentCity) {
		this.studentCity = studentCity;
	}	
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
	public int getStudentStatus() {
		return studentStatus;
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
	public void setStudentStatus(int studentStatus) {
		this.studentStatus = studentStatus;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentMobileNumber=" + studentMobileNumber + ", studentName="
				+ studentName + ", studentCollegeName=" + studentCollegeName
				+ ", studentStatus=" + studentStatus + ", studentCity=" + studentCity +", registrationDatetime=" + registrationDatetime + "]";
	}
}