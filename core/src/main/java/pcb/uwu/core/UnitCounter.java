package pcb.uwu.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitCounter {
	private final Map<Unit, Integer> major, minor;

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

	public UnitCounter major(Unit unit) {
		return major(unit, 1);
	}

	public UnitCounter major(Unit unit, int counts) {
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

	// region private methods

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

	// endregion
}
