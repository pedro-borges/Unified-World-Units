package pcb.uwu.unit.composite.fundamental;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.units.composite.fundamental.VolumeUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;
import static pcb.uwu.unit.quantity.MeterUnit.METER;

public class LitreUnit extends VolumeUnit {

	private static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);

	public static final LitreUnit LITRE = new LitreUnit() {
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

	private LitreUnit() {
		super(METER, METER, METER);
	}
}
