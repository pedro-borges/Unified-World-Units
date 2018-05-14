package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricCurrent extends CompositeUnitAmount<ElectricCurrentUnit> {

	// region constructors

	public ElectricCurrent(Number value, ElectricCurrentUnit unit) {
		super(value, unit);
	}

	public ElectricCurrent(Number value, Magnitude magnitude, ElectricCurrentUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCurrent(String value, ElectricCurrentUnit unit) {
		super(value, unit);
	}

	public ElectricCurrent(String value, Magnitude magnitude, ElectricCurrentUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCurrent(BigDecimal value, ElectricCurrentUnit unit) {
		super(value, unit);
	}

	public ElectricCurrent(BigDecimal value, Magnitude magnitude, ElectricCurrentUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCurrent(BigDecimalAmount amount, ElectricCurrentUnit unit) {
		super(amount, unit);
	}

	public ElectricCurrent(BigDecimalAmount amount, Magnitude magnitude, ElectricCurrentUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricCurrent plus(UnitAmount<ElectricCurrentUnit> other, MathContext mathContext) {
		return new ElectricCurrent(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent minus(UnitAmount<ElectricCurrentUnit> other, MathContext mathContext) {
		return new ElectricCurrent(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent in(ElectricCurrentUnit unit) {
		return new ElectricCurrent(getAmountIn(this, unit), unit);
	}

	// endregion
}
