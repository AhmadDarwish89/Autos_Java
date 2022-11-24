package Auto_V_01;


import java.text.DecimalFormat;

//http://www.java2s.com/Tutorials/Java/Swing_How_to/JTable/Implement_jTable_from_Arraylist.htm

public class Tanken {
	private int TankIdNr;
	private String KfzNr;
	private String sDatum;
	private double Liter;
	private double PreisProLiter;

	private double GesamtPreis;

	public static int StartTankIdNr = 1; 
	private static final DecimalFormat df = new DecimalFormat("0.00");
	
	public Tanken () { 
		setTankIdNr(StartTankIdNr ++);
	} 
	
	public int getTankIdNr() {
		return TankIdNr;
	}

	public void setTankIdNr(int tankIdNr) {
		TankIdNr = tankIdNr;
	}
		
	public String getKfzNr() {
		return KfzNr;
	}

	public void setKfzNr(String kfzNr) {
		KfzNr = kfzNr;
	}
	
	public String getsDatum() {
		return sDatum;
	}

	public void setsDatum(String sDatum) {
		this.sDatum = sDatum;
	}
	
	public double getLiter() {
		return Liter;
	}

	public void setLiter(double liter) {
		Liter = liter;
	}
	
	public double getPreisProLiter() {
		return PreisProLiter;
	}

	public void setPreisProLiter(double preisProLiter) {
		PreisProLiter = preisProLiter;
	}
	
	public double getGesamtPreis() {
		return GesamtPreis;
	}

	public void setGesamtPreis(double gesamtPreis) {
		GesamtPreis = gesamtPreis;
	}
	
}


