package pcb.units.base;

public interface Unit<N extends Number, T extends Unit<N, T>> {
	String getSymbol();
	String getSingularName();
	String getPluralName();
}
