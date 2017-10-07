package pcb.uwu.impl.fundamental;

import pcb.uwu.amounts.fundamental.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.impl.composite.electromagnetism.Coulombs;
import pcb.uwu.units.fundamental.ElectricCurrentUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.units.fundamental.ElectricCurrentUnit.AMPERE;

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

	public Coulombs multipliedBy(Seconds time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.multipliedBy(time.getAmount().getValue(), mathContext);

		return new Coulombs(amount);
	}

	// endregion
}
