package com.webinar.form.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.webinar.form.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query("select u.studentName from Student u where u.studentId = :studentId")
	public String getStudentNameByStudentId(@Param("studentId") int studentId);

	@Query("select u from Student u where u.studentMobileNumber = :mobile")
	public Student getStudentByMobileNumber(@Param("mobile") String mobile);
	
	@Transactional
	@Modifying
	@Query(value="update tbl_student set certificate_status = 1 where student_id = :studentId", nativeQuery = true)
	public int updateCertificateStatus(@Param("studentId") int studentId);
	
	@Transactional
	@Modifying
	@Query(value="update tbl_student set e_book_status = 1 where student_id = :studentId", nativeQuery = true)
	public int updateEBookStatus(@Param("studentId") int studentId);
	
	@Transactional
	@Modifying
	@Query(value="update tbl_student set source_code_status = 1 where student_id = :studentId", nativeQuery = true)
	public int updateSourceCodeStatus(@Param("studentId") int studentId);
	
	@Transactional
	@Modifying
	@Query(value="update tbl_student set enroll_status = 1 where student_id = :studentId", nativeQuery = true)
	public int updateEnrollStatus(@Param("studentId") int studentId);	
	
	
	@Query("SELECT s FROM Student s")
	public List<Student> getListRegisterStudent();
	
	
	@Query(value = "SELECT * FROM tbl_student WHERE certificate_status = 1", nativeQuery = true)
	public List<Student> getActiveCertificateStatus();
	
	
	@Query(value = "SELECT * FROM tbl_student WHERE e_book_status = 1", nativeQuery = true)
	public List<Student> getActiveEBookStatus();
	
	
	@Query(value = "SELECT * FROM tbl_student WHERE source_code_status = 1", nativeQuery = true)
	public List<Student> getActiveSourceCodeStatus();
	
	
	@Query(value = "SELECT * FROM tbl_student WHERE enroll_status = 1", nativeQuery = true)
	public List<Student> getActiveEnRollStatus();


	
	
	
	

}