package org.jsp.cda.daoimpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.jsp.cda.repositary.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
	@Autowired
private UserRepositery repositary;


	@Override
	public Optional<User> findByUserNameAndPassword(String userName, String password) {
		// TODO Auto-generated method stub
		return repositary.findByUserNameAndPassword(userName,password);
	}


	@Override
	public User saveUser(User user) {
		
		return repositary.save(user);
	}


	@Override
	public Optional<User> findById(int id) {
		
		return repositary.findById(id);
	}


	@Override
	public List<User> findAllUser() {
	
		return repositary.findAll();
	}


	@Override
	public Optional<User> verifyOTP(int id, int otp) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}


	@Override
	public Optional<User> findUserByEmail(String email) {
	
		return repositary.findUserByEmail(email);
	}

	
}
