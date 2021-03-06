package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricCapacitance extends CompositeUnitAmount<ElectricCapacitanceUnit> {

	// region constructors

	public ElectricCapacitance(Number value, ElectricCapacitanceUnit unit) {
		super(value, unit);
	}

	public ElectricCapacitance(Number value, Magnitude magnitude, ElectricCapacitanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCapacitance(String value, ElectricCapacitanceUnit unit) {
		super(value, unit);
	}

	public ElectricCapacitance(String value, Magnitude magnitude, ElectricCapacitanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCapacitance(BigDecimal value, ElectricCapacitanceUnit unit) {
		super(value, unit);
	}

	public ElectricCapacitance(BigDecimal value, Magnitude magnitude, ElectricCapacitanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCapacitance(BigDecimalAmount amount, ElectricCapacitanceUnit unit) {
		super(amount, unit);
	}

	public ElectricCapacitance(BigDecimalAmount amount, Magnitude magnitude, ElectricCapacitanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricCapacitance plus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new ElectricCapacitance(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance minus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new ElectricCapacitance(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCapacitance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCapacitance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance in(ElectricCapacitanceUnit unit) {
		return new ElectricCapacitance(getAmountIn(this, unit), unit);
	}

	// endregion
}
