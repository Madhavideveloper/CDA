package org.jsp.cda.controler;

import org.jsp.cda.entity.Course;
import org.jsp.cda.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/course")
public class CourseControler {
	@Autowired
	private CourseService service;
	@Operation(summary="it will do the save coursees",description="for saving the course data")

	@PostMapping
	public ResponseEntity<?> saveCourse(@RequestBody Course course) {
		return service.saveCourse(course);
	}
	@Operation(summary="it will do find course by Id",description="for finding the course by id")
	@GetMapping("/{id}")
	public ResponseEntity<?> findCourseById(@PathVariable int id) {
		return service.findById(id);
	}
	@Operation(summary="it will find all the coursess")
	@GetMapping
	public ResponseEntity<?> findAllCourse() {
		return service.findAll();
	}
	@Operation(summary="it will do delete the course by id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCourseById(@PathVariable int id){
		return service.deleteCourseById(id);
	}
	@Operation(summary="it will assign faculty to course")
	@PatchMapping(value="/{cid}/{fid}")
	public ResponseEntity<?> assignFacultyToCourse(@PathVariable int cid,@PathVariable int fid){
	return service.assignFacultyToCourse(cid,fid);
}
}
