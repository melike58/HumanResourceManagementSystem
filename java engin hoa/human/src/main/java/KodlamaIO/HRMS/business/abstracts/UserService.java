package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.User;

public interface UserService<T extends User> {
	
	DataResult<List<T>> getAll();
	Result add(T user);

}
