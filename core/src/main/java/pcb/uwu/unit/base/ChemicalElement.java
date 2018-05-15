package pcb.uwu.unit.base;

import java.math.BigDecimal;

public class ChemicalElement {

	//region elements

	public static final ChemicalElement HYDROGEN = new ChemicalElement(1, "Hydrogen", "H", "1.0080000000000");
	public static final ChemicalElement HELIUM = new ChemicalElement(2, "Helium", "He", "4.0026022222222");
	public static final ChemicalElement LITHIUM = new ChemicalElement(3, "Lithium", "Li", "6.9400000000000");
	public static final ChemicalElement BERYLLIUM = new ChemicalElement(4, "Beryllium", "Be", "9.0121831555555");
	public static final ChemicalElement BORON = new ChemicalElement(5, "Boron", "B", "10.810000000000");
	public static final ChemicalElement CARBON = new ChemicalElement(6, "Carbon", "C", "12.011000000000");
	public static final ChemicalElement NITROGEN = new ChemicalElement(7, "Nitrogen", "N", "14.007000000000");
	public static final ChemicalElement OXYGEN = new ChemicalElement(8, "Oxygen", "O", "15.999000000000");
	public static final ChemicalElement FLUORINE = new ChemicalElement(9, "Fluorine", "F", "18.998403163666");
	public static final ChemicalElement NEON = new ChemicalElement(10, "Neon", "Ne", "20.179766666666");
	public static final ChemicalElement SODIUM = new ChemicalElement(11, "Sodium", "Na", "22.989769282222");
	public static final ChemicalElement MAGNESIUM = new ChemicalElement(12, "Magnesium", "Mg", "24.305000000000");
	public static final ChemicalElement ALUMINIUM = new ChemicalElement(13, "Aluminium", "Al", "26.981538577777");
	public static final ChemicalElement SILICON = new ChemicalElement(14, "Silicon", "Si", "28.085000000000");
	public static final ChemicalElement PHOSPHORUS = new ChemicalElement(15, "Phosphorus", "P", "30.973761998555");
	public static final ChemicalElement SULFUR = new ChemicalElement(16, "Sulfur", "S", "32.060000000000");
	public static final ChemicalElement CHLORINE = new ChemicalElement(17, "Chlorine", "Cl", "35.450000000000");
	public static final ChemicalElement ARGON = new ChemicalElement(18, "Argon", "Ar", "39.948111111111");
	public static final ChemicalElement POTASSIUM = new ChemicalElement(19, "Potassium", "K", "39.098311111111");
	public static final ChemicalElement CALCIUM = new ChemicalElement(20, "Calcium", "Ca", "40.078444444444");
	public static final ChemicalElement SCANDIUM = new ChemicalElement(21, "Scandium", "Sc", "44.955908555555");
	public static final ChemicalElement TITANIUM = new ChemicalElement(22, "Titanium", "Ti", "47.867111111111");
	public static final ChemicalElement VANADIUM = new ChemicalElement(23, "Vanadium", "V", "50.941511111111");
	public static final ChemicalElement CHROMIUM = new ChemicalElement(24, "Chromium", "Cr", "51.996166666666");
	public static final ChemicalElement MANGANESE = new ChemicalElement(25, "Manganese", "Mn", "54.938044333333");
	public static final ChemicalElement IRON = new ChemicalElement(26, "Iron", "Fe", "55.845222222222");
	public static final ChemicalElement COBALT = new ChemicalElement(27, "Cobalt", "Co", "58.933194444444");
	public static final ChemicalElement NICKEL = new ChemicalElement(28, "Nickel", "Ni", "58.693444444444");
	public static final ChemicalElement COPPER = new ChemicalElement(29, "Copper", "Cu", "63.546333333333");
	public static final ChemicalElement ZINC = new ChemicalElement(30, "Zinc", "Zn", "65.382222222222");
	public static final ChemicalElement GALLIUM = new ChemicalElement(31, "Gallium", "Ga", "69.723111111111");
	public static final ChemicalElement GERMANIUM = new ChemicalElement(32, "Germanium", "Ge", "72.630888888888");
	public static final ChemicalElement ARSENIC = new ChemicalElement(33, "Arsenic", "As", "749215956666666");
	public static final ChemicalElement SELENIUM = new ChemicalElement(34, "Selenium", "Se", "78.971888888888");
	public static final ChemicalElement BROMINE = new ChemicalElement(35, "Bromine", "Br", "79.904000000000");
	public static final ChemicalElement KRYPTON = new ChemicalElement(36, "Krypton", "Kr", "83.798222222222");
	public static final ChemicalElement RUBIDIUM = new ChemicalElement(37, "Rubidium", "Rb", "85.467833333333");
	public static final ChemicalElement STRONTIUM = new ChemicalElement(38, "Strontium", "Sr", "87.621111111111");
	public static final ChemicalElement YTTRIUM = new ChemicalElement(39, "Yttrium", "Y", "88.905842222222");
	public static final ChemicalElement ZIRCONIUM = new ChemicalElement(40, "Zirconium", "Zr", "91.224222222222");
	public static final ChemicalElement NIOBIUM = new ChemicalElement(41, "Niobium", "Nb", "92.906372222222");
	public static final ChemicalElement MOLYBDENUM = new ChemicalElement(42, "Molybdenum", "Mo", "95.951111111111");
	public static final ChemicalElement TECHNETIUM = new ChemicalElement(43, "Technetium", "Tc", "98.000000000000");
	public static final ChemicalElement RUTHENIUM = new ChemicalElement(44, "Ruthenium", "Ru", "101.07222222222");
	public static final ChemicalElement RHODIUM = new ChemicalElement(45, "Rhodium", "Rh", "102.90550222222");
	public static final ChemicalElement PALLADIUM = new ChemicalElement(46, "Palladium", "Pd", "106.42111111111");
	public static final ChemicalElement SILVER = new ChemicalElement(47, "Silver", "Ag", "107.86822222222");
	public static final ChemicalElement CADMIUM = new ChemicalElement(48, "Cadmium", "Cd", "112.41444444444");
	public static final ChemicalElement INDIUM = new ChemicalElement(49, "Indium", "In", "114.81811111111");
	public static final ChemicalElement TIN = new ChemicalElement(50, "Tin", "Sn", "118.71077777777");
	public static final ChemicalElement ANTIMONY = new ChemicalElement(51, "Antimony", "Sb", "121.76011111111");
	public static final ChemicalElement TELLURIUM = new ChemicalElement(52, "Tellurium", "Te", "127.60333333333");
	public static final ChemicalElement IODINE = new ChemicalElement(53, "Iodine", "I", "126.90447333333");
	public static final ChemicalElement XENON = new ChemicalElement(54, "Xenon", "Xe", "131.29366666666");
	public static final ChemicalElement CAESIUM = new ChemicalElement(55, "Caesium", "Cs", "132.90545196666");
	public static final ChemicalElement BARIUM = new ChemicalElement(56, "Barium", "Ba", "137.32777777777");
	public static final ChemicalElement LANTHANUM = new ChemicalElement(57, "Lanthanum", "La", "138.90547777777");
	public static final ChemicalElement CERIUM = new ChemicalElement(58, "Cerium", "Ce", "140.11611111111");
	public static final ChemicalElement PRASEODYMIUM = new ChemicalElement(59, "Praseodymium", "Pr", "140.90766222222");
	public static final ChemicalElement NEODYMIUM = new ChemicalElement(60, "Neodymium", "Nd", "144.24233333333");
	public static final ChemicalElement PROMETHIUM = new ChemicalElement(61, "Promethium", "Pm", "145.00000000000");
	public static final ChemicalElement SAMARIUM = new ChemicalElement(62, "Samarium", "Sm", "150.36222222222");
	public static final ChemicalElement EUROPIUM = new ChemicalElement(63, "Europium", "Eu", "151.96411111111");
	public static final ChemicalElement GADOLINIUM = new ChemicalElement(64, "Gadolinium", "Gd", "157.25333333333");
	public static final ChemicalElement TERBIUM = new ChemicalElement(65, "Terbium", "Tb", "158.92535222222");
	public static final ChemicalElement DYSPROSIUM = new ChemicalElement(66, "Dysprosium", "Dy", "162.50011111111");
	public static final ChemicalElement HOLMIUM = new ChemicalElement(67, "Holmium", "Ho", "164.93033222222");
	public static final ChemicalElement ERBIUM = new ChemicalElement(68, "Erbium", "Er", "167.25933333333");
	public static final ChemicalElement THULIUM = new ChemicalElement(69, "Thulium", "Tm", "168.93422222222");
	public static final ChemicalElement YTTERBIUM = new ChemicalElement(70, "Ytterbium", "Yb", "173.04510101010");
	public static final ChemicalElement LUTETIUM = new ChemicalElement(71, "Lutetium", "Lu", "174.96681111111");
	public static final ChemicalElement HAFNIUM = new ChemicalElement(72, "Hafnium", "Hf", "178.49222222222");
	public static final ChemicalElement TANTALUM = new ChemicalElement(73, "Tantalum", "Ta", "180.94788222222");
	public static final ChemicalElement TUNGSTEN = new ChemicalElement(74, "Tungsten", "W", "183.84111111111");
	public static final ChemicalElement RHENIUM = new ChemicalElement(75, "Rhenium", "Re", "186.20711111111");
	public static final ChemicalElement OSMIUM = new ChemicalElement(76, "Osmium", "Os", "190.23333333333");
	public static final ChemicalElement IRIDIUM = new ChemicalElement(77, "Iridium", "Ir", "192.21733333333");
	public static final ChemicalElement PLATINUM = new ChemicalElement(78, "Platinum", "Pt", "195.08499999999");
	public static final ChemicalElement GOLD = new ChemicalElement(79, "Gold", "Au", "196.96656955555");
	public static final ChemicalElement MERCURY = new ChemicalElement(80, "Mercury", "Hg", "200.59233333333");
	public static final ChemicalElement THALLIUM = new ChemicalElement(81, "Thallium", "Tl", "204.38000000000");
	public static final ChemicalElement LEAD = new ChemicalElement(82, "Lead", "Pb", "207.21111111111");
	public static final ChemicalElement BISMUTH = new ChemicalElement(83, "Bismuth", "Bi", "208.98040111111");
	public static final ChemicalElement POLONIUM = new ChemicalElement(84, "Polonium", "Po", "209.00000000000");
	public static final ChemicalElement ASTATINE = new ChemicalElement(85, "Astatine", "At", "210.00000000000");
	public static final ChemicalElement RADON = new ChemicalElement(86, "Radon", "Rn", "222.00000000000");
	public static final ChemicalElement FRANCIUM = new ChemicalElement(87, "Francium", "Fr", "223.00000000000");
	public static final ChemicalElement RADIUM = new ChemicalElement(88, "Radium", "Ra", "226.00000000000");
	public static final ChemicalElement ACTINIUM = new ChemicalElement(89, "Actinium", "Ac", "227.00000000000");
	public static final ChemicalElement THORIUM = new ChemicalElement(90, "Thorium", "Th", "232.03774444444");
	public static final ChemicalElement PROTACTINIUM = new ChemicalElement(91, "Protactinium", "Pa", "231.03588222222");
	public static final ChemicalElement URANIUM = new ChemicalElement(92, "Uranium", "U", "238.02891333333");
	public static final ChemicalElement NEPTUNIUM = new ChemicalElement(93, "Neptunium", "Np", "237.00000000000");
	public static final ChemicalElement PLUTONIUM = new ChemicalElement(94, "Plutonium", "Pu", "244.00000000000");
	public static final ChemicalElement AMERICIUM = new ChemicalElement(95, "Americium", "Am", "243.00000000000");
	public static final ChemicalElement CURIUM = new ChemicalElement(96, "Curium", "Cm", "247.00000000000");
	public static final ChemicalElement BERKELIUM = new ChemicalElement(97, "Berkelium", "Bk", "247.00000000000");
	public static final ChemicalElement CALIFORNIUM = new ChemicalElement(98, "Californium", "Cf", "251.00000000000");
	public static final ChemicalElement EINSTEINIUM = new ChemicalElement(99, "Einsteinium", "Es", "252.00000000000");
	public static final ChemicalElement FERMIUM = new ChemicalElement(100, "Fermium", "Fm", "257.00000000000");
	public static final ChemicalElement MENDELEVIUM = new ChemicalElement(101, "Mendelevium", "Md", "258.00000000000");
	public static final ChemicalElement NOBELIUM = new ChemicalElement(102, "Nobelium", "No", "259.00000000000");
	public static final ChemicalElement LAWRENCIUM = new ChemicalElement(103, "Lawrencium", "Lr", "266.00000000000");
	public static final ChemicalElement RUTHERFORDIUM = new ChemicalElement(104, "Rutherfordium", "Rf", "267.00000000000");
	public static final ChemicalElement DUBNIUM = new ChemicalElement(105, "Dubnium", "Db", "268.00000000000");
	public static final ChemicalElement SEABORGIUM = new ChemicalElement(106, "Seaborgium", "Sg", "269.00000000000");
	public static final ChemicalElement BOHRIUM = new ChemicalElement(107, "Bohrium", "Bh", "270.00000000000");
	public static final ChemicalElement HASSIUM = new ChemicalElement(108, "Hassium", "Hs", "270.00000000000");
	public static final ChemicalElement MEITNERIUM = new ChemicalElement(109, "Meitnerium", "Mt", "278.00000000000");
	public static final ChemicalElement DARMSTADTIUM = new ChemicalElement(110, "Darmstadtium", "Ds", "281.00000000000");
	public static final ChemicalElement ROENTGENIUM = new ChemicalElement(111, "Roentgenium", "Rg", "282.00000000000");
	public static final ChemicalElement COPERNICUM = new ChemicalElement(112, "Copernicum", "Cn", "285.00000000000");
	public static final ChemicalElement NIHONIUM = new ChemicalElement(113, "Nihonium", "Nh", "286.00000000000");
	public static final ChemicalElement FLEROVIUM = new ChemicalElement(114, "Flerovium", "Fl", "289.00000000000");
	public static final ChemicalElement MOSCOVIUM = new ChemicalElement(115, "Moscovium", "Mc", "290.00000000000");
	public static final ChemicalElement LIVERMORIUM = new ChemicalElement(116, "Livermorium", "Lv", "293.00000000000");
	public static final ChemicalElement TENNESSINE = new ChemicalElement(117, "Tennessine", "Ts", "294.00000000000");
	public static final ChemicalElement OGANESSON = new ChemicalElement(118, "Oganesson", "Og", "294.00000000000");

	// endregion

	private final int atomicNumber;
	private final String name;
	private final String symbol;
	private final BigDecimal atomicWeight;

	protected ChemicalElement(int atomicNumber, String name, String symbol, String atomicWeight) {
		this(atomicNumber, name, symbol, new BigDecimal(atomicWeight));
	}

	protected ChemicalElement(int atomicNumber, String name, String symbol, BigDecimal atomicWeight) {
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
