package pcb.uwu.amount.derived.electromagnetism;

import pcb.uwu.amount.base.Amperes;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.amount.base.Seconds;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.termodynamics.Joules;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.electromagnetism.MagneticFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.base.SecondUnit.SECOND;
import static pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.unit.derived.electromagnetism.TeslaUnit.TESLA;
import static pcb.uwu.unit.derived.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.derived.electromagnetism.WebberUnit.WEBBER;
import static pcb.uwu.unit.derived.fundamental.SquareMeterUnit.SQUARE_METER;

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

	@Override
	public Webbers plus(UnitAmount<MagneticFluxUnit> other, MathContext mathContext) {
		return new Webbers(plusAmount(other, mathContext));
	}

	@Override
	public Webbers minus(UnitAmount<MagneticFluxUnit> other, MathContext mathContext) {
		return new Webbers(minusAmount(other, mathContext));
	}

	@Override
	public Webbers multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Webbers(multipliedByScalar(other, mathContext));
	}

	@Override
	public Webbers dividedBy(BigDecimal other, MathContext mathContext) {
		return new Webbers(dividedByScalar(other, mathContext));
	}

	@Override
	public Webbers convertTo(MagneticFluxUnit unit) {
		return new Webbers(getAmountIn(unit));
	}

	// endregion

	// region composition

	public Volts dividedBy(Time time, MathContext mathContext) {
		return new Volts(getAmount().dividedBy(time.getAmountIn(SECOND), mathContext));
	}

	public Seconds dividedBy(ElectricPotential electricPotential, MathContext mathContext) {
		return new Seconds(getAmount().dividedBy(electricPotential.getAmountIn(VOLT), mathContext));
	}

	public Henries dividedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Henries(getAmount().dividedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	public Amperes dividedBy(ElectricInductance electricInductance, MathContext mathContext) {
		return new Amperes(getAmount().dividedBy(electricInductance.getAmountIn(HENRY), mathContext));
	}

	public Area dividedBy(MagneticField magneticField, MathContext mathContext) {
		return new Area(getAmount().dividedBy(magneticField.getAmountIn(TESLA), mathContext), SQUARE_METER);
	}

	public Teslas dividedBy(Area area, MathContext mathContext) {
		return new Teslas(getAmount().dividedBy(area.getAmountIn(SQUARE_METER), mathContext));
	}

	public Joules multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	// endregion
}
