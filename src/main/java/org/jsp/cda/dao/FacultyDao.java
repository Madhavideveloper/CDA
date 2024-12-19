package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;

public interface FacultyDao {

	void assignFacultyToCourse(int fid);

	Optional<Faculty> findFacultyById(int fid);

	Faculty saveFaculty(Faculty faculty);

	Optional<Faculty> findFactultyById(int fid);

	List<Faculty> findAllFaculty();

	Optional<Department> findDepartmentById(int did);

}
