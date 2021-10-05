package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class WeekUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_WEEK = new BigDecimal(604_800);

	public static final WeekUnit WEEK = new WeekUnit();

	private WeekUnit() {
		super("wk", "week", "weeks",
				value -> value.times(SECONDS_PER_WEEK),
				value -> value.div(SECONDS_PER_WEEK));
	}
}
