package pcb.uwu.unit.base;

import java.math.BigDecimal;
import java.util.function.Function;

public class MoleUnit extends AmountOfSubstanceUnit {

	public static final BigDecimal AVOGADRO_NUMBER = new BigDecimal("6.02214076E23");

	public static final MoleUnit MOLE = new MoleUnit();

	private MoleUnit() {
		super("mol", "mole", "moles",
				Function.identity(),
				Function.identity());
	}
}
