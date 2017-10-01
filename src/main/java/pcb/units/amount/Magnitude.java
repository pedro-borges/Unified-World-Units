package pcb.units.amount;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

public enum Magnitude {
	PICO(-12, "p"),
	NANO(-9, "n"),
	MICRO(-6, "μ"),
	MILI(-3, "m"),
	CENTI(-2, "c"),
	DECI(-1, "d"),
	NATURAL(0, ""),
	DECA(1, "D"),
	HECTA(2, "H"),
	KILO(3, "K"),
	MEGA(6, "M"),
	GIGA(9, "G"),
	TERA(12, "T"),
	;

	private final int order;
	private final String symbol;
	private final BigDecimal value;

	Magnitude(int order, String symbol) {
		this.order = order;
		this.symbol = symbol;
		this.value = TEN.scaleByPowerOfTen(order);
	}

	public int order() {
		return order;
	}

	public String symbol() {
		return symbol;
	}

	public BigDecimal getValue() {
		return value;
	}
}
