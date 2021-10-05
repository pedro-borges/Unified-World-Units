package pcb.uwu.amount.derived.fundamental;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.AreaUnit;
import pcb.uwu.unit.derived.fundamental.VolumeUnit;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.function.BiFunction;

import static pcb.uwu.utils.MathUtils.PI;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.multipliedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Area extends CompositeUnitAmount<AreaUnit> {

	// region geometry factories

	public static final AreaFactory FOR = new AreaFactory();

	public static class AreaFactory {

		public static final BiFunction<BigDecimalAmount, MathContext, BigDecimalAmount> CIRCLE_FUNCTION =
				(radius, mathContext) -> radius
						.pow(2, mathContext)
						.times(PI, mathContext);

		public static final BiFunction<BigDecimalAmount, MathContext, BigDecimalAmount> SQUARE_FUNCTION =
				(side, mathContext) -> side
						.pow(2, mathContext);

		public Area circleWithRadius(Length radius, MathContext mathContext) {
			return new Area(CIRCLE_FUNCTION.apply(radius.getAmount(), mathContext),
					new AreaUnit(radius.getUnit(), radius.getUnit()));
		}

		public Area squareWithSide(Length side, MathContext mathContext) {
			return new Area(SQUARE_FUNCTION.apply(side.getAmount(), mathContext),
					new AreaUnit(side.getUnit(), side.getUnit()));
		}
	}

	// endregion

	// region constructors

	public Area(Number value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(Number value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(String value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(String value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(BigDecimal value, AreaUnit unit) {
		super(value, unit);
	}

	public Area(BigDecimal value, Magnitude magnitude, AreaUnit unit) {
		super(value, magnitude, unit);
	}

	public Area(BigDecimalAmount amount, AreaUnit unit) {
		super(amount, unit);
	}

	public Area(BigDecimalAmount amount, Magnitude magnitude, AreaUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Area plus(@NotNull UnitAmount<AreaUnit> other) {
		return new Area(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Area minus(@NotNull UnitAmount<AreaUnit> other) {
		return new Area(minusAmount(this, other), getUnit());
	}

	@Override
	public Area multiply(BigDecimal other, MathContext mathContext) {
		return new Area(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Area div(BigDecimal other, MathContext mathContext) {
		return new Area(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Area into(AreaUnit unit) {
		return new Area(getAmountIn(this, unit), unit);
	}

	// endregion

	// region composition

	// region composition

	public Volume multipliedBy(Length length, MathContext mathContext) {
		return new Volume(
				getAmount().times(length.getAmount(), mathContext),
				new VolumeUnit(getUnit(), length.getUnit()));
	}

	// endregion
}
