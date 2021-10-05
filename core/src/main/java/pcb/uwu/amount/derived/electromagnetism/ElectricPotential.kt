package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricPotentialUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricPotential extends CompositeUnitAmount<ElectricPotentialUnit> {

	// region constructors

	public ElectricPotential(Number value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(Number value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(String value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(String value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(BigDecimal value, ElectricPotentialUnit unit) {
		super(value, unit);
	}

	public ElectricPotential(BigDecimal value, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricPotential(BigDecimalAmount amount, ElectricPotentialUnit unit) {
		super(amount, unit);
	}

	public ElectricPotential(BigDecimalAmount amount, Magnitude magnitude, ElectricPotentialUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public ElectricPotential plus(@NotNull UnitAmount<ElectricPotentialUnit> other) {
		return new ElectricPotential(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public ElectricPotential minus(@NotNull UnitAmount<ElectricPotentialUnit> other) {
		return new ElectricPotential(minusAmount(this, other), getUnit());
	}

	@Override
	public ElectricPotential multiply(BigDecimal other, MathContext mathContext) {
		return new ElectricPotential(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential div(BigDecimal other, MathContext mathContext) {
		return new ElectricPotential(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricPotential into(ElectricPotentialUnit unit) {
		return new ElectricPotential(getAmountIn(this, unit), unit);
	}

	// endregion
}
