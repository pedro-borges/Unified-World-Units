package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class MinuteUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_MINUTE = new BigDecimal(60);

	public static final MinuteUnit MINUTE = new MinuteUnit();

	private MinuteUnit() {
		super("min", "minute", "minutes",
				value -> value.times(SECONDS_PER_MINUTE),
				value -> value.div(SECONDS_PER_MINUTE));
	}
}
