package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.GramUnit.GRAM;

public class Grams extends Mass {

	// region constructors

	public Grams(Number value) {
		super(value, GRAM);
	}

	public Grams(Number value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(String value) {
		super(value, GRAM);
	}

	public Grams(String value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(BigDecimal value) {
		super(value, GRAM);
	}

	public Grams(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(BigDecimalAmount amount) {
		super(amount, GRAM);
	}

	public Grams(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, GRAM);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Grams plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Grams(plusAmount(other, mathContext));
	}

	@Override
	public Grams minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Grams(minusAmount(other, mathContext));
	}

	@Override
	public Grams multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Grams(multipliedByScalar(other, mathContext));
	}

	@Override
	public Grams dividedBy(BigDecimal other, MathContext mathContext) {
		return new Grams(dividedByScalar(other, mathContext));
	}

	// endregion
}
