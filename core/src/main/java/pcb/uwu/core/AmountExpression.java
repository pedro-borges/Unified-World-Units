package pcb.uwu.core;

import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AmountExpression {
    private UnitAmount<?> base;
    private List<ExpressionPart> parts = new LinkedList<>();

    private enum Operator {
        MULTIPLY, DIVIDE
    }

    private static class ExpressionPart {
        private final Operator operator;
        private final UnitAmount<?> unitAmount;

        private ExpressionPart(Operator operator, UnitAmount<?> unitAmount) {
            this.operator = operator;
            this.unitAmount = unitAmount;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;

            ExpressionPart that = (ExpressionPart) obj;
            return this.operator == that.operator
                    && Objects.equals(this.unitAmount, that.unitAmount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operator, unitAmount);
        }
    }

    public AmountExpression(UnitAmount<?> base)
    {
        this.base = base;
    }

    public AmountExpression multipliedBy(CompositeUnitAmount<?> other)
    {
        parts.add(new ExpressionPart(Operator.MULTIPLY, other));
        return this;
    }

    public AmountExpression dividedBy(CompositeUnitAmount<?> other)
    {
        parts.add(new ExpressionPart(Operator.DIVIDE, other));
        return this;
    }

    public UnitAmount<?> calculate(MathContext mathContext)
    {
        UnitAmount<?> result = base;

        for (ExpressionPart part : parts) {
            switch (part.operator)
            {
                case MULTIPLY: result = result.multipliedBy(part.unitAmount, mathContext); break;
                case DIVIDE: result = result.dividedBy(part.unitAmount, mathContext);break;
            }
        }

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        AmountExpression that = (AmountExpression) obj;

        return Objects.equals(this.base, that.base)
                && Objects.equals(this.parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, parts);
    }
}
