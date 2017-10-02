package pcb.units.dimensions.finance.amounts;

import pcb.units.amount.Amount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.finance.CurrencyUnit;

public interface Currency<A extends Amount<A>>
		extends UnitAmount<A, CurrencyUnit> {

}
