package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricResistance extends CompositeUnitAmount<ElectricResistanceUnit> {

	// region constructors

	public ElectricResistance(Number value, ElectricResistanceUnit unit) {
		super(value, unit);
	}

	public ElectricResistance(Number value, Magnitude magnitude, ElectricResistanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricResistance(String value, ElectricResistanceUnit unit) {
		super(value, unit);
	}

	public ElectricResistance(String value, Magnitude magnitude, ElectricResistanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricResistance(BigDecimal value, ElectricResistanceUnit unit) {
		super(value, unit);
	}

	public ElectricResistance(BigDecimal value, Magnitude magnitude, ElectricResistanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricResistance(BigDecimalAmount amount, ElectricResistanceUnit unit) {
		super(amount, unit);
	}

	public ElectricResistance(BigDecimalAmount amount, Magnitude magnitude, ElectricResistanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricResistance plus(UnitAmount<ElectricResistanceUnit> other, MathContext mathContext) {
		return new ElectricResistance(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricResistance minus(UnitAmount<ElectricResistanceUnit> other, MathContext mathContext) {
		return new ElectricResistance(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricResistance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricResistance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricResistance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricResistance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricResistance in(ElectricResistanceUnit unit) {
		return new ElectricResistance(getAmountIn(this, unit), unit);
	}

	// endregion
}
