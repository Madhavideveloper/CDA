package org.jsp.cda.service;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

	
	ResponseEntity<?> saveUser(User user);
	ResponseEntity<?> findByUserNameAndPassword(AuthUser auth);
	ResponseEntity<?> findById(int id);
	ResponseEntity<?> findAllUser();
	ResponseEntity<?> verifyOTP(int id, int otp);
	ResponseEntity<?> findUserByEmail(String email);

	

}
