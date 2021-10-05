package pcb.uwu.unit.base

import pcb.uwu.core.BaseUnit
import pcb.uwu.core.BigDecimalAmount
import pcb.uwu.core.UnitCounter
import java.util.function.Function

open class LuminousIntensityUnit(symbol: String,
                                 singularName: String,
                                 pluralName: String,
                                 translationToCanonical: Function<BigDecimalAmount, BigDecimalAmount>,
                                 translationFromCanonical: Function<BigDecimalAmount, BigDecimalAmount>) :
    BaseUnit(6, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical)
{
    override val unitCounter
        get() = UnitCounter(this)
    override val baseUnitType = LuminousIntensityUnit::class.java
}