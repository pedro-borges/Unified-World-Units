package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.LengthUnit.YARD;

public class Yards extends Length {

	// region constructors

	public Yards(Number value) {
		super(value, YARD);
	}

	public Yards(Number value, Magnitude magnitude) {
		super(value, magnitude, YARD);
	}

	public Yards(String value) {
		super(value, YARD);
	}

	public Yards(String value, Magnitude magnitude) {
		super(value, magnitude, YARD);
	}

	public Yards(BigDecimal value) {
		super(value, YARD);
	}

	public Yards(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, YARD);
	}

	public Yards(BigDecimalAmount amount) {
		super(amount, YARD);
	}

	public Yards(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, YARD);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Yards plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Yards(plusAmount(other, mathContext));
	}

	@Override
	public Yards minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Yards(minusAmount(other, mathContext));
	}

	@Override
	public Yards multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Yards(multipliedByScalar(other, mathContext));
	}

	@Override
	public Yards dividedBy(BigDecimal other, MathContext mathContext) {
		return new Yards(dividedByScalar(other, mathContext));
	}

	@Override
	public Yards convertTo(LengthUnit unit) {
		return new Yards(getAmountIn(unit));
	}

	// endregion

}
