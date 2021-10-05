package pcb.uwu.core

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import pcb.uwu.amount.base.Length
import pcb.uwu.amount.base.Time
import pcb.uwu.unit.base.LengthUnit
import pcb.uwu.unit.base.TimeUnit
import java.math.MathContext.DECIMAL64
import java.util.function.Function.identity

class AmountExpressionTest
{
    @Test
    fun testCommutation()
    {
        val meters = LengthUnit("m", "meter", "meters", identity(), identity())
        val seconds = TimeUnit("s", "second", "seconds", identity(), identity())
        val meters10 = Length(10, meters)
        val seconds5 = Time(5, seconds)
        val amountExpression1 = AmountExpression(meters10).dividedBy(seconds5).multipliedBy(seconds5)
        val amountExpression2 = AmountExpression(meters10).multipliedBy(seconds5).dividedBy(seconds5)
        assertEquals(BigDecimalAmount(10),
                     amountExpression1.calculate(DECIMAL64).amount)
        assertEquals(meters.unitCounter, amountExpression1.calculate(DECIMAL64).unit.unitCounter)
        assertEquals(BigDecimalAmount(10),
                     amountExpression2.calculate(DECIMAL64).amount)
        assertEquals(meters.unitCounter, amountExpression2.calculate(DECIMAL64).unit.unitCounter)
        assertEquals(amountExpression1.calculate(DECIMAL64),
                     amountExpression2.calculate(DECIMAL64))
    }

    @Test
    fun testTrim()
    {
        val meters = LengthUnit("m", "meter", "meters", identity(), identity())
        val seconds = TimeUnit("s", "second", "seconds", identity(), identity())
        val minutes =
            TimeUnit("m", "minute", "minutes", { it.multipliedBy(60, DECIMAL64) }, { it.dividedBy(60, DECIMAL64) })
        val meters10 = Length(10, meters)
        val seconds300 = Time(300, seconds)
        val minutes5 = Time(5, minutes)
        assertTrue(seconds300.equivalentTo(minutes5))
        val amountExpression1 = AmountExpression(meters10).dividedBy(seconds300).multipliedBy(minutes5)
        val amountExpression2 = AmountExpression(meters10).multipliedBy(seconds300).dividedBy(minutes5)
        assertEquals(BigDecimalAmount(10),
                     amountExpression1.calculate(DECIMAL64).amount)
        assertEquals(meters.unitCounter, amountExpression1.calculate(DECIMAL64).unit.unitCounter)
        assertEquals(BigDecimalAmount(10),
                     amountExpression2.calculate(DECIMAL64).amount)
        assertEquals(meters.unitCounter, amountExpression2.calculate(DECIMAL64).unit.unitCounter)
        assertEquals(amountExpression1.calculate(DECIMAL64),
                     amountExpression2.calculate(DECIMAL64))
    }
}