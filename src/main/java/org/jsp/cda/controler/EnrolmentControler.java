package org.jsp.cda.controler;

import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/enrollments")
public class EnrolmentControler {
	@Autowired
	private EnrolmentService enroleservice;

	@PostMapping("/{uid}/{sid}")
	public ResponseEntity<?> saveEnrollment(@PathVariable int cid, @PathVariable int sid) {
		return enroleservice.saveEnrollment(cid, sid);
	}

	@GetMapping("/student/{sid}")
	public ResponseEntity<?> findEnrollemntByStudentId(@PathVariable int sid) {
		return enroleservice.findEnrollemntByStudentId(sid);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findEnrolementsById(@PathVariable int id) {
		return enroleservice.findEnrolementsById(id);
	}

	@GetMapping
	public ResponseEntity<?> findAllEnrolements(@RequestBody Enrollment enrolement) {
		return enroleservice.findAllEnrolements();
	}

}
