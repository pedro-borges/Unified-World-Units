package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFieldUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.electromagnetism.TeslaUnit.TESLA;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Teslas extends MagneticField {

	// region constructors

	public Teslas(Number value) {
		super(value, TESLA);
	}

	public Teslas(Number value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(String value) {
		super(value, TESLA);
	}

	public Teslas(String value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(BigDecimal value) {
		super(value, TESLA);
	}

	public Teslas(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, TESLA);
	}

	public Teslas(BigDecimalAmount amount) {
		super(amount, TESLA);
	}

	public Teslas(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, TESLA);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Teslas plus(@NotNull UnitAmount<MagneticFieldUnit> other) {
		return new Teslas(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Teslas minus(@NotNull UnitAmount<MagneticFieldUnit> other) {
		return new Teslas(minusAmount(this, other));
	}

	@Override
	public Teslas times(BigDecimal other, MathContext mathContext) {
		return new Teslas(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Teslas div(BigDecimal other, MathContext mathContext) {
		return new Teslas(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Teslas into(MagneticFieldUnit unit) {
		return new Teslas(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Webbers multipliedBy(Area area, MathContext mathContext) {
		return new Webbers(getAmount().times(getAmountIn(area, SQUARE_METER), mathContext));
	}
	
	// endregion
}
