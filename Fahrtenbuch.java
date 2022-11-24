package Auto_V_01;


import java.text.DecimalFormat;

//http://www.java2s.com/Tutorials/Java/Swing_How_to/JTable/Implement_jTable_from_Arraylist.htm

public class Fahrtenbuch {
	private int FahrtIdNr;
	private String KfzNr;
	private String sDatum;
	private double Distanz;
	private String AbfahrtOrt;
	private String AnkunftOrt;
	private String FahrtGrund;

	public String getFahrtGrund() {
		return FahrtGrund;
	}

	public void setFahrtGrund(String fahrtGrund) {
		FahrtGrund = fahrtGrund;
	}

	public String getsDatum() {
		return sDatum;
	}

	public void setsDatum(String sDatum) {
		this.sDatum = sDatum;
	}

	public double getDistanz() {
		return Distanz;
	}

	public void setDistanz(double distanz) {
		Distanz = distanz;
	}

	public String getAbfahrtOrt() {
		return AbfahrtOrt;
	}

	public void setAbfahrtOrt(String abfahrtOrt) {
		AbfahrtOrt = abfahrtOrt;
	}

	public String getAnkunftOrt() {
		return AnkunftOrt;
	}

	public void setAnkunftOrt(String ankunftOrt) {
		AnkunftOrt = ankunftOrt;
	}

	public static int StartIdNr = 1; 
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Fahrtenbuch (String Kennzeichen) { 
		FahrtIdNr = StartIdNr ++;
		setKfzNr(Kennzeichen);
	} 

	public String getKfzNr() {
		return KfzNr;
	}

	public void setKfzNr(String kfzNr) {
		KfzNr = kfzNr;
	}
}
