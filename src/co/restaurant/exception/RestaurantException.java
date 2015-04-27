package co.restaurant.exception;

public class RestaurantException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4082265177812178274L;

	public RestaurantException() {

	}

	public RestaurantException(String message) {
		super(message);

	}

	public RestaurantException(String message, Throwable cause) {
		super(message, cause);
	}
}
