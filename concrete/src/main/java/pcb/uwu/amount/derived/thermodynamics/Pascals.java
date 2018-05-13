package pcb.uwu.amount.derived.thermodynamics;

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

	@Override
	public Pascals plus(UnitAmount<PressureUnit> other, MathContext mathContext) {
		return new Pascals(plusAmount(other, mathContext));
	}

	@Override
	public Pascals minus(UnitAmount<PressureUnit> other, MathContext mathContext) {
		return new Pascals(minusAmount(other, mathContext));
	}

	@Override
	public Pascals multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Pascals(multipliedByScalar(other, mathContext));
	}

	@Override
	public Pascals dividedBy(BigDecimal other, MathContext mathContext) {
		return new Pascals(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Joules multipliedBy(Volume volume, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(volume.getAmountIn(CUBIC_METER), mathContext));
	}

	public Newtons multipliedBy(Area area, MathContext mathContext) {
		return new Newtons(getAmount().multipliedBy(area.getAmountIn(SQUARE_METER), mathContext));
	}

	// endregion
}
