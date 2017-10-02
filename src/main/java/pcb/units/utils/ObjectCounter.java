package pcb.units.utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ObjectCounter<T> {
	private final Map<T, Integer> superior, inferior;

	public ObjectCounter() {
		superior = new HashMap<>();
		inferior = new HashMap<>();
	}

	public int reset(T key) {
		superior.remove(key);
		inferior.remove(key);

		return 0;
	}

	public int increase(T key) {
		return increase(key, 1);
	}

	public int increase(T key, int counts) {
		int result = remove(key) + counts;

		updateMaps(key, result);

		return result;
	}

	public int decrease(T key) {
		return decrease(key, 1);
	}

	public int decrease(T key, int counts) {
		int result = remove(key) - counts;

		updateMaps(key, result);

		return result;
	}

	public int get(T key) {
		if (superior.containsKey(key)) {
			return superior.get(key);
		}
		if (inferior.containsKey(key)) {
			return inferior.get(key);
		}

		return 0;
	}

	public List<T> getNegativeKeys(List<T> order) {
		return inferior.keySet().stream()
				.sorted(Comparator.comparingInt(order::indexOf))
				.collect(Collectors.toList());
	}

	public List<T> getPositiveKeys(List<T> order) {
		return superior.keySet().stream()
				.sorted(Comparator.comparingInt(order::indexOf))
				.collect(Collectors.toList());
	}

	// region private methods

	private void updateMaps(T key, int result) {
		if (result < 0) {
			inferior.put(key, result);
		} else if (result > 0) {
			superior.put(key, result);
		} else {
			inferior.remove(key);
			superior.remove(key);
		}
	}

	private int remove(T key) {
		if (superior.containsKey(key)) {
			return superior.remove(key);
		}
		if (inferior.containsKey(key)) {
			return inferior.remove(key);
		}

		return 0;
	}

	// endregion
}
