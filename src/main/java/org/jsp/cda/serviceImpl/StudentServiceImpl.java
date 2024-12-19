package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.DepartmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Student;
import org.jsp.cda.entity.User;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao stddao;
	@Autowired
	private UserDao userdao;
	private DepartmentDao deptdao;

	@Override
	public ResponseEntity<?> saveStudent(Student student) {
     student=stddao.saveStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponceStructure.builder().httpStatus(HttpStatus.CREATED.value()).message("Added successfully").body(student).build());
	}

	@Override
	public ResponseEntity<?> findAllStudent() {
		List<Student> student=stddao.findAllStudent();
		if(student.isEmpty())
			throw new RuntimeException("no student found");
		return ResponseEntity.status(HttpStatus.OK)
				.body(ResponceStructure.builder()
						.httpStatus(HttpStatus.OK.value())
						.message("all Student found sucessfully")
						.body(student).build());
	}

	@Override
	public ResponseEntity<?> findStudentById(int id) {
		Optional<Student> optional=stddao.findStudentById(id);
		if(optional.isEmpty())
			throw new RuntimeException(" invalid Student id Exception");
		  Student student=optional.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(id).message("student found sucessfully").body(student).build());
	}

	@Override
	public ResponseEntity<?> assignDepartmentToStudent(int uid, int did) {
		Optional<Department> optional1=deptdao.findById(did);
		if(optional1.isEmpty())
			throw new RuntimeException(" invalid department id entered");
		Department department=optional1.get();
		Optional<User> optional2=userdao.findById(uid);
		if(optional2.isEmpty())
			throw new RuntimeException("invalid user id exception");
		User user=optional2.get();
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(HttpStatus.OK.value()).message("department assigned to student sucessfully").build());
	}

}
