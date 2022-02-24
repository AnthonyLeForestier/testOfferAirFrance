package offer.test.airfrance.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import offer.test.airfrance.controller.error.ErrorResponse.TypeError;
import offer.test.airfrance.exception.InvalidParameterException;
import offer.test.airfrance.exception.NotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionHandlerAdvice.class);

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(MethodArgumentNotValidException exception, WebRequest request) {
		LOGGER.warn(exception.getMessage());
		return new ErrorResponse(TypeError.FIELD_VALIDATION.getLabel(),
				exception.getFieldErrors().get(0).getDefaultMessage());
	}

	@ExceptionHandler(value = { InvalidParameterException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(InvalidParameterException exception, WebRequest request) {
		LOGGER.warn(exception.getMessage());
		return new ErrorResponse(TypeError.FIELD_VALIDATION.getLabel(), exception.getMessage());
	}

	@ExceptionHandler(value = { NotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse notFoundRequest(NotFoundException exception, WebRequest request) {
		LOGGER.warn(exception.getMessage());
		return new ErrorResponse(TypeError.NOT_FOUND.getLabel(), exception.getMessage());
	}

	@ExceptionHandler(value = Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorResponse internal(Throwable exception, WebRequest request) {
		LOGGER.error(exception.getMessage(), exception);
		return new ErrorResponse(TypeError.GENERIC.getLabel(), exception.getMessage());
	}
}
