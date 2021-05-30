package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.Job;

public interface JobService {
	
	DataResult<List<Job>> getAll();
	DataResult<List<Job>> findByPosition(String position);

	Result add(Job job);

}
