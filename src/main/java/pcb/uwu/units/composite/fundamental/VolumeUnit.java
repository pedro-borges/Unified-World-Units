package pcb.uwu.units.composite.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.LengthUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;
import static pcb.uwu.units.fundamental.LengthUnit.FOOT;
import static pcb.uwu.units.fundamental.LengthUnit.INCH;
import static pcb.uwu.units.fundamental.LengthUnit.METER;
import static pcb.uwu.units.fundamental.LengthUnit.MILE;
import static pcb.uwu.units.fundamental.LengthUnit.NAUTICAL_MILE;
import static pcb.uwu.units.fundamental.LengthUnit.YARD;

public class VolumeUnit extends CompositeUnit {

	private static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);

	public static final VolumeUnit CUBIC_METER = new VolumeUnit(METER, METER, METER);
	public static final VolumeUnit METRIC_TON = CUBIC_METER;
	public static final VolumeUnit CUBIC_NAUTICAL_MILE = new VolumeUnit(NAUTICAL_MILE, NAUTICAL_MILE, NAUTICAL_MILE);
	public static final VolumeUnit CUBIC_MILE = new VolumeUnit(MILE, MILE, MILE);
	public static final VolumeUnit CUBIC_YARD = new VolumeUnit(YARD, YARD, YARD);
	public static final VolumeUnit CUBIC_FOOT = new VolumeUnit(FOOT, FOOT, FOOT);
	public static final VolumeUnit CUBIC_INCH = new VolumeUnit(INCH, INCH, INCH);
	public static final VolumeUnit LITRE = new VolumeUnit(METER, METER, METER) {
		@Override
		public String getSymbol() {
			return "l";
		}

		@Override
		public String getSingularName() {
			return "litre";
		}

		@Override
		public String getPluralName() {
			return "litres";
		}

		@Override
		public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
			return super.getTranslationToCanonical()
					.andThen(amount -> amount.dividedBy(ONE_THOUSAND, UNLIMITED));
		}

		@Override
		public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
			return super.getTranslationFromCanonical()
					.andThen(amount -> amount.multipliedBy(ONE_THOUSAND, UNLIMITED));
		}
	};

	public VolumeUnit(LengthUnit length, LengthUnit height, LengthUnit depth) {
		super(new UnitCounter()
				.major(length)
				.major(height)
				.major(depth));
	}
}
