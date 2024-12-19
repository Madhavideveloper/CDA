package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.exceptionclassess.InvalidIdException;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
private DepartmentDao dao;

	@Override
	public ResponseEntity<?> saveDept(Department dept) {
		dept=dao.saveDept(dept);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponceStructure.builder().httpStatus(HttpStatus.CREATED.value()).message("save sucessfully").body(dept).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Department> optional=dao.findById(id);
		if(optional.isEmpty()){
			throw InvalidIdException.builder().message("invalid id entered").build();
		}
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponceStructure.builder().httpStatus(id).message("data found by id").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAllDepartments() {
		List<Department> depadtment=dao.findAllDepartments();
		if(depadtment.isEmpty()) {
		throw new RuntimeException("Not found");
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponceStructure.builder()
				.httpStatus(HttpStatus.OK.value())
				.message("All departments found Successfully..")
				.body(depadtment).build());
	}

	@Override
	public ResponseEntity<?> deleteById(int id) {
		Optional<Department> optional=dao.findById(id);
		if(optional.isEmpty()) {
			throw new RuntimeException("invalid id entered");
		}
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponceStructure.builder().httpStatus(id).message("data deleted sucessfully").body(optional).build());
	}

	
	
	

	
}
