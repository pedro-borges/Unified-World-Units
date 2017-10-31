<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.w3.org/1999/XSL/Transform http://www.w3.org/2007/schema-for-xslt20.xsd">

	<xsl:template match="/unit">
		<xsl:variable name="unit"><xsl:value-of select="name"/>Unit</xsl:variable>
		<xsl:variable name="unitAmount">UnitAmount&lt;<xsl:value-of select="name"/>Unit&gt;</xsl:variable>package pcb.uwu.amount.<xsl:value-of select="package"/>;

import pcb.uwu.amount.derived.fundamental.Area;
import pcb.uwu.amount.derived.mechanics.Speed;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.CompositeUnitAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.base.<xsl:value-of select="$unit"/>;

import java.math.BigDecimal;
import java.math.MathContext;

public class <xsl:value-of select="name"/> extends Composite<xsl:value-of select="$unitAmount"/> {

	// region constructors

	public <xsl:value-of select="name"/>(Number value, <xsl:value-of select="$unit"/> unit) {
		super(value, unit);
	}

	public <xsl:value-of select="name"/>(Number value, Magnitude magnitude, <xsl:value-of select="$unit"/> unit) {
		super(value, magnitude, unit);
	}

	public <xsl:value-of select="name"/>(String value, <xsl:value-of select="$unit"/> unit) {
		super(value, unit);
	}

	public <xsl:value-of select="name"/>(String value, Magnitude magnitude, <xsl:value-of select="$unit"/> unit) {
		super(value, magnitude, unit);
	}

	public <xsl:value-of select="name"/>(BigDecimal value, <xsl:value-of select="$unit"/> unit) {
		super(value, unit);
	}

	public <xsl:value-of select="name"/>(BigDecimal value, Magnitude magnitude, <xsl:value-of select="$unit"/> unit) {
		super(value, magnitude, unit);
	}

	public <xsl:value-of select="name"/>(BigDecimalAmount amount, <xsl:value-of select="$unit"/> unit) {
		super(amount, unit);
	}

	public <xsl:value-of select="name"/>(BigDecimalAmount amount, Magnitude magnitude, <xsl:value-of select="$unit"/> unit) {
		super(amount, magnitude, unit);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public <xsl:value-of select="name"/> plus(<xsl:value-of select="$unitAmount"/> other, MathContext mathContext) {
		return new <xsl:value-of select="name"/>(plusAmount(other, mathContext), getUnit());
	}

	@Override
	public <xsl:value-of select="name"/> minus(<xsl:value-of select="$unitAmount"/> other, MathContext mathContext) {
		return new <xsl:value-of select="name"/>(minusAmount(other, mathContext), getUnit());
	}

	@Override
	public <xsl:value-of select="name"/> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new <xsl:value-of select="name"/>(multipliedByScalar(other, mathContext), getUnit());
	}

	@Override
	public <xsl:value-of select="name"/> dividedBy(BigDecimal other, MathContext mathContext) {
		return new <xsl:value-of select="name"/>(dividedByScalar(other, mathContext), getUnit());
	}

	@Override
	public <xsl:value-of select="name"/> convertTo(<xsl:value-of select="$unit"/> unit) {
		return new <xsl:value-of select="name"/>(getAmountIn(unit), unit);
	}

	// endregion

	// region composition



	// endregion
}
</xsl:template>
</xsl:stylesheet>