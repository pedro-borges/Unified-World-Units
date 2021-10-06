package pcb.uwu.core

import pcb.uwu.core.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.exception.OffendingUnitException
import kotlin.math.abs
import kotlin.reflect.KClass
import kotlin.reflect.full.isSuperclassOf

class UnitCounter
{
    private val counts: MutableMap<KClass<out BaseUnit>, UnitCount>

    // region constructors

    constructor() : this(HashMap())

    constructor(unit: BaseUnit) : this()
    {
        addPower(unit.baseUnitType, unit, 1)
    }

    constructor(source: UnitCounter) : this(source.counts)

    private constructor(counts: Map<KClass<out BaseUnit>, UnitCount>)
    {
        this.counts = HashMap(counts)
    }

    // endregion

    // region public methods

    fun invert(): UnitCounter
    {
        val result: MutableMap<KClass<out BaseUnit>, UnitCount> = HashMap()

        counts.forEach { (clazz, unitCount) ->
            result[clazz] = UnitCount(unitCount.unit, -unitCount.count)
        }

        return UnitCounter(result)
    }

    fun major(unit: CompositeUnit) =
        UnitCounter(this)
            .apply {
                unit.unitCounter.counts.forEach { (clazz, unitCount) ->
                    addMajor(clazz, unitCount)
                }
            }

    fun minor(unit: CompositeUnit) =
        UnitCounter(this)
            .apply {
                unit.unitCounter.counts.forEach { (clazz, unitCount) ->
                    addMinor(clazz, unitCount)
                }
            }

    fun major(unit: BaseUnit) =
        UnitCounter(this)
            .apply {
                addPower(unit.baseUnitType, unit, 1)
            }

    fun minor(unit: BaseUnit) =
        UnitCounter(this)
            .apply {
                addPower(unit.baseUnitType, unit, -1)
            }

    operator fun get(unit: BaseUnit) =
        counts[unit.baseUnitType] ?: EMPTY_BASE_UNIT_COUNT

    val baseUnits: Collection<UnitCount>
        get() = counts.values

    fun asString(majorString: (Unit) -> String,
                 minorString: (Unit) -> String)
            : String
    {
        val result = StringBuilder()
        val baseUnits = counts.values.asSequence()
            .map { it.unit }
            .sorted()
            .toList()

        var first = true
        for (unit in baseUnits)
        {
            val power = buildPower(get(unit).count)
            if (first)
            {
                result.append(majorString(unit)).append(power)
            }
            else
            {
                result.append('⋅').append(minorString(unit)).append(power)
            }
            first = false
        }
        return result.toString()
    }

    // region private methods

    private fun buildPower(power: Int): String
    {
        var mutablePower = power
        val result = StringBuilder()
        val negative = mutablePower < 0

        // Omit neutral power of 1
        if (mutablePower == 1)
        {
            return result.toString()
        }
        if (mutablePower == 0)
        {
            return POWERS[0].toString()
        }
        mutablePower = abs(mutablePower)
        while (mutablePower > 0)
        {
            result.insert(0, POWERS[mutablePower % 10])
            mutablePower /= 10
        }
        return if (negative)
        {
            "$NEGATIVE$result"
        }
        else result.toString()
    }

    private fun addMajor(kClass: KClass<out BaseUnit>, unitCount: UnitCount) =
        addPower(kClass, unitCount.unit, unitCount.count)

    private fun addMinor(kClass: KClass<out BaseUnit>, unitCount: UnitCount) =
        addPower(kClass, unitCount.unit, -unitCount.count)

    private fun addPower(kClazz: KClass<out BaseUnit>, unit: BaseUnit, count: Int)
    {
        if (count == 0) return
        val unitCount = counts[kClazz]
        val result = if (unitCount == null)
        {
            count
        }
        else
        {
            if (unitCount.unit != unit)
            {
                throw OffendingUnitException("${unitCount.unit.singularName} and ${unit.singularName} are both ${unit.baseUnitType.simpleName}")
            }
            unitCount.count + count
        }
        if (result == 0)
        {
            counts.remove(kClazz)
        }
        else
        {
            counts[kClazz] = UnitCount(unit, result)
        }
    }

    fun <U : BaseUnit> findUnit(unitClass: KClass<U>) =
        getUnit(unitClass, baseUnits)

    @Suppress("UNCHECKED_CAST")
    private fun <U : BaseUnit> getUnit(unitClass: KClass<U>, units: Collection<UnitCount>): U?
    {
        for (unitCount in units)
        {
            val unit = unitCount.unit
            if (unitClass.isSuperclassOf(unit::class)) return unit as U
        }
        return null
    }

    val isEmpty: Boolean
        get() = counts.isEmpty()

    // endregion

    // region Object

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun equals(that: Any?): Boolean
    {
        if (that is UnitCounter)
        {
            return this.counts == that.counts
        }
        return false
    }

    override fun hashCode() =
        counts.hashCode()

    // endregion

    companion object
    {
        private const val NEGATIVE = '⁻'
        private val POWERS = charArrayOf('⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹')
    }
}
