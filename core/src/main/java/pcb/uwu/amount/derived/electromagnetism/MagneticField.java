package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class MagneticField extends CompositeUnitAmount<MagneticFieldUnit> {

	// region constructors

	public MagneticField(Number value, MagneticFieldUnit unit) {
		super(value, unit);
	}

	public MagneticField(Number value, Magnitude magnitude, MagneticFieldUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticField(String value, MagneticFieldUnit unit) {
		super(value, unit);
	}

	public MagneticField(String value, Magnitude magnitude, MagneticFieldUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticField(BigDecimal value, MagneticFieldUnit unit) {
		super(value, unit);
	}

	public MagneticField(BigDecimal value, Magnitude magnitude, MagneticFieldUnit unit) {
		super(value, magnitude, unit);
	}

	public MagneticField(BigDecimalAmount amount, MagneticFieldUnit unit) {
		super(amount, unit);
	}

	public MagneticField(BigDecimalAmount amount, Magnitude magnitude, MagneticFieldUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public MagneticField plus(UnitAmount<MagneticFieldUnit> other, MathContext mathContext) {
		return new MagneticField(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public MagneticField minus(UnitAmount<MagneticFieldUnit> other, MathContext mathContext) {
		return new MagneticField(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public MagneticField multipliedBy(BigDecimal other, MathContext mathContext) {
		return new MagneticField(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public MagneticField dividedBy(BigDecimal other, MathContext mathContext) {
		return new MagneticField(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public MagneticField in(MagneticFieldUnit unit) {
		return new MagneticField(getAmountIn(this, unit), unit);
	}

	// endregion
}
