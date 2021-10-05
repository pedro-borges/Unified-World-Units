package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.InchUnit.INCH;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Inches extends Length {

	// region constructors

	public Inches(Number value) {
		super(value, INCH);
	}

	public Inches(Number value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(String value) {
		super(value, INCH);
	}

	public Inches(String value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimal value) {
		super(value, INCH);
	}

	public Inches(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimalAmount amount) {
		super(amount, INCH);
	}

	public Inches(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, INCH);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Inches plus(@NotNull UnitAmount<LengthUnit> other) {
		return new Inches(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Inches minus(@NotNull UnitAmount<LengthUnit> other) {
		return new Inches(minusAmount(this, other));
	}

	@Override
	public Inches times(BigDecimal other, MathContext mathContext) {
		return new Inches(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Inches div(BigDecimal other, MathContext mathContext) {
		return new Inches(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
