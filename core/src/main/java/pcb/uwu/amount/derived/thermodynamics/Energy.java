package pcb.uwu.amount.derived.thermodynamics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.EnergyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Energy extends CompositeUnitAmount<EnergyUnit> {

	// region constructors

	public Energy(Number value, EnergyUnit unit) {
		super(value, unit);
	}

	public Energy(Number value, Magnitude magnitude, EnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public Energy(String value, EnergyUnit unit) {
		super(value, unit);
	}

	public Energy(String value, Magnitude magnitude, EnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public Energy(BigDecimal value, EnergyUnit unit) {
		super(value, unit);
	}

	public Energy(BigDecimal value, Magnitude magnitude, EnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public Energy(BigDecimalAmount amount, EnergyUnit unit) {
		super(amount, unit);
	}

	public Energy(BigDecimalAmount amount, Magnitude magnitude, EnergyUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Energy plus(UnitAmount<EnergyUnit> other, MathContext mathContext) {
		return new Energy(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Energy minus(UnitAmount<EnergyUnit> other, MathContext mathContext) {
		return new Energy(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Energy multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Energy(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Energy dividedBy(BigDecimal other, MathContext mathContext) {
		return new Energy(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Energy convertTo(EnergyUnit unit) {
		return new Energy(getAmountIn(unit), unit);
	}

	// endregion

}
