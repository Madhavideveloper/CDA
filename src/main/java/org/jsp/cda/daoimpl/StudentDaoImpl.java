package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.entity.Student;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl implements StudentDao {
private StudentDao studentdao;

@Override
public Optional<Student> findStudentById(int sid) {
	
	return studentdao.findStudentById(sid);
}

@Override
public Student saveStudent(Student student) {
      
	return studentdao.saveStudent(student);
}

@Override
public List<Student> findAllStudent() {
	
	return studentdao.findAllStudent();
}
}
