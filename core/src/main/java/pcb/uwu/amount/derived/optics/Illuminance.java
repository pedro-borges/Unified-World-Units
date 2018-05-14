package pcb.uwu.amount.derived.optics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.IlluminanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Illuminance extends CompositeUnitAmount<IlluminanceUnit> {

	// region constructors

	public Illuminance(Number value, IlluminanceUnit unit) {
		super(value, unit);
	}

	public Illuminance(Number value, Magnitude magnitude, IlluminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Illuminance(String value, IlluminanceUnit unit) {
		super(value, unit);
	}

	public Illuminance(String value, Magnitude magnitude, IlluminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Illuminance(BigDecimal value, IlluminanceUnit unit) {
		super(value, unit);
	}

	public Illuminance(BigDecimal value, Magnitude magnitude, IlluminanceUnit unit) {
		super(value, magnitude, unit);
	}

	public Illuminance(BigDecimalAmount amount, IlluminanceUnit unit) {
		super(amount, unit);
	}

	public Illuminance(BigDecimalAmount amount, Magnitude magnitude, IlluminanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Illuminance plus(UnitAmount<IlluminanceUnit> other, MathContext mathContext) {
		return new Illuminance(plusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Illuminance minus(UnitAmount<IlluminanceUnit> other, MathContext mathContext) {
		return new Illuminance(minusAmount(this, other, mathContext), getUnit());
	}

	@Override
	public Illuminance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Illuminance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Illuminance dividedBy(BigDecimal other, MathContext mathContext) {
		return new Illuminance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Illuminance in(IlluminanceUnit unit) {
		return new Illuminance(getAmountIn(this, unit), unit);
	}

	// endregion
}
