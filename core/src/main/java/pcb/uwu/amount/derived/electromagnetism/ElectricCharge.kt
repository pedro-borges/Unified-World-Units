package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class ElectricCharge extends CompositeUnitAmount<ElectricChargeUnit> {

	// region constructors

	public ElectricCharge(Number value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(Number value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(String value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(String value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(BigDecimal value, ElectricChargeUnit unit) {
		super(value, unit);
	}

	public ElectricCharge(BigDecimal value, Magnitude magnitude, ElectricChargeUnit unit) {
		super(value, magnitude, unit);
	}

	public ElectricCharge(BigDecimalAmount amount, ElectricChargeUnit unit) {
		super(amount, unit);
	}

	public ElectricCharge(BigDecimalAmount amount, Magnitude magnitude, ElectricChargeUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public ElectricCharge plus(@NotNull UnitAmount<ElectricChargeUnit> other) {
		return new ElectricCharge(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public ElectricCharge minus(@NotNull UnitAmount<ElectricChargeUnit> other) {
		return new ElectricCharge(minusAmount(this, other), getUnit());
	}

	@Override
	public ElectricCharge multiply(BigDecimal other, MathContext mathContext) {
		return new ElectricCharge(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge div(BigDecimal other, MathContext mathContext) {
		return new ElectricCharge(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public ElectricCharge into(ElectricChargeUnit unit) {
		return new ElectricCharge(getAmountIn(this, unit), unit);
	}

	// endregion
}
