package pcb.uwu.impl.composite.electromagnetism;

import pcb.uwu.amounts.composite.electromagnetism.ElectricCharge;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit.COULOMB;

public class Coulombs extends ElectricCharge {

	// region constructors

	public Coulombs(Number value) {
		super(value, COULOMB);
	}

	public Coulombs(Number value, Magnitude magnitude) {
		super(value, magnitude, COULOMB);
	}

	public Coulombs(String value) {
		super(value, COULOMB);
	}

	public Coulombs(String value, Magnitude magnitude) {
		super(value, magnitude, COULOMB);
	}

	public Coulombs(BigDecimal value) {
		super(value, COULOMB);
	}

	public Coulombs(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, COULOMB);
	}

	public Coulombs(BigDecimalAmount amount) {
		super(amount, COULOMB);
	}

	public Coulombs(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, COULOMB);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Coulombs plus(UnitAmount<ElectricChargeUnit> other, MathContext mathContext) {
		return new Coulombs(plusAmount(other, mathContext));
	}

	@Override
	public Coulombs minus(UnitAmount<ElectricChargeUnit> other, MathContext mathContext) {
		return new Coulombs(minusAmount(other, mathContext));
	}

	@Override
	public Coulombs multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Coulombs(multipliedByScalar(other, mathContext));
	}

	@Override
	public Coulombs dividedBy(BigDecimal other, MathContext mathContext) {
		return new Coulombs(dividedByScalar(other, mathContext));
	}

	@Override
	public Coulombs convertTo(ElectricChargeUnit unit) {
		return new Coulombs(getAmountIn(unit));
	}

	// endregion
}
