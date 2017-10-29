package pcb.uwu.exceptions;

public class OffendingUnitException extends RuntimeException {
	public OffendingUnitException(String message, Object... args) {
		super(String.format(message, args));
	}
}
