package pcb.units.concrete.fundamental.si;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.fundamental.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class MinuteUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	private static final BigDecimal SECONDS_PER_MINUTE = new BigDecimal(60);

	public MinuteUnit() {
		super("min", "minute", "minutes",
				value -> value.multiply(SECONDS_PER_MINUTE, DECIMAL64),
				value -> value.divide(SECONDS_PER_MINUTE, DECIMAL64));
	}
}
