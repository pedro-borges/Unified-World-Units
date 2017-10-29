package pcb.uwu.amount.quantity;

import pcb.uwu.amount.composite.electromagnetism.Coulombs;
import pcb.uwu.amount.composite.electromagnetism.Ohms;
import pcb.uwu.amount.composite.electromagnetism.Volts;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;

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

	public Coulombs multipliedBy(Seconds seconds, MathContext mathContext) {
		return new Coulombs(super.multipliedBy(seconds, mathContext).getAmount());
	}

	public Volts multipliedBy(Ohms ohms, MathContext mathContext) {
		return new Volts(super.multipliedBy(ohms, mathContext).getAmount());
	}

	// endregion
}
