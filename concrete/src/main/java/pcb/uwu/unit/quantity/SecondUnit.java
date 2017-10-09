package pcb.uwu.unit.quantity;

import pcb.uwu.units.quantity.TimeUnit;

import java.util.function.Function;

public class SecondUnit extends TimeUnit {

	public static final SecondUnit SECOND = new SecondUnit();

	private SecondUnit() {
		super("s", "second", "seconds",
				Function.identity(),
				Function.identity());
	}
}
