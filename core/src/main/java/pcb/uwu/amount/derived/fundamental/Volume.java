package pcb.uwu.amount.derived.fundamental;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Length;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
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

public class Volume extends CompositeUnitAmount<VolumeUnit> {

	// region geometry factories

	public static final VolumeFactory FOR = new VolumeFactory();

	public static class VolumeFactory {
		public static final BiFunction<BigDecimalAmount, MathContext, BigDecimalAmount> SPHERE_FUNCTION =
				(radius, mathContext) -> radius
						.pow(3, mathContext)
						.times(4)
						.div(3, mathContext)
						.times(PI, mathContext);

		public static final BiFunction<BigDecimalAmount, MathContext, BigDecimalAmount> CUBE_FUNCTION =
				(side, mathContext) -> side.pow(3, mathContext);

		public Volume sphereWithRadius(Length radius, MathContext mathContext) {
			return new Volume(SPHERE_FUNCTION.apply(radius.getAmount(), mathContext),
					new VolumeUnit(radius.getUnit(), radius.getUnit(), radius.getUnit()));
		}

		public Volume cubeWithSide(Length side, MathContext mathContext) {
			return new Volume(CUBE_FUNCTION.apply(side.getAmount(), mathContext),
					new VolumeUnit(side.getUnit(), side.getUnit(), side.getUnit()));
		}
	}

	// endregion

	// region constructors

	public Volume(Number value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(Number value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(String value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(String value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(BigDecimal value, VolumeUnit unit) {
		super(value, unit);
	}

	public Volume(BigDecimal value, Magnitude magnitude, VolumeUnit unit) {
		super(value, magnitude, unit);
	}

	public Volume(BigDecimalAmount amount, VolumeUnit unit) {
		super(amount, unit);
	}

	public Volume(BigDecimalAmount amount, Magnitude magnitude, VolumeUnit unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Volume plus(@NotNull UnitAmount<VolumeUnit> other) {
		return new Volume(plusAmount(this, other), getUnit());
	}

	@NotNull
	@Override
	public Volume minus(@NotNull UnitAmount<VolumeUnit> other) {
		return new Volume(minusAmount(this, other), getUnit());
	}

	@Override
	public Volume multiply(BigDecimal other, MathContext mathContext) {
		return new Volume(multipliedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Volume div(BigDecimal other, MathContext mathContext) {
		return new Volume(dividedByScalar(this, other, mathContext), getUnit());
	}

	@Override
	public Volume into(VolumeUnit unit) {
		return new Volume(getAmountIn(this, unit), unit);
	}

	// endregion
}
