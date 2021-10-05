package pcb.uwu.amount.derived.thermodynamics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.mechanics.Newtons;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PressureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER;
import static pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Pascals extends Pressure {

	// region constructors

	public Pascals(Number value) {
		super(value, PASCAL);
	}

	public Pascals(Number value, Magnitude magnitude) {
		super(value, magnitude, PASCAL);
	}

	public Pascals(String value) {
		super(value, PASCAL);
	}

	public Pascals(String value, Magnitude magnitude) {
		super(value, magnitude, PASCAL);
	}

	public Pascals(BigDecimal value) {
		super(value, PASCAL);
	}

	public Pascals(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, PASCAL);
	}

	public Pascals(BigDecimalAmount amount) {
		super(amount, PASCAL);
	}

	public Pascals(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, PASCAL);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Pascals plus(@NotNull UnitAmount<PressureUnit> other) {
		return new Pascals(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Pascals minus(@NotNull UnitAmount<PressureUnit> other) {
		return new Pascals(minusAmount(this, other));
	}

	@Override
	public Pascals times(BigDecimal other, MathContext mathContext) {
		return new Pascals(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Pascals div(BigDecimal other, MathContext mathContext) {
		return new Pascals(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Joules multipliedBy(Volume volume, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(volume, CUBIC_METER), mathContext));
	}

	public Newtons multipliedBy(Area area, MathContext mathContext) {
		return new Newtons(getAmount().times(getAmountIn(area, SQUARE_METER), mathContext));
	}

	// endregion
}
