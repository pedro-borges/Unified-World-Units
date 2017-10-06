package pcb.uwu.amounts.composite.electromagnetism;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class ElectricCharge extends AbstractUnitAmount<ElectricChargeUnit> {

	// region constructors

	public ElectricCharge(Number value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(Number value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(String value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(String value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(BigDecimal value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(BigDecimal value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(BigDecimalAmount amount, ElectricChargeUnit unit) {
		super(amount, unit);
	}

	public ElectricCharge(BigDecimalAmount amount, Magnitude magnitude, ElectricChargeUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricCharge plus(UnitAmount<ElectricChargeUnit> other, MathContext mathContext) {
		return new ElectricCharge(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge minus(UnitAmount<ElectricChargeUnit> other, MathContext mathContext) {
		return new ElectricCharge(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCharge(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCharge(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge convertTo(ElectricChargeUnit unit) {
		return new ElectricCharge(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	// endregion
}
