package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.OunceUnit.OUNCE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Ounces extends Mass {

	// region constructors

	public Ounces(Number value) {
		super(value, OUNCE);
	}

	public Ounces(Number value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(String value) {
		super(value, OUNCE);
	}

	public Ounces(String value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(BigDecimal value) {
		super(value, OUNCE);
	}

	public Ounces(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, OUNCE);
	}

	public Ounces(BigDecimalAmount amount) {
		super(amount, OUNCE);
	}

	public Ounces(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, OUNCE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Ounces plus(@NotNull UnitAmount<MassUnit> other) {
		return new Ounces(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Ounces minus(@NotNull UnitAmount<MassUnit> other) {
		return new Ounces(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Ounces times(@NotNull Number other) {
		return new Ounces(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Ounces div(@NotNull Number other) {
		return new Ounces(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
