package offer.test.airfrance.controller.error;

public class ErrorResponse {

	public enum TypeError {
		GENERIC("GenericFault"), FIELD_VALIDATION("FieldValidationFault"), NOT_FOUND("ResourceNotFoundFault");

		private String label = "";

		TypeError(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}
	}

	private String typeError;
	private String message;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String typeError, String message) {
		this.typeError = typeError;
		this.message = message;
	}

	public String getTypeError() {
		return typeError;
	}

	public void setTypeError(String typeError) {
		this.typeError = typeError;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
