package KodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.UserService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
import KodlamaIO.HRMS.dataAccess.abstracts.UserDao;
import KodlamaIO.HRMS.entities.concretes.User;

@Service
public class UserManager<T extends User> implements UserService<T>{
	
	private UserDao<T> userDao;
	
	@Autowired
	public UserManager(UserDao<T> userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<List<T>> getAll() {
		return new SuccessDataResult<List<T>>(this.userDao.findAll());
	}

	@Override
	public Result add(T user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanıcı eklendi");
	}
	
	public Result existByEmail(String email) {
		var input = this.userDao.existsByEmail(email);
		
		if(input) {
			return new ErrorResult("Bu email sisteme kayıtlı");
			
		}
		return new SuccessResult("Doğrulama Başarılı");
	}

}
