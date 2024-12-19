package org.jsp.cda.repositary;

import org.jsp.cda.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface DepartmentRepositary extends JpaRepository<Department, Integer>{


	

}
