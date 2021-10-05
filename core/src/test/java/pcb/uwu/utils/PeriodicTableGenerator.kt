package pcb.uwu.utils;

import org.junit.Test;
import pcb.uwu.core.BigDecimalAmount;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PeriodicTableGenerator {
	@Test
	public void generateElements() {

		StringBuilder builder = new StringBuilder();
		File file = new File("ChemicalElement.java");

		for (PeriodicTable element : PeriodicTable.values()) {
			String name = element.name().charAt(0) + element.name().substring(1).toLowerCase();
			builder.append("public static final ChemicalElement ")
					.append(element.name())
					.append(" =\n\t\tnew ChemicalElement(")
					.append(element.atomicNumber)
					.append(", \"")
					.append(name)
					.append("\", \"")
					.append(element.symbol)
					.append("\", new BigDecimal(\"")
					.append(element.atomicWeight)
					.append("\"));\n");
		}

		try (FileWriter writer = new FileWriter(file)) {
			writer.write(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public enum PeriodicTable {
		HYDROGEN	(  1,  "H", "1.0080000000000"),
		HELIUM		(  2, "He", "4.0026022222222"),
		LITHIUM		(  3, "Li", "6.9400000000000"),
		BERYLLIUM	(  4, "Be", "9.0121831555555"),
		BORON		(  5,  "B", "10.810000000000"),
		CARBON		(  6,  "C", "12.011000000000"),
		NITROGEN	(  7,  "N", "14.007000000000"),
		OXYGEN		(  8,  "O", "15.999000000000"),
		FLUORINE	(  9,  "F", "18.998403163666"),
		NEON		( 10, "Ne", "20.179766666666"),
		SODIUM		( 11, "Na", "22.989769282222"),
		MAGNESIUM	( 12, "Mg", "24.305000000000"),
		ALUMINIUM	( 13, "Al", "26.981538577777"),
		SILICON		( 14, "Si", "28.085000000000"),
		PHOSPHORUS	( 15,  "P", "30.973761998555"),
		SULFUR		( 16,  "S", "32.060000000000"),
		CHLORINE	( 17, "Cl", "35.450000000000"),
		ARGON		( 18, "Ar", "39.948111111111"),
		POTASSIUM	( 19,  "K", "39.098311111111"),
		CALCIUM		( 20, "Ca", "40.078444444444"),
		SCANDIUM	( 21, "Sc", "44.955908555555"),
		TITANIUM	( 22, "Ti", "47.867111111111"),
		VANADIUM	( 23,  "V", "50.941511111111"),
		CHROMIUM	( 24, "Cr", "51.996166666666"),
		MANGANESE	( 25, "Mn", "54.938044333333"),
		IRON		( 26, "Fe", "55.845222222222"),
		COBALT		( 27, "Co", "58.933194444444"),
		NICKEL		( 28, "Ni", "58.693444444444"),
		COPPER		( 29, "Cu", "63.546333333333"),
		ZINC		( 30, "Zn", "65.382222222222"),
		GALLIUM		( 31, "Ga", "69.723111111111"),
		GERMANIUM	( 32, "Ge", "72.630888888888"),
		ARSENIC		( 33, "As", "749215956666666"),
		SELENIUM	( 34, "Se", "78.971888888888"),
		BROMINE		( 35, "Br", "79.904000000000"),
		KRYPTON		( 36, "Kr", "83.798222222222"),
		RUBIDIUM	( 37, "Rb", "85.467833333333"),
		STRONTIUM	( 38, "Sr", "87.621111111111"),
		YTTRIUM		( 39,  "Y", "88.905842222222"),
		ZIRCONIUM	( 40, "Zr", "91.224222222222"),
		NIOBIUM		( 41, "Nb", "92.906372222222"),
		MOLYBDENUM	( 42, "Mo", "95.951111111111"),
		TECHNETIUM	( 43, "Tc", "98.000000000000"),
		RUTHENIUM	( 44, "Ru", "101.07222222222"),
		RHODIUM		( 45, "Rh", "102.90550222222"),
		PALLADIUM	( 46, "Pd", "106.42111111111"),
		SILVER		( 47, "Ag", "107.86822222222"),
		CADMIUM		( 48, "Cd", "112.41444444444"),
		INDIUM		( 49, "In", "114.81811111111"),
		TIN			( 50, "Sn", "118.71077777777"),
		ANTIMONY	( 51, "Sb", "121.76011111111"),
		TELLURIUM	( 52, "Te", "127.60333333333"),
		IODINE		( 53,  "I", "126.90447333333"),
		XENON		( 54, "Xe", "131.29366666666"),
		CAESIUM		( 55, "Cs", "132.90545196666"),
		BARIUM		( 56, "Ba", "137.32777777777"),
		LANTHANUM	( 57, "La", "138.90547777777"),
		CERIUM		( 58, "Ce", "140.11611111111"),
		PRASEODYMIUM( 59, "Pr", "140.90766222222"),
		NEODYMIUM	( 60, "Nd", "144.24233333333"),
		PROMETHIUM	( 61, "Pm", "145.00000000000"),
		SAMARIUM	( 62, "Sm", "150.36222222222"),
		EUROPIUM	( 63, "Eu", "151.96411111111"),
		GADOLINIUM	( 64, "Gd", "157.25333333333"),
		TERBIUM		( 65, "Tb", "158.92535222222"),
		DYSPROSIUM	( 66, "Dy", "162.50011111111"),
		HOLMIUM		( 67, "Ho", "164.93033222222"),
		ERBIUM		( 68, "Er", "167.25933333333"),
		THULIUM		( 69, "Tm", "168.93422222222"),
		YTTERBIUM	( 70, "Yb", "173.04510101010"),
		LUTETIUM	( 71, "Lu", "174.96681111111"),
		HAFNIUM		( 72, "Hf", "178.49222222222"),
		TANTALUM	( 73, "Ta", "180.94788222222"),
		TUNGSTEN	( 74,  "W", "183.84111111111"),
		RHENIUM		( 75, "Re", "186.20711111111"),
		OSMIUM		( 76, "Os", "190.23333333333"),
		IRIDIUM		( 77, "Ir", "192.21733333333"),
		PLATINUM	( 78, "Pt", "195.08499999999"),
		GOLD		( 79, "Au", "196.96656955555"),
		MERCURY		(  80, "Hg", "200.59233333333"),
		THALLIUM	( 81, "Tl", "204.38000000000"),
		LEAD		( 82, "Pb", "207.21111111111"),
		BISMUTH		( 83, "Bi", "208.98040111111"),
		POLONIUM	( 84, "Po", "209.00000000000"),
		ASTATINE	( 85, "At", "210.00000000000"),
		RADON		( 86, "Rn", "222.00000000000"),
		FRANCIUM	( 87, "Fr", "223.00000000000"),
		RADIUM		( 88, "Ra", "226.00000000000"),
		ACTINIUM	( 89, "Ac", "227.00000000000"),
		THORIUM		( 90, "Th", "232.03774444444"),
		PROTACTINIUM( 91, "Pa", "231.03588222222"),
		URANIUM		( 92,  "U", "238.02891333333"),
		NEPTUNIUM	( 93, "Np", "237.00000000000"),
		PLUTONIUM	( 94, "Pu", "244.00000000000"),
		AMERICIUM	( 95, "Am", "243.00000000000"),
		CURIUM		( 96, "Cm", "247.00000000000"),
		BERKELIUM	( 97, "Bk", "247.00000000000"),
		CALIFORNIUM	( 98, "Cf", "251.00000000000"),
		EINSTEINIUM	( 99, "Es", "252.00000000000"),
		FERMIUM		(100, "Fm", "257.00000000000"),
		MENDELEVIUM	(101, "Md", "258.00000000000"),
		NOBELIUM	(102, "No", "259.00000000000"),
		LAWRENCIUM	(103, "Lr", "266.00000000000"),
		RUTHERFORDIUM(104, "Rf", "267.00000000000"),
		DUBNIUM		(105, "Db", "268.00000000000"),
		SEABORGIUM	(106, "Sg", "269.00000000000"),
		BOHRIUM		(107, "Bh", "270.00000000000"),
		HASSIUM		(108, "Hs", "270.00000000000"),
		MEITNERIUM	(109, "Mt", "278.00000000000"),
		DARMSTADTIUM(110, "Ds", "281.00000000000"),
		ROENTGENIUM	(111, "Rg", "282.00000000000"),
		COPERNICUM	(112, "Cn", "285.00000000000"),
		NIHONIUM	(113, "Nh", "286.00000000000"),
		FLEROVIUM	(114, "Fl", "289.00000000000"),
		MOSCOVIUM	(115, "Mc", "290.00000000000"),
		LIVERMORIUM	(116, "Lv", "293.00000000000"),
		TENNESSINE	(117, "Ts", "294.00000000000"),
		OGANESSON	(118, "Og", "294.00000000000")
		;

		public final int atomicNumber;
		public final String symbol;
		public final BigDecimalAmount atomicWeight;

		PeriodicTable(int atomicNumber, String symbol, String atomicWeight) {
			this.atomicNumber = atomicNumber;
			this.symbol = symbol;
			this.atomicWeight = new BigDecimalAmount(atomicWeight);
		}
	}
}
