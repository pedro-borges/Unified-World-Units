package pcb.units.concrete.time;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class HourUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	public static final HourUnit instance = new HourUnit();

	private static final BigDecimal SECONDS_PER_HOUR = new BigDecimal(3_600);

	private HourUnit() {
		super("h", "hour", "hours",
				value -> value.multiply(SECONDS_PER_HOUR, DECIMAL64),
				value -> value.divide(SECONDS_PER_HOUR, DECIMAL64));
	}
}
