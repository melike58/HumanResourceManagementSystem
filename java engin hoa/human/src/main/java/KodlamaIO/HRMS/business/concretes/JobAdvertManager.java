package KodlamaIO.HRMS.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.JobAdvertService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.ErrorResult;
import KodlamaIO.HRMS.core.utilities.results.Result;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessResult;
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
	public DataResult<List<JobAdvert>> findByIsActiveTrueOrderByPublishDesc() {
		
			return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findByIsActiveTrueOrderByPublishDateDesc(),"Tüm aktif iş ilanları tarihe göre listelendi");
		}

	@Override
	public DataResult<List<JobAdvert>> getByIsActiveAndEmployerCompany(int id) {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.getByIsActiveAndEmployerCompany(id),"Bu firmaya ait tüm aktif iş ilanları");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result update(JobAdvert jobAdvert) {
		this.jobAdvertDao.save(jobAdvert);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public Result delete(int id) {
		this.jobAdvertDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public Result isActiveChange(int id) {
		
		JobAdvert job = this.jobAdvertDao.getById(id);
		
		if(job.isActive() == false) {
			return new ErrorResult("Bu ilan zaten pasif");
		}
		job.setActive(false);
		update(job);
		return new SuccessResult("İş ilanı pasif hale getirildi");
	}

	

	

}
