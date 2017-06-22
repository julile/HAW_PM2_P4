package de.hawhh.informatik.sml.kino.fachwerte;

import static org.junit.Assert.assertEquals;

import org.junit.Before;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class EurocentTest
{

	private Eurocent eu1;
	private Eurocent eu2;

	@Before
	public void setUp()
	{
		eu1 = Eurocent.get(1234);
		eu2 = Eurocent.get(05, 00);
	}

	@Test
	public void testeKonstruktoren()
	{
		assertNotNull(eu1);
		assertNotNull(eu2);
	}

	@Test
	public void testeToEuroString()
	{
		Eurocent eu3 = Eurocent.get("12,34");
		assertEquals(eu1, eu3);
		Eurocent eu4 = Eurocent.get("5,00");
		assertEquals(eu2, eu4);
		Eurocent eu5 = Eurocent.get("05,00");
		assertEquals(eu2, eu5);
	}

	@Test
	public void testeToEuroInt()
	{
		Eurocent eu3 = Eurocent.get(1234);
		assertEquals(eu1, eu3);
		Eurocent eu4 = Eurocent.get(500);
		assertEquals(eu2, eu4);
		// Eurocent eu5 = Eurocent.toEuro(0500);
		// assertEquals(eu2, eu5);
	}

	@Test
	public void testeToString()
	{
		assertEquals(eu1.toString(), "12,34");
		assertEquals(eu2.toString(), "5,00");
	}

	@Test
	public void testeAdd()
	{
		Eurocent eu3 = Eurocent.add(eu2, eu1);
		Eurocent eu4 = Eurocent.add(eu1, eu2);
		assertEquals(eu4, eu3);
		assertEquals(eu3.toString(), "17,34");
	}

	@Test
	public void testeSub()
	{
		Eurocent eu3 =Eurocent.sub(eu1, eu2);
		assertEquals(eu3.toString(), "7,34");
	}

	@Test
	public void testeMul()
	{
		Eurocent eu3 = Eurocent.mul(eu1, 2);
		assertEquals(eu3.toString(), "24,68");
	}
}
