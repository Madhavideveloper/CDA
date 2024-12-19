package org.jsp.cda.repositary;

import org.jsp.cda.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface StudentRepositary extends JpaRepository<Student, Integer> {

}
