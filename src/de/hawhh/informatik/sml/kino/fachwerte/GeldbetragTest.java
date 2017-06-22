package de.hawhh.informatik.sml.kino.fachwerte;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GeldbetragTest {
	
	Geldbetrag betrag1 = new Geldbetrag (15,234);
	Geldbetrag betrag2 = new Geldbetrag (3,9);
	
	@Test
	public void testKonstruktor (){
		assertEquals (15, betrag1.euro);
		assertEquals (23, betrag1.cent);
		assertEquals (3, betrag2.euro);
		assertEquals (90, betrag2.cent);
	}
	
	@Test
	public void testToString (){
		assertEquals ("15,23", betrag1.toString ());
		assertEquals ("3,90", betrag2.toString ());
	}
	
	@Test
	public void testAddieren (){
		Geldbetrag betrag3 = betrag1.addieren (betrag2);
		assertEquals (19, betrag3.euro);
		assertEquals (13, betrag3.cent);
	}
	
	@Test
	public void testSubtrahieren (){
		Geldbetrag betrag4 = betrag1.subtrahieren (betrag2);
		assertEquals (11, betrag4.euro);
		assertEquals (33, betrag4.cent);
	}
	
	@Test
	public void testStringToGeldbetrag (){
		Geldbetrag betrag5 = Geldbetrag.toGeldbetrag("15,50");
		assertEquals (15, betrag5.euro);
		assertEquals (50, betrag5.cent);
	}
	
	@Test
	public void testIntToGeldbetrag (){
		Geldbetrag betrag6 = Geldbetrag.toGeldbetrag (3579);
		assertEquals (35, betrag6.euro);
		assertEquals (79, betrag6.cent);
	}
}
