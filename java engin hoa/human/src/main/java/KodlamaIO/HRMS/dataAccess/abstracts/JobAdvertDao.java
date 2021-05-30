package KodlamaIO.HRMS.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.JobAdvert;

@Repository
public interface JobAdvertDao extends JpaRepository<JobAdvert,Integer>{
	
	List<JobAdvert> getByIsActiveTrue();
	
	List<JobAdvert> findByIsActiveTrueOrderByPublishDateDesc();
	
	@Query("From JobAdvert where isActive = true and employerId=:employerId")
	List<JobAdvert> findByIsActiveAndEmployerCompany(int employerId);
	

}
