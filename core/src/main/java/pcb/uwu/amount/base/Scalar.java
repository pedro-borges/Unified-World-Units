package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.derived.finance.InterestRate;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.ScalarUnit;
import pcb.uwu.unit.derived.fundamental.FrequencyUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.ScalarUnit.SCALAR;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Scalar extends CompositeUnitAmount<ScalarUnit> {

	public static final Scalar ZERO = new Scalar(0);
	public static final Scalar ONE = new Scalar(1);

	// region constructors

	public Scalar(Number value) {
		super(value, SCALAR);
	}

	public Scalar(Number value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(String value) {
		super(value, SCALAR);
	}

	public Scalar(String value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(BigDecimal value) {
		super(value, SCALAR);
	}

	public Scalar(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, SCALAR);
	}

	public Scalar(BigDecimalAmount amount) {
		super(amount, SCALAR);
	}

	public Scalar(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, SCALAR);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Scalar plus(@NotNull UnitAmount<ScalarUnit> other) {
		return new Scalar(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Scalar minus(@NotNull UnitAmount<ScalarUnit> other) {
		return new Scalar(minusAmount(this, other));
	}

	@Override
	public Scalar multiply(BigDecimal other, MathContext mathContext) {
		return new Scalar(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Scalar div(BigDecimal other, MathContext mathContext) {
		return new Scalar(dividedByScalar(this, other, mathContext));
	}

	@Override
	public Scalar into(ScalarUnit unit) {
		return new Scalar(getAmountIn(this, unit));
	}

	// endregion

	// region composition

	public InterestRate dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.div(time.getAmount().getValue(), mathContext);
		FrequencyUnit unit = new FrequencyUnit(time.getUnit());

		return new InterestRate(amount, unit);
	}

	// endregion
}
