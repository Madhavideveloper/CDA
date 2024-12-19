package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.entity.User;

public interface EnrolmentDao {

	Optional<Enrollment> findEnrolementsById(int id);

	List<Enrollment> findEnrolements();

	

}
