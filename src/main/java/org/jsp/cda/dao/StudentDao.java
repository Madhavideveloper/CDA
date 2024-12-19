package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Student;

public interface StudentDao {

	Optional<Student> findStudentById(int sid);

	Student saveStudent(Student student);

	List<Student> findAllStudent();

	

}
