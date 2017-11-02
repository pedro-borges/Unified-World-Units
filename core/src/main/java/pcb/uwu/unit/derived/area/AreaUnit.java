package pcb.uwu.unit.derived.area;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.unit.base.LengthUnit;

public class AreaUnit extends CompositeUnit {

	public AreaUnit(LengthUnit length, LengthUnit height) {
		super(new UnitCounter()
				.major(length)
				.major(height));
	}
}
