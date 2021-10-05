package pcb.uwu.core;

import pcb.uwu.amount.base.Scalar;

import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class AmountExpression {
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
            if (!(obj instanceof ExpressionPart)) return false;

            ExpressionPart that = (ExpressionPart) obj;
            return this.operator == that.operator
                    && Objects.equals(this.unitAmount, that.unitAmount);
        }

        @Override
        public int hashCode() {
            return Objects.hash(operator, unitAmount);
        }

        @Override
        public String toString() {
            return operator + " " + unitAmount;
        }
    }

    public AmountExpression(UnitAmount<?> unitAmount)
    {
        parts.add(new ExpressionPart(Operator.MULTIPLY, unitAmount));
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
        UnitAmount<?> result = Scalar.ONE;

        trim(parts);

        for (ExpressionPart part : parts) {
            switch (part.operator)
            {
                case MULTIPLY: result = result.multipliedBy(part.unitAmount, mathContext); break;
                case DIVIDE: result = result.dividedBy(part.unitAmount, mathContext);break;
            }
        }

        return result;
    }

    public static void trim(List<ExpressionPart> parts)
    {
        List<ExpressionPart> majorParts = parts.stream()
                .filter(part -> part.operator == Operator.MULTIPLY)
                .collect(toList());
        List<ExpressionPart> minorParts = parts.stream()
                .filter(part -> part.operator == Operator.DIVIDE)
                .collect(toList());

        for (ExpressionPart majorPart : majorParts) {
            for (ExpressionPart minorPart : minorParts) {
                // Cut off perfect opposites
                if (majorPart.unitAmount.equivalentTo(minorPart.unitAmount))
                {
                    parts.remove(majorPart);
                    parts.remove(minorPart);
                }
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AmountExpression)) return false;

        AmountExpression that = (AmountExpression) obj;

        return Objects.equals(this.parts, that.parts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parts);
    }
}
