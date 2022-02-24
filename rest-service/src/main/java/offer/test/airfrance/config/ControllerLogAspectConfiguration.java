package offer.test.airfrance.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLogAspectConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerLogAspectConfiguration.class);

	@Around("execution(public * offer.test.airfrance.controller..*Controller.*(..))")
	public Object logControllerCall(final ProceedingJoinPoint pjp) throws Throwable {
		long executionTime = System.currentTimeMillis();
		String errorMessage = null;

		Object value = null;
		try {
			logBefore(pjp);
			value = pjp.proceed();
			return value;
		} catch (Throwable throwable) {
			errorMessage = throwable.toString();
			throw throwable;
		} finally {
			executionTime = System.currentTimeMillis() - executionTime;
			logAfter(pjp, value, executionTime, errorMessage);
		}
	}

	private void logBefore(ProceedingJoinPoint pjp) {
		StringBuilder message = new StringBuilder();
		appendClassInfos(message, pjp);
		message.append(" | ");
		message.append(" >>> ");
		message.append(" | ");
		appendParameters(message, pjp);
		message.append(" | ");
		String string = message.toString();
		LOGGER.info(string);
	}

	private void logAfter(ProceedingJoinPoint proceedingJoinPoint, Object value, long executionTime,
			String errorMessage) {
		StringBuilder message = new StringBuilder();
		appendClassInfos(message, proceedingJoinPoint);
		message.append(" | ");
		message.append(" <<< ");
		message.append(" | ");
		message.append(value == null ? null : value.toString());
		message.append(" | ");
		message.append(executionTime + "ms");
		String string = message.toString();
		if (errorMessage == null) {
			LOGGER.info(string);

		} else {
			message.append("\n").append(errorMessage);
			LOGGER.error(string);
		}
	}

	private void appendClassInfos(StringBuilder message, ProceedingJoinPoint pjp) {
		message.append(pjp.getSignature().getDeclaringType().getSimpleName()).append(".")
				.append(pjp.getSignature().getName());
	}

	private void appendParameters(StringBuilder message, ProceedingJoinPoint proceedingJoinPoint) {
		StringBuilder stringBuilder = new StringBuilder();
		Object[] parameters = proceedingJoinPoint.getArgs();
		if (parameters.length == 0)
			return;
		for (int i = 0; i < parameters.length; i++) {
			stringBuilder.append(parameters[i].toString());
			if (i < parameters.length - 1)
				stringBuilder.append(", ");
		}
		message.append(stringBuilder);
	}

}
