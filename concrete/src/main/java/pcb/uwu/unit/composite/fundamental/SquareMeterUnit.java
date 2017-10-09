package pcb.uwu.unit.composite.fundamental;

import pcb.uwu.units.composite.fundamental.AreaUnit;

import static pcb.uwu.unit.quantity.MeterUnit.METER;

public class SquareMeterUnit extends AreaUnit {

	public static final SquareMeterUnit SQUARE_METER = new SquareMeterUnit();

	public SquareMeterUnit() {
		super(METER, METER);
	}
}
