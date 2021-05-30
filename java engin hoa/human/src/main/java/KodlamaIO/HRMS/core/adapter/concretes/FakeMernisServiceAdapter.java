package KodlamaIO.HRMS.core.adapter.concretes;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import KodlamaIO.HRMS.core.adapter.abstracts.UserCheckService;

@Component
public class FakeMernisServiceAdapter implements UserCheckService{

	@Override
	public boolean checkRealPerson(String identityNumber, String firstName, String lastName, LocalDate birthYear) {
		
		return true;
		
	}

}
