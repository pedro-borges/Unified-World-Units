package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Nits extends Luminance {

	// region constructors

	public Nits(Number value) {
		super(value, NIT);
	}

	public Nits(Number value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(String value) {
		super(value, NIT);
	}

	public Nits(String value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(BigDecimal value) {
		super(value, NIT);
	}

	public Nits(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NIT);
	}

	public Nits(BigDecimalAmount amount) {
		super(amount, NIT);
	}

	public Nits(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NIT);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Nits plus(@NotNull UnitAmount<LuminanceUnit> luminance) {
		return new Nits(plusAmount(this, luminance));
	}

	@NotNull
	@Override
	public Nits minus(@NotNull UnitAmount<LuminanceUnit> luminance) {
		return new Nits(minusAmount(this, luminance));
	}

	@NotNull
	@Override
	public Nits times(@NotNull Number scalar) {
		return new Nits(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Nits div(@NotNull Number scalar) {
		return new Nits(dividedByScalar(this, scalar));
	}

	// endregion

	// region composition

	public Candelas times(Area area) {
		return new Candelas(getAmount().times(getAmountIn(area, SQUARE_METER)));
	}

	// endregion
}
