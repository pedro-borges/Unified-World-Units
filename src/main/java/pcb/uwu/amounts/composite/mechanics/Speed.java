package pcb.uwu.amounts.composite.mechanics;

import pcb.uwu.amounts.fundamental.Length;
import pcb.uwu.amounts.fundamental.Time;
import pcb.uwu.core.AbstractUnitAmount;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.composite.mechanics.SpeedUnit;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.math.MathContext;

public class Speed
		extends AbstractUnitAmount<BigDecimalAmount, SpeedUnit>
		implements UnitAmount<BigDecimalAmount, SpeedUnit> {

	// region factory

	public static <T extends LengthUnit> Speed create(MathContext mathContext, Length length, Time time) {
		BigDecimalAmount amount = length.getAmount().dividedBy(time.getAmount().getValue(), mathContext);
		SpeedUnit unit = new SpeedUnit(length.getUnit(), time.getUnit());

		return new Speed(amount, unit);
	}

	// endregion

	// region constructors

	public Speed(Number value, SpeedUnit unit) {
		this(value.toString(), unit);
	}

	public Speed(String value, SpeedUnit unit) {
		this(new BigDecimal(value), unit);
	}

	public Speed(BigDecimal value, SpeedUnit unit) {
		this(new BigDecimalAmount(value), unit);
	}

	public Speed(BigDecimalAmount amount, SpeedUnit unit) {
		super(amount, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Speed plus(UnitAmount<BigDecimalAmount, SpeedUnit> other, MathContext mathContext) {
		return new Speed(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed minus(UnitAmount<BigDecimalAmount, SpeedUnit> other, MathContext mathContext) {
		return new Speed(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(multipliedByAmount(other, mathContext), getUnit());
	}

	@Override
	public Speed dividedBy(BigDecimal other, MathContext mathContext) {
		return new Speed(dividedByAmount(other, mathContext), getUnit());
	}

	// endregion
}
