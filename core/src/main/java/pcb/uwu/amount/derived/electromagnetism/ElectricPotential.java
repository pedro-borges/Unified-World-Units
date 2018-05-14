package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class ElectricPotential extends CompositeUnitAmount<ElectricPotentialUnit> {

	// region constructors

	public ElectricPotential(Number value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(Number value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(String value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(String value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(BigDecimal value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(BigDecimal value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(BigDecimalAmount amount, ElectricPotentialUnit unit) {
		super(amount, unit);
	}

	public ElectricPotential(BigDecimalAmount amount, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricPotential plus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new ElectricPotential(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential minus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new ElectricPotential(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricPotential(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricPotential(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential in(ElectricPotentialUnit unit) {
		return new ElectricPotential(getAmountIn(this, unit), unit);
	}

	// endregion
}
