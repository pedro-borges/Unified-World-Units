package pcb.uwu.core;

import java.util.Objects;
import java.util.function.Function;

public class CompositeUnit implements Unit {

	// region private fields

	private final UnitCounter unitCounter;
	private final Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical;
	private final Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical;

	// endregion

	// region constructors

	CompositeUnit() {
		this(new UnitCounter());
	}

	public CompositeUnit(UnitCounter unitCounter)
	{
		this(unitCounter, Function.identity(), Function.identity());
	}

	protected CompositeUnit(UnitCounter unitCounter,
							Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
							Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		this.unitCounter = unitCounter;
		this.translationToCanonical = translationToCanonical;
		this.translationFromCanonical = translationFromCanonical;
	}

	// endregion

	// region public methods

	public CompositeUnit major(BaseUnit unit) {
		return new CompositeUnit(unitCounter.major(unit));
	}

	public CompositeUnit minor(BaseUnit unit) {
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
		return unitCounter.asString(Unit::getSymbol, Unit::getSymbol, "/");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getSingularName() {
		return unitCounter.asString(Unit::getSingularName, Unit::getSingularName, " per ");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPluralName() {
		return unitCounter.asString(Unit::getPluralName, Unit::getSingularName, " per ");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
		Function<BigDecimalAmount, BigDecimalAmount> result = Function.identity();

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

	protected Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical(
			Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
			Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		Function<BigDecimalAmount, BigDecimalAmount> result = Function.identity();

		for (Unit unit : unitCounter.getPositiveKeys()) {
			for (int i = 0; i < unitCounter.get(unit); i++) {
				result = result.andThen(unit.getTranslationToCanonical().andThen(translationToCanonical));
			}
		}

		for (Unit unit : unitCounter.getNegativeKeys()) {
			for (int i = 0; i > unitCounter.get(unit); i--) {
				result = result.andThen(unit.getTranslationFromCanonical().andThen(translationFromCanonical));
			}
		}

		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
		Function<BigDecimalAmount, BigDecimalAmount> result = Function.identity();

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

	protected Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical(
			Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
			Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

		Function<BigDecimalAmount, BigDecimalAmount> result = Function.identity();

		for (Unit unit : unitCounter.getPositiveKeys()) {
			for (int i = 0; i < unitCounter.get(unit); i++) {
				result = result.andThen(unit.getTranslationFromCanonical().andThen(translationFromCanonical));
			}
		}

		for (Unit unit : unitCounter.getNegativeKeys()) {
			for (int i = 0; i > unitCounter.get(unit); i--) {
				result = result.andThen(unit.getTranslationToCanonical().andThen(translationToCanonical));
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
