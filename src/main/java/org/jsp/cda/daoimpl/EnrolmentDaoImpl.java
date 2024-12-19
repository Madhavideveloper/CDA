package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.EnrolmentDao;
import org.jsp.cda.entity.Enrollment;
import org.jsp.cda.repositary.EnrolmentRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EnrolmentDaoImpl implements EnrolmentDao {
	@Autowired
	private EnrolmentRepositary enrolrepositary;

	@Override
	public Optional<Enrollment> findEnrolementsById(int id) {
	
		return enrolrepositary.findById(id);
	}

	@Override
	public List<Enrollment> findEnrolements() {
		
		return enrolrepositary.findAll();
	}
}
