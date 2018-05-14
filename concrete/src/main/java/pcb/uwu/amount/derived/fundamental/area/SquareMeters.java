package pcb.uwu.amount.derived.fundamental.area;

import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.optics.Illuminance;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Luminance;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.AreaUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class SquareMeters extends Area {

	// region geometry factories

	public static final SquareMetersFactory FOR = new SquareMetersFactory();

	public static class SquareMetersFactory extends AreaFactory {

		@Override
		public SquareMeters circleWithRadius(Length radius, MathContext mathContext) {
			return new SquareMeters(CIRCLE_FUNCTION.apply(getAmountIn(radius, METER), mathContext));
		}

		@Override
		public SquareMeters squareWithSide(Length side, MathContext mathContext) {
			return new SquareMeters(SQUARE_FUNCTION.apply(getAmountIn(side, METER), mathContext));
		}
	}

	// endregion

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
		return new SquareMeters(plusAmount(this, other, mathContext));
	}

	@Override
	public SquareMeters minus(UnitAmount<AreaUnit> other, MathContext mathContext) {
		return new SquareMeters(minusAmount(this, other, mathContext));
	}

	@Override
	public SquareMeters multipliedBy(BigDecimal other, MathContext mathContext) {
		return new SquareMeters(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public SquareMeters dividedBy(BigDecimal other, MathContext mathContext) {
		return new SquareMeters(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	public Candelas multipliedBy(Luminance luminance, MathContext mathContext) {
		return new Candelas(getAmount().multipliedBy(getAmountIn(luminance, NIT), mathContext));
	}

	public Lumens multipliedBy(Illuminance illuminance, MathContext mathContext) {
		return new Lumens(getAmount().multipliedBy(getAmountIn(illuminance, LUX), mathContext));
	}

	// endregion
}
