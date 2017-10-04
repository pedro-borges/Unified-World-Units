package pcb.uwu.units.fundamental;

import pcb.uwu.core.BaseUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;

public class MassUnit extends BaseUnit<MassUnit> {

	private static final BigDecimal GRAMS_PER_STONE = new BigDecimal("6350.29318");
	private static final BigDecimal GRAMS_PER_POUND = new BigDecimal("453.59237");
	private static final BigDecimal GRAMS_PER_OUNCE = new BigDecimal("28.349523125");

	public static final MassUnit GRAM = new MassUnit(
			"g", "gram", "grams",
			Function.identity(),
			Function.identity());

	public static final MassUnit STONE = new MassUnit(
			"st", "stone", "stones",
			value -> value.multiply(GRAMS_PER_STONE, DECIMAL64),
			value -> value.divide(GRAMS_PER_STONE, DECIMAL64));

	public static final MassUnit POUND = new MassUnit(
			"lb", "pound", "pounds",
			value -> value.multiply(GRAMS_PER_POUND, DECIMAL64),
			value -> value.divide(GRAMS_PER_POUND, DECIMAL64));

	public static final MassUnit OUNCE = new MassUnit(
			"oz", "ounce", "ounces",
			value -> value.multiply(GRAMS_PER_OUNCE, DECIMAL64),
			value -> value.divide(GRAMS_PER_OUNCE, DECIMAL64));

	private MassUnit(String symbol,
					 String singularName,
					 String pluralName,
					 Function<BigDecimal, BigDecimal> translationToCanonical,
					 Function<BigDecimal, BigDecimal> translationFromCanonical) {

		super(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
	}
}
