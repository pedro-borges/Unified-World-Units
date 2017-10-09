package pcb.uwu.units.composite.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;

public abstract class VolumeUnit extends CompositeUnit {

	public VolumeUnit(LengthUnit length, LengthUnit height, LengthUnit depth) {
		super(new UnitCounter()
				.major(length)
				.major(height)
				.major(depth));
	}
}
