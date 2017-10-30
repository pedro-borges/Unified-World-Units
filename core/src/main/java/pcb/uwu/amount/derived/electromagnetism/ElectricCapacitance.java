package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.electromagnetism.ElectricCapacitanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

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
		return new ElectricCapacitance(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance minus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new ElectricCapacitance(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCapacitance(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCapacitance(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCapacitance convertTo(ElectricCapacitanceUnit unit) {
		return new ElectricCapacitance(getAmountIn(unit), unit);
	}

	// endregion
}
