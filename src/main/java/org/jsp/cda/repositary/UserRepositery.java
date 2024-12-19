package org.jsp.cda.repositary;

import java.util.Optional;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepositery extends JpaRepository<User, Integer>{

	

	Optional<User> findByUserNameAndPassword(String userName, String password);

	Optional<User> findUserByEmail(String email);

}
