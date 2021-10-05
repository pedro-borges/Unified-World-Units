package pcb.uwu.amount.derived.mechanics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.KiloGrams;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Mass;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.amount.derived.thermodynamics.Pascals;
import pcb.uwu.amount.derived.thermodynamics.Pressure;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Newtons plus(@NotNull UnitAmount<ForceUnit> force) {
		return new Newtons(plusAmount(this, force));
	}

	@NotNull
	@Override
	public Newtons minus(@NotNull UnitAmount<ForceUnit> force) {
		return new Newtons(minusAmount(this, force));
	}

	@NotNull
	@Override
	public Newtons times(@NotNull Number number) {
		return new Newtons(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Newtons div(@NotNull Number number) {
		return new Newtons(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public KiloGrams div(Acceleration acceleration) {
		return new KiloGrams(super.div(acceleration).getAmount());
	}

	public Acceleration div(Mass mass) {
		return new Acceleration(
				super.div(mass).getAmount(),
				new AccelerationUnit(METER, SECOND));
	}

	public Joules times(Length length) {
		return new Joules(getAmount().times(getAmountIn(length, METER)));
	}

	public Area div(Pressure pressure) {
		return new Area(getAmount().div(getAmountIn(pressure, PASCAL)), SQUARE_METER);
	}

	public Pascals div(Area area) {
		return new Pascals(getAmount().div(getAmountIn(area, SQUARE_METER)));
	}

	// endregion
}
