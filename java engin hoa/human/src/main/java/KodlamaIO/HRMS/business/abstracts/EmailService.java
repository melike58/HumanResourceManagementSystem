package KodlamaIO.HRMS.business.abstracts;

import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.entities.concretes.User;

public interface EmailService {
	Result sendEmail(User User);
}
