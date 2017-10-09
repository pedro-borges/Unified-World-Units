package pcb.uwu.amount.quantity;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.quantity.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.quantity.FahrenheitUnit.FAHRENHEIT;

public class Fahrenheits extends Temperature {

	// region constructors

	public Fahrenheits(Number value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(Number value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(String value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(String value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimal value) {
		super(value, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimalAmount amount) {
		super(amount, FAHRENHEIT);
	}

	public Fahrenheits(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, FAHRENHEIT);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Fahrenheits plus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Fahrenheits(plusAmount(other, mathContext));
	}

	@Override
	public Fahrenheits minus(UnitAmount<TemperatureUnit> other, MathContext mathContext) {
		return new Fahrenheits(minusAmount(other, mathContext));
	}

	@Override
	public Fahrenheits multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Fahrenheits(multipliedByScalar(other, mathContext));
	}

	@Override
	public Fahrenheits dividedBy(BigDecimal other, MathContext mathContext) {
		return new Fahrenheits(dividedByScalar(other, mathContext));
	}

	// endregion
}
