package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Miles
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public Miles(Number value) {
		this(value.toString());
	}

	public Miles(String value) {
		this(new BigDecimal(value));
	}

	public Miles(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Miles(BigDecimalAmount amount) {
		super(amount, MileUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Miles plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Miles inches = new Miles(other.getAmountIn(getUnit()));
		return new Miles(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Miles minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Miles inches = new Miles(other.getAmountIn(getUnit()));
		return new Miles(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Miles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Miles dividedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
