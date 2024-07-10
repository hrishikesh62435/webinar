package com.webinar.form.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.webinar.form.model.NotRegisterStudent;

public interface NotRegisterStudentRepository extends JpaRepository<NotRegisterStudent, Integer>{
	
	@Transactional
	@Modifying
	@Query(value="update tbl_not_Regi_student set enroll_status = 1 where student_id = :studentId", nativeQuery = true)
	public int updateEnrollStatus(@Param("studentId") int studentId);	
	
	@Query("SELECT s FROM NotRegisterStudent s")
	public List<NotRegisterStudent> getListUnRegisterStudent();

}