package pcb.uwu.amount.composite.electromagnetism;

import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.ElectricCurrent;
import pcb.uwu.amount.quantity.Seconds;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricChargeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.composite.electromagnetism.FaradUnit.FARAD;
import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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

	// region composition

	public Amperes dividedBy(Time time, MathContext mathContext) {
		return new Amperes(getAmount().dividedBy(time.getAmountIn(SECOND), mathContext));
	}

	public Seconds dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	public Volts dividedBy(ElectricCapacitance electricCapacitance, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(electricCapacitance.getAmountIn(FARAD), mathContext));
	}

	public Farads dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Farads(getAmount().dividedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	public Joules multipliedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	// endregion
}
