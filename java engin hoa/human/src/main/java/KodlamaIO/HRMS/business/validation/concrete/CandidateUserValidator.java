package KodlamaIO.HRMS.business.validation.concrete;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import KodlamaIO.HRMS.business.validation.abstracts.CandidateUserValidatorService;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.entities.concretes.CandidateUser;

@Component
public class CandidateUserValidator extends UserValidator implements CandidateUserValidatorService {

	@Override
	public Result candidateUserCheckFields(CandidateUser candidateUser) {
		
		String firstName = candidateUser.getFirstName();
		String lastName = candidateUser.getLastName();
		String identityNumber = candidateUser.getIdentityNumber();
		LocalDate birthDate = candidateUser.getBirthDate();
		
		if(!super.userCheckFields(candidateUser).isSuccess() || (firstName == null || firstName.isBlank()) || (lastName == null || lastName.isBlank())
				|| (identityNumber == null || identityNumber.isBlank() || identityNumber.length() != 11) || (birthDate == null || birthDate.toString().isBlank())) {
			return new ErrorResult("All fields need to be filled.");
		}
		return new SuccessResult();
		
	}

}
