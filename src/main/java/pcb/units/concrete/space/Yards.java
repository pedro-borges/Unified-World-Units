package pcb.units.concrete.space;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.space.Length;
import pcb.units.dimensions.space.SpaceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Yards
		extends AbstractUnitAmount<BigDecimalAmount, SpaceUnit>
		implements Length {

	// region constructors

	public Yards(Number value) {
		this(value.toString());
	}

	public Yards(String value) {
		this(new BigDecimal(value));
	}

	public Yards(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Yards(BigDecimalAmount amount) {
		super(amount, YardUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Yards plus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Yards inches = new Yards(other.getAmountIn(getUnit()));
		return new Yards(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Yards minus(UnitAmount<BigDecimalAmount, SpaceUnit> other, MathContext mathContext) {
		Yards inches = new Yards(other.getAmountIn(getUnit()));
		return new Yards(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Yards multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Yards(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Yards dividedBy(BigDecimal other, MathContext mathContext) {
		return new Yards(getAmount().dividedBy(other, mathContext));
	}

	// endregion
}
