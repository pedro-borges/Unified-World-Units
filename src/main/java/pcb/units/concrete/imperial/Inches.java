package pcb.units.concrete.imperial;

import pcb.units.amount.Amount;
import pcb.units.amount.BigDecimalAmount;
import pcb.units.base.BaseUnit;
import pcb.units.base.Unit;
import pcb.units.base.UnitAmount;
import pcb.units.dimensions.fundamental.SpaceUnit;
import pcb.units.dimensions.fundamental.amounts.Space;

import java.math.BigDecimal;
import java.math.MathContext;

import static java.math.MathContext.DECIMAL64;

public class Inches extends Space {
	public static final SpaceUnit INCH = new SpaceUnit() {
		@Override
		public String getSymbol() {
			return "in";
		}

		@Override
		public String getSingularName() {
			return "inch";
		}

		@Override
		public String getPluralName() {
			return "inches";
		}
	};

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
	public Inches plus(Space other, MathContext mathContext) {
		Space inches = convertToSelfScale(other);
		return new Inches(getAmount().plus(inches.getAmount(), mathContext));
	}

	@Override
	public Inches minus(Space other, MathContext mathContext) {
		Space inches = convertToSelfScale(other);
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
	public BigDecimal dividedBy(Space other, MathContext mathContext) {
		Space inches = convertToSelfScale(other);
		return getAmount().dividedBy(inches.getAmount(), mathContext);
	}

	// endregion
}
