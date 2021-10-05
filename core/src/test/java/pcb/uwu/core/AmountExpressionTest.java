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

public class AmountExpressionTest
{
    @Test
    public void testCommutation()
    {
        LengthUnit meters = new LengthUnit("m", "meter", "meters", identity(), identity());
        TimeUnit seconds = new TimeUnit("s", "second", "seconds", identity(), identity());
        Length meters10 = new Length(10, meters);
        Time seconds3 = new Time(5, seconds);

        AmountExpression amountExpression1 = new AmountExpression(meters10).dividedBy(seconds3).multipliedBy(seconds3);
        AmountExpression amountExpression2 = new AmountExpression(meters10).multipliedBy(seconds3).dividedBy(seconds3);

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression1.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression1.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(new BigDecimalAmount(10).doubleValue(), amountExpression2.calculate(DECIMAL64).getAmount().doubleValue(), 0);
        assertEquals(meters.getUnitCounter(), amountExpression2.calculate(DECIMAL64).getUnit().getUnitCounter());

        assertEquals(amountExpression1.calculate(DECIMAL64), amountExpression2.calculate(DECIMAL64));
    }
}
