package pcb.uwu.amount.derived.optics;

import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.IlluminanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
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

	@Override
	public Lux plus(UnitAmount<IlluminanceUnit> other, MathContext mathContext) {
		return new Lux(plusAmount(this, other, mathContext));
	}

	@Override
	public Lux minus(UnitAmount<IlluminanceUnit> other, MathContext mathContext) {
		return new Lux(minusAmount(this, other, mathContext));
	}

	@Override
	public Lux multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Lux(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Lux dividedBy(BigDecimal other, MathContext mathContext) {
		return new Lux(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Lumens multipliedBy(Area area, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(getAmountIn(area, SQUARE_METER), mathContext));
	}

	// endregion
}
