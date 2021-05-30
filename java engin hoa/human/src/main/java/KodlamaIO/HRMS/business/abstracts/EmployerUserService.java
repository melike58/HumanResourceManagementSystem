package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserService {

	DataResult<List<EmployerUser>> getAll();
	
	Result add(EmployerUser employerUser);
}
