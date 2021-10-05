package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricConductance extends CompositeUnitAmount<ElectricConductanceUnit> {

	// region constructors

	public ElectricConductance(Number value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(Number value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(String value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(String value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(BigDecimal value, ElectricConductanceUnit unit) {
		super(value, unit);
	}

	public ElectricConductance(BigDecimal value, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricConductance(BigDecimalAmount amount, ElectricConductanceUnit unit) {
		super(amount, unit);
	}

	public ElectricConductance(BigDecimalAmount amount, Magnitude magnitude, ElectricConductanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public ElectricConductance plus(@NotNull UnitAmount<ElectricConductanceUnit> other) {
		return new ElectricConductance(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public ElectricConductance minus(@NotNull UnitAmount<ElectricConductanceUnit> other) {
		return new ElectricConductance(minusAmount(this, other), getUnit());
	}

	@Override
	public ElectricConductance multiply(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance div(BigDecimal other, MathContext mathContext) {
		return new ElectricConductance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricConductance into(ElectricConductanceUnit unit) {
		return new ElectricConductance(getAmountIn(this, unit), unit);
	}

	// endregion
}
