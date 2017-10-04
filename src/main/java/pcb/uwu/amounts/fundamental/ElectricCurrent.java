package pcb.uwu.amounts.fundamental;

import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class ElectricCurrent
		extends AbstractUnitAmount<BigDecimalAmount, ElectricCurrentUnit>
		implements UnitAmount<BigDecimalAmount, ElectricCurrentUnit> {

	// region constructors

	public ElectricCurrent(Number value, ElectricCurrentUnit unit) {
		this(value.toString(), unit);
	}

	public ElectricCurrent(String value, ElectricCurrentUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public ElectricCurrent(BigDecimal value, ElectricCurrentUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public ElectricCurrent(BigDecimalAmount amount, ElectricCurrentUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public ElectricCurrent plus(UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other, MathContext mathContext) {
		return new ElectricCurrent(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> minus(UnitAmount<BigDecimalAmount, ElectricCurrentUnit> other, MathContext mathContext) {
		return new ElectricCurrent(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public UnitAmount<BigDecimalAmount, ElectricCurrentUnit> dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricCurrent(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
