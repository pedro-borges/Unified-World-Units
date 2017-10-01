package pcb.units.base;

public class BaseUnit<T extends Unit<T>> implements Unit<T> {
	private final String symbol;
	private final String singularName;
	private final String pluralName;

	public BaseUnit(
			String symbol,
			String singularName,
			String pluralName) {

		this.symbol = symbol;
		this.singularName = singularName;
		this.pluralName = pluralName;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public String getSingularName() {
		return singularName;
	}

	@Override
	public String getPluralName() {
		return pluralName;
	}
}
