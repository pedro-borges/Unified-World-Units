package pcb.uwu.unit.base;

import pcb.uwu.units.base.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class DayUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_DAY = new BigDecimal(86_400);

	public static final DayUnit DAY = new DayUnit();

	private DayUnit() {
		super("d", "day", "days",
				value -> value.multipliedBy(SECONDS_PER_DAY, DECIMAL64),
				value -> value.dividedBy(SECONDS_PER_DAY, DECIMAL64));
	}
}
