package pcb.units.concrete.time;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class MinuteUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	public static final MinuteUnit instance = new MinuteUnit();

	private static final BigDecimal SECONDS_PER_MINUTE = new BigDecimal(60);

	private MinuteUnit() {
		super("min", "minute", "minutes",
				value -> value.multiply(SECONDS_PER_MINUTE, DECIMAL64),
				value -> value.divide(SECONDS_PER_MINUTE, DECIMAL64));
	}
}
