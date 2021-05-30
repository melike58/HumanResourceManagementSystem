package KodlamaIO.HRMS.business.validation.abstracts;

import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserValidatorService {
	
	Result candidateUserCheckFields(CandidateUser candidateUser);

}
