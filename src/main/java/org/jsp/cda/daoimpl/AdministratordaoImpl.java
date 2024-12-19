package org.jsp.cda.daoimpl;

import org.jsp.cda.dao.AdministratorDao;
import org.jsp.cda.entity.Administrator;
import org.jsp.cda.entity.Course;
import org.jsp.cda.repositary.AdministratorRepositary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdministratordaoImpl implements AdministratorDao {
	@Autowired
private AdministratorRepositary repositary;

	@Override
	public Administrator saveAdministrator(Administrator administrator) {
	
		return repositary.save(administrator);
	}

	
}
