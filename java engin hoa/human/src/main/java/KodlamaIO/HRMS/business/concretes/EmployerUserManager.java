
package KodlamaIO.HRMS.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.EmailService;
import KodlamaIO.HRMS.business.abstracts.EmployerUserService;
import KodlamaIO.HRMS.business.concretes.checkHelper.UserCheckHelper;
import KodlamaIO.HRMS.business.validation.abstracts.EmployerUserValidatorService;
import KodlamaIO.HRMS.core.utilities.business.BusinessEngine;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.dataAccess.abstracts.EmployerUserDao;
import KodlamaIO.HRMS.dataAccess.abstracts.UserDao;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;

@Service
public class EmployerUserManager extends UserManager<EmployerUser> implements EmployerUserService {

	private EmployerUserDao employerUserDao;
	private EmployerUserValidatorService employerUserValidatorService;
	private EmailService emailService;

	@Autowired
	public EmployerUserManager(UserDao<EmployerUser> userDao, EmployerUserValidatorService employerUserValidatorService,
			EmailService emailService) {
		super(userDao);
		this.employerUserDao = (EmployerUserDao) userDao;
		this.employerUserValidatorService = employerUserValidatorService;
		this.emailService = emailService;
	}

	@Override
	public DataResult<List<EmployerUser>> getAll() {
		return new SuccessDataResult<List<EmployerUser>>(this.employerUserDao.findAll(), "Employers are listed.");
	}

	@Override
	public Result add(EmployerUser employerUser) {
		List<Result> results = new ArrayList<>();
		results.add(BusinessEngine.run(super.existByEmail(employerUser.getEmail())));
		results.add(BusinessEngine.run(this.employerUserValidatorService.employerUserCheckFields(employerUser)));
		results.add(BusinessEngine.run(this.employerUserValidatorService.isEmailCheck(employerUser)));

		Result result = UserCheckHelper.checkLogicResults(results);

		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}

		this.employerUserDao.save(employerUser);
		return new SuccessResult(this.emailService.sendEmail(employerUser).getMessage());
	}

}