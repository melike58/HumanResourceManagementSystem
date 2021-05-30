package KodlamaIO.HRMS.business.validation.abstracts;

import KodlamaIO.HRMS.core.utilities.results.Result;

import KodlamaIO.HRMS.entities.concretes.EmployerUser;

public interface EmployerUserValidatorService {
	Result employerUserCheckFields(EmployerUser employerUser);
	Result isEmailCheck(EmployerUser employerUser);
}
