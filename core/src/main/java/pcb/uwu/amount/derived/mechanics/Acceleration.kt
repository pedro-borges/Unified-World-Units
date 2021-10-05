package pcb.uwu.amount.derived.mechanics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Mass;
import pcb.uwu.amount.base.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;
import pcb.uwu.unit.derived.mechanics.AccelerationUnit;
import pcb.uwu.unit.derived.mechanics.ForceUnit;
import pcb.uwu.unit.derived.mechanics.SpeedUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Acceleration extends CompositeUnitAmount<AccelerationUnit> {

	// region constructors

	public Acceleration(Number value, AccelerationUnit unit) {
		super(value, unit);
	}

	public Acceleration(Number value, Magnitude magnitude, AccelerationUnit unit) {
		super(value, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Acceleration plus(@NotNull UnitAmount<AccelerationUnit> other) {
		return new Acceleration(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Acceleration minus(@NotNull UnitAmount<AccelerationUnit> other) {
		return new Acceleration(minusAmount(this, other), getUnit());
	}

	@Override
	public Acceleration multiply(BigDecimal other, MathContext mathContext) {
		return new Acceleration(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Acceleration div(BigDecimal other, MathContext mathContext) {
		return new Acceleration(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Acceleration into(AccelerationUnit unit) {
		return new Acceleration(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	public Force multipliedBy(Mass mass, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.times(mass.getAmount().getValue(), mathContext);
		ForceUnit unit = new ForceUnit(mass.getUnit(), getUnit());

		return new Force(amount, unit);
	}

	public Speed multipliedBy(Time time, MathContext mathContext) {
		LengthUnit lengthUnit = getUnit().getUnitCounter().findUnit(LengthUnit.class);
		TimeUnit timeUnit = getUnit().getUnitCounter().findUnit(TimeUnit.class);

		return new Speed(super.multiply(time, mathContext).getAmount(), new SpeedUnit(lengthUnit, timeUnit));
	}

	// endregion
}
