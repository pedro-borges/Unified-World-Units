package pcb.uwu.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;

import static java.util.Collections.emptyMap;
import static java.util.stream.Collectors.toSet;

public class UnitCounter {

	private final Map<Class<? extends BaseUnit>, Map<BaseUnit, Integer>> powers;

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	// region constructors

	public UnitCounter() {
		powers = new HashMap<>();
	}

	public UnitCounter(BaseUnit canonic) {
		this();

		addPower(canonic.getBaseUnitType(), canonic, 1);
	}

	private UnitCounter(UnitCounter source) {
		this(source.powers);
	}

	private UnitCounter(Map<Class<? extends BaseUnit>, Map<BaseUnit, Integer>> powers) {
		this.powers = new HashMap<>(powers);
	}

	// endregion

	public UnitCounter major(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.powers.forEach(result::addMajor);

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

		unitCounter.powers.forEach(result::addMinor);

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

	public int get(BaseUnit unit) {
		return powers.getOrDefault(unit.getBaseUnitType(), emptyMap()).getOrDefault(unit, 0);
	}

	public Set<BaseUnit> getBaseUnits() {
		return powers.values().stream()
				.map(Map::keySet)
				.flatMap(Collection::stream)
				.collect(toSet());
	}

	public String asString(Function<Unit, String> majorString, Function<Unit, String> minorString, String separator) {
		String result = "";

		Set<BaseUnit> major = powers.values().stream()
				.map(Map::entrySet)
				.flatMap(Collection::stream)
				.filter(entry -> entry.getValue() > 0)
				.map(Entry::getKey)
				.collect(toSet());

		boolean first = true;

		for (BaseUnit unit : major) {
			String power = buildPower(get(unit));
			if (first) {
				result += majorString.apply(unit) + power;
			} else {
				result += minorString.apply(unit) + power;
			}
			first = false;
		}

		Set<BaseUnit> minor = powers.values().stream()
				.map(Map::entrySet)
				.flatMap(Collection::stream)
				.filter(entry -> entry.getValue() < 0)
				.map(Entry::getKey)
				.collect(toSet());

		if (!minor.isEmpty()) {
			result += separator;
		}

		for (BaseUnit unit : minor) {
			String power = buildPower(Math.abs(get(unit)));
			result += minorString.apply(unit) + power;
		}

		return result;
	}

	// region private methods

	private String buildPower(int power) {
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

	private void addMajor(Class<? extends BaseUnit> clazz, Map<BaseUnit, Integer> unitCounts) {
		for (Entry<BaseUnit, Integer> entry : unitCounts.entrySet()) {
			BaseUnit unit = entry.getKey();
			Integer count = entry.getValue();

			addPower(clazz, unit, count);
		}
	}

	private void addMinor(Class<? extends BaseUnit> clazz, Map<BaseUnit, Integer> unitCounts) {
		for (Entry<BaseUnit, Integer> entry : unitCounts.entrySet()) {
			BaseUnit unit = entry.getKey();
			Integer count = entry.getValue();

			addPower(clazz, unit, -count);
		}
	}

	private void addPower(Class<? extends BaseUnit> clazz, BaseUnit unit, Integer count) {
		if (count == 0) return;

		Map<BaseUnit, Integer> internal = powers.getOrDefault(clazz, new HashMap<>());
		int result = internal.getOrDefault(unit, 0) + count;

		if (result == 0) {
			internal.remove(unit);

			if (internal.isEmpty()) {
				powers.remove(clazz);
			}
		} else {
			internal.put(unit, result);

			powers.put(clazz, internal);
		}
	}

	public boolean isEmpty() {
		return powers.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public <U extends BaseUnit> U findUnit(Class<U> unitClass) {
		return getUnit(unitClass, getBaseUnits()); //todo drop after normalisation is applied
	}

	@SuppressWarnings("unchecked")
	private <U extends BaseUnit> U getUnit(Class<U> unitClass, Set<BaseUnit> units) {
		for (Unit unit : units) {
			if (unitClass.isAssignableFrom(unit.getClass())) return (U) unit;
		}

		return null;
	}

	// endregion
}
