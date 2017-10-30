package pcb.uwu.amount.derived.optics;

import pcb.uwu.amount.base.Candelas;
import pcb.uwu.amount.base.LuminousIntensity;
import pcb.uwu.amount.derived.scalar.SolidAngle;
import pcb.uwu.amount.derived.scalar.Steradians;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.units.derived.optics.LuminousFluxUnit;

import java.math.BigDecimal;
import java.math.MathContext;

import static pcb.uwu.unit.base.CandelaUnit.CANDELA;
import static pcb.uwu.unit.derived.optics.LumenUnit.LUMEN;
import static pcb.uwu.unit.derived.scalar.SteradianUnit.STERADIAN;

public class Lumens extends LuminousFlux {

	// region constructors

	public Lumens(Number value) {
		super(value, LUMEN);
	}

	public Lumens(Number value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(String value) {
		super(value, LUMEN);
	}

	public Lumens(String value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimal value) {
		super(value, LUMEN);
	}

	public Lumens(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, LUMEN);
	}

	public Lumens(BigDecimalAmount amount) {
		super(amount, LUMEN);
	}

	public Lumens(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, LUMEN);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public Lumens plus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new Lumens(plusAmount(other, mathContext));
	}

	@Override
	public Lumens minus(UnitAmount<LuminousFluxUnit> other, MathContext mathContext) {
		return new Lumens(minusAmount(other, mathContext));
	}

	@Override
	public Lumens multipliedBy(BigDecimal other, MathContext mathContext) {
		return new Lumens(multipliedByScalar(other, mathContext));
	}

	@Override
	public Lumens dividedBy(BigDecimal other, MathContext mathContext) {
		return new Lumens(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition

	public Candelas dividedBy(SolidAngle solidAngle, MathContext mathContext) {
		return new Candelas(getAmount().dividedBy(solidAngle.getAmountIn(STERADIAN), mathContext));
	}

	public Steradians dividedBy(LuminousIntensity luminousIntensity, MathContext mathContext) {
		return new Steradians(getAmount().dividedBy(luminousIntensity.getAmountIn(CANDELA), mathContext));
	}

	// endregion
}
