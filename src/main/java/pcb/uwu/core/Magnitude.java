package pcb.uwu.core;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static java.math.BigDecimal.ONE;

public enum Magnitude {
	PICO(-12, "p"),
	NANO(-9, "n"),
	MICRO(-6, "μ"),
	MILLI(-3, "m"),
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

	public static final List<Magnitude> ALL_MAGNITUDES = Arrays
			.asList(PICO, NANO, MICRO, MILLI, CENTI, DECI, NATURAL, DECA, HECTA, KILO, MEGA, GIGA, TERA);
	public static final List<Magnitude> MAJOR_MAGNITUDES = Arrays
			.asList(PICO, NANO, MICRO, MILLI, NATURAL, KILO, MEGA, GIGA, TERA);

	private final int order;
	private final String symbol;
	private final BigDecimal value;

	Magnitude(int order, String symbol) {
		this.order = order;
		this.symbol = symbol;
		this.value = ONE.movePointRight(order);
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
