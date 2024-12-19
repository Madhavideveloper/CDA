package org.jsp.cda.service;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentService {

	ResponseEntity<?> saveDept(Department dept);

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> findAllDepartments();

	ResponseEntity<?> deleteById(int id);

	


	




}
