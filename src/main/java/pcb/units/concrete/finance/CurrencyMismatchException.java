package pcb.units.concrete.finance;

public class CurrencyMismatchException extends RuntimeException {
	public CurrencyMismatchException(String message, Object... args) {
		super(String.format(message, args));
	}
}
