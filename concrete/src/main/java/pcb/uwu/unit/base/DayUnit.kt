package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class DayUnit extends TimeUnit {

	private static final BigDecimal SECONDS_PER_DAY = new BigDecimal(86_400);

	public static final DayUnit DAY = new DayUnit();

	private DayUnit() {
		super("d", "day", "days",
				value -> value.times(SECONDS_PER_DAY),
				value -> value.div(SECONDS_PER_DAY));
	}
}
