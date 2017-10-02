package pcb.units.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ObjectCounter<T> {
	private final Map<T, Integer> superior, inferior;

	public ObjectCounter() {
		superior = new HashMap<>();
		inferior = new HashMap<>();
	}

	public ObjectCounter(ObjectCounter<T> source) {
		superior = new HashMap<>(source.superior);
		inferior = new HashMap<>(source.inferior);
	}

	public ObjectCounter<T> increase(T key) {
		return increase(key, 1);
	}

	public ObjectCounter<T> increase(T key, int counts) {
		ObjectCounter<T> result = new ObjectCounter<>(this);

		result.updateMaps(key, result.remove(key) + counts);

		return result;
	}

	public ObjectCounter<T> decrease(T key) {
		return decrease(key, 1);
	}

	public ObjectCounter<T> decrease(T key, int counts) {
		ObjectCounter<T> result = new ObjectCounter<>(this);

		result.updateMaps(key, result.remove(key) - counts);

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

	public List<T> getNegativeKeys() {
		return new ArrayList<>(inferior.keySet());
	}

	public List<T> getPositiveKeys() {
		return new ArrayList<>(superior.keySet());
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
