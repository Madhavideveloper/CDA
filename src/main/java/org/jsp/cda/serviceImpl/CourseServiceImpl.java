
package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclassess.InvalidIdException;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	private CourseDao dao;
	@Autowired
	private FacultyDao facultydao;

	@Override
	public ResponseEntity<?> saveCourse(Course course) {
		course = dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponceStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("course save suceessfully").body(course).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<Course> optional = dao.findCourseById(id);
		if (optional.isEmpty()) {
			throw InvalidIdException.builder().message("invali id enterd").build();
		}
		return ResponseEntity.status(HttpStatus.FOUND.value())
				.body(ResponceStructure.builder().httpStatus(id).message("data found by id").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<Course> course = dao.findAllCourse();
		if (course.isEmpty()) {
			throw new RuntimeException("no course is not there");
		}
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("All departments found Successfully..").body(course).build());
	}

	@Override
	public ResponseEntity<?> deleteCourseById(int id) {
		Optional<Course> optional = dao.findCourseById(id);
		if (optional.isEmpty()) {
			throw InvalidIdException.builder().message("invali id enterd").build();
		}
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponceStructure.builder().httpStatus(id)
				.message("Course deleted sucessfully").body(optional).build());
	}

	@Override
	public ResponseEntity<?> assignFacultyToCourse(int cid, int fid) {
		Optional<Faculty> optional1 = facultydao.findFacultyById(fid);
		if (optional1.isEmpty())
			throw new RuntimeException("invali course id" + fid);
		Optional<Course> optional2 = dao.findCourseById(fid);
		if (optional2.isEmpty())
			throw new RuntimeException("invalid course id" + cid);
		Faculty faculty = optional1.get();
		Course course = optional2.get();
		course.setFaculty(faculty);
		course = dao.saveCourse(course);
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(HttpStatus.OK.value())
				.message("faculty Assigned to course sucessfully").body(course).build());

	}
}
