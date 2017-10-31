package pcb.uwu.unit.derived.area;

import pcb.uwu.unit.derived.fundamental.AreaUnit;

import static pcb.uwu.unit.base.MeterUnit.METER;

public class SquareMeterUnit extends AreaUnit {

	public static final SquareMeterUnit SQUARE_METER = new SquareMeterUnit();

	public SquareMeterUnit() {
		super(METER, METER);
	}
}
