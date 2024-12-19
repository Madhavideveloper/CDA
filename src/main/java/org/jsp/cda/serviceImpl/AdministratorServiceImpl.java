package org.jsp.cda.serviceImpl;

import org.jsp.cda.dao.AdministratorDao;
import org.jsp.cda.entity.Administrator;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	@Autowired
	private AdministratorDao dao;
	@Override
	public ResponseEntity<?> saveAdministrator(Administrator administrator) {
		administrator=	dao.saveAdministrator(administrator);
		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponceStructure.builder()
				.httpStatus(HttpStatus.OK.value()).message("Adminisrator added sucessfully").body(administrator).build());
	}

	

}
