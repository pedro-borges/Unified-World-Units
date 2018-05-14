package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

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

	@Override
	public ElectricInductance plus(UnitAmount<ElectricInductanceUnit> other, MathContext mathContext) {
		return new ElectricInductance(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance minus(UnitAmount<ElectricInductanceUnit> other, MathContext mathContext) {
		return new ElectricInductance(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance multipliedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricInductance(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance dividedBy(BigDecimal other, MathContext mathContext) {
		return new ElectricInductance(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public ElectricInductance in(ElectricInductanceUnit unit) {
		return new ElectricInductance(getAmountIn(unit), unit);
	}

	// endregion
}
