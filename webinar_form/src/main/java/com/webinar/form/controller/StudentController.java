package com.webinar.form.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itextpdf.text.DocumentException;
import com.webinar.form.config.UserPDFExporter;
import com.webinar.form.model.NotRegisterStudent;
import com.webinar.form.model.Student;
import com.webinar.form.repository.NotRegisterStudentRepository;
import com.webinar.form.repository.StudentRepository;
import com.webinar.form.utilities.DateTimeUtil;

@Controller
public class StudentController {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	NotRegisterStudentRepository notRegisterStudentRepository ;
	
	@GetMapping("/")
	public String studentLogin(Model model) {
	
		return "registration-page"; 
	}
	
	
	@GetMapping("/download-document")
	public String addBeneficiary( Model model) {
		
		return "download-document";
	}
	
	@GetMapping("/not-register")
	public String notRegister( Model model) {
		
		return "not-registed-student";
	}
	
	 @GetMapping("/certificate/{studentId}")
     public void exportToPDF(HttpServletResponse response, @PathVariable int studentId) throws DocumentException, IOException {
		 
         response.setContentType("application/pdf");
                 
         String headerKey = "Content-Disposition";
         String headerValue = "attachment; filename=certificate.pdf"; 
         response.setHeader(headerKey, headerValue);
          
         String studentName = studentRepository.getStudentNameByStudentId(studentId);           
         UserPDFExporter exporter = new UserPDFExporter();
         exporter.export(response, studentName);
     }
	
	
	
	@PostMapping("/register-student")
	public String registerStudent(Student student, NotRegisterStudent NotRegisterStudent, RedirectAttributes attributes) {
		
		Student studentByMobileNumber = studentRepository.getStudentByMobileNumber(student.getStudentMobileNumber());
		
		 if (studentByMobileNumber != null) {
	    	 	
			 studentByMobileNumber.setStudentCollegeName(student.getStudentCollegeName());
			 studentByMobileNumber.setStudentCity(student.getStudentCity());
			 studentByMobileNumber.setStudentName(student.getStudentName());
			 studentByMobileNumber.setRegistrationDatetime(DateTimeUtil.getSysDateTime());
			 studentByMobileNumber.setStudentStatus(1);
			 
			 studentRepository.save(studentByMobileNumber);
			 attributes.addFlashAttribute("studentId", studentByMobileNumber.getStudentId());
			 
			 return "redirect:/download-document";
			 
		 }else{
				 
				 NotRegisterStudent notRegisterStudent = new NotRegisterStudent();
				 
				 notRegisterStudent.setStudentName(student.getStudentName());
				 notRegisterStudent.setStudentMobileNumber(student.getStudentMobileNumber());
				 notRegisterStudent.setStudentCollegeName(student.getStudentCollegeName());
				 notRegisterStudent.setStudentCity(student.getStudentCity());
				 notRegisterStudent.setRegistrationDatetime(DateTimeUtil.getSysDateTime());
				 
				 NotRegisterStudent unregistedStudent = notRegisterStudentRepository.save(notRegisterStudent);
				 
				 attributes.addFlashAttribute("studentId", unregistedStudent.getStudentId());
				 attributes.addFlashAttribute("error", "true");
				 
				 return "redirect:/";				 
		 }		
	}
	
	@GetMapping("/updateCertificateStatus")
	public @ResponseBody String updateCertificateStatus(@RequestParam int studentId) {
			
		  studentRepository.updateCertificateStatus(studentId);
		   
		  return "updateCertificateStatus for studentId ="+studentId;
	}
	
	@GetMapping("/updateEnrollStatus")
	public @ResponseBody String updateEnrollStatus(@RequestParam int studentId) {
			
		  studentRepository.updateEnrollStatus(studentId);
		   
		  return "updateEnrollStatus for studentId ="+studentId;
	}
	
	@GetMapping("/updateEBookStatus")
	public @ResponseBody String updateEBookStatus(@RequestParam int studentId) {
			
		  studentRepository.updateEBookStatus(studentId);
		   
		  return "updateEBookStatus for studentId ="+studentId;
	}
	
	@GetMapping("/updateSourceCodeStatus")
	public @ResponseBody String updateSourceCodeStatus(@RequestParam int studentId) {
			
		  studentRepository.updateSourceCodeStatus(studentId);
		   
		  return "updateSourceCodeStatus for studentId ="+studentId;
	}
	
	@GetMapping("/updateEnrollStatusUnregisted")  
	public @ResponseBody String updateEnrollStatusUnregisted(@RequestParam int studentId) {
			
		  notRegisterStudentRepository.updateEnrollStatus(studentId);
		   
		  return "updateEnrollStatusUnregisted for studentId ="+studentId;
	}
	
	@GetMapping("/registeredList")
	public String registeredList(@RequestParam(value = "status", defaultValue = "0") int status,Student student, Model model){
		
		List<Student> listRegisterStudent = studentRepository.getListRegisterStudent();
		List<Student> activeCertificateStatus = studentRepository.getActiveCertificateStatus();
		List<Student> activeEBookStatus = studentRepository.getActiveEBookStatus();
		List<Student> activeSourceCodeStatus = studentRepository.getActiveSourceCodeStatus();
		List<Student> activeEnRollStatus = studentRepository.getActiveEnRollStatus();
		
		System.out.println(activeCertificateStatus);
		
		model.addAttribute("listRegisterStudent", listRegisterStudent);
		model.addAttribute("activeCertificateStatus", activeCertificateStatus);
		model.addAttribute("activeEBookStatus", activeEBookStatus);
		model.addAttribute("activeSourceCodeStatus", activeSourceCodeStatus);
		model.addAttribute("activeEnRollStatus", activeEnRollStatus);
		model.addAttribute("status", status);
		
		
		return "registered-list";

	}
	
	@GetMapping("/notregisteredList")
	public String unRegisteredList(NotRegisterStudent student, Model model) {
		
		List<NotRegisterStudent> listUnRegisterStudent = notRegisterStudentRepository.getListUnRegisterStudent();
		
		model.addAttribute("listUnRegisterStudent", listUnRegisterStudent);
		
		return "unregistered-list";
	}
}