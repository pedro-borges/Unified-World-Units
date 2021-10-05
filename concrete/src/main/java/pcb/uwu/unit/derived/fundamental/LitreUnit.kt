package pcb.uwu.unit.derived.fundamental;

import pcb.uwu.core.Amount;

import java.math.BigDecimal;
import java.util.function.Function;

import static pcb.uwu.unit.base.MeterUnit.METER;

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
		public Function<Amount, Amount> getTranslationToCanonical() {
			return super.getTranslationToCanonical()
					.andThen(amount -> amount.div(ONE_THOUSAND));
		}

		@Override
		public Function<Amount, Amount> getTranslationFromCanonical() {
			return super.getTranslationFromCanonical()
					.andThen(amount -> amount.times(ONE_THOUSAND));
		}
	};

	private LitreUnit() {
		super(METER, METER, METER);
	}
}
