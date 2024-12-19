package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;
import org.springframework.http.ResponseEntity;

public interface DepartmentDao {

	Department saveDept(Department dept);

	Optional<Department> findById(int id);

	List<Department> findAllDepartments();

	
	

	


	

}
