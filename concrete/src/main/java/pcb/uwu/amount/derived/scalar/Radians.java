package pcb.uwu.amount.derived.scalar;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.scalar.AngleUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.scalar.RadianUnit.RADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Radians extends Angle {

	// region constructors

	public Radians(Number value) {
		super(value, RADIAN);
	}

	public Radians(Number value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(String value) {
		super(value, RADIAN);
	}

	public Radians(String value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(BigDecimal value) {
		super(value, RADIAN);
	}

	public Radians(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, RADIAN);
	}

	public Radians(BigDecimalAmount amount) {
		super(amount, RADIAN);
	}

	public Radians(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, RADIAN);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Radians plus(@NotNull UnitAmount<AngleUnit> angle) {
		return new Radians(plusAmount(this, angle));
	}

	@NotNull
	@Override
	public Radians minus(@NotNull UnitAmount<AngleUnit> angle) {
		return new Radians(minusAmount(this, angle));
	}

	@NotNull
	@Override
	public Radians times(@NotNull Number scalar) {
		return new Radians(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Radians div(@NotNull Number scalar) {
		return new Radians(dividedByScalar(this, scalar));
	}

	// endregion
}
