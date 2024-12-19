package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.repositary.DepartmentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentDaoImpl implements DepartmentDao {
	@Autowired
	private DepartmentRepositary repositary;

	@Override
	public Department saveDept(Department dept) {
		// TODO Auto-generated method stub
		return repositary.save(dept);
	}

	@Override
	public Optional<Department> findById(int id) {

		return repositary.findById(id);
	}

	@Override
	public List<Department> findAllDepartments() {
		
		return repositary.findAll();
	}

	

	
	
}
