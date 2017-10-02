package pcb.units.base;

import pcb.units.utils.ObjectCounter;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Function;

public class ComposedUnit
		implements Unit {

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	// region private fields

	private final ObjectCounter<Unit> units;

	// endregion

	// region constructors

	public ComposedUnit() {
		units = new ObjectCounter<>();
	}

	private ComposedUnit(ObjectCounter<Unit> units)
	{
		this.units = units;
	}

	// endregion

	// region public methods

	public ComposedUnit multipliedBy(Unit unit) {
		return new ComposedUnit(units.increase(unit));
	}

	public ComposedUnit dividedBy(Unit unit) {
		return new ComposedUnit(units.decrease(unit));
	}

	// endregion

	// region implement Unit

	@Override
	public String getSymbol() {
		return buildString(Unit::getSymbol, Unit::getSymbol, "/");
	}

	@Override
	public String getSingularName() {
		return buildString(Unit::getSingularName, Unit::getSingularName, " per ");
	}

	@Override
	public String getPluralName() {
		return buildString(Unit::getPluralName, Unit::getSingularName, " per ");
	}

	@Override
	public Function<BigDecimal, BigDecimal> getTranslationToCanonical() {
		Function<BigDecimal, BigDecimal> result = Function.identity();

		for (Unit unit : units.getPositiveKeys()) {
			for (int i = 0; i < units.get(unit); i++) {
				result = result.andThen(unit.getTranslationToCanonical());
			}
		}

		for (Unit unit : units.getNegativeKeys()) {
			for (int i = 0; i > units.get(unit); i--) {
				result = result.andThen(unit.getTranslationFromCanonical());
			}
		}

		return result;
	}

	@Override
	public Function<BigDecimal, BigDecimal> getTranslationFromCanonical() {
		Function<BigDecimal, BigDecimal> result = Function.identity();

		for (Unit unit : units.getPositiveKeys()) {
			for (int i = 0; i < units.get(unit); i++) {
				result = result.andThen(unit.getTranslationFromCanonical());
			}
		}

		for (Unit unit : units.getNegativeKeys()) {
			for (int i = 0; i > units.get(unit); i--) {
				result = result.andThen(unit.getTranslationToCanonical());
			}
		}

		return result;
	}

	// endregion

	// region private methods

	String buildString(Function<Unit, String> major, Function<Unit, String> minor, String separator) {
		String result = "";

		List<Unit> positiveKeys = units.getPositiveKeys();
		List<Unit> negativeKeys = units.getNegativeKeys();

		boolean first = true;

		for (Unit unit : positiveKeys) {
			String power = buildPower(units.get(unit));
			if (first) {
				result += major.apply(unit) + power;
			} else {
				result += minor.apply(unit) + power;
			}
			first = false;
		}

		if (!negativeKeys.isEmpty()) {
			result += separator;
		}

		for (Unit unit : negativeKeys) {
			String power = buildPower(Math.abs(units.get(unit)));
			result += minor.apply(unit) + power;
		}

		return result;
	}

	String buildPower(int power) {
		String result = "";
		boolean negative = power < 0;

		// Omit neutral power of 1
		if (power == 1) {
			return result;
		}

		if (power == 0) {
			return String.valueOf(POWERS[0]);
		}

		power = Math.abs(power);

		for (;power > 0 ; power /= 10)
		{
			result = POWERS[power % 10] + result;
		}

		if (negative) {
			return NEGATIVE + result;
		}

		return result;
	}

	// endregion
}
