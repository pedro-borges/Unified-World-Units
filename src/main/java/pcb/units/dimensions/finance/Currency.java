package pcb.units.dimensions.finance;

import pcb.units.amount.Amount;
import pcb.units.base.UnitAmount;

public interface Currency<A extends Amount<A>>
		extends UnitAmount<A, CurrencyUnit> {

}
