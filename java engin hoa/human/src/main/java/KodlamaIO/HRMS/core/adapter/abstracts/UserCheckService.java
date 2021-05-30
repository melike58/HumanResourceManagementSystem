package KodlamaIO.HRMS.core.adapter.abstracts;

import java.time.LocalDate;

public interface UserCheckService {
	
	boolean checkRealPerson(String identityNumber,String firstName,String lastName,LocalDate birthYear);

}
