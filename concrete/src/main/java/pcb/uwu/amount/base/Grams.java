package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.GramUnit.GRAM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Grams extends Mass {

	// region constructors

	public Grams(Number value) {
		super(value, GRAM);
	}

	public Grams(Number value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(String value) {
		super(value, GRAM);
	}

	public Grams(String value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(BigDecimal value) {
		super(value, GRAM);
	}

	public Grams(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, GRAM);
	}

	public Grams(BigDecimalAmount amount) {
		super(amount, GRAM);
	}

	public Grams(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, GRAM);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Grams plus(@NotNull UnitAmount<MassUnit> other) {
		return new Grams(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Grams minus(@NotNull UnitAmount<MassUnit> other) {
		return new Grams(minusAmount(this, other));
	}

	@Override
	public Grams times(BigDecimal other, MathContext mathContext) {
		return new Grams(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Grams div(BigDecimal other, MathContext mathContext) {
		return new Grams(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
