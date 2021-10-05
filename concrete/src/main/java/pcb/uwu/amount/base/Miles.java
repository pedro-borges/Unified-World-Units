package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MileUnit.MILE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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

	@NotNull
	@Override
	public Miles plus(@NotNull UnitAmount<LengthUnit> other) {
		return new Miles(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Miles minus(@NotNull UnitAmount<LengthUnit> other) {
		return new Miles(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Miles times(@NotNull Number other) {
		return new Miles(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Miles div(@NotNull Number other) {
		return new Miles(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
