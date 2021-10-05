package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricInductance extends CompositeUnitAmount<ElectricInductanceUnit> {

	// region constructors

	public ElectricInductance(Number value, ElectricInductanceUnit unit) {
		super(value, unit);
	}

	public ElectricInductance(Number value, Magnitude magnitude, ElectricInductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricInductance(String value, ElectricInductanceUnit unit) {
		super(value, unit);
	}

	public ElectricInductance(String value, Magnitude magnitude, ElectricInductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricInductance(BigDecimal value, ElectricInductanceUnit unit) {
		super(value, unit);
	}

	public ElectricInductance(BigDecimal value, Magnitude magnitude, ElectricInductanceUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricInductance(BigDecimalAmount amount, ElectricInductanceUnit unit) {
		super(amount, unit);
	}

	public ElectricInductance(BigDecimalAmount amount, Magnitude magnitude, ElectricInductanceUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public ElectricInductance plus(@NotNull UnitAmount<ElectricInductanceUnit> other) {
		return new ElectricInductance(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public ElectricInductance minus(@NotNull UnitAmount<ElectricInductanceUnit> other) {
		return new ElectricInductance(minusAmount(this, other), getUnit());
	}

	@Override
	public ElectricInductance multiply(BigDecimal other, MathContext mathContext) {
		return new ElectricInductance(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance div(BigDecimal other, MathContext mathContext) {
		return new ElectricInductance(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance into(ElectricInductanceUnit unit) {
		return new ElectricInductance(getAmountIn(this, unit), unit);
	}

	// endregion
}
