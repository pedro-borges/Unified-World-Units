package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.units.base.LengthUnit;
import pcb.uwu.units.base.MassUnit;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class BaseUnitTest {
	private LengthUnit length = new LengthUnit("", "", "", Function.identity(), Function.identity()) {};
	private MassUnit mass = new MassUnit("", "", "", Function.identity(), Function.identity()) {};

	@Test
	public void testPrecendence() {
		List<BaseUnit> test = Stream.of(mass, length)
				.sorted()
				.collect(Collectors.toList());

		assertEquals(length, test.get(0));
		assertEquals(mass, test.get(1));
	}
}