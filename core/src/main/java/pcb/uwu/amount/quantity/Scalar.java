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

import static pcb.uwu.units.quantity.ScalarUnit.SCALAR;

public class Scalar extends CompositeUnitAmount<ScalarUnit> {

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

	@Override
	public Scalar plus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(plusAmount(other, mathContext));
	}

	@Override
	public Scalar minus(UnitAmount<ScalarUnit> other, MathContext mathContext) {
		return new Scalar(minusAmount(other, mathContext));
	}

	@Override
	public Scalar multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(multipliedByScalar(other, mathContext));
	}

	@Override
	public Scalar dividedBy(BigDecimal other, MathContext mathContext) {
		return new Scalar(dividedByScalar(other, mathContext));
	}

	@Override
	public Scalar convertTo(ScalarUnit unit) {
		return new Scalar(getAmountIn(unit));
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
