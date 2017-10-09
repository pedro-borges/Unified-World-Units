package pcb.uwu.unit.composite.fundamental;

import pcb.uwu.units.composite.fundamental.FrequencyUnit;

import static pcb.uwu.unit.quantity.SecondUnit.SECOND;

public class HertzUnit extends FrequencyUnit {

	public static final HertzUnit HERTZ = new HertzUnit();

	private HertzUnit() {
		super(SECOND);
	}
}
