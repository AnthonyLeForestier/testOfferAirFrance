package offer.test.airfrance.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(generator = "id_user_generator")
	@SequenceGenerator(name = "id_user_generator", sequenceName = "id_user_sq")
	private Long id;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "birthdate")
	private LocalDate birthdate;

	@Column(name = "country_residence")
	private String countryResidence;

	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "gender")
	private String gender;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountryResidence() {
		return countryResidence;
	}

	public void setCountryResidence(String countryResidence) {
		this.countryResidence = countryResidence;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
