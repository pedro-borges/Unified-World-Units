package pcb.uwu.amount.composite.electromagnetism;

import pcb.uwu.amount.composite.fundamental.Area;
import pcb.uwu.amount.composite.termodynamics.Joules;
import pcb.uwu.amount.quantity.Amperes;
import pcb.uwu.amount.quantity.ElectricCurrent;
import pcb.uwu.amount.quantity.Seconds;
import pcb.uwu.amount.quantity.Time;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.electromagnetism.MagneticFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.composite.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.unit.composite.electromagnetism.TeslaUnit.TESLA;
import static pcb.uwu.unit.composite.electromagnetism.VoltUnit.VOLT;
import static pcb.uwu.unit.composite.electromagnetism.WebberUnit.WEBBER;
import static pcb.uwu.unit.composite.fundamental.SquareMeterUnit.SQUARE_METER;
import static pcb.uwu.unit.quantity.AmpereUnit.AMPERE;
import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

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

	public Joules multiplyBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Joules(getAmount().multipliedBy(electricCurrent.getAmountIn(AMPERE), mathContext));
	}

	// endregion
}
