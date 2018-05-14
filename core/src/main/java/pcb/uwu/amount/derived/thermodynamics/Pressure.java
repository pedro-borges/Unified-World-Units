package pcb.uwu.amount.derived.thermodynamics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PressureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Pressure extends CompositeUnitAmount<PressureUnit> {

	// region constructors

	public Pressure(Number value, PressureUnit unit) {
		super(value, unit);
	}

	public Pressure(Number value, Magnitude magnitude, PressureUnit unit) {
		super(value, magnitude, unit);
	}

	public Pressure(String value, PressureUnit unit) {
		super(value, unit);
	}

	public Pressure(String value, Magnitude magnitude, PressureUnit unit) {
		super(value, magnitude, unit);
	}

	public Pressure(BigDecimal value, PressureUnit unit) {
		super(value, unit);
	}

	public Pressure(BigDecimal value, Magnitude magnitude, PressureUnit unit) {
		super(value, magnitude, unit);
	}

	public Pressure(BigDecimalAmount amount, PressureUnit unit) {
		super(amount, unit);
	}

	public Pressure(BigDecimalAmount amount, Magnitude magnitude, PressureUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Pressure plus(UnitAmount<PressureUnit> other, MathContext mathContext) {
		return new Pressure(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Pressure minus(UnitAmount<PressureUnit> other, MathContext mathContext) {
		return new Pressure(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Pressure multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Pressure(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Pressure dividedBy(BigDecimal other, MathContext mathContext) {
		return new Pressure(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Pressure in(PressureUnit unit) {
		return new Pressure(getAmountIn(this, unit), unit);
	}

	// endregion
}
