package org.jsp.cda.controler;

import org.jsp.cda.entity.Administrator;
import org.jsp.cda.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;

@Controller
@RequestMapping("/admin")
public class AdministratorControler {
	@Autowired
private AdministratorService service;
	@Operation(summary="i will do save administration",description="for saving the administrators data")
	@PostMapping
	public ResponseEntity<?> saveAdministrator(@RequestBody Administrator administrator){
		return service.saveAdministrator(administrator);
	}
}
