package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.AmountOfSubstanceUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.MoleUnit.MOLE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Mole extends AmountOfSubstance {

	// region constructors

	public Mole(Number value) {
		super(value, MOLE);
	}

	public Mole(Number value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(String value) {
		super(value, MOLE);
	}

	public Mole(String value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(BigDecimal value) {
		super(value, MOLE);
	}

	public Mole(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, MOLE);
	}

	public Mole(BigDecimalAmount amount) {
		super(amount, MOLE);
	}

	public Mole(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, MOLE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Mole plus(@NotNull UnitAmount<AmountOfSubstanceUnit> other) {
		return new Mole(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Mole minus(@NotNull UnitAmount<AmountOfSubstanceUnit> other) {
		return new Mole(minusAmount(this, other));
	}

	@NotNull
	@Override
	public Mole times(@NotNull Number other) {
		return new Mole(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public Mole div(@NotNull Number other) {
		return new Mole(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
