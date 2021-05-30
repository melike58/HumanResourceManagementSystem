package KodlamaIO.HRMS.business.abstracts;

import java.util.List;

import KodlamaIO.HRMS.core.utilities.results.DataResult;
import KodlamaIO.HRMS.entities.concretes.City;

public interface CityService {
	
	DataResult<List<City>> getAll();

}
