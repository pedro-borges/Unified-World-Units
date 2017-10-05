package pcb.uwu.units.composite.finance;

import pcb.uwu.core.CompositeUnit;
import pcb.uwu.core.UnitCounter;
import pcb.uwu.units.fundamental.TimeUnit;

import static pcb.uwu.units.fundamental.TimeUnit.DAY;
import static pcb.uwu.units.fundamental.TimeUnit.HOUR;
import static pcb.uwu.units.fundamental.TimeUnit.MINUTE;
import static pcb.uwu.units.fundamental.TimeUnit.SECOND;
import static pcb.uwu.units.fundamental.TimeUnit.WEEK;

public class InterestRateUnit extends CompositeUnit {

	public static final InterestRateUnit PER_SECOND = new InterestRateUnit(SECOND);
	public static final InterestRateUnit PER_MINUTE = new InterestRateUnit(MINUTE);
	public static final InterestRateUnit PER_HOUR = new InterestRateUnit(HOUR);
	public static final InterestRateUnit PER_DAY = new InterestRateUnit(DAY);
	public static final InterestRateUnit PER_WEEK = new InterestRateUnit(WEEK);

	public InterestRateUnit(TimeUnit time) {
		super(new UnitCounter()
				.minor(time));
	}
}
