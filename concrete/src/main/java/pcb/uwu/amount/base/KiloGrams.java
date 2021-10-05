package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.KiloGramUnit.KILOGRAM;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class KiloGrams extends Mass {

	// region constructors

	public KiloGrams(Number value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(Number value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(String value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(String value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(BigDecimal value) {
		super(value, KILOGRAM);
	}

	public KiloGrams(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, KILOGRAM);
	}

	public KiloGrams(BigDecimalAmount amount) {
		super(amount, KILOGRAM);
	}

	public KiloGrams(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, KILOGRAM);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public KiloGrams plus(@NotNull UnitAmount<MassUnit> other) {
		return new KiloGrams(plusAmount(this, other));
	}

	@NotNull
	@Override
	public KiloGrams minus(@NotNull UnitAmount<MassUnit> other) {
		return new KiloGrams(minusAmount(this, other));
	}

	@NotNull
	@Override
	public KiloGrams times(@NotNull Number other) {
		return new KiloGrams(UnitAmountUtils.times(this, other));
	}

	@NotNull
	@Override
	public KiloGrams div(@NotNull Number other) {
		return new KiloGrams(dividedByScalar(this, other));
	}

	// endregion

	// region composition

	// endregion
}
