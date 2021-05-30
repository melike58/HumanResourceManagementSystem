package KodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.EmployeeUserService;
import KodlamaIO.HRMS.business.concretes.checkHelper.EmployeeUserCheckHelper;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.dataAccess.abstracts.EmployeeUserDao;
import KodlamaIO.HRMS.entities.concretes.EmployeeUser;
import KodlamaIO.HRMS.entities.concretes.EmployerUser;


@Service
public class EmployeeUserManager implements EmployeeUserService{

	private EmployeeUserDao employeeUserDao;
	
	@Autowired
	public EmployeeUserManager(EmployeeUserDao employeeUserDao) {
		super();
		this.employeeUserDao = employeeUserDao;
	}

	@Override
	public DataResult<List<EmployeeUser>> getAll() {
		return new SuccessDataResult<List<EmployeeUser>>(this.employeeUserDao.findAll(),"İşçiler Eklendi");
	}

	@Override
	public DataResult<Boolean> verifyEmployer(EmployeeUser employeeUser, EmployerUser employerUser) {
		return new SuccessDataResult<Boolean>(EmployeeUserCheckHelper.verifyEmployer(employerUser));
		
	}

}
