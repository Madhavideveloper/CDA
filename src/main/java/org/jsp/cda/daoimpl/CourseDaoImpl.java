package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.CourseDao;
import org.jsp.cda.entity.Course;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.repositary.CourseRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl implements CourseDao {
	@Autowired
	private CourseRepositary repositary;

	@Override
	public Course saveCourse(Course course) {

		return repositary.save(course);
	}

	@Override
	public Optional<Course> findCourseById(int id) {
		// TODO Auto-generated method stub
		return repositary.findById(id);
	}

	@Override
	public List<Course> findAllCourse() {
		
		return repositary.findAll();
	}

	

}
