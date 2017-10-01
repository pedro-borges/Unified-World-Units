package pcb.units.base;

public interface Unit<T extends Unit<T>> {
	String getSymbol();
	String getSingularName();
	String getPluralName();
}
