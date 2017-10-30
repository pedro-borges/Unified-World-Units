package pcb.uwu.amount.derived.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.fundamental.VolumeUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE;

public class Litres extends Volume {

	// region constructors

	public Litres(Number value) {
		super(value, LITRE);
	}

	public Litres(Number value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(String value) {
		super(value, LITRE);
	}

	public Litres(String value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(BigDecimal value) {
		super(value, LITRE);
	}

	public Litres(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(BigDecimalAmount amount) {
		super(amount, LITRE);
	}

	public Litres(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LITRE);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Litres plus(UnitAmount<VolumeUnit> other, MathContext mathContext) {
		return new Litres(plusAmount(other, mathContext));
	}

	@Override
	public Litres minus(UnitAmount<VolumeUnit> other, MathContext mathContext) {
		return new Litres(minusAmount(other, mathContext));
	}

	@Override
	public Litres multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Litres(multipliedByScalar(other, mathContext));
	}

	@Override
	public Litres dividedBy(BigDecimal other, MathContext mathContext) {
		return new Litres(dividedByScalar(other, mathContext));
	}

	// endregion
}
