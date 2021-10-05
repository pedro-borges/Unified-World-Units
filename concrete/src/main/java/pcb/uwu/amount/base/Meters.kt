package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.mechanics.Force;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Meters extends Length {

	// region constructors

	public Meters(Number value) {
		super(value, METER);
	}

	public Meters(Number value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(String value) {
		super(value, METER);
	}

	public Meters(String value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(BigDecimal value) {
		super(value, METER);
	}

	public Meters(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, METER);
	}

	public Meters(BigDecimalAmount amount) {
		super(amount, METER);
	}

	public Meters(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, METER);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Meters plus(@NotNull UnitAmount<LengthUnit> other) {
		return new Meters(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Meters minus(@NotNull UnitAmount<LengthUnit> other) {
		return new Meters(minusAmount(this, other));
	}

	@Override
	public Meters times(BigDecimal other, MathContext mathContext) {
		return new Meters(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Meters div(BigDecimal other, MathContext mathContext) {
		return new Meters(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Joules multipliedBy(Force force, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(force, NEWTON), mathContext));
	}

	// endregion
}
