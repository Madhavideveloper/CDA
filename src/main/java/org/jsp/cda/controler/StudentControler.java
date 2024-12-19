package org.jsp.cda.controler;

import org.jsp.cda.entity.Student;
import org.jsp.cda.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;

@Controller
public class StudentControler {
	private StudentService stdservice;
	@Operation(summary="it will do save all the students ",description="to do saving all students here")
	@PostMapping
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		return stdservice.saveStudent(student);

	}
	@Operation(summary="it will use to find all studentd",description="it wiil use to find all the users data")
	@GetMapping
	public ResponseEntity<?> findAllStudent() {
		return stdservice.findAllStudent();
	}
	@Operation(summary="it will use to find the student data by id",description="we can find student by ID ")
	@GetMapping("/{id}")
	public ResponseEntity<?> findStudentById(@PathVariable int id) {
		return stdservice.findStudentById(id);
	}
	@Operation(summary="assigin department to student")
	@PatchMapping("/year/{uid}/{did}")
	public ResponseEntity<?> assignDepartmentToStudent(@PathVariable int uid, @PathVariable int did) {
		return stdservice.assignDepartmentToStudent(uid, did);
	}
}
