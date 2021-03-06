package pcb.uwu.sandbox;

import org.junit.Test;
import pcb.uwu.amount.base.Hours;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Meters;
import pcb.uwu.amount.base.Time;
import pcb.uwu.amount.derived.finance.Rent;
import pcb.uwu.amount.derived.mechanics.Speed;
import pcb.uwu.amount.finance.Money;
import pcb.uwu.unit.finance.MoneyUnit;

import static java.math.MathContext.DECIMAL64;
import static java.math.MathContext.UNLIMITED;
import static org.junit.Assert.assertEquals;
import static pcb.uwu.core.Magnitude.KILO;

public class RunningCostTest {

	private final Length distance = new Meters(70, KILO);

	private final Speed speed = new Meters(13, KILO)
			.dividedBy(new Hours(1), UNLIMITED);

	private final Rent runningCost = new Money(18, MoneyUnit.of("GBP"))
			.dividedBy(new Hours(1), UNLIMITED);

	@Test
	public void test() {
		Time duration = distance.dividedBy(speed, DECIMAL64);

		Money price = runningCost.multipliedBy(duration, UNLIMITED);

		assertEquals("96.92 £", price.toString());
	}
}
