package org.jsp.cda.service;

import org.springframework.http.ResponseEntity;

public interface EnrolmentService {

	ResponseEntity<?> saveEnrollment(int cid, int sid);

	ResponseEntity<?> findEnrollemntByStudentId(int sid);

	ResponseEntity<?> findEnrolementsById(int id);

	ResponseEntity<?> findAllEnrolements();

}
