package pcb.uwu.amount.quantity;

import pcb.uwu.amount.finance.InterestRate;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.finance.InterestRateUnit;
import pcb.uwu.units.quantity.ScalarUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Scalar extends CompositeUnitAmount<ScalarUnit> {

	// region constructors

	public Scalar(Number value, ScalarUnit unit) {
		super(value, unit);
	}

	public Scalar(Number value, Magnitude magnitude, ScalarUnit unit) {
		super(value, magnitude, unit);
	}

	public Scalar(String value, ScalarUnit unit) {
		super(value, unit);
	}

	public Scalar(String value, Magnitude magnitude, ScalarUnit unit) {
		super(value, magnitude, unit);
	}

	public Scalar(BigDecimal value, ScalarUnit unit) {
		super(value, unit);
	}

	public Scalar(BigDecimal value, Magnitude magnitude, ScalarUnit unit) {
		super(value, magnitude, unit);
	}

	public Scalar(BigDecimalAmount amount, ScalarUnit unit) {
		super(amount, unit);
	}

	public Scalar(BigDecimalAmount amount, Magnitude magnitude, ScalarUnit unit) {
		super(amount, magnitude, unit);
	}


	// endregion

	// region implement UnitAmount

	@Override
	public Scalar plus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Scalar minus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Scalar multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Scalar dividedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public Scalar convertTo(ScalarUnit unit) {
		return new Scalar(getAmountIn(unit), unit);
	}

	// endregion

	// region composition

	public InterestRate dividedBy(Time time, MathContext mathContext) {
		BigDecimalAmount amount = getAmount()
				.dividedBy(time.getAmount().getValue(), mathContext);
		InterestRateUnit unit = new InterestRateUnit(time.getUnit());

		return new InterestRate(amount, unit);
	}

	// endregion
}
