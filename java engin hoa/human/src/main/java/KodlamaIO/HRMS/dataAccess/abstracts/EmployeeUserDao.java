package KodlamaIO.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.EmployeeUser;

@Repository
public interface EmployeeUserDao extends JpaRepository<EmployeeUser,Integer> {

}