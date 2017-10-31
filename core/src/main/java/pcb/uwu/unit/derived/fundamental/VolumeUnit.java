package pcb.uwu.unit.derived.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;

public abstract class VolumeUnit extends CompositeUnit {

	public VolumeUnit(LengthUnit length, LengthUnit height, LengthUnit depth) {
		super(new UnitCounter()
				.major(length)
				.major(height)
				.major(depth));
	}
}
