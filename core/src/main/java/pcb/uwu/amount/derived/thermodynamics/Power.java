package pcb.uwu.amount.derived.thermodynamics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.PowerUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Power extends CompositeUnitAmount<PowerUnit> {

	// region constructors

	public Power(Number value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(Number value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(String value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(String value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(BigDecimal value, PowerUnit unit) {
		super(value, unit);
	}

	public Power(BigDecimal value, Magnitude magnitude, PowerUnit unit) {
		super(value, magnitude, unit);
	}

	public Power(BigDecimalAmount amount, PowerUnit unit) {
		super(amount, unit);
	}

	public Power(BigDecimalAmount amount, Magnitude magnitude, PowerUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Power plus(@NotNull UnitAmount<PowerUnit> other) {
		return new Power(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Power minus(@NotNull UnitAmount<PowerUnit> other) {
		return new Power(minusAmount(this, other), getUnit());
	}

	@Override
	public Power multiply(BigDecimal other, MathContext mathContext) {
		return new Power(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Power div(BigDecimal other, MathContext mathContext) {
		return new Power(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Power into(PowerUnit unit) {
		return new Power(getAmountIn(this, unit), unit);
	}

	// endregion
}
