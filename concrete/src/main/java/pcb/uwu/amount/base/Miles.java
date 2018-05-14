package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.MileUnit.MILE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Miles(plusAmount(this, other, mathContext));
	}

	@Override
	public Miles minus(UnitAmount<LengthUnit> other, MathContext mathContext) {
		return new Miles(minusAmount(this, other, mathContext));
	}

	@Override
	public Miles multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Miles dividedBy(BigDecimal other, MathContext mathContext) {
		return new Miles(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
