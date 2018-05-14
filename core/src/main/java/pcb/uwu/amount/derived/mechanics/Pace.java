package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.mechanics.PaceUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;

public class Pace extends CompositeUnitAmount<PaceUnit> {

	// region constructors

	public Pace(Number value, PaceUnit unit) {
		super(value, unit);
	}

	public Pace(Number value, Magnitude magnitude, PaceUnit unit) {
		super(value, magnitude, unit);
	}

	public Pace(String value, PaceUnit unit) {
		super(value, unit);
	}

	public Pace(String value, Magnitude magnitude, PaceUnit unit) {
		super(value, magnitude, unit);
	}

	public Pace(BigDecimal value, PaceUnit unit) {
		super(value, unit);
	}

	public Pace(BigDecimal value, Magnitude magnitude, PaceUnit unit) {
		super(value, magnitude, unit);
	}

	public Pace(BigDecimalAmount amount, PaceUnit unit) {
		super(amount, unit);
	}

	public Pace(BigDecimalAmount amount, Magnitude magnitude, PaceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Pace plus(UnitAmount<PaceUnit> other, MathContext mathContext) {
		return new Pace(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Pace minus(UnitAmount<PaceUnit> other, MathContext mathContext) {
		return new Pace(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Pace multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Pace(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Pace dividedBy(BigDecimal other, MathContext mathContext) {
		return new Pace(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Pace in(PaceUnit unit) {
		return new Pace(getAmountIn(this, unit), unit);
	}

	@Override
	public Speed invert(MathContext mathContext) {
		return new Speed(getAmount().invert(mathContext), new SpeedUnit(getUnit()));
	}

	// endregion

	// region composition

	public Time multipliedBy(Length length, MathContext mathContext) {
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Time(super.multipliedBy(length, mathContext).getAmount(), timeUnit);
	}

	// endregion
}
