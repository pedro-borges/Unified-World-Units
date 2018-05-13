package pcb.uwu.exception;

public class OffendingUnitException extends RuntimeException {
	public OffendingUnitException(String message, Object... args) {
		super(String.format(message, args));
	}
}
