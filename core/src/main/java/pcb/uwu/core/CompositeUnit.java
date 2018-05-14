package pcb.uwu.core;

import pcb.uwu.core.UnitCounter.UnitCount;

import java.util.Objects;
import java.util.function.Function;

public class CompositeUnit implements Unit {

	// region private fields

	private final UnitCounter unitCounter;

	// endregion

	// region constructors

	CompositeUnit() {
		this(new UnitCounter());
	}

	public CompositeUnit(UnitCounter unitCounter)
	{
		this.unitCounter = unitCounter;
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

		for (UnitCount unitCount : unitCounter.getBaseUnits()) {
			BaseUnit unit = unitCount.getUnit();
			int count = unitCount.getCount();

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					result = result.andThen(unit.getTranslationToCanonical());
				}
			} else if (count < 0) {
				for (int i = 0; i > count; i--) {
					result = result.andThen(unit.getTranslationFromCanonical());
				}
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

		for (UnitCount unitCount : unitCounter.getBaseUnits()) {
			BaseUnit unit = unitCount.getUnit();
			int count = unitCount.getCount();

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					result = result.andThen(unit.getTranslationFromCanonical());
				}
			} else if (count < 0) {
				for (int i = 0; i > count; i--) {
					result = result.andThen(unit.getTranslationToCanonical());
				}
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

	@Override
	public Class<? extends BaseUnit> getBaseUnitType() {
		return null;
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CompositeUnit) {
			CompositeUnit that = (CompositeUnit) obj;

			return Objects.equals(this.unitCounter, that.unitCounter)
					&& Objects.equals(this.getTranslationFromCanonical(), that.getTranslationFromCanonical())
					&& Objects.equals(this.getTranslationToCanonical(), that.getTranslationToCanonical());
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
