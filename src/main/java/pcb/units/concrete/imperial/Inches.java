package pcb.units.concrete.imperial;

import pcb.units.amount.Amount;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.BaseUnit;
import pcb.units.base.Unit;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.ScalarUnit;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL32;
import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;

public class Inches extends Space {
	public static final Unit<SpaceUnit> INCH = new BaseUnit<>("in", "inch", "inches");

	private static final BigDecimal METERS_PER_INCH = new BigDecimal("0.0254");

	// region constructors

	public Inches(Number amount) {
		this(new BigDecimalAmount(amount));
	}

	public Inches(Amount<BigDecimal> amount) {
		super(amount, INCH,
				value -> value.dividedBy(METERS_PER_INCH, DECIMAL64),
				value -> value.multipliedBy(METERS_PER_INCH, DECIMAL64));
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Inches plus(UnitAmount<SpaceUnit, BigDecimal> other, MathContext mathContext) {
		UnitAmount<SpaceUnit, BigDecimal> inches = convertToSelfScale(other);
		return new Inches(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches minus(UnitAmount<SpaceUnit, BigDecimal> other, MathContext mathContext) {
		UnitAmount<SpaceUnit, BigDecimal> inches = convertToSelfScale(other);
		return new Inches(getAmount().minus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(getAmount().multipliedBy(other, mathContext));
	}

	@Override
	public Inches dividedBy(BigDecimal other, MathContext mathContext) {
		return new Inches(getAmount().dividedBy(other, mathContext));
	}

	@Override
	public BigDecimal dividedBy(UnitAmount<SpaceUnit, BigDecimal> other, MathContext mathContext) {
		UnitAmount<SpaceUnit, BigDecimal> inches = convertToSelfScale(other);
		return getAmount().dividedBy(inches.getAmount(), mathContext);
	}

	// endregion
}
