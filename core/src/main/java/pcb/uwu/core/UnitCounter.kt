package pcb.uwu.core

import pcb.uwu.core.UnitCounter.UnitCount.Companion.EMPTY_BASE_UNIT_COUNT
import pcb.uwu.exception.OffendingUnitException
import pcb.uwu.unit.base.ScalarUnit
import java.util.Objects
import java.util.function.Function
import kotlin.math.abs

class UnitCounter
{
    class UnitCount(val unit: BaseUnit, val count: Int)
    {
        @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
        override fun equals(that: Any?): Boolean
        {
            if (that is UnitCount)
            {
                return unit == that.unit &&
                        count == that.count
            }
            return false
        }

        override fun hashCode(): Int
        {
            return Objects.hash(unit, count)
        }

        companion object
        {
            val EMPTY_BASE_UNIT_COUNT = UnitCount(ScalarUnit.SCALAR, 0)
        }
    }

    // region private fields

    private val counts: MutableMap<Class<out BaseUnit>, UnitCount>

    // endregion

    // region constructors

    constructor() : this(HashMap())

    constructor(unit: BaseUnit) : this()
    {
        addPower(unit.baseUnitType, unit, 1)
    }

    constructor(source: UnitCounter) : this(source.counts)

    private constructor(counts: Map<Class<out BaseUnit>, UnitCount>)
    {
        this.counts = HashMap(counts)
    }

    // endregion

    fun invert(): UnitCounter
    {
        val result: MutableMap<Class<out BaseUnit>, UnitCount> = HashMap()

        counts.forEach { (clazz, unitCount) ->
            result[clazz] = UnitCount(unitCount.unit, -unitCount.count)
        }

        return UnitCounter(result)
    }

    fun major(unitCounter: UnitCounter): UnitCounter
    {
        val result = UnitCounter(this)
        unitCounter.counts.forEach { (clazz, unitCount) ->
            result.addMajor(clazz, unitCount)
        }
        return result
    }

    @JvmOverloads
    fun major(unit: BaseUnit, counts: Int = 1): UnitCounter
    {
        val result = UnitCounter(this)
        result.addPower(unit.baseUnitType, unit, counts)
        return result
    }

    fun minor(unitCounter: UnitCounter): UnitCounter
    {
        val result = UnitCounter(this)
        unitCounter.counts.forEach { (clazz, unitCount) ->
            result.addMinor(clazz, unitCount)
        }
        return result
    }

    @JvmOverloads
    fun minor(unit: BaseUnit, counts: Int = 1): UnitCounter
    {
        val result = UnitCounter(this)
        result.addPower(unit.baseUnitType, unit, -counts)
        return result
    }

    operator fun get(unit: BaseUnit) =
        counts[unit.baseUnitType] ?: EMPTY_BASE_UNIT_COUNT

    val baseUnits: Collection<UnitCount>
        get() = counts.values

    fun asString(majorString: Function<Unit, String>,
                 minorString: Function<Unit, String>)
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
                result.append(majorString.apply(unit)).append(power)
            }
            else
            {
                result.append('⋅').append(minorString.apply(unit)).append(power)
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

    private fun addMajor(clazz: Class<out BaseUnit>, unitCount: UnitCount)
    {
        addPower(clazz, unitCount.unit, unitCount.count)
    }

    private fun addMinor(clazz: Class<out BaseUnit>, unitCount: UnitCount)
    {
        addPower(clazz, unitCount.unit, -unitCount.count)
    }

    private fun addPower(clazz: Class<out BaseUnit>, unit: BaseUnit, count: Int)
    {
        if (count == 0) return
        val unitCount = counts[clazz]
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
            counts.remove(clazz)
        }
        else
        {
            counts[clazz] = UnitCount(unit, result)
        }
    }

    fun <U : BaseUnit> findUnit(unitClass: Class<U>): U?
    {
        return getUnit(unitClass, baseUnits)
    }

    @Suppress("UNCHECKED_CAST")
    private fun <U : BaseUnit> getUnit(unitClass: Class<U>, units: Collection<UnitCount>): U?
    {
        for (unitCount in units)
        {
            val unit = unitCount.unit
            if (unitClass.isAssignableFrom(unit.javaClass)) return unit as U
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

    override fun hashCode(): Int
    {
        return counts.hashCode()
    }

    // endregion

    companion object
    {
        private const val NEGATIVE = '⁻'
        private val POWERS = charArrayOf('⁰', '¹', '²', '³', '⁴', '⁵', '⁶', '⁷', '⁸', '⁹')
    }
}