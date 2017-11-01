package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.electromagnetism.ElectricConductance;
import pcb.uwu.amount.derived.electromagnetism.ElectricInductance;
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential;
import pcb.uwu.amount.derived.electromagnetism.ElectricResistance;
import pcb.uwu.amount.derived.electromagnetism.MagneticFlux;
import pcb.uwu.amount.derived.electromagnetism.Siemens;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.amount.derived.electromagnetism.Webbers;
import pcb.uwu.amount.derived.termodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.derived.electromagnetism.SiemensUnit.SIEMENS;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.derived.electromagnetism.WebberUnit.WEBBER;

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

	public Coulombs multipliedBy(Time unitAmount, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(unitAmount.getAmountIn(SECOND), mathContext));
	}

	public Volts multipliedBy(ElectricResistance unitAmount, MathContext mathContext) {
		return new Volts(getAmount().multipliedBy(unitAmount.getAmountIn(OHM), mathContext));
	}

	public Webbers multipliedBy(ElectricInductance unitAmount, MathContext mathContext) {
		return new Webbers(getAmount().multipliedBy(unitAmount.getAmountIn(HENRY), mathContext));
	}

	public Joules multipliedBy(MagneticFlux unitAmount, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(unitAmount.getAmountIn(WEBBER), mathContext));
	}

	public Siemens dividedBy(ElectricPotential unitAmount, MathContext mathContext) {
		return new Siemens(getAmount().dividedBy(unitAmount.getAmountIn(VOLT), mathContext));
	}

	public Volts dividedBy(ElectricConductance unitAmount, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(unitAmount.getAmountIn(SIEMENS), mathContext));
	}

	// endregion
}
