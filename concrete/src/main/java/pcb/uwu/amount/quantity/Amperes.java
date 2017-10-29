package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.electromagnetism.Coulombs;
import pcb.uwu.amount.composite.electromagnetism.ElectricConductance;
import pcb.uwu.amount.composite.electromagnetism.ElectricInductance;
import pcb.uwu.amount.composite.electromagnetism.ElectricPotential;
import pcb.uwu.amount.composite.electromagnetism.ElectricResistance;
import pcb.uwu.amount.composite.electromagnetism.MagneticFlux;
import pcb.uwu.amount.composite.electromagnetism.Siemens;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.amount.composite.electromagnetism.Webbers;
import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.unit.composite.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.composite.electromagnetism.SiemensUnit.SIEMENS;
import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.composite.electromagnetism.WebberUnit.WEBBER;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class Amperes extends ElectricCurrent {

	// region constructors

	public Amperes(Number value) {
		super(value, AMPERE);
	}

	public Amperes(Number value, Magnitude magnitude) {
		super(value, magnitude, AMPERE);
	}

	public Amperes(String value) {
		super(value, AMPERE);
	}

	public Amperes(String value, Magnitude magnitude) {
		super(value, magnitude, AMPERE);
	}

	public Amperes(BigDecimal value) {
		super(value, AMPERE);
	}

	public Amperes(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, AMPERE);
	}

	public Amperes(BigDecimalAmount amount) {
		super(amount, AMPERE);
	}

	public Amperes(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, AMPERE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Amperes plus(UnitAmount<ElectricCurrentUnit> other, MathContext mathContext) {
		return new Amperes(plusAmount(other, mathContext));
	}

	@Override
	public Amperes minus(UnitAmount<ElectricCurrentUnit> other, MathContext mathContext) {
		return new Amperes(minusAmount(other, mathContext));
	}

	@Override
	public Amperes multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Amperes(multipliedByScalar(other, mathContext));
	}

	@Override
	public Amperes dividedBy(BigDecimal other, MathContext mathContext) {
		return new Amperes(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Coulombs multipliedBy(Time time, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(time.getAmountIn(SECOND), mathContext));
	}

	public Volts multipliedBy(ElectricResistance electricResistance, MathContext mathContext) {
		return new Volts(getAmount().multipliedBy(electricResistance.getAmountIn(OHM), mathContext));
	}

	public Siemens dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Siemens(getAmount().dividedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	public Volts dividedBy(ElectricConductance electricConductance, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(electricConductance.getAmountIn(SIEMENS), mathContext));
	}

	public Webbers multipliedBy(ElectricInductance electricInductance, MathContext mathContext) {
		return new Webbers(getAmount().multipliedBy(electricInductance.getAmountIn(HENRY), mathContext));
	}

	public Joules multipliedBy(MagneticFlux magneticFlux, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(magneticFlux.getAmountIn(WEBBER), mathContext));
	}

	// endregion
}
