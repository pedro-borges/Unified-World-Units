package pcb.units.concrete.physics;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.physics.Temperature;
import pcb.units.dimensions.physics.TemperatureUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Kelvins
		extends AbstractUnitAmount<BigDecimalAmount, TemperatureUnit>
		implements Temperature {

	// region constructors

	public Kelvins(Number value) {
		this(value.toString());
	}

	public Kelvins(String value) {
		this(new BigDecimal(value));
	}

	public Kelvins(BigDecimal value) {
		this(new BigDecimalAmount(value));
	}

	public Kelvins(BigDecimalAmount amount) {
		super(amount, KelvinUnit.instance);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Kelvins plus(UnitAmount<BigDecimalAmount, TemperatureUnit> other, MathContext mathContext) {
		return new Kelvins(plusAmount(other, mathContext));
	}

	@Override
	public Kelvins minus(UnitAmount<BigDecimalAmount, TemperatureUnit> other, MathContext mathContext) {
		return new Kelvins(minusAmount(other, mathContext));
	}

	@Override
	public Kelvins multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Kelvins(multipliedByAmount(other, mathContext));
	}

	@Override
	public Kelvins dividedBy(BigDecimal other, MathContext mathContext) {
		return new Kelvins(dividedByAmount(other, mathContext));
	}

	// endregion
}
