<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
				xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
				xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
				xsi:schemaLocation="http://www.w3.org/1999/XSL/Transform http://www.w3.org/2007/schema-for-xslt20.xsd">

	<xsl:template match="/unit">
		<xsl:variable name="lowerCase" select="' abcdefghijklmnopqrstuvwxyz'" />
		<xsl:variable name="upperCase" select="' ABCDEFGHIJKLMNOPQRSTUVWXYZ'" />
		<xsl:variable name="unit"><xsl:value-of select="singularName"/>Unit</xsl:variable>
		<xsl:variable name="baseUnit"><xsl:value-of select="base"/>Unit</xsl:variable>package pcb.uwu.unit.<xsl:value-of select="package"/>;

import java.util.function.Function;

public class <xsl:value-of select="$unit"/> extends <xsl:value-of select="$baseUnit"/> {

	public static final <xsl:value-of select="$unit"/><xsl:text> </xsl:text><xsl:value-of select="translate(singularName, $lowerCase, $upperCase)"/> = new <xsl:value-of select="$unit"/>();

	private <xsl:value-of select="$unit"/>() {
		super("<xsl:value-of select="symbol"/>", "<xsl:value-of select="translate(singularName, $upperCase, $lowerCase)"/>", "<xsl:value-of select="translate(pluralName, $upperCase, $lowerCase)"/>",
				<xsl:value-of select="translationToCanonical"/>,
				<xsl:value-of select="translationFromCanonical"/>);
	}
}
</xsl:template>
</xsl:stylesheet>