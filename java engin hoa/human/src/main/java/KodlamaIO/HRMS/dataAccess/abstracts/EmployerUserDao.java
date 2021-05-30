package KodlamaIO.HRMS.dataAccess.abstracts;

import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.EmployerUser;

@Repository
public interface EmployerUserDao extends UserDao<EmployerUser>{

}