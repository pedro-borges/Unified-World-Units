package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.PoundUnit.POUND;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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

	@NotNull
	@Override
	public Pounds times(@NotNull Number other) {
		return new Pounds(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Pounds div(@NotNull Number other) {
		return new Pounds(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
