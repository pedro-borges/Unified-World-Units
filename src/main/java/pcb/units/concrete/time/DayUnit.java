package pcb.units.concrete.time;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class DayUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	public static final DayUnit instance = new DayUnit();

	private static final BigDecimal SECONDS_PER_DAY = new BigDecimal(86_400);

	private DayUnit() {
		super("d", "day", "days",
				value -> value.multiply(SECONDS_PER_DAY, DECIMAL64),
				value -> value.divide(SECONDS_PER_DAY, DECIMAL64));
	}
}
