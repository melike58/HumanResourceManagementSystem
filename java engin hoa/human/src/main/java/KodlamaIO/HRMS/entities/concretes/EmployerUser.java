package KodlamaIO.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvert"})
public class EmployerUser extends User {

	@Column(name = "company_name")
	private String companyName;

	@Column(name = "company_web_site")
	private String companyWebsite;

	@Column(name = "telefon_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy="employerUser")
	private List<JobAdvert> jobAdvert;
}
