package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.base.Seconds;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricCapacitanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.electromagnetism.FaradUnit.FARAD;
import static pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;

public class Farads extends ElectricCapacitance {

	// region constructors

	public Farads(Number value) {
		super(value, FARAD);
	}

	public Farads(Number value, Magnitude magnitude) {
		super(value, magnitude, FARAD);
	}

	public Farads(String value) {
		super(value, FARAD);
	}

	public Farads(String value, Magnitude magnitude) {
		super(value, magnitude, FARAD);
	}

	public Farads(BigDecimal value) {
		super(value, FARAD);
	}

	public Farads(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, FARAD);
	}

	public Farads(BigDecimalAmount amount) {
		super(amount, FARAD);
	}

	public Farads(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, FARAD);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Farads plus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new Farads(plusAmount(other, mathContext));
	}

	@Override
	public Farads minus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new Farads(minusAmount(other, mathContext));
	}

	@Override
	public Farads multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Farads(multipliedByScalar(other, mathContext));
	}

	@Override
	public Farads dividedBy(BigDecimal other, MathContext mathContext) {
		return new Farads(dividedByScalar(other, mathContext));
	}

	@Override
	public Farads in(ElectricCapacitanceUnit unit) {
		return new Farads(getAmountIn(unit));
	}

	// endregion

	// region composition

	public Coulombs multipliedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	public Seconds multipliedBy(ElectricResistance electricResistance, MathContext mathContext) {
		return new Seconds(getAmount().multipliedBy(electricResistance.getAmountIn(OHM), mathContext));
	}

	// endregion
}
