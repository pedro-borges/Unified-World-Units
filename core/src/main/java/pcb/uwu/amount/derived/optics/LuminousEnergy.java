package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousEnergyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public LuminousEnergy plus(@NotNull UnitAmount<LuminousEnergyUnit> other) {
		return new LuminousEnergy(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public LuminousEnergy minus(@NotNull UnitAmount<LuminousEnergyUnit> other) {
		return new LuminousEnergy(minusAmount(this, other), getUnit());
	}

	@Override
	public LuminousEnergy multiply(BigDecimal other, MathContext mathContext) {
		return new LuminousEnergy(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy div(BigDecimal other, MathContext mathContext) {
		return new LuminousEnergy(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public LuminousEnergy into(LuminousEnergyUnit unit) {
		return new LuminousEnergy(getAmountIn(this, unit), unit);
	}

	// endregion
}
