package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.UserDao;
import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.jsp.cda.exceptionclassess.InvalidCredentialsException;
import org.jsp.cda.exceptionclassess.InvalidIdException;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.UserService;
import org.jsp.cda.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.status.Status;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao dao;
	@Autowired
	private JavaMailSender jms;

	@Override
	public ResponseEntity<?> saveUser(User user) {
		user.setOtp(MyUtil.getOtp());
		user=dao.saveUser(user);
		MimeMessage mimemessage=jms.createMimeMessage();
		try {
			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimemessage, true);
			mimeMessageHelper.addTo(user.getEmail());
			mimeMessageHelper.setSubject("Account Created...");
			//mimeMessageHelper.setText("Hello "+user.getName()+"CDA Account Created Sucessfully...");
			//mimeMessageHelper.setText("<html><body style='background':green;><h1>Hello "+user.getName()+"Your CDA Account created sucessfully... </h1> <br> <br> your otp: "+MyUtil.getOTP()+"</body></html>",true);
			mimeMessageHelper.setText("<html><body style='background':blue; 'color':black;><h1>Hello "+user.getName()+"Your CDA Account created sucessfully... </h1> <br> <br> your otp: "+user.getOtp()+"</body></html>",true);

			jms.send(mimemessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(ResponceStructure.builder().httpStatus(HttpStatus.CREATED.value()).message("Added successfully").body(user).build());
	}

	@Override
	public ResponseEntity<?> findByUserNameAndPassword(AuthUser auth) {
		Optional<User> optional=dao.findByUserNameAndPassword(auth.getUserName(),auth.getPassword());
		if(optional.isEmpty()) {
			throw InvalidCredentialsException.builder().message("inavali login credentials").build();
		}
		return ResponseEntity.status(HttpStatus.FOUND.value()).body(ResponceStructure.builder().httpStatus(HttpStatus.FOUND.value()).message("Login sucessfully").body(optional.get()).build());
	}

	@Override
	public ResponseEntity<?> findById(int id) {
		Optional<User> optional=dao.findById(id);
		if(optional.isEmpty())
			throw InvalidIdException.builder().message("invalid id enterded").build();
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder()
				.httpStatus(id).message("user data found sucessfully By ID").body(optional).build());
	}

	@Override
	public ResponseEntity<?> findAllUser() {
		List<User> user=dao.findAllUser();
		if(user.isEmpty()) {
			throw InvalidIdException.builder().message("invali id enterded").build();
		}
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(ResponceStructure.builder()
				.httpStatus(HttpStatus.OK.value())
				.message("All departments found Successfully..")
				.body(user).build());
	}

	@Override
	public ResponseEntity<?> verifyOTP(int id, int otp) {
		Optional<User> optional=dao.verifyOTP(id,otp);
		if(optional.isEmpty())
			throw InvalidIdException.builder().message("invalid id unable to verify otp").build();
		User user=optional.get();
		if(otp!=user.getOtp())
			throw new RuntimeException("invalid otp entered it is incorrect");
//		user.setUserstatus(null);
		user=dao.saveUser(user);
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder().httpStatus(otp).message("otp verified sucessfully").build());
	}

	@Override
	public ResponseEntity<?> findUserByEmail(String email) {
		Optional<User> optional=dao.findUserByEmail(email);
		if(optional.isEmpty())
			throw new RuntimeException("invalid email exception");
		return ResponseEntity.status(HttpStatus.OK).body(ResponceStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("user data found sucessfully By ID").body(optional).build());
				
	}

}
