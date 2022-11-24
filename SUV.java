package Auto_V_01;


public class SUV extends Autos {

	private double LeistungKw;

	private double GrundVerbrauch = 4.5;
	private double SpezifischerVerbrauch;

	private double TankInhalt;
	private int AnzahlSitze;
	private int LeerGewicht;
	private double CwWert;
	private int Hubraum;


	private double AktTankLevel;
	private String FahrzeugModell;
	private String FahrzeugHersteller;


	public SUV(String Kennzeichen) {
		super(Kennzeichen);
	}
	
	public double getLeistungKw() {
		return LeistungKw;
	}

	public void setLeistungKw(double leistungKw) {
		LeistungKw = leistungKw;
	}
	
	public double getCwWert() {
		return CwWert;
	}

	public void setCwWert(double cwWert) {
		CwWert = cwWert;
	}

	public int getHubraum() {
		return Hubraum;
	}

	public void setHubraum(int hubraum) {
		Hubraum = hubraum;
	}
	
	public double getGrundVerbrauch() {
		return GrundVerbrauch;
	}

	public double getSpezifischerVerbrauch() {
		return SpezifischerVerbrauch;
	}

	public void setSpezifischerVerbrauch(double spezifischerVerbrauch) {
		SpezifischerVerbrauch = spezifischerVerbrauch;
	}
	
	public void setGrundVerbrauch(double grundVerbrauch) {
		GrundVerbrauch = grundVerbrauch;
	}
	
	public double getTankInhalt() {
		return TankInhalt;
	}

	public void setTankInhalt(double tankInhalt) {
		TankInhalt = tankInhalt;
	}
	
	public int getAnzahlSitze() {
		return AnzahlSitze;
	}

	public void setAnzahlSitze(int anzahlSitze) {
		AnzahlSitze = anzahlSitze;
	}
	
	public int getLeerGewicht() {
		return LeerGewicht;
	}

	public void setLeerGewicht(int leerGewicht) {
		LeerGewicht = leerGewicht;
	}
	
	public double getAktTankLevel() {
		return AktTankLevel;
	}

	public void setAktTankLevel(double aktTankLevel) {
		AktTankLevel = aktTankLevel;
	}
	
	public String getFahrzeugModell() {
		return FahrzeugModell;
	}

	public void setFahrzeugModell(String fahrzeugModell) {
		FahrzeugModell = fahrzeugModell;
	}
	
	public String getFahrzeugHersteller() {
		return FahrzeugHersteller;
	}

	public void setFahrzeugHersteller(String fahrzeugHersteller) {
		FahrzeugHersteller = fahrzeugHersteller;
	}
	

}

