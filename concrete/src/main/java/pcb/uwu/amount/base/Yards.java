package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.YardUnit.YARD;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Yards plus(@NotNull UnitAmount<LengthUnit> other) {
		return new Yards(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Yards minus(@NotNull UnitAmount<LengthUnit> other) {
		return new Yards(minusAmount(this, other));
	}

	@Override
	public Yards multiply(BigDecimal other, MathContext mathContext) {
		return new Yards(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Yards div(BigDecimal other, MathContext mathContext) {
		return new Yards(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
