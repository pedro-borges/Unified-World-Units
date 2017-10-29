package pcb.uwu.core;

import pcb.uwu.exceptions.OffendingUnitException;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;
import static pcb.uwu.core.UnitCounter.UnitCount.EMPTY_BASE_UNIT_COUNT;
import static pcb.uwu.units.quantity.ScalarUnit.SCALAR;

public class UnitCounter {

	public static class UnitCount {
		static final UnitCount EMPTY_BASE_UNIT_COUNT = new UnitCount(SCALAR, 0);

		private final BaseUnit unit;
		private final int count;

		public UnitCount(BaseUnit unit, int count) {
			this.unit = unit;
			this.count = count;
		}

		public BaseUnit getUnit() {
			return unit;
		}

		public int getCount() {
			return count;
		}

		@Override
		public boolean equals(Object obj) {
			if (obj instanceof UnitCount) {
				UnitCount other = (UnitCount) obj;

				return Objects.equals(this.unit, other.unit) &&
						Objects.equals(this.count, other.count);
			}

			return false;
		}

		@Override
		public int hashCode() {
			return Objects.hash(unit, count);
		}
	}

	// region private fields

	private final Map<Class<? extends BaseUnit>, UnitCount> counts;

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	// endregion

	// region constructors

	public UnitCounter() {
		counts = new HashMap<>();
	}

	public UnitCounter(BaseUnit unit) {
		this();

		addPower(unit.getBaseUnitType(), unit, 1);
	}

	public UnitCounter(UnitCounter source) {
		this(source.counts);
	}

	private UnitCounter(Map<Class<? extends BaseUnit>, UnitCount> counts) {
		this.counts = new HashMap<>(counts);
	}

	// endregion

	public UnitCounter invert() {
		Map<Class<? extends BaseUnit>, UnitCount> result = new HashMap<>();

		counts.forEach((clazz, unitCount) -> result.put(clazz, new UnitCount(unitCount.unit, -unitCount.count)));

		return new UnitCounter(result);
	}

	public UnitCounter major(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.counts.forEach(result::addMajor);

		return result;
	}

	public UnitCounter major(BaseUnit unit) {
		return major(unit, 1);
	}

	public UnitCounter major(BaseUnit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.addPower(unit.getBaseUnitType(), unit, counts);

		return result;
	}

	public UnitCounter minor(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.counts.forEach(result::addMinor);

		return result;
	}

	public UnitCounter minor(BaseUnit unit) {
		return minor(unit, 1);
	}

	public UnitCounter minor(BaseUnit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.addPower(unit.getBaseUnitType(), unit, -counts);

		return result;
	}

	public UnitCount get(BaseUnit unit) {
		return counts.getOrDefault(unit.getBaseUnitType(), EMPTY_BASE_UNIT_COUNT);
	}

	public Collection<UnitCount> getBaseUnits() {
		return counts.values();
	}

	public String asString(Function<Unit, String> majorString, Function<Unit, String> minorString, String separator) {
		StringBuilder result = new StringBuilder();

		List<BaseUnit> baseUnits = counts.values().stream()
				.map(UnitCount::getUnit)
				.sorted()
				.collect(toList());

		boolean first = true;

		for (BaseUnit unit : baseUnits) {
			String power = buildPower(get(unit).count);
			if (first) {
				result.append(majorString.apply(unit)).append(power);
			} else {
				result.append('⋅').append(minorString.apply(unit)).append(power);
			}
			first = false;
		}

		return result.toString();
	}

	// region private methods

	private String buildPower(int power) {
		StringBuilder result = new StringBuilder();
		boolean negative = power < 0;

		// Omit neutral power of 1
		if (power == 1) {
			return result.toString();
		}

		if (power == 0) {
			return String.valueOf(POWERS[0]);
		}

		power = Math.abs(power);

		for (;power > 0 ; power /= 10)
		{
			result.insert(0, POWERS[power % 10]);
		}

		if (negative) {
			return NEGATIVE + result.toString();
		}

		return result.toString();
	}

	private void addMajor(Class<? extends BaseUnit> clazz, UnitCount unitCount) {
		addPower(clazz, unitCount.unit, unitCount.count);
	}

	private void addMinor(Class<? extends BaseUnit> clazz, UnitCount unitCount) {
		addPower(clazz, unitCount.unit, -unitCount.count);
	}

	private void addPower(Class<? extends BaseUnit> clazz, BaseUnit unit, Integer count) {
		if (count == 0) return;

		UnitCount unitCount = counts.get(clazz);
		int result;

		if (unitCount == null) {
			result = count;
		} else {
			if (!unitCount.unit.equals(unit)) {
				throw new OffendingUnitException(unitCount.unit.getSingularName() + " and " + unit.getSingularName() + " are both " + unit.getBaseUnitType().getSimpleName());
			}

		 	result = unitCount.count + count;
		}

		if (result == 0) {
			counts.remove(clazz);
		} else {
			counts.put(clazz, new UnitCount(unit, result));
		}
	}

	@SuppressWarnings("unchecked")
	public <U extends BaseUnit> U findUnit(Class<U> unitClass) {
		return getUnit(unitClass, getBaseUnits());
	}

	@SuppressWarnings("unchecked")
	private <U extends BaseUnit> U getUnit(Class<U> unitClass, Collection<UnitCount> units) {
		for (UnitCount unitCount : units) {
			BaseUnit unit = unitCount.getUnit();

			if (unitClass.isAssignableFrom(unit.getClass())) return (U) unit;
		}

		return null;
	}

	public boolean isEmpty() {
		return counts.isEmpty();
	}

	// endregion

	// region override Object

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof UnitCounter) {
			UnitCounter other = (UnitCounter) obj;

			if (this.counts.size() != other.counts.size()) return false;

			for (Class<? extends BaseUnit> baseUnit : counts.keySet()) {
				UnitCount thisCount = this.counts.get(baseUnit);
				UnitCount otherCount = other.counts.get(baseUnit);

				if (!Objects.equals(thisCount, otherCount)) return false;
			}

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return counts.hashCode();
	}

	// endregion

}
