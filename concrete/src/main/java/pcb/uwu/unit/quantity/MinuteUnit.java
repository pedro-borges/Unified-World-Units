package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class MinuteUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_MINUTE = new BigDecimal(60);

	public static final MinuteUnit MINUTE = new MinuteUnit();

	private MinuteUnit() {
		super("min", "minute", "minutes",
				value -> value.multipliedBy(SECONDS_PER_MINUTE, DECIMAL64),
				value -> value.dividedBy(SECONDS_PER_MINUTE, DECIMAL64));
	}
}
