package pcb.uwu.amount.derived.optics;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.LuminousIntensity;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.fundamental.area.SquareMeters;
import pcb.uwu.amount.derived.scalar.SolidAngle;
import pcb.uwu.amount.derived.scalar.Steradians;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.optics.LuminousFluxUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.optics.LuxUnit.LUX;
import static pcb.uwu.unit.scalar.SteradianUnit.STERADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Lumens extends LuminousFlux {

	// region constructors

	public Lumens(Number value) {
		super(value, LUMEN);
	}

	public Lumens(Number value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(String value) {
		super(value, LUMEN);
	}

	public Lumens(String value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimal value) {
		super(value, LUMEN);
	}

	public Lumens(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimalAmount amount) {
		super(amount, LUMEN);
	}

	public Lumens(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LUMEN);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Lumens plus(@NotNull UnitAmount<LuminousFluxUnit> luminousFlux) {
		return new Lumens(plusAmount(this, luminousFlux));
	}

	@NotNull
	@Override
	public Lumens minus(@NotNull UnitAmount<LuminousFluxUnit> luminousFlux) {
		return new Lumens(minusAmount(this, luminousFlux));
	}

	@NotNull
	@Override
	public Lumens times(@NotNull Number scalar) {
		return new Lumens(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Lumens div(@NotNull Number scalar) {
		return new Lumens(dividedByScalar(this, scalar));
	}

	// endregion

	// region composition

	public Candelas div(SolidAngle solidAngle) {
		return new Candelas(getAmount().div(getAmountIn(solidAngle, STERADIAN)));
	}

	public Steradians div(LuminousIntensity luminousIntensity) {
		return new Steradians(getAmount().div(getAmountIn(luminousIntensity, CANDELA)));
	}

	public Talbots times(Time time) {
		return new Talbots(getAmount().times(getAmountIn(time, SECOND)));
	}

	public Lux div(Area area) {
		return new Lux(getAmount().div(getAmountIn(area, SQUARE_METER)));
	}

	public SquareMeters div(Illuminance illuminance) {
		return new SquareMeters(getAmount().div(getAmountIn(illuminance, LUX)));
	}

	// endregion
}
