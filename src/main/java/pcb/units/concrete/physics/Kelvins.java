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

	public Kelvins(BigDecimalAmount amount) {
		super(amount, KelvinUnit.instance);
	}

	@Override
	public Kelvins plus(MathContext mathContext, UnitAmount<BigDecimalAmount, TemperatureUnit> other) {
		return new Kelvins(plusAmount(mathContext, other));
	}

	@Override
	public Kelvins minus(MathContext mathContext, UnitAmount<BigDecimalAmount, TemperatureUnit> other) {
		return new Kelvins(minusAmount(mathContext, other));
	}

	@Override
	public Kelvins multipliedBy(MathContext mathContext, BigDecimal other) {
		return new Kelvins(multipliedByAmount(mathContext, other));
	}

	@Override
	public Kelvins dividedBy(MathContext mathContext, BigDecimal other) {
		return new Kelvins(dividedByAmount(mathContext, other));
	}
}
