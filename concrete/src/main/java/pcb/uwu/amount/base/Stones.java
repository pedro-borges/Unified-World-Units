package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.StoneUnit.STONE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Stones extends Mass {

	// region constructors

	public Stones(Number value) {
		super(value, STONE);
	}

	public Stones(Number value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(String value) {
		super(value, STONE);
	}

	public Stones(String value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(BigDecimal value) {
		super(value, STONE);
	}

	public Stones(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, STONE);
	}

	public Stones(BigDecimalAmount amount) {
		super(amount, STONE);
	}

	public Stones(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, STONE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Stones plus(@NotNull UnitAmount<MassUnit> other) {
		return new Stones(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Stones minus(@NotNull UnitAmount<MassUnit> other) {
		return new Stones(minusAmount(this, other));
	}

	@Override
	public Stones times(BigDecimal other, MathContext mathContext) {
		return new Stones(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Stones div(BigDecimal other, MathContext mathContext) {
		return new Stones(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
