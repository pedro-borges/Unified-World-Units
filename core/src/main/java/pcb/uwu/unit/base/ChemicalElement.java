package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class ChemicalElement {

	// region element constants

	public static final ChemicalElement HYDROGEN =
			new ChemicalElement(1, "Hydrogen", "H", new BigDecimal("1.0080000000000"));
	public static final ChemicalElement HELIUM =
			new ChemicalElement(2, "Helium", "He", new BigDecimal("4.0026022222222"));
	public static final ChemicalElement LITHIUM =
			new ChemicalElement(3, "Lithium", "Li", new BigDecimal("6.9400000000000"));
	public static final ChemicalElement BERYLLIUM =
			new ChemicalElement(4, "Beryllium", "Be", new BigDecimal("9.0121831555555"));
	public static final ChemicalElement BORON =
			new ChemicalElement(5, "Boron", "B", new BigDecimal("10.810000000000"));
	public static final ChemicalElement CARBON =
			new ChemicalElement(6, "Carbon", "C", new BigDecimal("12.011000000000"));
	public static final ChemicalElement NITROGEN =
			new ChemicalElement(7, "Nitrogen", "N", new BigDecimal("14.007000000000"));
	public static final ChemicalElement OXYGEN =
			new ChemicalElement(8, "Oxygen", "O", new BigDecimal("15.999000000000"));
	public static final ChemicalElement FLUORINE =
			new ChemicalElement(9, "Fluorine", "F", new BigDecimal("18.998403163666"));
	public static final ChemicalElement NEON =
			new ChemicalElement(10, "Neon", "Ne", new BigDecimal("20.179766666666"));
	public static final ChemicalElement SODIUM =
			new ChemicalElement(11, "Sodium", "Na", new BigDecimal("22.989769282222"));
	public static final ChemicalElement MAGNESIUM =
			new ChemicalElement(12, "Magnesium", "Mg", new BigDecimal("24.305000000000"));
	public static final ChemicalElement ALUMINIUM =
			new ChemicalElement(13, "Aluminium", "Al", new BigDecimal("26.981538577777"));
	public static final ChemicalElement SILICON =
			new ChemicalElement(14, "Silicon", "Si", new BigDecimal("28.085000000000"));
	public static final ChemicalElement PHOSPHORUS =
			new ChemicalElement(15, "Phosphorus", "P", new BigDecimal("30.973761998555"));
	public static final ChemicalElement SULFUR =
			new ChemicalElement(16, "Sulfur", "S", new BigDecimal("32.060000000000"));
	public static final ChemicalElement CHLORINE =
			new ChemicalElement(17, "Chlorine", "Cl", new BigDecimal("35.450000000000"));
	public static final ChemicalElement ARGON =
			new ChemicalElement(18, "Argon", "Ar", new BigDecimal("39.948111111111"));
	public static final ChemicalElement POTASSIUM =
			new ChemicalElement(19, "Potassium", "K", new BigDecimal("39.098311111111"));
	public static final ChemicalElement CALCIUM =
			new ChemicalElement(20, "Calcium", "Ca", new BigDecimal("40.078444444444"));
	public static final ChemicalElement SCANDIUM =
			new ChemicalElement(21, "Scandium", "Sc", new BigDecimal("44.955908555555"));
	public static final ChemicalElement TITANIUM =
			new ChemicalElement(22, "Titanium", "Ti", new BigDecimal("47.867111111111"));
	public static final ChemicalElement VANADIUM =
			new ChemicalElement(23, "Vanadium", "V", new BigDecimal("50.941511111111"));
	public static final ChemicalElement CHROMIUM =
			new ChemicalElement(24, "Chromium", "Cr", new BigDecimal("51.996166666666"));
	public static final ChemicalElement MANGANESE =
			new ChemicalElement(25, "Manganese", "Mn", new BigDecimal("54.938044333333"));
	public static final ChemicalElement IRON =
			new ChemicalElement(26, "Iron", "Fe", new BigDecimal("55.845222222222"));
	public static final ChemicalElement COBALT =
			new ChemicalElement(27, "Cobalt", "Co", new BigDecimal("58.933194444444"));
	public static final ChemicalElement NICKEL =
			new ChemicalElement(28, "Nickel", "Ni", new BigDecimal("58.693444444444"));
	public static final ChemicalElement COPPER =
			new ChemicalElement(29, "Copper", "Cu", new BigDecimal("63.546333333333"));
	public static final ChemicalElement ZINC =
			new ChemicalElement(30, "Zinc", "Zn", new BigDecimal("65.382222222222"));
	public static final ChemicalElement GALLIUM =
			new ChemicalElement(31, "Gallium", "Ga", new BigDecimal("69.723111111111"));
	public static final ChemicalElement GERMANIUM =
			new ChemicalElement(32, "Germanium", "Ge", new BigDecimal("72.630888888888"));
	public static final ChemicalElement ARSENIC =
			new ChemicalElement(33, "Arsenic", "As", new BigDecimal("749215956666666"));
	public static final ChemicalElement SELENIUM =
			new ChemicalElement(34, "Selenium", "Se", new BigDecimal("78.971888888888"));
	public static final ChemicalElement BROMINE =
			new ChemicalElement(35, "Bromine", "Br", new BigDecimal("79.904000000000"));
	public static final ChemicalElement KRYPTON =
			new ChemicalElement(36, "Krypton", "Kr", new BigDecimal("83.798222222222"));
	public static final ChemicalElement RUBIDIUM =
			new ChemicalElement(37, "Rubidium", "Rb", new BigDecimal("85.467833333333"));
	public static final ChemicalElement STRONTIUM =
			new ChemicalElement(38, "Strontium", "Sr", new BigDecimal("87.621111111111"));
	public static final ChemicalElement YTTRIUM =
			new ChemicalElement(39, "Yttrium", "Y", new BigDecimal("88.905842222222"));
	public static final ChemicalElement ZIRCONIUM =
			new ChemicalElement(40, "Zirconium", "Zr", new BigDecimal("91.224222222222"));
	public static final ChemicalElement NIOBIUM =
			new ChemicalElement(41, "Niobium", "Nb", new BigDecimal("92.906372222222"));
	public static final ChemicalElement MOLYBDENUM =
			new ChemicalElement(42, "Molybdenum", "Mo", new BigDecimal("95.951111111111"));
	public static final ChemicalElement TECHNETIUM =
			new ChemicalElement(43, "Technetium", "Tc", new BigDecimal("98.000000000000"));
	public static final ChemicalElement RUTHENIUM =
			new ChemicalElement(44, "Ruthenium", "Ru", new BigDecimal("101.07222222222"));
	public static final ChemicalElement RHODIUM =
			new ChemicalElement(45, "Rhodium", "Rh", new BigDecimal("102.90550222222"));
	public static final ChemicalElement PALLADIUM =
			new ChemicalElement(46, "Palladium", "Pd", new BigDecimal("106.42111111111"));
	public static final ChemicalElement SILVER =
			new ChemicalElement(47, "Silver", "Ag", new BigDecimal("107.86822222222"));
	public static final ChemicalElement CADMIUM =
			new ChemicalElement(48, "Cadmium", "Cd", new BigDecimal("112.41444444444"));
	public static final ChemicalElement INDIUM =
			new ChemicalElement(49, "Indium", "In", new BigDecimal("114.81811111111"));
	public static final ChemicalElement TIN =
			new ChemicalElement(50, "Tin", "Sn", new BigDecimal("118.71077777777"));
	public static final ChemicalElement ANTIMONY =
			new ChemicalElement(51, "Antimony", "Sb", new BigDecimal("121.76011111111"));
	public static final ChemicalElement TELLURIUM =
			new ChemicalElement(52, "Tellurium", "Te", new BigDecimal("127.60333333333"));
	public static final ChemicalElement IODINE =
			new ChemicalElement(53, "Iodine", "I", new BigDecimal("126.90447333333"));
	public static final ChemicalElement XENON =
			new ChemicalElement(54, "Xenon", "Xe", new BigDecimal("131.29366666666"));
	public static final ChemicalElement CAESIUM =
			new ChemicalElement(55, "Caesium", "Cs", new BigDecimal("132.90545196666"));
	public static final ChemicalElement BARIUM =
			new ChemicalElement(56, "Barium", "Ba", new BigDecimal("137.32777777777"));
	public static final ChemicalElement LANTHANUM =
			new ChemicalElement(57, "Lanthanum", "La", new BigDecimal("138.90547777777"));
	public static final ChemicalElement CERIUM =
			new ChemicalElement(58, "Cerium", "Ce", new BigDecimal("140.11611111111"));
	public static final ChemicalElement PRASEODYMIUM =
			new ChemicalElement(59, "Praseodymium", "Pr", new BigDecimal("140.90766222222"));
	public static final ChemicalElement NEODYMIUM =
			new ChemicalElement(60, "Neodymium", "Nd", new BigDecimal("144.24233333333"));
	public static final ChemicalElement PROMETHIUM =
			new ChemicalElement(61, "Promethium", "Pm", new BigDecimal("145.00000000000"));
	public static final ChemicalElement SAMARIUM =
			new ChemicalElement(62, "Samarium", "Sm", new BigDecimal("150.36222222222"));
	public static final ChemicalElement EUROPIUM =
			new ChemicalElement(63, "Europium", "Eu", new BigDecimal("151.96411111111"));
	public static final ChemicalElement GADOLINIUM =
			new ChemicalElement(64, "Gadolinium", "Gd", new BigDecimal("157.25333333333"));
	public static final ChemicalElement TERBIUM =
			new ChemicalElement(65, "Terbium", "Tb", new BigDecimal("158.92535222222"));
	public static final ChemicalElement DYSPROSIUM =
			new ChemicalElement(66, "Dysprosium", "Dy", new BigDecimal("162.50011111111"));
	public static final ChemicalElement HOLMIUM =
			new ChemicalElement(67, "Holmium", "Ho", new BigDecimal("164.93033222222"));
	public static final ChemicalElement ERBIUM =
			new ChemicalElement(68, "Erbium", "Er", new BigDecimal("167.25933333333"));
	public static final ChemicalElement THULIUM =
			new ChemicalElement(69, "Thulium", "Tm", new BigDecimal("168.93422222222"));
	public static final ChemicalElement YTTERBIUM =
			new ChemicalElement(70, "Ytterbium", "Yb", new BigDecimal("173.04510101010"));
	public static final ChemicalElement LUTETIUM =
			new ChemicalElement(71, "Lutetium", "Lu", new BigDecimal("174.96681111111"));
	public static final ChemicalElement HAFNIUM =
			new ChemicalElement(72, "Hafnium", "Hf", new BigDecimal("178.49222222222"));
	public static final ChemicalElement TANTALUM =
			new ChemicalElement(73, "Tantalum", "Ta", new BigDecimal("180.94788222222"));
	public static final ChemicalElement TUNGSTEN =
			new ChemicalElement(74, "Tungsten", "W", new BigDecimal("183.84111111111"));
	public static final ChemicalElement RHENIUM =
			new ChemicalElement(75, "Rhenium", "Re", new BigDecimal("186.20711111111"));
	public static final ChemicalElement OSMIUM =
			new ChemicalElement(76, "Osmium", "Os", new BigDecimal("190.23333333333"));
	public static final ChemicalElement IRIDIUM =
			new ChemicalElement(77, "Iridium", "Ir", new BigDecimal("192.21733333333"));
	public static final ChemicalElement PLATINUM =
			new ChemicalElement(78, "Platinum", "Pt", new BigDecimal("195.08499999999"));
	public static final ChemicalElement GOLD =
			new ChemicalElement(79, "Gold", "Au", new BigDecimal("196.96656955555"));
	public static final ChemicalElement MERCURY =
			new ChemicalElement(80, "Mercury", "Hg", new BigDecimal("200.59233333333"));
	public static final ChemicalElement THALLIUM =
			new ChemicalElement(81, "Thallium", "Tl", new BigDecimal("204.38000000000"));
	public static final ChemicalElement LEAD =
			new ChemicalElement(82, "Lead", "Pb", new BigDecimal("207.21111111111"));
	public static final ChemicalElement BISMUTH =
			new ChemicalElement(83, "Bismuth", "Bi", new BigDecimal("208.98040111111"));
	public static final ChemicalElement POLONIUM =
			new ChemicalElement(84, "Polonium", "Po", new BigDecimal("209.00000000000"));
	public static final ChemicalElement ASTATINE =
			new ChemicalElement(85, "Astatine", "At", new BigDecimal("210.00000000000"));
	public static final ChemicalElement RADON =
			new ChemicalElement(86, "Radon", "Rn", new BigDecimal("222.00000000000"));
	public static final ChemicalElement FRANCIUM =
			new ChemicalElement(87, "Francium", "Fr", new BigDecimal("223.00000000000"));
	public static final ChemicalElement RADIUM =
			new ChemicalElement(88, "Radium", "Ra", new BigDecimal("226.00000000000"));
	public static final ChemicalElement ACTINIUM =
			new ChemicalElement(89, "Actinium", "Ac", new BigDecimal("227.00000000000"));
	public static final ChemicalElement THORIUM =
			new ChemicalElement(90, "Thorium", "Th", new BigDecimal("232.03774444444"));
	public static final ChemicalElement PROTACTINIUM =
			new ChemicalElement(91, "Protactinium", "Pa", new BigDecimal("231.03588222222"));
	public static final ChemicalElement URANIUM =
			new ChemicalElement(92, "Uranium", "U", new BigDecimal("238.02891333333"));
	public static final ChemicalElement NEPTUNIUM =
			new ChemicalElement(93, "Neptunium", "Np", new BigDecimal("237.00000000000"));
	public static final ChemicalElement PLUTONIUM =
			new ChemicalElement(94, "Plutonium", "Pu", new BigDecimal("244.00000000000"));
	public static final ChemicalElement AMERICIUM =
			new ChemicalElement(95, "Americium", "Am", new BigDecimal("243.00000000000"));
	public static final ChemicalElement CURIUM =
			new ChemicalElement(96, "Curium", "Cm", new BigDecimal("247.00000000000"));
	public static final ChemicalElement BERKELIUM =
			new ChemicalElement(97, "Berkelium", "Bk", new BigDecimal("247.00000000000"));
	public static final ChemicalElement CALIFORNIUM =
			new ChemicalElement(98, "Californium", "Cf", new BigDecimal("251.00000000000"));
	public static final ChemicalElement EINSTEINIUM =
			new ChemicalElement(99, "Einsteinium", "Es", new BigDecimal("252.00000000000"));
	public static final ChemicalElement FERMIUM =
			new ChemicalElement(100, "Fermium", "Fm", new BigDecimal("257.00000000000"));
	public static final ChemicalElement MENDELEVIUM =
			new ChemicalElement(101, "Mendelevium", "Md", new BigDecimal("258.00000000000"));
	public static final ChemicalElement NOBELIUM =
			new ChemicalElement(102, "Nobelium", "No", new BigDecimal("259.00000000000"));
	public static final ChemicalElement LAWRENCIUM =
			new ChemicalElement(103, "Lawrencium", "Lr", new BigDecimal("266.00000000000"));
	public static final ChemicalElement RUTHERFORDIUM =
			new ChemicalElement(104, "Rutherfordium", "Rf", new BigDecimal("267.00000000000"));
	public static final ChemicalElement DUBNIUM =
			new ChemicalElement(105, "Dubnium", "Db", new BigDecimal("268.00000000000"));
	public static final ChemicalElement SEABORGIUM =
			new ChemicalElement(106, "Seaborgium", "Sg", new BigDecimal("269.00000000000"));
	public static final ChemicalElement BOHRIUM =
			new ChemicalElement(107, "Bohrium", "Bh", new BigDecimal("270.00000000000"));
	public static final ChemicalElement HASSIUM =
			new ChemicalElement(108, "Hassium", "Hs", new BigDecimal("270.00000000000"));
	public static final ChemicalElement MEITNERIUM =
			new ChemicalElement(109, "Meitnerium", "Mt", new BigDecimal("278.00000000000"));
	public static final ChemicalElement DARMSTADTIUM =
			new ChemicalElement(110, "Darmstadtium", "Ds", new BigDecimal("281.00000000000"));
	public static final ChemicalElement ROENTGENIUM =
			new ChemicalElement(111, "Roentgenium", "Rg", new BigDecimal("282.00000000000"));
	public static final ChemicalElement COPERNICUM =
			new ChemicalElement(112, "Copernicum", "Cn", new BigDecimal("285.00000000000"));
	public static final ChemicalElement NIHONIUM =
			new ChemicalElement(113, "Nihonium", "Nh", new BigDecimal("286.00000000000"));
	public static final ChemicalElement FLEROVIUM =
			new ChemicalElement(114, "Flerovium", "Fl", new BigDecimal("289.00000000000"));
	public static final ChemicalElement MOSCOVIUM =
			new ChemicalElement(115, "Moscovium", "Mc", new BigDecimal("290.00000000000"));
	public static final ChemicalElement LIVERMORIUM =
			new ChemicalElement(116, "Livermorium", "Lv", new BigDecimal("293.00000000000"));
	public static final ChemicalElement TENNESSINE =
			new ChemicalElement(117, "Tennessine", "Ts", new BigDecimal("294.00000000000"));
	public static final ChemicalElement OGANESSON =
			new ChemicalElement(118, "Oganesson", "Og", new BigDecimal("294.00000000000"));

	// endregion

	private final int atomicNumber;
	private final String name;
	private final String symbol;
	private final BigDecimal atomicWeight;

	public ChemicalElement(int atomicNumber, String name, String symbol, BigDecimal atomicWeight) {
		this.atomicNumber = atomicNumber;
		this.name = name;
		this.symbol = symbol;
		this.atomicWeight = atomicWeight;
	}

	public int getAtomicNumber() {
		return atomicNumber;
	}

	public String getName() {
		return name;
	}

	public String getSymbol() {
		return symbol;
	}

	public BigDecimal getAtomicWeight() {
		return atomicWeight;
	}
}
