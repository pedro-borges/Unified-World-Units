package pcb.units.dimensions.finance.amounts;

import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.finance.InterestRateUnit;

import java.math.BigDecimal;

public interface InterestRate
		extends UnitAmount<BigDecimal, BigDecimalAmount, InterestRateUnit, InterestRate> {
}
