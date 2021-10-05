package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.electromagnetism.ElectricConductance;
import pcb.uwu.amount.derived.electromagnetism.ElectricInductance;
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential;
import pcb.uwu.amount.derived.electromagnetism.ElectricResistance;
import pcb.uwu.amount.derived.electromagnetism.MagneticFlux;
import pcb.uwu.amount.derived.electromagnetism.Siemens;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.amount.derived.electromagnetism.Webbers;
import pcb.uwu.amount.derived.thermodynamics.Joules;
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
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Amperes plus(@NotNull UnitAmount<ElectricCurrentUnit> other) {
		return new Amperes(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Amperes minus(@NotNull UnitAmount<ElectricCurrentUnit> other) {
		return new Amperes(minusAmount(this, other));
	}

	@Override
	public Amperes times(BigDecimal other, MathContext mathContext) {
		return new Amperes(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Amperes div(BigDecimal other, MathContext mathContext) {
		return new Amperes(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Coulombs times(Time time, MathContext mathContext) {
		return new Coulombs(getAmount().times(getAmountIn(time, SECOND), mathContext));
	}

	public Volts times(ElectricResistance electricResistance, MathContext mathContext) {
		return new Volts(getAmount().times(getAmountIn(electricResistance, OHM), mathContext));
	}

	public Webbers times(ElectricInductance electricInductance, MathContext mathContext) {
		return new Webbers(getAmount().times(getAmountIn(electricInductance, HENRY), mathContext));
	}

	public Joules times(MagneticFlux magneticFlux, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(magneticFlux, WEBBER), mathContext));
	}

	public Siemens div(ElectricPotential electricPotential, MathContext mathContext) {
		return new Siemens(getAmount().div(getAmountIn(electricPotential, VOLT), mathContext));
	}

	public Volts div(ElectricConductance electricConductance, MathContext mathContext) {
		return new Volts(getAmount().div(getAmountIn(electricConductance, SIEMENS), mathContext));
	}

	// endregion
}
