package pcb.uwu.amount.derived.optics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class LuminousEnergy extends CompositeUnitAmount<LuminousEnergyUnit> {

	// region constructors

	public LuminousEnergy(Number value, LuminousEnergyUnit unit) {
		super(value, unit);
	}

	public LuminousEnergy(Number value, Magnitude magnitude, LuminousEnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousEnergy(String value, LuminousEnergyUnit unit) {
		super(value, unit);
	}

	public LuminousEnergy(String value, Magnitude magnitude, LuminousEnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousEnergy(BigDecimal value, LuminousEnergyUnit unit) {
		super(value, unit);
	}

	public LuminousEnergy(BigDecimal value, Magnitude magnitude, LuminousEnergyUnit unit) {
		super(value, magnitude, unit);
	}

	public LuminousEnergy(BigDecimalAmount amount, LuminousEnergyUnit unit) {
		super(amount, unit);
	}

	public LuminousEnergy(BigDecimalAmount amount, Magnitude magnitude, LuminousEnergyUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public LuminousEnergy plus(UnitAmount<LuminousEnergyUnit> other, MathContext mathContext) {
		return new LuminousEnergy(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy minus(UnitAmount<LuminousEnergyUnit> other, MathContext mathContext) {
		return new LuminousEnergy(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy multipliedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousEnergy(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy dividedBy(BigDecimal other, MathContext mathContext) {
		return new LuminousEnergy(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy in(LuminousEnergyUnit unit) {
		return new LuminousEnergy(getAmountIn(unit), unit);
	}

	// endregion
}
