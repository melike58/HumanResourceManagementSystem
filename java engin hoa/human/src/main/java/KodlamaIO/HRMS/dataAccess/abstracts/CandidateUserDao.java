package KodlamaIO.HRMS.dataAccess.abstracts;



import KodlamaIO.HRMS.entities.concretes.CandidateUser;

public interface CandidateUserDao extends UserDao<CandidateUser>{

	boolean existsByIdentityNumber(String identityNumber);
}