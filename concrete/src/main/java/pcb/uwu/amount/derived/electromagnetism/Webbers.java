package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.thermodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.MagneticFluxUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.area.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.unit.derived.electromagnetism.TeslaUnit.TESLA;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.derived.electromagnetism.WebberUnit.WEBBER;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Webbers extends MagneticFlux {

	// region constructors

	public Webbers(Number value) {
		super(value, WEBBER);
	}

	public Webbers(Number value, Magnitude magnitude) {
		super(value, magnitude, WEBBER);
	}

	public Webbers(String value) {
		super(value, WEBBER);
	}

	public Webbers(String value, Magnitude magnitude) {
		super(value, magnitude, WEBBER);
	}

	public Webbers(BigDecimal value) {
		super(value, WEBBER);
	}

	public Webbers(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, WEBBER);
	}

	public Webbers(BigDecimalAmount amount) {
		super(amount, WEBBER);
	}

	public Webbers(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, WEBBER);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Webbers plus(@NotNull UnitAmount<MagneticFluxUnit> other) {
		return new Webbers(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Webbers minus(@NotNull UnitAmount<MagneticFluxUnit> other) {
		return new Webbers(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Webbers times(@NotNull Number other) {
		return new Webbers(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Webbers div(@NotNull Number other) {
		return new Webbers(dividedByScalar(this, other));
	}

	@Override
	public Webbers into(MagneticFluxUnit unit) {
		return new Webbers(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Volts div(Time time) {
		return new Volts(getAmount().div(getAmountIn(time, SECOND)));
	}

	public Seconds div(ElectricPotential electricPotential) {
		return new Seconds(getAmount().div(getAmountIn(electricPotential, VOLT)));
	}

	public Henries div(ElectricCurrent electricCurrent) {
		return new Henries(getAmount().div(getAmountIn(electricCurrent, AMPERE)));
	}

	public Amperes div(ElectricInductance electricInductance) {
		return new Amperes(getAmount().div(getAmountIn(electricInductance, HENRY)));
	}

	public Area div(MagneticField magneticField) {
		return new Area(getAmount().div(getAmountIn(magneticField, TESLA)), SQUARE_METER);
	}

	public Teslas div(Area area) {
		return new Teslas(getAmount().div(getAmountIn(area, SQUARE_METER)));
	}

	public Joules times(ElectricCurrent electricCurrent) {
		return new Joules(getAmount().times(getAmountIn(electricCurrent, AMPERE)));
	}

	// endregion
}
