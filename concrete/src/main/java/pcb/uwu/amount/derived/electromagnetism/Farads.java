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
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Farads(plusAmount(this, other, mathContext));
	}

	@Override
	public Farads minus(UnitAmount<ElectricCapacitanceUnit> other, MathContext mathContext) {
		return new Farads(minusAmount(this, other, mathContext));
	}

	@Override
	public Farads multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Farads(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Farads dividedBy(BigDecimal other, MathContext mathContext) {
		return new Farads(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Farads in(ElectricCapacitanceUnit unit) {
		return new Farads(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Coulombs multipliedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Coulombs(getAmount().multipliedBy(getAmountIn(electricPotential, VOLT), mathContext));
	}

	public Seconds multipliedBy(ElectricResistance electricResistance, MathContext mathContext) {
		return new Seconds(getAmount().multipliedBy(getAmountIn(electricResistance, OHM), mathContext));
	}

	// endregion
}
