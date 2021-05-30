package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.entities.concretes.EmployeeUser;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

public interface EmployeeUserService {
	
	DataResult<List<EmployeeUser>> getAll();
	DataResult<Boolean> verifyEmployer(EmployeeUser employeeUser,EmployerUser employerUser);

}
