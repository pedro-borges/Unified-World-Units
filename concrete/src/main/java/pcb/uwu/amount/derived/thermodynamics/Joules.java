package pcb.uwu.amount.derived.thermodynamics;

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

import java.math.BigDecimal;
import java.math.MathContext;

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
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
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

	@Override
	public Joules plus(UnitAmount<EnergyUnit> other, MathContext mathContext) {
		return new Joules(plusAmount(this, other, mathContext));
	}

	@Override
	public Joules minus(UnitAmount<EnergyUnit> other, MathContext mathContext) {
		return new Joules(minusAmount(this, other, mathContext));
	}

	@Override
	public Joules multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Joules(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Joules dividedBy(BigDecimal other, MathContext mathContext) {
		return new Joules(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Pascals dividedBy(Volume volume, MathContext mathContext) {
		return new Pascals(getAmount().dividedBy(getAmountIn(volume, CUBIC_METER), mathContext));
	}

	public Volume dividedBy(Pressure pressure, MathContext mathContext) {
		return new Volume(getAmount().dividedBy(getAmountIn(pressure, PASCAL), mathContext), CUBIC_METER);
	}

	public Seconds dividedBy(Power power, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(getAmountIn(power, WATT), mathContext));
	}

	public Watts dividedBy(Time time, MathContext mathContext) {
		return new Watts(getAmount().dividedBy(getAmountIn(time, SECOND), mathContext));
	}

	public Newtons dividedBy(Length length, MathContext mathContext) {
		return new Newtons(getAmount().dividedBy(getAmountIn(length, METER), mathContext));
	}

	public Meters dividedBy(Force force, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(getAmountIn(force, NEWTON), mathContext));
	}

	public Volts dividedBy(ElectricCharge electricCharge, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(getAmountIn(electricCharge, COULOMB), mathContext));
	}

	public Coulombs dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Coulombs(getAmount().dividedBy(getAmountIn(electricPotential, VOLT), mathContext));
	}

	// endregion
}
