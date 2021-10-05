package pcb.uwu.amount.derived.fundamental.volume;

import org.jetbrains.annotations.NotNull;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.derived.fundamental.Volume;
import pcb.uwu.amount.derived.fundamental.VolumeFactory;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.derived.fundamental.VolumeUnit;
import pcb.uwu.utils.UnitAmountUtils;

import java.math.BigDecimal;

import static pcb.uwu.core.Magnitude.DECI;
import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.derived.fundamental.LitreUnit.LITRE;
import static pcb.uwu.utils.UnitAmountUtils.dividedByScalar;
import static pcb.uwu.utils.UnitAmountUtils.getAmountIn;
import static pcb.uwu.utils.UnitAmountUtils.minusAmount;
import static pcb.uwu.utils.UnitAmountUtils.plusAmount;

public class Litres extends Volume {

	// region geometry factories

	public static final LitresFactory FOR = new LitresFactory();

	public static class LitresFactory extends VolumeFactory {
		@NotNull
		@Override
		public Litres sphere(@NotNull Length radius) {
			return new Litres(SPHERE_FUNCTION.invoke(getAmountIn(radius, DECI, METER)));
		}

		@NotNull
		@Override
		public Litres cube(@NotNull Length side) {
			return new Litres(CUBE_FUNCTION.invoke(getAmountIn(side, DECI, METER)));
		}
	}

	// endregion

	// region constructors

	public Litres(Number value) {
		super(value, LITRE);
	}

	public Litres(Number value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(String value) {
		super(value, LITRE);
	}

	public Litres(String value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(BigDecimal value) {
		super(value, LITRE);
	}

	public Litres(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LITRE);
	}

	public Litres(BigDecimalAmount amount) {
		super(amount, LITRE);
	}

	public Litres(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LITRE);
	}

	// endregion

	// region implement UnitAmount

	@NotNull
	@Override
	public Litres plus(@NotNull UnitAmount<VolumeUnit> volume) {
		return new Litres(plusAmount(this, volume));
	}

	@NotNull
	@Override
	public Litres minus(@NotNull UnitAmount<VolumeUnit> volume) {
		return new Litres(minusAmount(this, volume));
	}

	@NotNull
	@Override
	public Litres times(@NotNull Number scalar) {
		return new Litres(UnitAmountUtils.times(this, scalar));
	}

	@NotNull
	@Override
	public Litres div(@NotNull Number scalar) {
		return new Litres(dividedByScalar(this, scalar));
	}

	// endregion
}
