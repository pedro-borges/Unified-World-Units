package pcb.uwu.amount.derived.thermodynamics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.electromagnetism.Coulombs;
import pcb.uwu.amount.derived.electromagnetism.ElectricCharge;
import pcb.uwu.amount.derived.electromagnetism.ElectricPotential;
import pcb.uwu.amount.derived.electromagnetism.Volts;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.mechanics.Force;
import pcb.uwu.amount.derived.mechanics.Newtons;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.termodynamics.EnergyUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.derived.fundamental.CubicMeterUnit.CUBIC_METER;
import static pcb.uwu.unit.derived.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.derived.termodynamics.JouleUnit.JOULE;
import static pcb.uwu.unit.derived.termodynamics.PascalUnit.PASCAL;
import static pcb.uwu.unit.derived.termodynamics.WattUnit.WATT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Joules extends Energy {

	// region constructors

	public Joules(Number value) {
		super(value, JOULE);
	}

	public Joules(Number value, Magnitude magnitude) {
		super(value, magnitude, JOULE);
	}

	public Joules(String value) {
		super(value, JOULE);
	}

	public Joules(String value, Magnitude magnitude) {
		super(value, magnitude, JOULE);
	}

	public Joules(BigDecimal value) {
		super(value, JOULE);
	}

	public Joules(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, JOULE);
	}

	public Joules(BigDecimalAmount amount) {
		super(amount, JOULE);
	}

	public Joules(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, JOULE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Joules plus(@NotNull UnitAmount<EnergyUnit> amount) {
		return new Joules(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Joules minus(@NotNull UnitAmount<EnergyUnit> amount) {
		return new Joules(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Joules times(@NotNull Number number) {
		return new Joules(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Joules div(@NotNull Number number) {
		return new Joules(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Pascals div(Volume volume) {
		return new Pascals(getAmount().div(getAmountIn(volume, CUBIC_METER)));
	}

	public Volume div(Pressure pressure) {
		return new Volume(getAmount().div(getAmountIn(pressure, PASCAL)), CUBIC_METER);
	}

	public Seconds div(Power power) {
		return new Seconds(getAmount().div(getAmountIn(power, WATT)));
	}

	public Watts div(Time time) {
		return new Watts(getAmount().div(getAmountIn(time, SECOND)));
	}

	public Newtons div(Length length) {
		return new Newtons(getAmount().div(getAmountIn(length, METER)));
	}

	public Meters div(Force force) {
		return new Meters(getAmount().div(getAmountIn(force, NEWTON)));
	}

	public Volts div(ElectricCharge electricCharge) {
		return new Volts(getAmount().div(getAmountIn(electricCharge, COULOMB)));
	}

	public Coulombs div(ElectricPotential electricPotential) {
		return new Coulombs(getAmount().div(getAmountIn(electricPotential, VOLT)));
	}

	// endregion
}
