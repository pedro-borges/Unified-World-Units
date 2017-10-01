package pcb.units.concrete.finance;

public class InvalidCurrencyException extends RuntimeException {
	public InvalidCurrencyException(String message, Object... args) {
		super(String.format(message, args));
	}
}
