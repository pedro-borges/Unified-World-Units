package pcb.uwu.core;

import pcb.uwu.unit.base.ScalarUnit;

import java.util.Objects;
import java.util.function.Function;

import static pcb.uwu.core.BigDecimalAmount.ONE;

public abstract class BaseUnit implements Unit, Comparable<BaseUnit> {

    // region private fields

    private final int precedence;
    private final String symbol;
    private final String singularName;
    private final String pluralName;
    private final Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical;
    private final Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical;

    // endregion

    // region constructors

    protected BaseUnit(
            int precedence,
            String symbol,
            String singularName,
            String pluralName,
            Function<BigDecimalAmount, BigDecimalAmount> translationToCanonical,
            Function<BigDecimalAmount, BigDecimalAmount> translationFromCanonical) {

        this.precedence = precedence;
        this.symbol = symbol;
        this.singularName = singularName;
        this.pluralName = pluralName;
        this.translationToCanonical = translationToCanonical;
        this.translationFromCanonical = translationFromCanonical;
    }

    // endregion

    // region implement Unit

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getSingularName() {
        return singularName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getPluralName() {
        return pluralName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<BigDecimalAmount, BigDecimalAmount> getTranslationToCanonical() {
        return translationToCanonical;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Function<BigDecimalAmount, BigDecimalAmount> getTranslationFromCanonical() {
        return translationFromCanonical;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isScalar() {
        return this instanceof ScalarUnit;
    }

    // endregion

    // region implement Comparable

    @Override
    public int compareTo(BaseUnit other) {
        return other.precedence - this.precedence;
    }

    //endregion

    // region override Object

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Unit)) return false;

        Unit that = (Unit) obj;

        return Objects.equals(this.symbol, that.getSymbol()) &&
                Objects.equals(this.singularName, that.getSingularName()) &&
                Objects.equals(this.pluralName, that.getPluralName()) &&
                Objects.equals(
                		this.getTranslationToCanonical().apply(ONE),
						that.getTranslationToCanonical().apply(ONE)) &&
                Objects.equals(
                		this.getTranslationFromCanonical().apply(ONE),
						that.getTranslationFromCanonical().apply(ONE));
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);
    }

    @Override
    public String toString() {
        return symbol;
    }

    // endregion
}
