package pcb.uwu.exception;

public class CurrencyMismatchException extends RuntimeException {
	public CurrencyMismatchException(String message, Object... args) {
		super(String.format(message, args));
	}
}
