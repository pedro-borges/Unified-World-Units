package pcb.uwu.utils;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.Unit;
import pcb.uwu.core.UnitAmount;

import java.util.function.Function;

import static java.math.MathContext.UNLIMITED;

public class UnitAmountUtils {

	public static <U extends Unit> BigDecimalAmount getAmountIn(UnitAmount<U> unitAmount, U newUnit) {
		U unit = unitAmount.getUnit();
		BigDecimalAmount amount = unitAmount.getAmount();

		if (unit.equals(newUnit))
		{
			return amount;
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = unit
				.getTranslationToCanonical()
				.andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation);
	}

	public static <U extends Unit> BigDecimalAmount getAmountIn(UnitAmount<U> unitAmount, Magnitude magnitude, U newUnit) {
		U unit = unitAmount.getUnit();
		BigDecimalAmount amount = unitAmount.getAmount();

		if (unit.equals(newUnit))
		{
			return amount.dividedBy(magnitude.getValue(), UNLIMITED);
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = unit
				.getTranslationToCanonical()
				.andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation).dividedBy(magnitude.getValue(), UNLIMITED);
	}
}
