package org.jsp.cda.repositary;

import org.jsp.cda.entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface EnrolmentRepositary extends JpaRepository<Enrollment, Integer>{

}
