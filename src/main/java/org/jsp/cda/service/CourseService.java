package org.jsp.cda.service;

import org.jsp.cda.entity.Course;
import org.springframework.http.ResponseEntity;

public interface CourseService {

	ResponseEntity<?> saveCourse(Course course);

	ResponseEntity<?> findById(int id);

	ResponseEntity<?> findAll();

	ResponseEntity<?> deleteCourseById(int id);

	ResponseEntity<?> assignFacultyToCourse(int cid, int fid);

	

	

	

}
