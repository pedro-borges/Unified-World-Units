package pcb.uwu.core;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class CompositeUnit implements Unit {

	// region private fields

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	private final UnitCounter unitCounter;

	// endregion

	// region constructors

	CompositeUnit() {
		unitCounter = new UnitCounter();
	}

	public CompositeUnit(UnitCounter unitCounter)
	{
		this.unitCounter = unitCounter;
	}

	// endregion

	// region public methods

	public CompositeUnit major(Unit unit) {
		return new CompositeUnit(unitCounter.major(unit));
	}

	public CompositeUnit minor(Unit unit) {
		return new CompositeUnit(unitCounter.minor(unit));
	}

	public UnitCounter getUnitCounter() {
		return unitCounter;
	}

	// endregion

	// region implement Unit

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSymbol() {
		return buildString(Unit::getSymbol, Unit::getSymbol, "/");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSingularName() {
		return buildString(Unit::getSingularName, Unit::getSingularName, " per ");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPluralName() {
		return buildString(Unit::getPluralName, Unit::getSingularName, " per ");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimal, BigDecimal> getTranslationToCanonical() {
		Function<BigDecimal, BigDecimal> result = Function.identity();

		for (Unit unit : unitCounter.getPositiveKeys()) {
			for (int i = 0; i < unitCounter.get(unit); i++) {
				result = result.andThen(unit.getTranslationToCanonical());
			}
		}

		for (Unit unit : unitCounter.getNegativeKeys()) {
			for (int i = 0; i > unitCounter.get(unit); i--) {
				result = result.andThen(unit.getTranslationFromCanonical());
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimal, BigDecimal> getTranslationFromCanonical() {
		Function<BigDecimal, BigDecimal> result = Function.identity();

		for (Unit unit : unitCounter.getPositiveKeys()) {
			for (int i = 0; i < unitCounter.get(unit); i++) {
				result = result.andThen(unit.getTranslationFromCanonical());
			}
		}

		for (Unit unit : unitCounter.getNegativeKeys()) {
			for (int i = 0; i > unitCounter.get(unit); i--) {
				result = result.andThen(unit.getTranslationToCanonical());
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isScalar() {
		return unitCounter.isEmpty();
	}

	// endregion

	// region private methods

	String buildString(Function<Unit, String> major, Function<Unit, String> minor, String separator) {
		String result = "";

		List<Unit> positiveKeys = unitCounter.getPositiveKeys();
		List<Unit> negativeKeys = unitCounter.getNegativeKeys();

		boolean first = true;

		for (Unit unit : positiveKeys) {
			String power = buildPower(unitCounter.get(unit));
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
			String power = buildPower(Math.abs(unitCounter.get(unit)));
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

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompositeUnit) {
			CompositeUnit other = (CompositeUnit) obj;

			return Objects.equals(this.unitCounter, other.unitCounter);
		}

		return false;
	}

	@Override
	public int hashCode() {
		return unitCounter.hashCode();
	}

	@Override
	public String toString() {
		return getSymbol();
	}

	// endregion
}
