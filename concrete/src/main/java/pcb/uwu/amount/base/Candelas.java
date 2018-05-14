package pcb.uwu.amount.base;

import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Luminance;
import pcb.uwu.amount.derived.optics.Nits;
import pcb.uwu.amount.derived.scalar.SolidAngle;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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
		return new Candelas(plusAmount(this, other, mathContext));
	}

	@Override
	public Candelas minus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(minusAmount(this, other, mathContext));
	}

	@Override
	public Candelas multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Candelas dividedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Lumens multipliedBy(SolidAngle solidAngle, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(getAmountIn(solidAngle, STERADIAN), mathContext));
	}

	public Nits dividedBy(Area area, MathContext mathContext) {
		return new Nits(getAmount().dividedBy(getAmountIn(area, SQUARE_METER), mathContext));
	}

	public SquareMeters dividedBy(Luminance luminance, MathContext mathContext) {
		return new SquareMeters(getAmount().dividedBy(getAmountIn(luminance, NIT), mathContext));
	}

	// endregion
}
