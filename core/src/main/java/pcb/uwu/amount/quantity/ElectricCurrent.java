package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.electromagnetism.ElectricCharge;
import pcb.uwu.amount.composite.electromagnetism.ElectricPotential;
import pcb.uwu.amount.composite.electromagnetism.ElectricResistance;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;
import pcb.uwu.units.composite.electromagnetism.ElectricPotentialUnit;
import pcb.uwu.units.quantity.ElectricCurrentUnit;
import pcb.uwu.units.quantity.LengthUnit;
import pcb.uwu.units.quantity.MassUnit;
import pcb.uwu.units.quantity.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

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

	public ElectricPotential dividedBy(ElectricResistance electricResistence, MathContext mathContext) {
		MassUnit massUnit = getUnit().getUnitCounter().findUnit(MassUnit.class);
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);
		ElectricCurrentUnit electricCurrentUnit = getUnit().getUnitCounter().findUnit(ElectricCurrentUnit.class);
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		ElectricPotentialUnit unit = new ElectricPotentialUnit(massUnit, lengthUnit, electricCurrentUnit, timeUnit);

		return new ElectricPotential(super.multipliedBy(electricResistence, mathContext).getAmount(), unit);
	}

	// endregion
}
