package org.jsp.cda.service;

import org.jsp.cda.entity.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {

	ResponseEntity<?> saveStudent(Student student);

	ResponseEntity<?> findAllStudent();

	ResponseEntity<?> findStudentById(int id);

	ResponseEntity<?> assignDepartmentToStudent(int uid, int did);

	

}
