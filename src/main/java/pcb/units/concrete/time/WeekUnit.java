package pcb.units.concrete.time;

import pcb.units.base.BaseUnit;
import pcb.units.dimensions.time.TimeUnit;

import java.math.BigDecimal;

import static java.math.MathContext.DECIMAL64;

public class WeekUnit
		extends BaseUnit<TimeUnit>
		implements TimeUnit {

	public static final WeekUnit instance = new WeekUnit();

	private static final BigDecimal SECONDS_PER_DAY = new BigDecimal(604_800);

	private WeekUnit() {
		super("wk", "week", "weeks",
				value -> value.multiply(SECONDS_PER_DAY, DECIMAL64),
				value -> value.divide(SECONDS_PER_DAY, DECIMAL64));
	}
}
