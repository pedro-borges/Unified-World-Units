package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.electromagnetism.ElectricCharge;
import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class ElectricCurrent extends AbstractUnitAmount<ElectricCurrentUnit> {

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
		return new ElectricCurrent(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent minus(UnitAmount<ElectricCurrentUnit> other, MathContext mathContext) {
		return new ElectricCurrent(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricCurrent convertTo(ElectricCurrentUnit unit) {
		return new ElectricCurrent(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public ElectricCharge multipliedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(time.getAmount().getValue(), mathContext);
		ElectricChargeUnit unit = new ElectricChargeUnit(getUnit(), time.getUnit());

		return new ElectricCharge(amount, unit);
	}

	// endregion
}