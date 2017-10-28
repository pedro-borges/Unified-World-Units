package pcb.uwu.units.composite.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.quantity.LengthUnit;

public class AreaUnit extends CompositeUnit {

	public AreaUnit(LengthUnit length, LengthUnit height) {
		super(new UnitCounter()
				.major(length)
				.major(height));
	}
}
