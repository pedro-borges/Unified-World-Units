package pcb.uwu.units.composite.fundamental;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.Unit;
import pcb.uwu.units.fundamental.LengthUnit;
import pcb.uwu.utils.ObjectCounter;

import static pcb.uwu.units.fundamental.LengthUnit.FOOT;
import static pcb.uwu.units.fundamental.LengthUnit.INCH;
import static pcb.uwu.units.fundamental.LengthUnit.METER;
import static pcb.uwu.units.fundamental.LengthUnit.MILE;
import static pcb.uwu.units.fundamental.LengthUnit.NAUTIC_MILE;
import static pcb.uwu.units.fundamental.LengthUnit.YARD;

public class AreaUnit extends CompositeUnit {

	public static final AreaUnit SQUARE_METER = new AreaUnit(METER, METER);
	public static final AreaUnit SQUARE_NAUTIC_MILE = new AreaUnit(NAUTIC_MILE, NAUTIC_MILE);
	public static final AreaUnit SQUARE_MILE = new AreaUnit(MILE, MILE);
	public static final AreaUnit SQUARE_YARD = new AreaUnit(YARD, YARD);
	public static final AreaUnit SQUARE_FOOT = new AreaUnit(FOOT, FOOT);
	public static final AreaUnit SQUARE_INCH = new AreaUnit(INCH, INCH);

	public AreaUnit(LengthUnit length, LengthUnit height) {
		super(new ObjectCounter<Unit>()
				.major(length)
				.major(height));
	}
}
