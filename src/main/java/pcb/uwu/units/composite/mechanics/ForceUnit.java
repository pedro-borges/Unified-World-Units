package pcb.uwu.units.composite.mechanics;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.LengthUnit;
import pcb.uwu.units.fundamental.MassUnit;
import pcb.uwu.units.fundamental.TimeUnit;

import java.math.BigDecimal;
import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;
import static pcb.uwu.units.fundamental.LengthUnit.METER;
import static pcb.uwu.units.fundamental.MassUnit.GRAM;
import static pcb.uwu.units.fundamental.TimeUnit.SECOND;

public class ForceUnit extends CompositeUnit {
	private static final BigDecimal ONE_THOUSAND = new BigDecimal(1000);

	public static final ForceUnit NEWTON = new ForceUnit(GRAM, METER, SECOND, SECOND) {
		@Override
		public String getSymbol() {
			return "N";
		}

		@Override
		public String getSingularName() {
			return "newton";
		}

		@Override
		public String getPluralName() {
			return "newtons";
		}

		@Override
		public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
			return super.getTranslationToCanonical()
					.andThen(amount -> amount.multipliedBy(ONE_THOUSAND, UNLIMITED));
		}

		@Override
		public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
			return super.getTranslationFromCanonical()
					.andThen(amount -> amount.dividedBy(ONE_THOUSAND, UNLIMITED));
		}
	};

	public ForceUnit(MassUnit mass, LengthUnit length, TimeUnit time1, TimeUnit time2) {
		super(new UnitCounter()
				.major(mass)
				.major(length)
				.minor(time1)
				.minor(time2));
	}

	public ForceUnit(MassUnit massUnit, AccelerationUnit accelerationUnit) {
		super(new UnitCounter()
				.major(massUnit)
				.major(accelerationUnit));
	}
}
