package pcb.uwu.utils;

import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.Unit;
import pcb.uwu.core.UnitAmount;

import java.math.BigDecimal;
import java.math.MathContext;
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
			return amount.div(magnitude.getValue(), UNLIMITED);
		}

		Function<BigDecimalAmount, BigDecimalAmount> translation = unit
				.getTranslationToCanonical()
				.andThen(newUnit.getTranslationFromCanonical());

		return amount.transformed(translation).div(magnitude.getValue(), UNLIMITED);
	}

	public static <U extends Unit> BigDecimalAmount plusAmount(UnitAmount<U> unitAmount, UnitAmount<U> other) {
		return unitAmount.getAmount().plus(getAmountIn(other, unitAmount.getUnit()));
	}

	public static <U extends Unit> BigDecimalAmount minusAmount(UnitAmount<U> unitAmount, UnitAmount<U> other) {
		return unitAmount.getAmount().minus(getAmountIn(other, unitAmount.getUnit()));
	}

	public static <U extends Unit> BigDecimalAmount multipliedByScalar(UnitAmount<U> unitAmount, BigDecimal other, MathContext mathContext) {
		return unitAmount.getAmount().times(other, mathContext);
	}

	public static <U extends Unit> BigDecimalAmount dividedByScalar(UnitAmount<U> unitAmount, BigDecimal other, MathContext mathContext) {
		return unitAmount.getAmount().div(other, mathContext);
	}
}
