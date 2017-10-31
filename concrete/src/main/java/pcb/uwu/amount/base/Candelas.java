package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.area.SquareMeters;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Luminance;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.amount.derived.scalar.SolidAngle;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.base.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;

public class Candelas extends LuminousIntensity {

	// region constructors

	public Candelas(Number value) {
		super(value, CANDELA);
	}

	public Candelas(Number value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(String value) {
		super(value, CANDELA);
	}

	public Candelas(String value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(BigDecimal value) {
		super(value, CANDELA);
	}

	public Candelas(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(BigDecimalAmount amount) {
		super(amount, CANDELA);
	}

	public Candelas(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, CANDELA);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Candelas plus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(plusAmount(other, mathContext));
	}

	@Override
	public Candelas minus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(minusAmount(other, mathContext));
	}

	@Override
	public Candelas multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(multipliedByScalar(other, mathContext));
	}

	@Override
	public Candelas dividedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Lumens multipliedBy(SolidAngle solidAngle, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(solidAngle.getAmountIn(STERADIAN), mathContext));
	}

	public Nits dividedBy(Area area, MathContext mathContext) {
		return new Nits(getAmount().dividedBy(area.getAmountIn(SQUARE_METER), mathContext));
	}

	public SquareMeters dividedBy(Luminance luminance, MathContext mathContext) {
		return new SquareMeters(getAmount().dividedBy(luminance.getAmountIn(NIT), mathContext));
	}

	// endregion
}
