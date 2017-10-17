package pcb.uwu.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

public class UnitCounter {
	private final Map<Unit, Integer> major, minor;

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	// region constructors

	public UnitCounter() {
		major = new HashMap<>();
		minor = new HashMap<>();
	}

	public UnitCounter(UnitCounter source) {
		major = new HashMap<>(source.major);
		minor = new HashMap<>(source.minor);
	}

	private UnitCounter(Map<Unit, Integer> major, Map<Unit, Integer> minor) {
		this.major = major;
		this.minor = minor;
	}

	// endregion

	public UnitCounter major(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.major.forEach(result::majorMaps);
		unitCounter.minor.forEach(result::majorMaps);

		return result;
	}

	public UnitCounter major(BaseUnit unit) {
		return major(unit, 1);
	}

	public UnitCounter major(BaseUnit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.majorMaps(unit, result.remove(unit) + counts);

		return result;
	}

	public UnitCounter minor(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.major.forEach(result::minorMaps);
		unitCounter.minor.forEach(result::minorMaps);

		return result;
	}

	public UnitCounter minor(Unit unit) {
		return minor(unit, 1);
	}

	public UnitCounter minor(Unit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.majorMaps(unit, result.remove(unit) - counts);

		return result;
	}

	public int get(Unit unit) {
		if (major.containsKey(unit)) {
			return major.get(unit);
		}
		if (minor.containsKey(unit)) {
			return minor.get(unit);
		}

		return 0;
	}

	public UnitCounter inverse() {
		return new UnitCounter(minor, major);
	}

	public List<Unit> getNegativeKeys() {
		return new ArrayList<>(minor.keySet());
	}

	public List<Unit> getPositiveKeys() {
		return new ArrayList<>(major.keySet());
	}

	public String asString(Function<Unit, String> majorString, Function<Unit, String> minorString, String separator) {
		String result = "";

		boolean first = true;

		for (Unit unit : major.keySet()) {
			String power = buildPower(get(unit));
			if (first) {
				result += majorString.apply(unit) + power;
			} else {
				result += minorString.apply(unit) + power;
			}
			first = false;
		}

		if (!minor.isEmpty()) {
			result += separator;
		}

		for (Unit unit : minor.keySet()) {
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

	private void minorMaps(Unit unit, int counts) {
		majorMaps(unit, -counts);
	}

	private void majorMaps(Unit unit, int counts) {
		if (counts < 0) {
			minor.put(unit, counts);
		} else if (counts > 0) {
			major.put(unit, counts);
		} else {
			minor.remove(unit);
			major.remove(unit);
		}
	}

	private int remove(Unit key) {
		if (major.containsKey(key)) {
			return major.remove(key);
		}
		if (minor.containsKey(key)) {
			return minor.remove(key);
		}

		return 0;
	}

	public boolean isEmpty() {
		return major.isEmpty() && minor.isEmpty();
	}

	@SuppressWarnings("unchecked")
	public <U extends Unit> U findMajorUnit(Class<U> unitClass) {
		return getUnit(unitClass, major.keySet());
	}

	@SuppressWarnings("unchecked")
	public <U extends Unit> U findMinorUnit(Class<U> unitClass) {
		return getUnit(unitClass, minor.keySet());
	}

	private <U extends Unit> U getUnit(Class<U> unitClass, Set<Unit> units) {
		for (Unit unit : units) {
			if (unitClass.isAssignableFrom(unit.getClass())) return (U) unit;
		}

		return null;
	}

	// endregion
}
