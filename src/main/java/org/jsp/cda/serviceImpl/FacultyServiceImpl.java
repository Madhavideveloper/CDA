package org.jsp.cda.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.jsp.cda.dao.FacultyDao;
import org.jsp.cda.entity.Department;
import org.jsp.cda.entity.Faculty;
import org.jsp.cda.exceptionclassess.InvalidIdException;
import org.jsp.cda.responcestructure.ResponceStructure;
import org.jsp.cda.service.FacultyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;

@Service
public class FacultyServiceImpl implements FacultyService {
	private FacultyDao facultydao;

	@Override
	public ResponseEntity<?> saveFaculty(Faculty faculty) {
		faculty = facultydao.saveFaculty(faculty);

		return ResponseEntity.status(HttpStatus.FOUND).body(
				ResponceStructure.builder().httpStatus(HttpStatus.OK.value()).message("faculty found sucessfully.."));
	}

	@Override
	public ResponseEntity findFacultyById(int fid) {

		Optional<Faculty> optional = facultydao.findFactultyById(fid);

		if (optional.isEmpty()) {

			throw InvalidIdException.builder().message("invalid id").build();

		}

		return ResponseEntity.status(HttpStatus.OK.value()).body(ResponceStructure.builder().

				httpStatus(HttpStatus.OK.value()).

				message("find faculty by id successfully").body(optional.get()).build());

	}

	@Override
	public ResponseEntity findAllFaculty() {
		List<Faculty> list = facultydao.findAllFaculty();
		
	        if(list.isEmpty()) {
				throw new RuntimeException("no faculty found");

	        	
	        }
	            return ResponseEntity.status(HttpStatus.OK.value()).
	    				body(ResponceStructure.builder().
	    	
	    						httpStatus(HttpStatus.OK.value()).
	
	    						message("found all faculty successfully").body(list).build());
	    		
	}

	@Override
	public ResponseEntity<?> setDepartmentToFaculty(int fid, int did) {
		
		Optional<Faculty> fac = facultydao.findFactultyById(fid);
		
		if(fac.isEmpty()){
			throw InvalidIdException.builder().message("invalid id").build();

		}
		
		Optional<Department> dep = facultydao.findDepartmentById(did);
		
		if(dep.isEmpty()) {
			throw InvalidIdException.builder().message("invalid id").build();

			
		}
		Faculty f = fac.get();
		Department d = dep.get();
		
		f.setDepartment(d);
		facultydao.saveFaculty(f);
		return ResponseEntity.status(HttpStatus.OK.value()).
				body(ResponceStructure.builder().
	
						httpStatus(HttpStatus.OK.value()).

						message("find course successfully").body(f).build());
		
		
	}
}
