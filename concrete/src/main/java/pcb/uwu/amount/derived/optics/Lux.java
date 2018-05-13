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
		return new Lux(plusAmount(other, mathContext));
	}

	@Override
	public Lux minus(UnitAmount<IlluminanceUnit> other, MathContext mathContext) {
		return new Lux(minusAmount(other, mathContext));
	}

	@Override
	public Lux multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Lux(multipliedByScalar(other, mathContext));
	}

	@Override
	public Lux dividedBy(BigDecimal other, MathContext mathContext) {
		return new Lux(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Lumens multipliedBy(Area area, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(area.getAmountIn(SQUARE_METER), mathContext));
	}

	// endregion
}
