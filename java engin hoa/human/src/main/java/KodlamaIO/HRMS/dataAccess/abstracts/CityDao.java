package KodlamaIO.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import KodlamaIO.HRMS.entities.concretes.City;

public interface CityDao extends JpaRepository<City,Integer>{

}
