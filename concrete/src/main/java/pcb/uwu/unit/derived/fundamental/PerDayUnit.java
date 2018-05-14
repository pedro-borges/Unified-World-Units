package pcb.uwu.unit.derived.fundamental;

import static pcb.uwu.unit.base.DayUnit.DAY;

public class PerDayUnit extends FrequencyUnit {

	public static final PerDayUnit PER_DAY = new PerDayUnit();

	private PerDayUnit() {
		super(DAY);
	}
}
