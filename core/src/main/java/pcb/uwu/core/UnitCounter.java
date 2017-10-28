package pcb.uwu.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UnitCounter {

	private final Map<BaseUnit, Integer> major, minor;

	private static final char NEGATIVE = '⁻';
	private static final char[] POWERS = new char[] {'⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹'};

	// region constructors

	public UnitCounter() {
		major = new HashMap<>();
		minor = new HashMap<>();
	}

	public UnitCounter(BaseUnit canonic) {
		this();

		major.put(canonic, 1);
	}

	private UnitCounter(UnitCounter source) {
		this(new HashMap<>(source.major), new HashMap<>(source.minor));
	}

	private UnitCounter(Map<BaseUnit, Integer> major, Map<BaseUnit, Integer> minor) {
		this.major = major;
		this.minor = minor;
	}

	// endregion

	public UnitCounter major(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.major.forEach(result::addMajor);
		unitCounter.minor.forEach(result::addMajor);

		return result;
	}

	public UnitCounter major(BaseUnit unit) {
		return major(unit, 1);
	}

	public UnitCounter major(BaseUnit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.addMajor(unit, result.remove(unit) + counts);

		return result;
	}

	public UnitCounter minor(UnitCounter unitCounter) {
		UnitCounter result = new UnitCounter(this);

		unitCounter.major.forEach(result::addMinor);
		unitCounter.minor.forEach(result::addMinor);

		return result;
	}

	public UnitCounter minor(BaseUnit unit) {
		return minor(unit, 1);
	}

	public UnitCounter minor(BaseUnit unit, int counts) {
		UnitCounter result = new UnitCounter(this);

		result.addMajor(unit, result.remove(unit) - counts);

		return result;
	}

	public int get(BaseUnit unit) {
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

	public Set<BaseUnit> getMinorKeys() {
		return minor.keySet();
	}

	public Set<BaseUnit> getMajorKeys() {
		return major.keySet();
	}

	public String asString(Function<Unit, String> majorString, Function<Unit, String> minorString, String separator) {
		String result = "";

		boolean first = true;

		for (BaseUnit unit : major.keySet()) {
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

		for (BaseUnit unit : minor.keySet()) {
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

	private void addMinor(BaseUnit unit, int counts) {
		addMajor(unit, -counts);
	}

	private void addMajor(BaseUnit unit, int counts) {
		if (counts < 0) {
			minor.put(unit, counts);
		} else if (counts > 0) {
			major.put(unit, counts);
		} else {
			minor.remove(unit);
			major.remove(unit);
		}
	}

	private int remove(BaseUnit key) {
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
	public <U extends BaseUnit> U findMajorUnit(Class<U> unitClass) {
		return getUnit(unitClass, major.keySet()); //todo drop after normalisation is applied
	}

	@SuppressWarnings("unchecked")
	public <U extends BaseUnit> U findMinorUnit(Class<U> unitClass) {
		return getUnit(unitClass, minor.keySet());
	}

	@SuppressWarnings("unchecked")
	private <U extends BaseUnit> U getUnit(Class<U> unitClass, Set<BaseUnit> units) {
		for (Unit unit : units) {
			if (unitClass.isAssignableFrom(unit.getClass())) return (U) unit;
		}

		return null;
	}

	public Set<BaseUnit> getBaseUnits() {
		return Stream.of(major.keySet(), minor.keySet())
				.flatMap(Set::stream)
				.collect(Collectors.toSet());
	}

	// endregion
}
