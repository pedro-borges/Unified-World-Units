package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public MagneticField plus(@NotNull UnitAmount<MagneticFieldUnit> other) {
		return new MagneticField(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public MagneticField minus(@NotNull UnitAmount<MagneticFieldUnit> other) {
		return new MagneticField(minusAmount(this, other), getUnit());
	}

	@Override
	public MagneticField multiply(BigDecimal other, MathContext mathContext) {
		return new MagneticField(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public MagneticField div(BigDecimal other, MathContext mathContext) {
		return new MagneticField(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public MagneticField into(MagneticFieldUnit unit) {
		return new MagneticField(getAmountIn(this, unit), unit);
	}

	// endregion
}
