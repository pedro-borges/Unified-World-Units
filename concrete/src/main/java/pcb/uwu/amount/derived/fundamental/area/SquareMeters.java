package pcb.uwu.amount.derived.fundamental.area;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.AreaFactory;
import pcb.uwu.amount.derived.optics.Illuminance;
import pcb.uwu.amount.derived.optics.Lumens;
import pcb.uwu.amount.derived.optics.Luminance;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.AreaUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class SquareMeters extends Area {

	// region geometry factories

	public static final SquareMetersFactory FOR = new SquareMetersFactory();

	public static class SquareMetersFactory extends AreaFactory {

		@Override
		public SquareMeters circle(@NotNull Length radius) {
			return new SquareMeters(CIRCLE_FUNCTION.invoke(getAmountIn(radius, METER)));
		}

		@Override
		public SquareMeters square(@NotNull Length side) {
			return new SquareMeters(SQUARE_FUNCTION.invoke(getAmountIn(side, METER)));
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

	@NotNull
	@Override
	public SquareMeters plus(@NotNull UnitAmount<AreaUnit> area) {
		return new SquareMeters(plusAmount(this, area));
	}

	@NotNull
	@Override
	public SquareMeters minus(@NotNull UnitAmount<AreaUnit> area) {
		return new SquareMeters(minusAmount(this, area));
	}

	@NotNull
	@Override
	public SquareMeters times(@NotNull Number number) {
		return new SquareMeters(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public SquareMeters div(@NotNull Number number) {
		return new SquareMeters(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Candelas times(Luminance luminance) {
		return new Candelas(getAmount().times(getAmountIn(luminance, NIT)));
	}

	public Lumens times(Illuminance illuminance) {
		return new Lumens(getAmount().times(getAmountIn(illuminance, LUX)));
	}

	public Meters div(Length length) {
		return new Meters(getAmount().div(getAmountIn(length, METER)));
	}

	// endregion
}
