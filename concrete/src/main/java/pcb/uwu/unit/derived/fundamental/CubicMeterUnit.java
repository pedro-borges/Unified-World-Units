package pcb.uwu.unit.derived.fundamental;

import pcb.uwu.units.derived.fundamental.VolumeUnit;

import static pcb.uwu.unit.base.MeterUnit.METER;

public class CubicMeterUnit extends VolumeUnit {

	public static final CubicMeterUnit CUBIC_METER = new CubicMeterUnit();

	public CubicMeterUnit() {
		super(METER, METER, METER);
	}
}
