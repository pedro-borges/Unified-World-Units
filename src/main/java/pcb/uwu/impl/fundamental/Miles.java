package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.LengthUnit.MILE;

public class Miles extends Length {

	// region constructors

	public Miles(Number value) {
		super(value, MILE);
	}

	public Miles(Number value, Magnitude magnitude) {
		super(value, magnitude, MILE);
	}

	public Miles(String value) {
		super(value, MILE);
	}

	public Miles(String value, Magnitude magnitude) {
		super(value, magnitude, MILE);
	}

	public Miles(BigDecimal value) {
		super(value, MILE);
	}

	public Miles(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, MILE);
	}

	public Miles(BigDecimalAmount amount) {
		super(amount, MILE);
	}

	public Miles(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, MILE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Miles plus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Miles(plusAmount(other, mathContext));
	}

	@Override
	public Miles minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Miles(minusAmount(other, mathContext));
	}

	@Override
	public Miles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(multipliedByScalar(other, mathContext));
	}

	@Override
	public Miles dividedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(dividedByScalar(other, mathContext));
	}

	@Override
	public Miles convertTo(LengthUnit unit) {
		return new Miles(getAmountIn(unit));
	}

	// endregion

}
