package offer.test.airfrance.config.validation;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import offer.test.airfrance.validation.AdultValidator;

public class AdultValidatorTest {

	@Test
	public void birthdateEmptyTest() {
		AdultValidator validator = new AdultValidator();
		AssertionErrors.assertFalse("Test fail, birthdate can't be null", validator.isValid(null, null));
	}

	@Test
	public void birthdateTodayTest() {
		AdultValidator validator = new AdultValidator();
		AssertionErrors.assertTrue("Test fail, birthdate is today", validator.isValid(LocalDate.now().minusYears(18), null));
	}

	@Test
	public void birthdateMinorTest() {
		AdultValidator validator = new AdultValidator();
		AssertionErrors.assertFalse("Test fail, user is minor", validator.isValid(LocalDate.now().minusYears(10), null));
	}
}
