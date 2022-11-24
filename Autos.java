package Auto_V_01;

//Leistungsabhängigkeit: 100 kW ≙ 0,73 L/100 km  --> 1 kW ≙ 0,0073 L/100 km
//Gewichtsabhängigkeit:  100 kg ≙ 0,09 L/100 km  --> 1 kg ≙ 0,0009 L/100 km
// CwWert Abhängigkeit :  1 + CwWert mal Verbrauch aus o.a. Beispiel
// Durchschnittliches Mittelklasse KFZ verbraucht 4,5 Liter pro 100 Kilometern, bei einen Gewicht von 1000 kg, 75 PS und 1000 ccm Hubraum 

// Berechnung des spezifischen Bezinverbrauch:
// 1. = tatächlicher (Hubraum - 1000) * 0,00225 +
// 2. = tatsächliche (KW - 100) * 0,0073
// 3. = tatsächliches (Gewicht - 1000) * 0,0009
// 4. = plus 4,5

import java.text.DecimalFormat;

public class Autos {
	private int AutoIdNr;
	private double GesamtKm;
	private double GesamtVerbrauch;
	private double GesamtKosten;
	
	private String KfzNr;
	private String Fahrzeughalter;
	private String FahrzeugTyp;


	public static int StartAutoIdNr = 1; 
	private static final DecimalFormat df = new DecimalFormat("0.00");

	public Autos (String Kennzeichen) { 
		AutoIdNr = StartAutoIdNr ++;
		setKfzNr(Kennzeichen);
	} 
	
	public int getAutoIdNr() {
		return AutoIdNr;
	}

	public void setAutoIdNr(int autoIdNr) {
		AutoIdNr = autoIdNr;
	}

	public String getKfzNr() {
		return KfzNr;
	}

	public void setKfzNr(String kfzNr) {
		KfzNr = kfzNr;
	}
	
	
	public double getGesamtKm() {
		return GesamtKm;
	}

	public void setGesamtKm(double gesamtKm) {
		GesamtKm = gesamtKm;
	}

	
	public double getGesamtVerbrauch() {
		return GesamtVerbrauch;
	}

	public void setGesamtVerbrauch(double gesamtVerbrauch) {
		GesamtVerbrauch = gesamtVerbrauch;
	}
	
	
	public double getGesamtKosten() {
		return GesamtKosten;
	}

	public void setGesamtKosten(double gesamtKosten) {
		GesamtKosten = gesamtKosten;
	}
	
	public String getFahrzeughalter() {
		return Fahrzeughalter;
	}

	public void setFahrzeughalter(String fahrzeughalter) {
		Fahrzeughalter = fahrzeughalter;
	}

	public String getFahrzeugTyp() {
		return FahrzeugTyp;
	}

	public void setFahrzeugTyp(String fahrzeugTyp) {
		FahrzeugTyp = fahrzeugTyp;
	}
	
	public double BerechneVerbrauch() {
		return 0.0;
		
	}

}
