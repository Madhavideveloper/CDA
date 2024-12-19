package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.EnrolmentDao;
import org.jsp.cda.dao.StudentDao;
import org.jsp.cda.dao.UserDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.entity.Student;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.EnrolmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EnrolementServiceImpl implements EnrolmentService {
	@Autowired
	private EnrolmentDao enroldao;
	@Autowired
	private CourseDao coursedao;
	@Autowired
	private StudentDao stddao;
	@Override
	public ResponseEntity<?> saveEnrollment(int cid, int sid) {
         Optional<Course> optional= coursedao.findCourseById(cid);
         Optional<Student> optional2=stddao.findStudentById(sid);
         if(optional.isEmpty())
        	 throw new RuntimeException("invalid Enrolement CourseId Exception");
         if(optional2.isEmpty())
        	 throw new RuntimeException("invalid Enrolement StudentId Eception");
         Course course=optional.get();
         Student student=optional2.get();
         
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(sid));
	}
	@Override
	public ResponseEntity<?> findEnrollemntByStudentId(int sid) {
		
		return null;
	}
	@Override
	public ResponseEntity<?> findEnrolementsById(int id) {
		Optional<Enrollment> optional=enroldao.findEnrolementsById(id);
		if(optional.isEmpty())
			throw new RuntimeException("invali enrolement id");
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().message("no enrolement found by this id").build());
	}
	@Override
	public ResponseEntity<?> findAllEnrolements() {
	List<Enrollment> enrolements=enroldao.findEnrolements();
	if(enrolements.isEmpty())
		throw new RuntimeException("invalid enrolement found");
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(HttpStatus.OK.value()).message("all enrollments found sucessfully").body(enrolements).build());
	}


}
