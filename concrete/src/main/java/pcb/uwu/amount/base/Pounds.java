package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.PoundUnit.POUND;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Pounds extends Mass {

	// region constructors

	public Pounds(Number value) {
		super(value, POUND);
	}

	public Pounds(Number value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(String value) {
		super(value, POUND);
	}

	public Pounds(String value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(BigDecimal value) {
		super(value, POUND);
	}

	public Pounds(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, POUND);
	}

	public Pounds(BigDecimalAmount amount) {
		super(amount, POUND);
	}

	public Pounds(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, POUND);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Pounds plus(@NotNull UnitAmount<MassUnit> other) {
		return new Pounds(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Pounds minus(@NotNull UnitAmount<MassUnit> other) {
		return new Pounds(minusAmount(this, other));
	}

	@Override
	public Pounds multiply(BigDecimal other, MathContext mathContext) {
		return new Pounds(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Pounds div(BigDecimal other, MathContext mathContext) {
		return new Pounds(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
