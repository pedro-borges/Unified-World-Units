package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class ElectricConductance extends CompositeUnitAmount<ElectricConductanceUnit> {

	// region constructors

	public ElectricConductance(Number value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(Number value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(String value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(String value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(BigDecimal value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(BigDecimal value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(BigDecimalAmount amount, ElectricConductanceUnit unit) {
		super(amount, unit);
	}

	public ElectricConductance(BigDecimalAmount amount, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricConductance plus(UnitAmount<ElectricConductanceUnit> other, MathContext mathContext) {
		return new ElectricConductance(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance minus(UnitAmount<ElectricConductanceUnit> other, MathContext mathContext) {
		return new ElectricConductance(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance in(ElectricConductanceUnit unit) {
		return new ElectricConductance(getAmountIn(unit), unit);
	}

	// endregion
}
