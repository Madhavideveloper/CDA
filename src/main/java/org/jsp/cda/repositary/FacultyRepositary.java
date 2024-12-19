package org.jsp.cda.repositary;

import org.jsp.cda.entity.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface FacultyRepositary extends JpaRepository<Faculty, Integer> {

}
