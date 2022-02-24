package offer.test.airfrance.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FrenchValidator implements ConstraintValidator<FrenchResidence, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && value.equals("FRA");
	}

}
