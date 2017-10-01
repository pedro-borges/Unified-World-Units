package pcb.units.dimensions.fundamental.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.AbstractUnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;

import java.math.BigDecimal;

public abstract class Space extends AbstractUnitAmount<BigDecimal, SpaceUnit, Space> {
	public Space(
			Amount<BigDecimal> amount,
		 	SpaceUnit unit) {

		super(amount, unit);
	}
}
