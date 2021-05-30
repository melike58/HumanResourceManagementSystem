package KodlamaIO.HRMS.business.abstracts;


import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByIsActiveTrue();
	DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDesc( );
	DataResult<List<JobAdvert>> getByIsActiveAndEmployerCompany(int id);
	
	
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(int id);
	Result isActiveChange(int id);


}
