package offer.test.airfrance.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import offer.test.airfrance.validation.Adult;
import offer.test.airfrance.validation.FrenchResidence;

public class UserDTO {

	private Long id;

	@NotNull(message = "userName is required.")
	private String userName;

	@Adult
	private LocalDate birthdate;

	@FrenchResidence
	private String countryResidence;

	@Pattern(regexp = "\\d{10}", message = "phoneNumber must be a valid phone number.")
	private String phoneNumber;

	@Pattern(regexp = "M|W", message = "gender must be a valid gender (M|W).")
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

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", userName=" + userName + "]";
	}

}
