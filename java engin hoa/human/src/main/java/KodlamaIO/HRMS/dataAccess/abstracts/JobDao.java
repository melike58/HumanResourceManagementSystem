package KodlamaIO.HRMS.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.Job;

@Repository
public interface JobDao extends JpaRepository<Job,Integer>{
	
	List<Job> findByPositions(String position);
}

