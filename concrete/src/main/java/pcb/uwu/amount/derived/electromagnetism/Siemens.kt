package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricConductanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.SiemensUnit.SIEMENS;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Siemens extends ElectricConductance {

	// region constructors

	public Siemens(Number value) {
		super(value, SIEMENS);
	}

	public Siemens(Number value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(String value) {
		super(value, SIEMENS);
	}

	public Siemens(String value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(BigDecimal value) {
		super(value, SIEMENS);
	}

	public Siemens(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SIEMENS);
	}

	public Siemens(BigDecimalAmount amount) {
		super(amount, SIEMENS);
	}

	public Siemens(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SIEMENS);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Siemens plus(@NotNull UnitAmount<ElectricConductanceUnit> electricConductance) {
		return new Siemens(plusAmount(this, electricConductance));
	}

	@NotNull
	@Override
	public Siemens minus(@NotNull UnitAmount<ElectricConductanceUnit> electricConductance) {
		return new Siemens(minusAmount(this, electricConductance));
	}

	@NotNull
	@Override
	public Siemens times(@NotNull Number scalar) {
		return new Siemens(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Siemens div(@NotNull Number scalar) {
		return new Siemens(dividedByScalar(this, scalar));
	}

	@Override
	public Siemens to(ElectricConductanceUnit unit) {
		return new Siemens(getAmountIn(this, unit));
	}

	@NotNull
	@Override
	public Ohms invert() {
		return new Ohms(getAmount().invert());
	}

	// endregion

	// region composition

	public Volts times(ElectricCurrent electricCurrent) {
		return new Volts(getAmount().times(getAmountIn(electricCurrent, AMPERE)));
	}

	// endregion
}
