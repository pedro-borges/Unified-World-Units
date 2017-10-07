package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.impl.composite.electromagnetism.Coulombs;
import pcb.uwu.units.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.TimeUnit.SECOND;

public class Seconds extends Time {

	// region constructors

	public Seconds(Number value) {
		super(value, SECOND);
	}

	public Seconds(Number value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(String value) {
		super(value, SECOND);
	}

	public Seconds(String value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(BigDecimal value) {
		super(value, SECOND);
	}

	public Seconds(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SECOND);
	}

	public Seconds(BigDecimalAmount amount) {
		super(amount, SECOND);
	}

	public Seconds(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SECOND);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Seconds plus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Seconds(plusAmount(other, mathContext));
	}

	@Override
	public Seconds minus(UnitAmount<TimeUnit> other, MathContext mathContext) {
		return new Seconds(minusAmount(other, mathContext));
	}

	@Override
	public Seconds multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(multipliedByScalar(other, mathContext));
	}

	@Override
	public Seconds dividedBy(BigDecimal other, MathContext mathContext) {
		return new Seconds(dividedByScalar(other, mathContext));
	}

	@Override
	public Seconds convertTo(TimeUnit unit) {
		return new Seconds(getAmountIn(unit));
	}

	// endregion

	// region composite

	public Coulombs multipliedBy(Amperes amperes, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(amperes.getAmount().getValue(), mathContext);

		return new Coulombs(amount);
	}

	// endregion
}
