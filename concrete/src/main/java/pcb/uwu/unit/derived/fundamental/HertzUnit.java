package pcb.uwu.unit.derived.fundamental;

import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class HertzUnit extends FrequencyUnit {

	public static final HertzUnit HERTZ = new HertzUnit();

	private HertzUnit() {
		super(SECOND);
	}
}
