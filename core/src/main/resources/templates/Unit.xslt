<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.w3.org/1999/XSL/Transform http://www.w3.org/2007/schema-for-xslt20.xsd">

	<xsl:template match="/unit">
		<xsl:variable name="unit"><xsl:value-of select="name"/>Unit</xsl:variable>package pcb.uwu.unit.<xsl:value-of select="package"/>;

import pcb.uwu.core.BaseUnit;
import pcb.uwu.core.BigDecimalAmount;
import pcb.uwu.core.UnitCounter;

import java.util.function.Function;

public abstract class <xsl:value-of select="$unit"/> extends BaseUnit {

	private final UnitCounter unitCounter;

	public <xsl:value-of select="$unit"/>(String symbol, String singularName, String pluralName,
			Function&lt;BigDecimalAmount, BigDecimalAmount&gt; translationToCanonical,
			Function&lt;BigDecimalAmount, BigDecimalAmount&gt; translationFromCanonical) {

		super(<xsl:value-of select="precedence"/>, symbol, singularName, pluralName, translationToCanonical, translationFromCanonical);

		unitCounter = new UnitCounter(this);
	}

	@Override
	public Class&lt;? extends BaseUnit&gt; getBaseUnitType() {
		return <xsl:value-of select="$unit"/>.class;
	}

	@Override
	public UnitCounter getUnitCounter() {
		return unitCounter;
	}
}
</xsl:template>
</xsl:stylesheet>
