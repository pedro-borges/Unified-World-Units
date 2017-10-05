package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;

public class LengthUnit extends BaseUnit<LengthUnit> {

	private static final BigDecimal METERS_PER_NAUTICAL_MILE = new BigDecimal("1852");
	private static final BigDecimal METERS_PER_MILE = new BigDecimal("1609.344");
	private static final BigDecimal METERS_PER_YARD = new BigDecimal("0.9144");
	private static final BigDecimal METERS_PER_FOOT = new BigDecimal("0.3048");
	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	public static final LengthUnit METER = new LengthUnit(
			"m", "meter", "meters",
			Function.identity(),
			Function.identity());

	public static final LengthUnit NAUTIC_MILE = new LengthUnit(
			"mile", "mile", "miles",
			value -> value.multiply(METERS_PER_NAUTICAL_MILE, DECIMAL64),
			value -> value.divide(METERS_PER_NAUTICAL_MILE, DECIMAL64));

	public static final LengthUnit MILE = new LengthUnit(
			"mile", "mile", "miles",
			value -> value.multiply(METERS_PER_MILE, DECIMAL64),
			value -> value.divide(METERS_PER_MILE, DECIMAL64));

	public static final LengthUnit YARD = new LengthUnit(
			"yd", "yard", "yards",
			value -> value.multiply(METERS_PER_YARD, DECIMAL64),
			value -> value.divide(METERS_PER_YARD, DECIMAL64));

	public static final LengthUnit FOOT = new LengthUnit(
			"ft", "foot", "feet",
			value -> value.multiply(METERS_PER_FOOT, DECIMAL64),
			value -> value.divide(METERS_PER_FOOT, DECIMAL64));

	public static final LengthUnit INCH = new LengthUnit(
			"in", "inch", "inches",
			value -> value.multiply(METERS_PER_INCH, DECIMAL64),
			value -> value.divide(METERS_PER_INCH, DECIMAL64));

	private LengthUnit(String symbol,
					   String singularName,
					   String pluralName,
					   Function<BigDecimal, BigDecimal> translationToCanonical,
					   Function<BigDecimal, BigDecimal> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
