package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricResistanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.OhmUnit.OHM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Ohms plus(@NotNull UnitAmount<ElectricResistanceUnit> electricResistance) {
		return new Ohms(plusAmount(this, electricResistance));
	}

	@NotNull
	@Override
	public Ohms minus(@NotNull UnitAmount<ElectricResistanceUnit> electricResistance) {
		return new Ohms(minusAmount(this, electricResistance));
	}

	@NotNull
	@Override
	public Ohms times(@NotNull Number scalar) {
		return new Ohms(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Ohms div(@NotNull Number scalar) {
		return new Ohms(dividedByScalar(this, scalar));
	}

	@Override
	public Ohms to(ElectricResistanceUnit unit) {
		return new Ohms(getAmountIn(this, unit));
	}

	@NotNull
	@Override
	public Siemens invert() {
		return new Siemens(getAmount().invert());
	}

	// endregion

	// region composition

	public Volts times(ElectricCurrent electricCurrent) {
		return new Volts(getAmount().times(getAmountIn(electricCurrent, AMPERE)));
	}

	// endregion
}
