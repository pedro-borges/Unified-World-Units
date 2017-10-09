package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.LuminousIntensityUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.CandelaUnit.CANDELA;

public class Candelas extends LuminousIntensity {

	// region constructors

	public Candelas(Number value) {
		super(value, CANDELA);
	}

	public Candelas(Number value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(String value) {
		super(value, CANDELA);
	}

	public Candelas(String value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(BigDecimal value) {
		super(value, CANDELA);
	}

	public Candelas(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, CANDELA);
	}

	public Candelas(BigDecimalAmount amount) {
		super(amount, CANDELA);
	}

	public Candelas(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, CANDELA);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Candelas plus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(plusAmount(other, mathContext));
	}

	@Override
	public Candelas minus(UnitAmount<LuminousIntensityUnit> other, MathContext mathContext) {
		return new Candelas(minusAmount(other, mathContext));
	}

	@Override
	public Candelas multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(multipliedByScalar(other, mathContext));
	}

	@Override
	public Candelas dividedBy(BigDecimal other, MathContext mathContext) {
		return new Candelas(dividedByScalar(other, mathContext));
	}

	// endregion
}
