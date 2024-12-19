package org.jsp.cda.repositary;

import org.jsp.cda.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface CourseRepositary extends JpaRepository<Course, Integer> {

}
