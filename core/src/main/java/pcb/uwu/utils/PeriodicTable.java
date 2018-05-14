package pcb.uwu.utils;

import pcb.uwu.core.BigDecimalAmount;

public enum PeriodicTable {
	HYDROGEN	( 1,  "H", "1.0080000000000"),
	HELIUM		( 2, "He", "4.0026022222222"),
	LITHIUM		( 3, "Li", "6.9400000000000"),
	BERYLLIUM	( 4, "Be", "9.0121831555555"),
	BORON		( 5,  "B", "10.810000000000"),
	CARBON		( 6,  "C", "12.011000000000"),
	NITROGEN	( 7,  "N", "14.007000000000"),
	OXYGEN		( 8,  "O", "15.999000000000"),
	FLUORINE	( 9,  "F", "18.998403163666"),
	NEON		(10, "Ne", "20.179766666666"),
	SODIUM		(11, "Na", "22.989769282222"),
	MAGNESIUM	(12, "Mg", "24.305000000000"),
	ALUMINIUM	(13, "Al", "26.981538577777"),
	SILICON		(14, "Si", "28.085000000000"),
	PHOSPHORUS	(15,  "P", "30.973761998555"),
	SULFUR		(16,  "S", "32.060000000000"),
	CHLORINE	(17, "Cl", "35.450000000000"),
	ARGON		(18, "Ar", "39.948111111111"),
	POTASSIUM	(19,  "K", "39.098311111111"),
	CALCIUM		(20, "Ca", "40.078444444444"),
	SCANDIUM	(21, "Sc", "44.955908555555"),
	TITANIUM	(22, "Ti", "47.867111111111"),
	VANADIUM	(23,  "V", "50.941511111111"),
	//todo continue
	;

	private final int atomicNumber;
	private final String symbol;
	private final BigDecimalAmount atomicWeight;

	PeriodicTable(int atomicNumber, String symbol, String atomicWeight) {
		this.atomicNumber = atomicNumber;
		this.symbol = symbol;
		this.atomicWeight = new BigDecimalAmount(atomicWeight);
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public String getSymbol() {
		return symbol;
	}

	public BigDecimalAmount getAtomicWeight() {
		return atomicWeight;
	}
}
