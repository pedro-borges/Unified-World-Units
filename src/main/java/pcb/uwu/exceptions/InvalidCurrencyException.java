package pcb.uwu.exceptions;

public class InvalidCurrencyException extends RuntimeException {
	public InvalidCurrencyException(String message, Object... args) {
		super(String.format(message, args));
	}
}
