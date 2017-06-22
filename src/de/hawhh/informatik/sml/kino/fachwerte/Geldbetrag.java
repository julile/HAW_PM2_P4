package de.hawhh.informatik.sml.kino.fachwerte;
/**
 * Eine Repräsentation eines Geldbetrages aufgeteilt in den Euro-Anteil und den Cent-Anteil
 * @author Julia
 *
 */
public class Geldbetrag {
	
	//Variablen deklarieren
	int euro;
	int cent;
	
	//Konstruktor
	public Geldbetrag (int euro, int cent) {
		this.euro = euro;
		while (cent >= 100){
			cent = cent/10;
		}
		if (cent < 10){
			cent = cent*10;
		}
		this.cent = cent;
	}
	
	/**
	 * Eine Methode um den Geldbetrag als String ausgeben zu können
	 * Form: EE,CC
	 */
	public String toString (){
		return euro+","+cent;
	}
	
	/**
	 * Addiert einen Betrag auf das Objekt an dem die Methode angewandt wird
	 * @param betrag
	 * @return Die Summe der beiden Beträge
	 */
	public Geldbetrag addieren (Geldbetrag betrag){
		int euro = this.euro + betrag.euro;
		int cent = this.cent + betrag.cent;
		if (cent >= 100){
			cent = cent-100;
			euro = euro+1;
		}
		return new Geldbetrag (euro, cent);
	}
	
	/**
	 * Subtrahiert einen Betrag von dem Objekt auf das die Methode angewandt wird
	 * @param betrag
	 * @return Die Differenz der Beträge
	 */
	public Geldbetrag subtrahieren (Geldbetrag betrag){
		int euro = this.euro - betrag.euro;
		int cent = this.cent - betrag.cent;
		if (cent < 0){
			cent = cent+100;
			euro = euro-1;
		}
		return new Geldbetrag (euro, cent);
	}
	
	/**
	 * Formt den Parameter von String in einen Geldbetrag um
	 * @param betrag als String
	 * @return Die Darstellung als Geldbetrag
	 */
	public static Geldbetrag toGeldbetrag(String betrag){
		int i = betrag.indexOf (",");
		int euro = 0;
		int cent = 0;
		int multiplikator = 1;
		//euro teil ermitteln
		for (int j=i-1; j>=0; j--){
			euro = euro + multiplikator*((int)betrag.charAt(j)-'0');
			multiplikator = multiplikator*10;
		}
		//cent teil ermitteln
		if (betrag.length()-1 >= i+2){
			cent = (10*((int)betrag.charAt(i+1)-'0'))+(1*((int)betrag.charAt(i+2)-'0'));
		} else if (betrag.length()-1 == i+1){
			cent = (10*((int)betrag.charAt(i+1)-'0'));
		}
		return new Geldbetrag (euro,cent);
	}
	
	/**
	 * Formt den Parameter von int bzw. Integer in einen Geldbetrag um
	 * @param betrag als int bzw. Integer
	 * @return Die Darstellung als Geldbetrag
	 */
	public static Geldbetrag toGeldbetrag (int betrag){
		int euro = betrag/100;
		int cent = betrag-(euro*100);
		return new Geldbetrag(euro,cent);
	}
}
