package pcb.uwu.unit.derived.mechanics;

import static pcb.uwu.unit.base.MeterUnit.METER;
import static pcb.uwu.unit.base.SecondUnit.SECOND;

public class MeterPerSecondUnit extends SpeedUnit {

	public static final MeterPerSecondUnit METER_PER_SECOND = new MeterPerSecondUnit();

	public MeterPerSecondUnit() {
		super(METER, SECOND);
	}
}
