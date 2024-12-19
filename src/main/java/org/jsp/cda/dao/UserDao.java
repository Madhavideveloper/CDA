package org.jsp.cda.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;

public interface UserDao {
	User saveUser(User user);
	Optional<User> findByUserNameAndPassword(String userName, String password);
	Optional<User> findById(int id);
	List<User> findAllUser();
	Optional<User> verifyOTP(int id, int otp);




	


	

}
