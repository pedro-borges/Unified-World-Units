package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.OunceUnit.OUNCE;

public class Ounces extends Mass {

	// region constructors

	public Ounces(Number value) {
		super(value, OUNCE);
	}

	public Ounces(Number value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(String value) {
		super(value, OUNCE);
	}

	public Ounces(String value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(BigDecimal value) {
		super(value, OUNCE);
	}

	public Ounces(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(BigDecimalAmount amount) {
		super(amount, OUNCE);
	}

	public Ounces(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, OUNCE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Ounces plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Ounces(plusAmount(other, mathContext));
	}

	@Override
	public Ounces minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Ounces(minusAmount(other, mathContext));
	}

	@Override
	public Ounces multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Ounces(multipliedByScalar(other, mathContext));
	}

	@Override
	public Ounces dividedBy(BigDecimal other, MathContext mathContext) {
		return new Ounces(dividedByScalar(other, mathContext));
	}

	// endregion
}
