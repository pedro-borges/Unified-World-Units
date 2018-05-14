package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new ElectricConductance(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance minus(UnitAmount<ElectricConductanceUnit> other, MathContext mathContext) {
		return new ElectricConductance(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance in(ElectricConductanceUnit unit) {
		return new ElectricConductance(getAmountIn(this, unit), unit);
	}

	// endregion
}
