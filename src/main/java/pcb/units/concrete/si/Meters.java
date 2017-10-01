package pcb.units.concrete.si;

import pcb.units.amount.Amount;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.BaseUnit;
import pcb.units.base.Unit;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.Function;

public class Meters extends Space {
	public static final Unit<BigDecimal, SpaceUnit> METER = new BaseUnit<>("m", "meter", "meters");

	// region constructors

	public Meters(Number amount) {
		this(new BigDecimalAmount(amount));
	}

	public Meters(Amount<BigDecimal> amount) {
		super(amount, METER,
				Function.identity(),
				Function.identity());
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Meters plus(Space other, MathContext mathContext) {
		Space meters = convertToSelfScale(other);
		return new Meters(getAmount().plus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters minus(Space other, MathContext mathContext) {
		Space meters = convertToSelfScale(other);
		return new Meters(getAmount().minus(meters.getAmount(), mathContext));
	}

	@Override
	public Meters multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Meters dividedBy(BigDecimal other, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(other, mathContext));
	}

	@Override
	public BigDecimal dividedBy(Space other, MathContext mathContext) {
		Space meters = convertToSelfScale(other);
		return getAmount().dividedBy(meters.getAmount(), mathContext);
	}

	// endregion
}
