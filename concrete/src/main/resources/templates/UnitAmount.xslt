<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.w3.org/1999/XSL/Transform http://www.w3.org/2007/schema-for-xslt20.xsd">

	<xsl:template match="/unit">
		<xsl:variable name="lowerCase" select="'abcdefghijklmnopqrstuvwxyz'" />
		<xsl:variable name="upperCase" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'" />
		<xsl:variable name="unit"><xsl:value-of select="singularName"/>Unit</xsl:variable>
		<xsl:variable name="baseUnit"><xsl:value-of select="base"/>Unit</xsl:variable>
		<xsl:variable name="unitAmount">UnitAmount&lt;<xsl:value-of select="base"/>Unit&gt;</xsl:variable>package pcb.uwu.amount.<xsl:value-of select="package"/>;
<xsl:for-each select="composition/dividedBy">
import pcb.uwu.amount.<xsl:value-of select="unit1/package"/>.<xsl:value-of select="unit1/base"/>;
import pcb.uwu.amount.<xsl:value-of select="unit2/package"/>.<xsl:value-of select="unit2/base"/>;
import pcb.uwu.amount.<xsl:value-of select="unit1/package"/>.<xsl:value-of select="unit1/pluralName"/>;
import pcb.uwu.amount.<xsl:value-of select="unit2/package"/>.<xsl:value-of select="unit2/pluralName"/>;</xsl:for-each>
<xsl:for-each select="composition/multipliedBy">
import pcb.uwu.amount.<xsl:value-of select="result/package"/>.<xsl:value-of select="result/name"/>;
import pcb.uwu.amount.<xsl:value-of select="multiplicand/package"/>.<xsl:value-of select="multiplicand/base"/>;</xsl:for-each>
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.Magnitude;
import pcb.uwu.core.UnitAmount;
import pcb.uwu.unit.<xsl:value-of select="package"/>.<xsl:value-of select="$baseUnit"/>;

import java.math.BigDecimal;
import java.math.MathContext;
<xsl:for-each select="composition/dividedBy">
import static pcb.uwu.unit.<xsl:value-of select="unit1/package"/>.<xsl:value-of select="unit1/singularName"/>Unit.<xsl:value-of select="translate(unit1/singularName, $lowerCase, $upperCase)"/>;
import static pcb.uwu.unit.<xsl:value-of select="unit2/package"/>.<xsl:value-of select="unit2/singularName"/>Unit.<xsl:value-of select="translate(unit2/singularName, $lowerCase, $upperCase)"/>;</xsl:for-each>
<xsl:for-each select="composition/multipliedBy">
import static pcb.uwu.unit.<xsl:value-of select="multiplicand/package"/>.<xsl:value-of select="multiplicand/name"/>Unit.<xsl:value-of select="translate(multiplicand/name, $lowerCase, $upperCase)"/>;</xsl:for-each>
import static pcb.uwu.unit.<xsl:value-of select="package"/>.<xsl:value-of select="$unit"/>.<xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>;

public class <xsl:value-of select="pluralName"/> extends <xsl:value-of select="base"/> {

	// region constructors

	public <xsl:value-of select="pluralName"/>(Number value) {
		super(value, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(Number value, Magnitude magnitude) {
		super(value, magnitude, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(String value) {
		super(value, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(String value, Magnitude magnitude) {
		super(value, magnitude, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(BigDecimal value) {
		super(value, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(BigDecimal value, Magnitude magnitude) {
		super(value, magnitude, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(BigDecimalAmount amount) {
		super(amount, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	public <xsl:value-of select="pluralName"/>(BigDecimalAmount amount, Magnitude magnitude) {
		super(amount, magnitude, <xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/>);
	}

	// endregion

	// region implement UnitAmount

	@Override
	public <xsl:value-of select="pluralName"/> plus(<xsl:value-of select="$unitAmount"/> other, MathContext mathContext) {
		return new <xsl:value-of select="pluralName"/>(plusAmount(other, mathContext));
	}

	@Override
	public <xsl:value-of select="pluralName"/> minus(<xsl:value-of select="$unitAmount"/> other, MathContext mathContext) {
		return new <xsl:value-of select="pluralName"/>(minusAmount(other, mathContext));
	}

	@Override
	public <xsl:value-of select="pluralName"/> multipliedBy(BigDecimal other, MathContext mathContext) {
		return new <xsl:value-of select="pluralName"/>(multipliedByScalar(other, mathContext));
	}

	@Override
	public <xsl:value-of select="pluralName"/> dividedBy(BigDecimal other, MathContext mathContext) {
		return new <xsl:value-of select="pluralName"/>(dividedByScalar(other, mathContext));
	}

	// endregion

	// region composition
<xsl:for-each select="composition/multipliedBy">
	public <xsl:value-of select="result/name"/> multipliedBy(<xsl:value-of select="multiplicand/base"/> unitAmount, MathContext mathContext) {
		return new <xsl:value-of select="result/name"/>(getAmount().multipliedBy(unitAmount.getAmountIn(<xsl:value-of select="translate(multiplicand/name, $lowerCase, $upperCase)"/>), mathContext));
	}
</xsl:for-each>
<xsl:for-each select="composition/dividedBy">
	public <xsl:value-of select="unit1/pluralName"/> dividedBy(<xsl:value-of select="unit2/base"/> unitAmount, MathContext mathContext) {
		return new <xsl:value-of select="unit1/pluralName"/>(getAmount().dividedBy(unitAmount.getAmountIn(<xsl:value-of select="translate(unit2/singularName, $lowerCase, $upperCase)"/>), mathContext));
	}

	public <xsl:value-of select="unit2/pluralName"/> dividedBy(<xsl:value-of select="unit1/base"/> unitAmount, MathContext mathContext) {
		return new <xsl:value-of select="unit2/pluralName"/>(getAmount().dividedBy(unitAmount.getAmountIn(<xsl:value-of select="translate(unit1/singularName, $lowerCase, $upperCase)"/>), mathContext));
	}
</xsl:for-each>
	// endregion
}
</xsl:template>
</xsl:stylesheet>