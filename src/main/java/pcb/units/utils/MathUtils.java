package pcb.units.utils;

import java.math.BigDecimal;

public class MathUtils {
	public static BigDecimal max(BigDecimal first, BigDecimal... others) {
		BigDecimal result = first;

		for (BigDecimal value : others) {
			if (value.compareTo(result) > 0) {
				result = value;
			}
		}

		return result;
	}

	public static short max(short first, short... others) {
		short result = first;

		for (short value : others) {
			if (value > result) {
				result = value;
			}
		}

		return result;
	}

	public static int max(int first, int... others) {
		int result = first;

		for (int value : others) {
			if (value > result) {
				result = value;
			}
		}

		return result;
	}

	public static long max(long first, long... others) {
		long result = first;

		for (long value : others) {
			if (value > result) {
				result = value;
			}
		}

		return result;
	}

	public static float max(float first, float... others) {
		float result = first;

		for (float value : others) {
			if (value > result) {
				result = value;
			}
		}

		return result;
	}

	public static double max(double first, double... others) {
		double result = first;

		for (double value : others) {
			if (value > result) {
				result = value;
			}
		}

		return result;
	}
}
