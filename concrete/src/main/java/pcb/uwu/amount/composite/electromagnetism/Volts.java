package pcb.uwu.amount.composite.electromagnetism;

import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.ElectricPotentialUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.composite.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;

public class Volts extends ElectricPotential {

	// region constructors

	public Volts(Number value) {
		super(value, VOLT);
	}

	public Volts(Number value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(String value) {
		super(value, VOLT);
	}

	public Volts(String value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(BigDecimal value) {
		super(value, VOLT);
	}

	public Volts(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, VOLT);
	}

	public Volts(BigDecimalAmount amount) {
		super(amount, VOLT);
	}

	public Volts(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, VOLT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Volts plus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new Volts(plusAmount(other, mathContext));
	}

	@Override
	public Volts minus(UnitAmount<ElectricPotentialUnit> other, MathContext mathContext) {
		return new Volts(minusAmount(other, mathContext));
	}

	@Override
	public Volts multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Volts(multipliedByScalar(other, mathContext));
	}

	@Override
	public Volts dividedBy(BigDecimal other, MathContext mathContext) {
		return new Volts(dividedByScalar(other, mathContext));
	}

	@Override
	public Volts convertTo(ElectricPotentialUnit unit) {
		return new Volts(getAmountIn(unit));
	}

	// endregion

	// region composition

	public Amperes dividedBy(ElectricResistance electricResistance, MathContext mathContext) {
		return new Amperes(getAmount().dividedBy(electricResistance.getAmountIn(OHM), mathContext));
	}

	public Ohms dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Ohms(getAmount().dividedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	public Joules multipliedBy(ElectricCharge electricCharge, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(electricCharge.getAmountIn(COULOMB), mathContext));
	}

	// endregion
}
