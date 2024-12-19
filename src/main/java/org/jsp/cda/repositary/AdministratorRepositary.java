package org.jsp.cda.repositary;

import org.jsp.cda.entity.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AdministratorRepositary  extends JpaRepository<Administrator, Integer>{

}
