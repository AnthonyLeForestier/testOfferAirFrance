package offer.test.airfrance.config.validation;

import org.junit.jupiter.api.Test;
import org.springframework.test.util.AssertionErrors;

import offer.test.airfrance.validation.FrenchValidator;

public class FrenchValidatorTest {

	@Test
	public void residenceEmptyTest() {
		FrenchValidator validator = new FrenchValidator();
		AssertionErrors.assertFalse("Test fail, value is null", validator.isValid(null, null));
	}

	@Test
	public void frenchResidenceTest() {
		FrenchValidator validator = new FrenchValidator();
		AssertionErrors.assertTrue("Test fail, value FRA is ok", validator.isValid("FRA", null));
	}

	@Test
	public void englishResidenceTest() {
		FrenchValidator validator = new FrenchValidator();
		AssertionErrors.assertFalse("Test fail, value ENG isn't ok", validator.isValid("ENG", null));
	}
}
