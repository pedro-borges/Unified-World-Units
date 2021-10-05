package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Ohms extends ElectricResistance {

	// region constructors

	public Ohms(Number value) {
		super(value, OHM);
	}

	public Ohms(Number value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(String value) {
		super(value, OHM);
	}

	public Ohms(String value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(BigDecimal value) {
		super(value, OHM);
	}

	public Ohms(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, OHM);
	}

	public Ohms(BigDecimalAmount amount) {
		super(amount, OHM);
	}

	public Ohms(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, OHM);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Ohms plus(@NotNull UnitAmount<ElectricResistanceUnit> other) {
		return new Ohms(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Ohms minus(@NotNull UnitAmount<ElectricResistanceUnit> other) {
		return new Ohms(minusAmount(this, other));
	}

	@Override
	public Ohms multiply(BigDecimal other, MathContext mathContext) {
		return new Ohms(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Ohms div(BigDecimal other, MathContext mathContext) {
		return new Ohms(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Ohms into(ElectricResistanceUnit unit) {
		return new Ohms(getAmountIn(this, unit));
	}

	@Override
	public Siemens invert(MathContext mathContext) {
		return new Siemens(getAmount().invert(mathContext));
	}

	// endregion

	// region composition

	public Volts multipliedBy(ElectricCurrent electricCurrent, MathContext mathContext) {
		return new Volts(getAmount().times(getAmountIn(electricCurrent, AMPERE), mathContext));
	}

	// endregion
}
