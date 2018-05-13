package pcb.uwu.utils;

import java.math.BigDecimal;

public class MathUtils {
	public static final BigDecimal PI = new BigDecimal(Math.PI);

	@SafeVarargs
	public static <T extends Comparable<T>> T max(T first, T... others) {
		T result = first;

		for (T value : others) {
			if (value.compareTo(result) > 0) {
				result = value;
			}
		}

		return result;
	}

	@SafeVarargs
	public static <T extends Comparable<T>> T min(T first, T... others) {
		T result = first;

		for (T value : others) {
			if (value.compareTo(result) < 0) {
				result = value;
			}
		}

		return result;
	}
}
