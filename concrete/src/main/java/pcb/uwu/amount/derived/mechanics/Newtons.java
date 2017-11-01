package pcb.uwu.amount.derived.mechanics;

import pcb.uwu.amount.base.KiloGrams;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Mass;
import pcb.uwu.amount.derived.area.Area;
import pcb.uwu.amount.derived.termodynamics.Joules;
import pcb.uwu.amount.derived.termodynamics.Pascals;
import pcb.uwu.amount.derived.termodynamics.Pressure;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUAREMETER;
import static pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL;

public class Newtons extends Force {

	// region constructors

	public Newtons(Number value) {
		super(value, NEWTON);
	}

	public Newtons(Number value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(String value) {
		super(value, NEWTON);
	}

	public Newtons(String value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimal value) {
		super(value, NEWTON);
	}

	public Newtons(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, NEWTON);
	}

	public Newtons(BigDecimalAmount amount) {
		super(amount, NEWTON);
	}

	public Newtons(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, NEWTON);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Newtons plus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(plusAmount(other, mathContext));
	}

	@Override
	public Newtons minus(UnitAmount<ForceUnit> other, MathContext mathContext) {
		return new Newtons(minusAmount(other, mathContext));
	}

	@Override
	public Newtons multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(multipliedByScalar(other, mathContext));
	}

	@Override
	public Newtons dividedBy(BigDecimal other, MathContext mathContext) {
		return new Newtons(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public KiloGrams dividedBy(Acceleration acceleration, MathContext mathContext) {
		return new KiloGrams(super.dividedBy(acceleration, mathContext).getAmount());
	}

	public Acceleration dividedBy(Mass mass, MathContext mathContext) {
		return new Acceleration(
				super.dividedBy(mass, mathContext).getAmount(),
				new AccelerationUnit(METER, SECOND));
	}

	public Joules multipliedBy(Length length, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(length.getAmountIn(METER), mathContext));
	}

	public Area dividedBy(Pressure pressure, MathContext mathContext) {
		return new Area(getAmount().dividedBy(pressure.getAmountIn(PASCAL), mathContext), SQUAREMETER);
	}

	public Pascals dividedBy(Area area, MathContext mathContext) {
		return new Pascals(getAmount().dividedBy(area.getAmountIn(SQUAREMETER), mathContext));
	}

	// endregion
}
