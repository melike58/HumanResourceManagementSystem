package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserService {
	
	DataResult<List<CandidateUser>> getAll();
	
	
	

	Result add(CandidateUser candidateUser);
	
}
