package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricChargeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.derived.electromagnetism.FaradUnit.FARAD;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Coulombs plus(@NotNull UnitAmount<ElectricChargeUnit> other) {
		return new Coulombs(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Coulombs minus(@NotNull UnitAmount<ElectricChargeUnit> other) {
		return new Coulombs(minusAmount(this, other));
	}

	@Override
	public Coulombs multiply(BigDecimal other, MathContext mathContext) {
		return new Coulombs(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Coulombs div(BigDecimal other, MathContext mathContext) {
		return new Coulombs(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Coulombs into(ElectricChargeUnit unit) {
		return new Coulombs(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Amperes dividedBy(Time time, MathContext mathContext) {
		return new Amperes(getAmount().div(getAmountIn(time, SECOND), mathContext));
	}

	public Seconds dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Seconds(getAmount().div(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	public Volts dividedBy(ElectricCapacitance electricCapacitance, MathContext mathContext) {
		return new Volts(getAmount().div(getAmountIn(electricCapacitance, FARAD), mathContext));
	}

	public Farads dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Farads(getAmount().div(getAmountIn(electricPotential, VOLT), mathContext));
	}

	public Joules multipliedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Joules(getAmount().times(getAmountIn(electricPotential, VOLT), mathContext));
	}

	// endregion
}
