package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.mechanics.Acceleration;
import pcb.uwu.amount.composite.mechanics.Force;
import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.ForceUnit;
import pcb.uwu.units.quantity.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Mass extends AbstractUnitAmount<MassUnit> {

	// region constructors

	public Mass(Number value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(Number value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(String value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(String value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(BigDecimal value, MassUnit unit) {
		super(value, unit);
	}

	public Mass(BigDecimal value, Magnitude magnitude, MassUnit unit) {
		super(value, magnitude, unit);
	}

	public Mass(BigDecimalAmount amount, MassUnit unit) {
		super(amount, unit);
	}

	public Mass(BigDecimalAmount amount, Magnitude magnitude, MassUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Mass plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Mass(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Mass(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Mass multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Mass dividedBy(BigDecimal other, MathContext mathContext) {
		return new Mass(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Mass convertTo(MassUnit unit) {
		return new Mass(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public Force multipliedBy(Acceleration acceleration, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(acceleration.getAmount().getValue(), mathContext);
		ForceUnit unit = new ForceUnit(getUnit(), acceleration.getUnit());

		return new Force(amount, unit);
	}

	// endregion
}
