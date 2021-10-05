package pcb.uwu.amount.derived.electromagnetism;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.ElectricCurrent;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.electromagnetism.ElectricInductanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.AmpereUnit.AMPERE;
import static pcb.uwu.unit.derived.electromagnetism.HenryUnit.HENRY;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Henries extends ElectricInductance {

	// region constructors

	public Henries(Number value) {
		super(value, HENRY);
	}

	public Henries(Number value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(String value) {
		super(value, HENRY);
	}

	public Henries(String value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(BigDecimal value) {
		super(value, HENRY);
	}

	public Henries(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, HENRY);
	}

	public Henries(BigDecimalAmount amount) {
		super(amount, HENRY);
	}

	public Henries(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, HENRY);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Henries plus(@NotNull UnitAmount<ElectricInductanceUnit> amount) {
		return new Henries(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Henries minus(@NotNull UnitAmount<ElectricInductanceUnit> amount) {
		return new Henries(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Henries times(@NotNull Number number) {
		return new Henries(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Henries div(@NotNull Number number) {
		return new Henries(dividedByScalar(this, number));
	}

	@Override
	public Henries to(ElectricInductanceUnit unit) {
		return new Henries(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public Webbers times(ElectricCurrent electricCurrent) {
		return new Webbers(getAmount().times(getAmountIn(electricCurrent, AMPERE)));
	}

	// endregion
}
