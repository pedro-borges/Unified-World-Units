package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.NauticalMileUnit.NAUTICAL_MILE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class NauticalMiles extends Length {

	// region constructors

	public NauticalMiles(Number value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(Number value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(String value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(String value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimal value) {
		super(value, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimalAmount amount) {
		super(amount, NAUTICAL_MILE);
	}

	public NauticalMiles(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NAUTICAL_MILE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public NauticalMiles plus(@NotNull UnitAmount<LengthUnit> amount) {
		return new NauticalMiles(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public NauticalMiles minus(@NotNull UnitAmount<LengthUnit> amount) {
		return new NauticalMiles(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public NauticalMiles times(@NotNull Number number) {
		return new NauticalMiles(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public NauticalMiles div(@NotNull Number number) {
		return new NauticalMiles(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
