package pcb.units.dimensions.fundamental.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;
import java.util.function.Function;

public abstract class Space extends AbstractUnitAmount<BigDecimal, SpaceUnit, Space> {
	public Space(
			Amount<BigDecimal> amount,
		 	SpaceUnit unit,
		 	Function<Space, Space> translationToCanonical,
			Function<Space, Space> translationFromCanonical) {

		super(amount, unit, translationToCanonical, translationFromCanonical);
	}
}
