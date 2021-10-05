package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.MassUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.StoneUnit.STONE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
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
	public Stones plus(@NotNull UnitAmount<MassUnit> mass) {
		return new Stones(plusAmount(this, mass));
	}

	@NotNull
	@Override
	public Stones minus(@NotNull UnitAmount<MassUnit> mass) {
		return new Stones(minusAmount(this, mass));
	}

	@NotNull
	@Override
	public Stones times(@NotNull Number number) {
		return new Stones(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Stones div(@NotNull Number number) {
		return new Stones(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
