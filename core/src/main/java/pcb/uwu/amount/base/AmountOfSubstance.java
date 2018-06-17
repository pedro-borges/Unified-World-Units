package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.AmountOfSubstanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class AmountOfSubstance extends CompositeUnitAmount<AmountOfSubstanceUnit> {

	// region constructors

	public AmountOfSubstance(Number value, AmountOfSubstanceUnit unit) {
		super(value, unit);
	}

	public AmountOfSubstance(Number value, Magnitude magnitude, AmountOfSubstanceUnit unit) {
		super(value, magnitude, unit);
	}

	public AmountOfSubstance(String value, AmountOfSubstanceUnit unit) {
		super(value, unit);
	}

	public AmountOfSubstance(String value, Magnitude magnitude, AmountOfSubstanceUnit unit) {
		super(value, magnitude, unit);
	}

	public AmountOfSubstance(BigDecimal value, AmountOfSubstanceUnit unit) {
		super(value, unit);
	}

	public AmountOfSubstance(BigDecimal value, Magnitude magnitude, AmountOfSubstanceUnit unit) {
		super(value, magnitude, unit);
	}

	public AmountOfSubstance(BigDecimalAmount amount, AmountOfSubstanceUnit unit) {
		super(amount, unit);
	}

	public AmountOfSubstance(BigDecimalAmount amount, Magnitude magnitude, AmountOfSubstanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public AmountOfSubstance plus(UnitAmount<AmountOfSubstanceUnit> other, MathContext mathContext) {
		return new AmountOfSubstance(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public AmountOfSubstance minus(UnitAmount<AmountOfSubstanceUnit> other, MathContext mathContext) {
		return new AmountOfSubstance(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public AmountOfSubstance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new AmountOfSubstance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public AmountOfSubstance dividedBy(BigDecimal other, MathContext mathContext) {
		return new AmountOfSubstance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public AmountOfSubstance in(AmountOfSubstanceUnit unit) {
		return new AmountOfSubstance(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition


	// endregion
}
