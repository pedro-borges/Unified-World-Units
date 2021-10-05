package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
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
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.optics.NitUnit.NIT;
import static pcb.uwu.unit.scalar.SteradianUnit.STERADIAN;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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

	@NotNull
	@Override
	public Candelas plus(@NotNull UnitAmount<LuminousIntensityUnit> amount) {
		return new Candelas(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Candelas minus(@NotNull UnitAmount<LuminousIntensityUnit> amount) {
		return new Candelas(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Candelas times(@NotNull Number number) {
		return new Candelas(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Candelas div(@NotNull Number number) {
		return new Candelas(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	public Lumens times(SolidAngle solidAngle) {
		return new Lumens(getAmount().times(getAmountIn(solidAngle, STERADIAN)));
	}

	public Nits div(Area area) {
		return new Nits(getAmount().div(getAmountIn(area, SQUARE_METER)));
	}

	public SquareMeters div(Luminance luminance) {
		return new SquareMeters(getAmount().div(getAmountIn(luminance, NIT)));
	}

	// endregion
}
