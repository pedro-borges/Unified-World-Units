package pcb.uwu.exceptions;

public class CurrencyMismatchException extends RuntimeException {
	public CurrencyMismatchException(String message, Object... args) {
		super(String.format(message, args));
	}
}
