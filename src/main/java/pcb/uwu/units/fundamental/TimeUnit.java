package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;

public class TimeUnit extends BaseUnit<TimeUnit> {

	private static final BigDecimal SECONDS_PER_WEEK = new BigDecimal(604_800);
	private static final BigDecimal SECONDS_PER_DAY = new BigDecimal(86_400);
	private static final BigDecimal SECONDS_PER_HOUR = new BigDecimal(3_600);
	private static final BigDecimal SECONDS_PER_MINUTE = new BigDecimal(60);

	public static final TimeUnit SECOND = new TimeUnit(
			"s", "second", "seconds",
			Function.identity(),
			Function.identity());

	public static final TimeUnit WEEK = new TimeUnit(
			"wk", "week", "weeks",
			value -> value.multipliedBy(SECONDS_PER_WEEK, DECIMAL64),
			value -> value.dividedBy(SECONDS_PER_WEEK, DECIMAL64));

	public static final TimeUnit DAY = new TimeUnit(
			"d", "day", "days",
			value -> value.multipliedBy(SECONDS_PER_DAY, DECIMAL64),
			value -> value.dividedBy(SECONDS_PER_DAY, DECIMAL64));

	public static final TimeUnit HOUR = new TimeUnit(
			"h", "hour", "hours",
			value -> value.multipliedBy(SECONDS_PER_HOUR, DECIMAL64),
			value -> value.dividedBy(SECONDS_PER_HOUR, DECIMAL64));

	public static final TimeUnit MINUTE = new TimeUnit(
			"min", "minute", "minutes",
			value -> value.multipliedBy(SECONDS_PER_MINUTE, DECIMAL64),
			value -> value.dividedBy(SECONDS_PER_MINUTE, DECIMAL64));

	private TimeUnit(String symbol,
					 String singularName,
					 String pluralName,
					 Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
					 Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
