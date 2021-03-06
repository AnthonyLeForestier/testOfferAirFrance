package offer.test.airfrance.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AdultValidator.class)
public @interface Adult {

	String message() default "birthDate is required ans user must be adult.";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
