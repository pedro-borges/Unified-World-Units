package pcb.units.concrete.fundamental.imperial;

import pcb.units.amount.Amount;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.DECIMAL64;

public class InchUnit implements SpaceUnit {
	private final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	@Override
	public String getSymbol() {
		return "in";
	}

	@Override
	public String getSingularName() {
		return "inch";
	}

	@Override
	public String getPluralName() {
		return "inches";
	}

	@Override
	public Function<Amount, Amount> translationToCanonical() {
		return value -> value.dividedBy(METERS_PER_INCH, DECIMAL64);
	}

	@Override
	public Function<Amount, Amount> translationFromCanonical() {
		return value -> value.multipliedBy(METERS_PER_INCH, DECIMAL64);
	}
}
