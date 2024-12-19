package org.jsp.cda.controler;

import org.jsp.cda.entity.Department;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dept")
public class DepartmentControler {
	@Autowired
private DepartmentService service;
	@PostMapping
	public ResponseEntity<?> saveDept(@RequestBody Department dept){
		return service.saveDept(dept);
	}
	@GetMapping("/{id}")
	public ResponseEntity<?>findById(@PathVariable int id){
		return service.findById(id);
	}
	@GetMapping
	public ResponseEntity<?> findAllDepartments(){
		return service.findAllDepartments();
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}

}
