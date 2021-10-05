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
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.derived.electromagnetism.FaradUnit.FARAD;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Coulombs plus(@NotNull UnitAmount<ElectricChargeUnit> amount) {
		return new Coulombs(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Coulombs minus(@NotNull UnitAmount<ElectricChargeUnit> amount) {
		return new Coulombs(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Coulombs times(@NotNull Number number) {
		return new Coulombs(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Coulombs div(@NotNull Number number) {
		return new Coulombs(dividedByScalar(this, number));
	}

	@Override
	public Coulombs to(ElectricChargeUnit unit) {
		return new Coulombs(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Amperes div(Time time) {
		return new Amperes(getAmount().div(getAmountIn(time, SECOND)));
	}

	public Seconds div(ElectricCurrent electricCurrent) {
		return new Seconds(getAmount().div(getAmountIn(electricCurrent, AMPERE)));
	}

	public Volts div(ElectricCapacitance electricCapacitance) {
		return new Volts(getAmount().div(getAmountIn(electricCapacitance, FARAD)));
	}

	public Farads div(ElectricPotential electricPotential) {
		return new Farads(getAmount().div(getAmountIn(electricPotential, VOLT)));
	}

	public Joules times(ElectricPotential electricPotential) {
		return new Joules(getAmount().times(getAmountIn(electricPotential, VOLT)));
	}

	// endregion
}
