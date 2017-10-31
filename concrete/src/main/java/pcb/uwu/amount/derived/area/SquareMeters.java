package pcb.uwu.amount.derived.area;

import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.optics.Illuminance;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Luminance;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.fundamental.AreaUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;

public class SquareMeters extends Area {

	// region constructors

	public SquareMeters(Number value) {
		super(value, SQUARE_METER);
	}

	public SquareMeters(Number value, Magnitude magnitude) {
		super(value, magnitude, SQUARE_METER);
	}

	public SquareMeters(String value) {
		super(value, SQUARE_METER);
	}

	public SquareMeters(String value, Magnitude magnitude) {
		super(value, magnitude, SQUARE_METER);
	}

	public SquareMeters(BigDecimal value) {
		super(value, SQUARE_METER);
	}

	public SquareMeters(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SQUARE_METER);
	}

	public SquareMeters(BigDecimalAmount amount) {
		super(amount, SQUARE_METER);
	}

	public SquareMeters(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SQUARE_METER);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public SquareMeters plus(UnitAmount<AreaUnit> other, MathContext mathContext) {
		return new SquareMeters(plusAmount(other, mathContext));
	}

	@Override
	public SquareMeters minus(UnitAmount<AreaUnit> other, MathContext mathContext) {
		return new SquareMeters(minusAmount(other, mathContext));
	}

	@Override
	public SquareMeters multipliedBy(BigDecimal other, MathContext mathContext) {
		return new SquareMeters(multipliedByScalar(other, mathContext));
	}

	@Override
	public SquareMeters dividedBy(BigDecimal other, MathContext mathContext) {
		return new SquareMeters(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Candelas multipliedBy(Luminance luminance, MathContext mathContext) {
		return new Candelas(getAmount().multipliedBy(luminance.getAmountIn(NIT), mathContext));
	}

	public Lumens multipliedBy(Illuminance illuminance, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(illuminance.getAmountIn(LUX), mathContext));
	}

	// endregion
}
