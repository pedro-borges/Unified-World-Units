package pcb.uwu.amount.derived.thermodynamics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.mechanics.Newtons;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PressureUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER;
import static pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Pascals plus(@NotNull UnitAmount<PressureUnit> amount) {
		return new Pascals(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Pascals minus(@NotNull UnitAmount<PressureUnit> amount) {
		return new Pascals(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Pascals times(@NotNull Number number) {
		return new Pascals(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Pascals div(@NotNull Number number) {
		return new Pascals(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Joules times(Volume volume) {
		return new Joules(getAmount().times(getAmountIn(volume, CUBIC_METER)));
	}

	public Newtons times(Area area) {
		return new Newtons(getAmount().times(getAmountIn(area, SQUARE_METER)));
	}

	// endregion
}
