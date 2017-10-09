package pcb.uwu.unit.composite.fundamental;

import pcb.uwu.units.composite.fundamental.VolumeUnit;

import static pcb.uwu.unit.quantity.MeterUnit.METER;

public class CubicMeterUnit extends VolumeUnit {

	public static final CubicMeterUnit CUBIC_METER = new CubicMeterUnit();

	public CubicMeterUnit() {
		super(METER, METER, METER);
	}
}
