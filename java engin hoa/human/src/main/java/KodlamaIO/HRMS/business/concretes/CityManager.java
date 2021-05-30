package KodlamaIO.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import KodlamaIO.HRMS.business.abstracts.CityService;
import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.core.utilities.results.SuccessDataResult;
import KodlamaIO.HRMS.dataAccess.abstracts.CityDao;
import KodlamaIO.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService{
	

	public CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(), "Şehirler Listelendi");
	}

}
