package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class WeekUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_WEEK = new BigDecimal(604_800);

	public static final WeekUnit WEEK = new WeekUnit();

	private WeekUnit() {
		super("wk", "week", "weeks",
				value -> value.multipliedBy(SECONDS_PER_WEEK, DECIMAL64),
				value -> value.dividedBy(SECONDS_PER_WEEK, DECIMAL64));
	}
}
