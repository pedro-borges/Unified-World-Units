package pcb.uwu.amount.derived.fundamental;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.unit.derived.fundamental.HertzUnit.HERTZ;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Hertz extends Frequency {
	
	// region constructors
	
	public Hertz(Number value) {
		super(value, HERTZ);
	}

	public Hertz(Number value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(String value) {
		super(value, HERTZ);
	}

	public Hertz(String value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(BigDecimal value) {
		super(value, HERTZ);
	}

	public Hertz(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, HERTZ);
	}

	public Hertz(BigDecimalAmount amount) {
		super(amount, HERTZ);
	}

	public Hertz(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, HERTZ);
	}
	
	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Hertz plus(@NotNull UnitAmount<FrequencyUnit> amount) {
		return new Hertz(plusAmount(this, amount));
	}

	@NotNull
	@Override
	public Hertz minus(@NotNull UnitAmount<FrequencyUnit> amount) {
		return new Hertz(minusAmount(this, amount));
	}

	@NotNull
	@Override
	public Hertz times(@NotNull Number number) {
		return new Hertz(UnitAmountUtils.times(this, number));
	}

	@NotNull
	@Override
	public Hertz div(@NotNull Number number) {
		return new Hertz(dividedByScalar(this, number));
	}

	// endregion
}
