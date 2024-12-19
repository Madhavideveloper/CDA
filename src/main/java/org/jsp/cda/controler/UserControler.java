package org.jsp.cda.controler;

import org.jsp.cda.dto.AuthUser;
import org.jsp.cda.entity.User;
import org.jsp.cda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/users")
public class UserControler {
	@Autowired
private UserService service;
	@Operation(summary="this API will save the user data",description="will save the user data")
	@PostMapping
	public ResponseEntity<?> saveUser(@RequestBody User user){
		return service.saveUser(user);
	}
	@Operation(summary="this ApI Login Operation",description="This API will do login validation by accepting request body i.e auth userName and Password")
	@PostMapping("/login")
	public ResponseEntity<?> findByUserNameAndPassword(@RequestBody AuthUser auth){
		return service.findByUserNameAndPassword(auth);
	}
	@Operation(summary="this API find the User",description="the user data will save by ID")
	@GetMapping("/{id}")
	public ResponseEntity<?> fingUserById(@PathVariable int id){
		return service.findById(id);
	}
	@Operation(summary="This API will find all user data",description="we will get all the user data")
	@GetMapping
	public ResponseEntity<?> findAllUser(){
		return service.findAllUser();
	}
	@PatchMapping("/{id}/otp/{otp}")
	public ResponseEntity<?> verifyOTP(@PathVariable int id,@PathVariable int otp){
		return service.verifyOTP(id,otp);
	}
}
