package pcb.uwu.amount.base;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.StoneUnit.STONE;

public class Stones extends Mass {

	// region constructors

	public Stones(Number value) {
		super(value, STONE);
	}

	public Stones(Number value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(String value) {
		super(value, STONE);
	}

	public Stones(String value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(BigDecimal value) {
		super(value, STONE);
	}

	public Stones(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(BigDecimalAmount amount) {
		super(amount, STONE);
	}

	public Stones(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, STONE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Stones plus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Stones(plusAmount(other, mathContext));
	}

	@Override
	public Stones minus(UnitAmount<MassUnit> other, MathContext mathContext) {
		return new Stones(minusAmount(other, mathContext));
	}

	@Override
	public Stones multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Stones(multipliedByScalar(other, mathContext));
	}

	@Override
	public Stones dividedBy(BigDecimal other, MathContext mathContext) {
		return new Stones(dividedByScalar(other, mathContext));
	}

	// endregion
}
