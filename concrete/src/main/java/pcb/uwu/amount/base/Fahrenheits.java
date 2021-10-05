package pcb.uwu.amount.base;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.FahrenheitUnit.FAHRENHEIT;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

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

	@NotNull
	@Override
	public Fahrenheits plus(@NotNull UnitAmount<TemperatureUnit> other) {
		return new Fahrenheits(plusAmount(this, other));
	}

	@NotNull
	@Override
	public Fahrenheits minus(@NotNull UnitAmount<TemperatureUnit> other) {
		return new Fahrenheits(minusAmount(this, other));
	}

	@Override
	public Fahrenheits times(BigDecimal other, MathContext mathContext) {
		return new Fahrenheits(multipliedByScalar(this, other, mathContext));
	}

	@Override
	public Fahrenheits div(BigDecimal other, MathContext mathContext) {
		return new Fahrenheits(dividedByScalar(this, other, mathContext));
	}

	// endregion

	// region composition

	// endregion
}
