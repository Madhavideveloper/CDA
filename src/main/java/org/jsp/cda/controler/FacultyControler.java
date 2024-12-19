package org.jsp.cda.controler;

import org.jsp.cda.entity.Faculty;
import org.jsp.cda.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/faculty")
public class FacultyControler {
	@Autowired
	private FacultyService facultyservice;

	@PostMapping
	public ResponseEntity<?> saveFaculty(@RequestBody Faculty faculty) {
		return facultyservice.saveFaculty(faculty);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findFacultyById(@PathVariable int fid) {

		return facultyservice.findFacultyById(fid);
	}

	@GetMapping
	public ResponseEntity<?> findAllFaculty() {

		return facultyservice.findAllFaculty();
	}
	@PatchMapping("/{fid}/{did}")
	public ResponseEntity<?> setDepartmentToFaculty(@PathVariable int fid,@PathVariable int did){
		return facultyservice.setDepartmentToFaculty(fid,did);
	}
}
