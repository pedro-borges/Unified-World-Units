package pcb.uwu.impl.composite.mechanics;

import pcb.uwu.amounts.composite.mechanics.Force;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.composite.mechanics.ForceUnit.NEWTON;

public class Newtons extends Force {

	// region constructors

	public Newtons(Number value) {
		super(value, NEWTON);
	}

	public Newtons(Number value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(String value) {
		super(value, NEWTON);
	}

	public Newtons(String value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimal value) {
		super(value, NEWTON);
	}

	public Newtons(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimalAmount amount) {
		super(amount, NEWTON);
	}

	public Newtons(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NEWTON);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Newtons plus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(plusAmount(other, mathContext));
	}

	@Override
	public Newtons minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(minusAmount(other, mathContext));
	}

	@Override
	public Newtons multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(multipliedByScalar(other, mathContext));
	}

	@Override
	public Newtons dividedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
