package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.GramUnit.GRAM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Grams plus(@NotNull UnitAmount<MassUnit> amount) {
		return new Grams(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Grams minus(@NotNull UnitAmount<MassUnit> amount) {
		return new Grams(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Grams times(@NotNull Number number) {
		return new Grams(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Grams div(@NotNull Number number) {
		return new Grams(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
