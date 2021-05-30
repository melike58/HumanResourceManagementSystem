package KodlamaIO.HRMS.business.concretes;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.CandidateUserService;
import KodlamaIO.HRMS.business.abstracts.EmailService;
import KodlamaIO.HRMS.business.concretes.checkHelper.UserCheckHelper;
import KodlamaIO.HRMS.business.validation.abstracts.CandidateUserValidatorService;
import KodlamaIO.HRMS.core.adapter.abstracts.UserCheckService;
import KodlamaIO.HRMS.core.utilities.business.BusinessEngine;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.dataAccess.abstracts.CandidateUserDao;
import KodlamaIO.HRMS.dataAccess.abstracts.UserDao;
import KodlamaIO.HRMS.entities.concretes.CandidateUser;

@Service
public class CandidateUserManager extends UserManager<CandidateUser> implements CandidateUserService{
	
	private CandidateUserDao candidateUserDao;
	private CandidateUserValidatorService candidateUserValidatorService;
	private UserCheckService userCheckService;
	private EmailService emailService;

	public CandidateUserManager(UserDao<CandidateUser> userDao,CandidateUserValidatorService candidateUserValidatorService,UserCheckService userCheckService,EmailService emailService) {
		super(userDao);
		this.candidateUserDao = (CandidateUserDao) userDao;
		this.candidateUserValidatorService = candidateUserValidatorService;
		this.userCheckService = userCheckService;
		this.emailService = emailService;
	}


	@Override
	public DataResult<List<CandidateUser>> getAll() {
		return new SuccessDataResult<List<CandidateUser>>(this.candidateUserDao.findAll(),"İş Arayanlar Listelendi");
	}


	@Override
	public Result add(CandidateUser candidateUser) {
		List<Result> results = new ArrayList<>();
		
		results.add(BusinessEngine.run(this.isUserReal(candidateUser.getIdentityNumber(),candidateUser.getFirstName(), candidateUser.getLastName(), candidateUser.getBirthDate())));
		results.add(BusinessEngine.run(super.existByEmail(candidateUser.getEmail())));
		results.add(BusinessEngine.run(this.checkIdentityNumber(candidateUser.getIdentityNumber())));
		results.add(BusinessEngine.run(candidateUserValidatorService.candidateUserCheckFields(candidateUser)));
		
		Result result = UserCheckHelper.checkLogicResults(results);
	    
		if(!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		this.candidateUserDao.save(candidateUser);
		return new SuccessResult(this.emailService.sendEmail(candidateUser).getMessage());
	}

	public Result checkIdentityNumber(String identityNumber) {
		var input = this.candidateUserDao.existsByIdentityNumber(identityNumber);
		
		if(input) {
			return new ErrorResult("Bu kimlik numarası sisteme kayıtlıdır");
		}
		return new SuccessResult("Doğrulama başarılı");
		
	}
	
	public Result isUserReal(String identityNumber,String firstName,String lastName,LocalDate birthDatte) {
		var input = this.userCheckService.checkRealPerson(identityNumber, firstName, lastName, birthDatte)  ;
		
		
		if(!input) {
			return new ErrorResult("Bu kullanıcı gerçek değil");
		}
		return new SuccessResult("Doğrulama Başarılı");
		
	}
	

}
