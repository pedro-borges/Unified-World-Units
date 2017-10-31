package pcb.uwu.amount.derived.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.VolumeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Volume extends CompositeUnitAmount<VolumeUnit> {

	// region constructors

	public Volume(Number value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(Number value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(String value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(String value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(BigDecimal value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(BigDecimal value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(BigDecimalAmount amount, VolumeUnit unit) {
		super(amount, unit);
	}

	public Volume(BigDecimalAmount amount, Magnitude magnitude, VolumeUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Volume plus(UnitAmount<VolumeUnit> other, MathContext mathContext) {
		return new Volume(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Volume minus(UnitAmount<VolumeUnit> other, MathContext mathContext) {
		return new Volume(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Volume multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Volume(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Volume dividedBy(BigDecimal other, MathContext mathContext) {
		return new Volume(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Volume convertTo(VolumeUnit unit) {
		return new Volume(getAmountIn(unit), unit);
	}

	// endregion
}
