package pcb.uwu.unit.base;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class HourUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_HOUR = new BigDecimal(3_600);

	public static final HourUnit HOUR = new HourUnit();

	private HourUnit() {
		super("h", "hour", "hours",
				value -> value.times(SECONDS_PER_HOUR, DECIMAL64),
				value -> value.div(SECONDS_PER_HOUR, DECIMAL64));
	}
}
