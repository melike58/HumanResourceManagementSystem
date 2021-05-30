package KodlamaIO.HRMS.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.JobAdvertService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.dataAccess.abstracts.JobAdvertDao;
import KodlamaIO.HRMS.entities.concretes.JobAdvert;

@Service
public class JobAdvertManager implements JobAdvertService {
	
	public JobAdvertDao jobAdvertDao;

	@Autowired
	public JobAdvertManager(JobAdvertDao jobAdvertDao) {
		super();
		this.jobAdvertDao = jobAdvertDao;
	}

	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"İş İlanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveTrue() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveTrue(),"Tüm Aktif İş İlanları listelendi");
	}

	

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveAndEmployerCompany(int employerId) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveAndEmployerCompany(employerId),"Bu firmaya ait tüm aktif iş ilnları");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult("İş ilanı eklendi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessDataResult("İş ilanı güncellendi");
	}

	@Override
	public Result delete(JobAdvert jobAdvert) {
		this.jobAdvertDao.delete(jobAdvert);
		return new SuccessDataResult("İş ilanı silindi");
	}

	@Override
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDesc() {
		
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueOrderByPublishDateDesc(),"Tüm aktif iş ilanları tarihe göre listelendi");
		}
	

	

}
