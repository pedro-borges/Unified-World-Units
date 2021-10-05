package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.FootUnit.FOOT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Feet extends Length {

	// region constructors

	public Feet(Number value) {
		super(value, FOOT);
	}

	public Feet(Number value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(String value) {
		super(value, FOOT);
	}

	public Feet(String value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(BigDecimal value) {
		super(value, FOOT);
	}

	public Feet(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, FOOT);
	}

	public Feet(BigDecimalAmount amount) {
		super(amount, FOOT);
	}

	public Feet(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, FOOT);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Feet plus(@NotNull UnitAmount<LengthUnit> length) {
		return new Feet(plusAmount(this, length));
	}

	@NotNull
	@Override
	public Feet minus(@NotNull UnitAmount<LengthUnit> length) {
		return new Feet(minusAmount(this, length));
	}

	@NotNull
	@Override
	public Feet times(@NotNull Number number) {
		return new Feet(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Feet div(@NotNull Number number) {
		return new Feet(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
