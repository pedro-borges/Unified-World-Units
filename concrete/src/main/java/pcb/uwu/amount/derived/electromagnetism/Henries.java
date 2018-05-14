package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY;

public class Henries extends ElectricInductance {

	// region constructors

	public Henries(Number value) {
		super(value, HENRY);
	}

	public Henries(Number value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(String value) {
		super(value, HENRY);
	}

	public Henries(String value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(BigDecimal value) {
		super(value, HENRY);
	}

	public Henries(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(BigDecimalAmount amount) {
		super(amount, HENRY);
	}

	public Henries(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, HENRY);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Henries plus(UnitAmount<ElectricInductanceUnit> other, MathContext mathContext) {
		return new Henries(plusAmount(other, mathContext));
	}

	@Override
	public Henries minus(UnitAmount<ElectricInductanceUnit> other, MathContext mathContext) {
		return new Henries(minusAmount(other, mathContext));
	}

	@Override
	public Henries multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Henries(multipliedByScalar(other, mathContext));
	}

	@Override
	public Henries dividedBy(BigDecimal other, MathContext mathContext) {
		return new Henries(dividedByScalar(other, mathContext));
	}

	@Override
	public Henries in(ElectricInductanceUnit unit) {
		return new Henries(getAmountIn(unit));
	}

	// endregion

	// region composition

	public Webbers multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Webbers(getAmount().multipliedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	// endregion
}
