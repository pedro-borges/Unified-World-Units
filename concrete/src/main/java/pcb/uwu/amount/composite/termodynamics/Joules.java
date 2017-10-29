package pcb.uwu.amount.composite.termodynamics;

import pcb.uwu.amount.composite.electromagnetism.Coulombs;
import pcb.uwu.amount.composite.electromagnetism.ElectricCharge;
import pcb.uwu.amount.composite.electromagnetism.ElectricPotential;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.amount.composite.fundamental.Volume;
import pcb.uwu.amount.composite.mechanics.Force;
import pcb.uwu.amount.composite.mechanics.Newtons;
import pcb.uwu.amount.quantity.Length;
import pcb.uwu.amount.quantity.Meters;
import pcb.uwu.amount.quantity.Seconds;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.termodynamics.EnergyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.CoulombUnit.COULOMB;
import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.composite.fundamental.CubicMeterUnit.CUBIC_METER;
import static pcb.uwu.unit.composite.mechanics.NewtonUnit.NEWTON;
import static pcb.uwu.unit.composite.termodynamics.JouleUnit.JOULE;
import static pcb.uwu.unit.composite.termodynamics.PascalUnit.PASCAL;
import static pcb.uwu.unit.composite.termodynamics.WattUnit.WATT;
import static pcb.uwu.unit.quantity.MeterUnit.METER;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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
		return new Joules(plusAmount(other, mathContext));
	}

	@Override
	public Joules minus(UnitAmount<EnergyUnit> other, MathContext mathContext) {
		return new Joules(minusAmount(other, mathContext));
	}

	@Override
	public Joules multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Joules(multipliedByScalar(other, mathContext));
	}

	@Override
	public Joules dividedBy(BigDecimal other, MathContext mathContext) {
		return new Joules(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Pascals dividedBy(Volume volume, MathContext mathContext) {
		return new Pascals(getAmount().dividedBy(volume.getAmountIn(CUBIC_METER), mathContext));
	}

	public Volume dividedBy(Pressure pressure, MathContext mathContext) {
		return new Volume(getAmount().dividedBy(pressure.getAmountIn(PASCAL), mathContext), CUBIC_METER);
	}

	public Seconds dividedBy(Power power, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(power.getAmountIn(WATT), mathContext));
	}

	public Watts dividedBy(Time time, MathContext mathContext) {
		return new Watts(getAmount().dividedBy(time.getAmountIn(SECOND), mathContext));
	}

	public Newtons dividedBy(Length length, MathContext mathContext) {
		return new Newtons(getAmount().dividedBy(length.getAmountIn(METER), mathContext));
	}

	public Meters dividedBy(Force force, MathContext mathContext) {
		return new Meters(getAmount().dividedBy(force.getAmountIn(NEWTON), mathContext));
	}

	public Volts dividedBy(ElectricCharge electricCharge, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(electricCharge.getAmountIn(COULOMB), mathContext));
	}

	public Coulombs dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Coulombs(getAmount().dividedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	// endregion
}
