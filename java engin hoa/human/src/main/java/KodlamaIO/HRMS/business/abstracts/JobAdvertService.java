package KodlamaIO.HRMS.business.abstracts;

import java.time.LocalDate;
import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.JobAdvert;

public interface JobAdvertService {
	
	DataResult<List<JobAdvert>> getAll();
	DataResult<List<JobAdvert>> getByIsActiveTrue();
	DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDesc( );
	DataResult<List<JobAdvert>> findByIsActiveAndEmployerCompany(int employerId);
	
	
	Result add(JobAdvert jobAdvert);
	Result update(JobAdvert jobAdvert);
	Result delete(JobAdvert jobAdvert);


}
