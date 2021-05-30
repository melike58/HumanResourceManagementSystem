package KodlamaIO.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import KodlamaIO.HRMS.entities.concretes.User;

@Repository
public interface UserDao<T extends User> extends JpaRepository<T,Integer> {

    boolean existsByEmail(String email);
    
}