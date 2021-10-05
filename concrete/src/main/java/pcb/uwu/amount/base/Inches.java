package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.base.InchUnit.INCH;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Inches extends Length {

	// region constructors

	public Inches(Number value) {
		super(value, INCH);
	}

	public Inches(Number value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(String value) {
		super(value, INCH);
	}

	public Inches(String value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimal value) {
		super(value, INCH);
	}

	public Inches(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, INCH);
	}

	public Inches(BigDecimalAmount amount) {
		super(amount, INCH);
	}

	public Inches(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, INCH);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Inches plus(@NotNull UnitAmount<LengthUnit> amount) {
		return new Inches(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Inches minus(@NotNull UnitAmount<LengthUnit> amount) {
		return new Inches(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Inches times(@NotNull Number number) {
		return new Inches(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Inches div(@NotNull Number number) {
		return new Inches(dividedByScalar(this, number));
	}

	// endregion

	// region composition

	// endregion
}
