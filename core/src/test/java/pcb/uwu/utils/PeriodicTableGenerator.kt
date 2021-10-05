package pcb.uwu.utils

import org.junit.Test
import java.io.File
import java.io.FileWriter
import java.io.IOException
import java.math.BigDecimal

class PeriodicTableGenerator
{
    @Test
    fun generateElements()
    {
        val builder = StringBuilder()
        val file = File("ChemicalElement.java")
        for (element in PeriodicTable.values())
        {
            val name = element.name[0].toString() + element.name.substring(1).lowercase()
            builder.append("public static final ChemicalElement ")
                .append(element.name)
                .append(" =\n\t\tnew ChemicalElement(")
                .append(element.atomicNumber)
                .append(", \"")
                .append(name)
                .append("\", \"")
                .append(element.symbol)
                .append("\", new BigDecimal(\"")
                .append(element.atomicWeight)
                .append("\"));\n")
        }
        try
        {
            FileWriter(file).use { writer -> writer.write(builder.toString()) }
        }
        catch (e: IOException)
        {
            e.printStackTrace()
        }
    }

    enum class PeriodicTable(val atomicNumber: Int, val symbol: String, val atomicWeight: BigDecimal)
    {
        HYDROGEN(1, "H", BigDecimal("1.0080000000000")),
        HELIUM(2, "He", BigDecimal("4.0026022222222")),
        LITHIUM(3, "Li", BigDecimal("6.9400000000000")),
        BERYLLIUM(4, "Be", BigDecimal("9.0121831555555")),
        BORON(5, "B", BigDecimal("10.810000000000")),
        CARBON(6, "C", BigDecimal("12.011000000000")),
        NITROGEN(7, "N", BigDecimal("14.007000000000")),
        OXYGEN(8, "O", BigDecimal("15.999000000000")),
        FLUORINE(9, "F", BigDecimal("18.998403163666")),
        NEON(10, "Ne", BigDecimal("20.179766666666")),
        SODIUM(11, "Na", BigDecimal("22.989769282222")),
        MAGNESIUM(12, "Mg", BigDecimal("24.305000000000")),
        ALUMINIUM(13, "Al", BigDecimal("26.981538577777")),
        SILICON(14, "Si", BigDecimal("28.085000000000")),
        PHOSPHORUS(15, "P", BigDecimal("30.973761998555")),
        SULFUR(16, "S", BigDecimal("32.060000000000")),
        CHLORINE(17, "Cl", BigDecimal("35.450000000000")),
        ARGON(18, "Ar", BigDecimal("39.948111111111")),
        POTASSIUM(19, "K", BigDecimal("39.098311111111")),
        CALCIUM(20, "Ca", BigDecimal("40.078444444444")),
        SCANDIUM(21, "Sc", BigDecimal("44.955908555555")),
        TITANIUM(22, "Ti", BigDecimal("47.867111111111")),
        VANADIUM(23, "V", BigDecimal("50.941511111111")),
        CHROMIUM(24, "Cr", BigDecimal("51.996166666666")),
        MANGANESE(25, "Mn", BigDecimal("54.938044333333")),
        IRON(26, "Fe", BigDecimal("55.845222222222")),
        COBALT(27, "Co", BigDecimal("58.933194444444")),
        NICKEL(28, "Ni", BigDecimal("58.693444444444")),
        COPPER(29, "Cu", BigDecimal("63.546333333333")),
        ZINC(30, "Zn", BigDecimal("65.382222222222")),
        GALLIUM(31, "Ga", BigDecimal("69.723111111111")),
        GERMANIUM(32, "Ge", BigDecimal("72.630888888888")),
        ARSENIC(33, "As", BigDecimal("74.9215956666666")),
        SELENIUM(34, "Se", BigDecimal("78.971888888888")),
        BROMINE(35, "Br", BigDecimal("79.904000000000")),
        KRYPTON(36, "Kr", BigDecimal("83.798222222222")),
        RUBIDIUM(37, "Rb", BigDecimal("85.467833333333")),
        STRONTIUM(38, "Sr", BigDecimal("87.621111111111")),
        YTTRIUM(39, "Y", BigDecimal("88.905842222222")),
        ZIRCONIUM(40, "Zr", BigDecimal("91.224222222222")),
        NIOBIUM(41, "Nb", BigDecimal("92.906372222222")),
        MOLYBDENUM(42, "Mo", BigDecimal("95.951111111111")),
        TECHNETIUM(43, "Tc", BigDecimal("98.000000000000")),
        RUTHENIUM(44, "Ru", BigDecimal("101.07222222222")),
        RHODIUM(45, "Rh", BigDecimal("102.90550222222")),
        PALLADIUM(46, "Pd", BigDecimal("106.42111111111")),
        SILVER(47, "Ag", BigDecimal("107.86822222222")),
        CADMIUM(48, "Cd", BigDecimal("112.41444444444")),
        INDIUM(49, "In", BigDecimal("114.81811111111")),
        TIN(50, "Sn", BigDecimal("118.71077777777")),
        ANTIMONY(51, "Sb", BigDecimal("121.76011111111")),
        TELLURIUM(52, "Te", BigDecimal("127.60333333333")),
        IODINE(53, "I", BigDecimal("126.90447333333")),
        XENON(54, "Xe", BigDecimal("131.29366666666")),
        CAESIUM(55, "Cs", BigDecimal("132.90545196666")),
        BARIUM(56, "Ba", BigDecimal("137.32777777777")),
        LANTHANUM(57, "La", BigDecimal("138.90547777777")),
        CERIUM(58, "Ce", BigDecimal("140.11611111111")),
        PRASEODYMIUM(59, "Pr", BigDecimal("140.90766222222")),
        NEODYMIUM(60, "Nd", BigDecimal("144.24233333333")),
        PROMETHIUM(61, "Pm", BigDecimal("145.00000000000")),
        SAMARIUM(62, "Sm", BigDecimal("150.36222222222")),
        EUROPIUM(63, "Eu", BigDecimal("151.96411111111")),
        GADOLINIUM(64, "Gd", BigDecimal("157.25333333333")),
        TERBIUM(65, "Tb", BigDecimal("158.92535222222")),
        DYSPROSIUM(66, "Dy", BigDecimal("162.50011111111")),
        HOLMIUM(67, "Ho", BigDecimal("164.93033222222")),
        ERBIUM(68, "Er", BigDecimal("167.25933333333")),
        THULIUM(69, "Tm", BigDecimal("168.93422222222")),
        YTTERBIUM(70, "Yb", BigDecimal("173.04510101010")),
        LUTETIUM(71, "Lu", BigDecimal("174.96681111111")),
        HAFNIUM(72, "Hf", BigDecimal("178.49222222222")),
        TANTALUM(73, "Ta", BigDecimal("180.94788222222")),
        TUNGSTEN(74, "W", BigDecimal("183.84111111111")),
        RHENIUM(75, "Re", BigDecimal("186.20711111111")),
        OSMIUM(76, "Os", BigDecimal("190.23333333333")),
        IRIDIUM(77, "Ir", BigDecimal("192.21733333333")),
        PLATINUM(78, "Pt", BigDecimal("195.08499999999")),
        GOLD(79, "Au", BigDecimal("196.96656955555")),
        MERCURY(80, "Hg", BigDecimal("200.59233333333")),
        THALLIUM(81, "Tl", BigDecimal("204.38000000000")),
        LEAD(82, "Pb", BigDecimal("207.21111111111")),
        BISMUTH(83, "Bi", BigDecimal("208.98040111111")),
        POLONIUM(84, "Po", BigDecimal("209.00000000000")),
        ASTATINE(85, "At", BigDecimal("210.00000000000")),
        RADON(86, "Rn", BigDecimal("222.00000000000")),
        FRANCIUM(87, "Fr", BigDecimal("223.00000000000")),
        RADIUM(88, "Ra", BigDecimal("226.00000000000")),
        ACTINIUM(89, "Ac", BigDecimal("227.00000000000")),
        THORIUM(90, "Th", BigDecimal("232.03774444444")),
        PROTACTINIUM(91, "Pa", BigDecimal("231.03588222222")),
        URANIUM(92, "U", BigDecimal("238.02891333333")),
        NEPTUNIUM(93, "Np", BigDecimal("237.00000000000")),
        PLUTONIUM(94, "Pu", BigDecimal("244.00000000000")),
        AMERICIUM(95, "Am", BigDecimal("243.00000000000")),
        CURIUM(96, "Cm", BigDecimal("247.00000000000")),
        BERKELIUM(97, "Bk", BigDecimal("247.00000000000")),
        CALIFORNIUM(98, "Cf", BigDecimal("251.00000000000")),
        EINSTEINIUM(99, "Es", BigDecimal("252.00000000000")),
        FERMIUM(100, "Fm", BigDecimal("257.00000000000")),
        MENDELEVIUM(101, "Md", BigDecimal("258.00000000000")),
        NOBELIUM(102, "No", BigDecimal("259.00000000000")),
        LAWRENCIUM(103, "Lr", BigDecimal("266.00000000000")),
        RUTHERFORDIUM(104, "Rf", BigDecimal("267.00000000000")),
        DUBNIUM(105, "Db", BigDecimal("268.00000000000")),
        SEABORGIUM(106, "Sg", BigDecimal("269.00000000000")),
        BOHRIUM(107, "Bh", BigDecimal("270.00000000000")),
        HASSIUM(108, "Hs", BigDecimal("270.00000000000")),
        MEITNERIUM(109, "Mt", BigDecimal("278.00000000000")),
        DARMSTADTIUM(110, "Ds", BigDecimal("281.00000000000")),
        ROENTGENIUM(111, "Rg", BigDecimal("282.00000000000")),
        COPERNICUM(112, "Cn", BigDecimal("285.00000000000")),
        NIHONIUM(113, "Nh", BigDecimal("286.00000000000")),
        FLEROVIUM(114, "Fl", BigDecimal("289.00000000000")),
        MOSCOVIUM(115, "Mc", BigDecimal("290.00000000000")),
        LIVERMORIUM(116, "Lv", BigDecimal("293.00000000000")),
        TENNESSINE(117, "Ts", BigDecimal("294.00000000000")),
        OGANESSON(118, "Og", BigDecimal("294.00000000000")),
    }
}