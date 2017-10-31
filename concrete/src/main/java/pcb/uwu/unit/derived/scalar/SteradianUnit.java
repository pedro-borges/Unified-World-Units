package pcb.uwu.unit.derived.scalar;

public class SteradianUnit extends SolidAngleUnit {

	public static final SteradianUnit STERADIAN = new SteradianUnit();

	public SteradianUnit() {
		super();
	}

	@Override
	public String getSymbol() {
		return "sr";
	}

	@Override
	public String getSingularName() {
		return "steradian";
	}

	@Override
	public String getPluralName() {
		return "steradians";
	}
}
