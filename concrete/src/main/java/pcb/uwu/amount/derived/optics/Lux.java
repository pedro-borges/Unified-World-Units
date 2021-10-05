package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.IlluminanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Lux extends Illuminance {

	// region constructors

	public Lux(Number value) {
		super(value, LUX);
	}

	public Lux(Number value, Magnitude magnitude) {
		super(value, magnitude, LUX);
	}

	public Lux(String value) {
		super(value, LUX);
	}

	public Lux(String value, Magnitude magnitude) {
		super(value, magnitude, LUX);
	}

	public Lux(BigDecimal value) {
		super(value, LUX);
	}

	public Lux(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LUX);
	}

	public Lux(BigDecimalAmount amount) {
		super(amount, LUX);
	}

	public Lux(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LUX);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Lux plus(@NotNull UnitAmount<IlluminanceUnit> other) {
		return new Lux(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Lux minus(@NotNull UnitAmount<IlluminanceUnit> other) {
		return new Lux(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Lux times(@NotNull Number other) {
		return new Lux(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Lux div(@NotNull Number other) {
		return new Lux(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	public Lumens times(Area area) {
		return new Lumens(getAmount().times(getAmountIn(area, SQUARE_METER)));
	}

	// endregion
}
