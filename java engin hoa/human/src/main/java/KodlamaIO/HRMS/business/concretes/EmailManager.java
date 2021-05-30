package KodlamaIO.HRMS.business.concretes;

import org.springframework.stereotype.Component;

import KodlamaIO.HRMS.business.abstracts.EmailService;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.entities.concretes.User;

@Component
public class EmailManager implements EmailService{

	@Override
	public Result sendEmail(User User) {
		return new SuccessResult("Email Gönderildi");
	}

}
