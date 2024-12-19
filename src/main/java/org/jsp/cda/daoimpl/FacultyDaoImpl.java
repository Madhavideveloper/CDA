package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repositary.FacultyRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FacultyDaoImpl implements FacultyDao {
	@Autowired
	private FacultyRepositary facultyrepositary;

	@Override
	public void assignFacultyToCourse(int fid) {
	
		
	}

	@Override
	public Optional<Faculty> findFacultyById(int fid) {
	
		return facultyrepositary.findById(fid);
	}

	@Override
	public Faculty saveFaculty(Faculty faculty) {
		
		return facultyrepositary.save(faculty);
	}

	@Override
	public Optional<Faculty> findFactultyById(int fid) {
		
		return facultyrepositary.findById(fid);
	}

	@Override
	public List<Faculty> findAllFaculty() {

		return facultyrepositary.findAll();
	}

	@Override
	public Optional findDepartmentById(int did) {
		
		return facultyrepositary.findById(did);
	}

}
