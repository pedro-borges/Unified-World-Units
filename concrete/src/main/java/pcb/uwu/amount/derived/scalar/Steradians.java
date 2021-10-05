package pcb.uwu.amount.derived.scalar;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.LuminousIntensity;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.scalar.SolidAngleUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.scalar.SteradianUnit.STERADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Steradians extends SolidAngle {

	// region constructors

	public Steradians(Number value) {
		super(value, STERADIAN);
	}

	public Steradians(Number value, Magnitude magnitude) {
		super(value, magnitude, STERADIAN);
	}

	public Steradians(String value) {
		super(value, STERADIAN);
	}

	public Steradians(String value, Magnitude magnitude) {
		super(value, magnitude, STERADIAN);
	}

	public Steradians(BigDecimal value) {
		super(value, STERADIAN);
	}

	public Steradians(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, STERADIAN);
	}

	public Steradians(BigDecimalAmount amount) {
		super(amount, STERADIAN);
	}

	public Steradians(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, STERADIAN);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Steradians plus(@NotNull UnitAmount<SolidAngleUnit> other) {
		return new Steradians(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Steradians minus(@NotNull UnitAmount<SolidAngleUnit> other) {
		return new Steradians(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Steradians times(@NotNull Number other) {
		return new Steradians(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Steradians div(@NotNull Number other) {
		return new Steradians(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	public Lumens times(LuminousIntensity luminousIntensity) {
		return new Lumens(getAmount().times(getAmountIn(luminousIntensity, CANDELA)));
	}

	// endregion
}
