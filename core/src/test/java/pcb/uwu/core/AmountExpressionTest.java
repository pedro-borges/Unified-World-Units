package pcb.uwu.core;

import org.junit.Test;
import pcb.uwu.amount.base.Length;
import pcb.uwu.amount.base.Time;
import pcb.uwu.unit.base.LengthUnit;
import pcb.uwu.unit.base.TimeUnit;

import java.math.MathContext;

import static java.math.MathContext.DECIMAL64;
import static java.util.function.Function.identity;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AmountExpressionTest
{
    @Test
    public void testCommutation()
    {
        LengthUnit meters = new LengthUnit("m", "meter", "meters", identity(), identity());
        TimeUnit seconds = new TimeUnit("s", "second", "seconds", identity(), identity());
        Length meters10 = new Length(10, meters);
        Time seconds5 = new Time(5, seconds);

        AmountExpression amountExpression1 = new AmountExpression(meters10).dividedBy(seconds5).multipliedBy(seconds5);
        AmountExpression amountExpression2 = new AmountExpression(meters10).multipliedBy(seconds5).dividedBy(seconds5);

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression1.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression1.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression2.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression2.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(amountExpression1.calculate(DECIMAL64), amountExpression2.calculate(DECIMAL64));
    }

    @Test
    public void testTrim()
    {
        LengthUnit meters = new LengthUnit("m", "meter", "meters", identity(), identity());
        TimeUnit seconds = new TimeUnit("s", "second", "seconds", identity(), identity());
        TimeUnit minutes = new TimeUnit("m", "minute", "minutes",
                value -> value.multipliedBy(60, DECIMAL64),
                value -> value.dividedBy(60, DECIMAL64));
        Length meters10 = new Length(10, meters);
        Time seconds300 = new Time(300, seconds);
        Time minutes5 = new Time(5, minutes);

        assertTrue(seconds300.equivalentTo(minutes5));

        AmountExpression amountExpression1 = new AmountExpression(meters10).dividedBy(seconds300).multipliedBy(minutes5);
        AmountExpression amountExpression2 = new AmountExpression(meters10).multipliedBy(seconds300).dividedBy(minutes5);

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression1.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression1.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression2.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression2.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(amountExpression1.calculate(DECIMAL64), amountExpression2.calculate(DECIMAL64));
    }
}
