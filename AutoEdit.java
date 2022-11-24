package Auto_V_01;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;

public class AutoEdit extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtKfzNr;
	private SUV aktSUV;
	private JTextField txtAnzahlSitze;
	private JTextField txtGesamtKm;
	private JTextField txtTankInhalt;
	private JTextField txtFahrzeugTyp;
	private JTextField txtGesamtKosten;
	private JTextField txtGesamtVerbrauch;
	private JTextField txtAktTankLevel;
	private JTextField txtFahrzeughalter;
	private JTextField txtGrundVerbrauch;
	private JTextField txtLeistungKw;
	private JTextField txtFahrzeugModell;
	private JTextField txtFahrzeugHersteller;
	private JTextField textLeerGewicht;
	private JTextField txtHubraum;
	private JTextField txtCwWert;
	private JTextField txtSpezVerbrauch;
	private DecimalFormat df = new DecimalFormat("#.##");
	
	void StartMe( SUV theSUV) {
		aktSUV = theSUV;
		txtKfzNr.setText(aktSUV.getKfzNr());
		txtGesamtKm.setText(String.valueOf(aktSUV.getGesamtKm()));
		txtGesamtVerbrauch.setText(String.valueOf(aktSUV.getGesamtVerbrauch()));
		txtFahrzeugTyp.setText(aktSUV.getFahrzeugTyp());
		txtGesamtKosten.setText(String.valueOf(aktSUV.getGesamtKosten()));
		txtFahrzeughalter.setText(aktSUV.getFahrzeughalter());
		txtFahrzeugHersteller.setText(aktSUV.getFahrzeugHersteller());
		txtFahrzeugModell.setText(aktSUV.getFahrzeugModell());
		txtTankInhalt.setText(String.valueOf(aktSUV.getTankInhalt()));
		txtAktTankLevel.setText(String.valueOf(aktSUV.getAktTankLevel()));
		txtGrundVerbrauch.setText(String.valueOf(aktSUV.getGrundVerbrauch()));
		txtAnzahlSitze.setText(String.valueOf(aktSUV.getAnzahlSitze()));
		textLeerGewicht.setText(String.valueOf(aktSUV.getLeerGewicht()));
		txtLeistungKw.setText(String.valueOf(aktSUV.getLeistungKw()));
		txtCwWert.setText(String.valueOf(aktSUV.getCwWert()));
		txtHubraum.setText(String.valueOf(aktSUV.getHubraum()));
		txtSpezVerbrauch.setText(String.valueOf(aktSUV.getSpezifischerVerbrauch()));
	}
	
	
	AutoEdit() {
		setTitle("Auto bearbeiten");
		setBounds(500, 600, 450, 589);  // PosX, PosY, h,b
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		txtKfzNr = new JTextField();
		txtKfzNr.setEditable(false);
		txtKfzNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKfzNr.setBounds(23, 36, 106, 21);
		contentPanel.add(txtKfzNr);
		txtKfzNr.setColumns(10);
		{
			txtAnzahlSitze = new JTextField();
			txtAnzahlSitze.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtAnzahlSitze.setColumns(10);
			txtAnzahlSitze.setBounds(23, 374, 106, 21);
			contentPanel.add(txtAnzahlSitze);
		}
		
		JLabel lblNewLabel = new JLabel("KFZ-Kennzeichen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 11, 106, 21);
		contentPanel.add(lblNewLabel);
		
		JLabel lblKontoinhaber = new JLabel("Anzahl Sitze");
		lblKontoinhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoinhaber.setBounds(23, 353, 106, 21);
		contentPanel.add(lblKontoinhaber);
		{
			JLabel lblKontosaldo = new JLabel("Gesamt-Fahrleistung");
			lblKontosaldo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontosaldo.setBounds(147, 15, 117, 21);
			contentPanel.add(lblKontosaldo);
		}
		{
			txtGesamtKm = new JTextField();
			txtGesamtKm.setEditable(false);
			txtGesamtKm.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtGesamtKm.setColumns(10);
			txtGesamtKm.setBounds(147, 36, 106, 21);
			contentPanel.add(txtGesamtKm);
		}
		{
			JLabel lblKontodispo = new JLabel("Tankinhalt");
			lblKontodispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontodispo.setBounds(23, 290, 117, 21);
			contentPanel.add(lblKontodispo);
		}
		{
			txtTankInhalt = new JTextField();
			txtTankInhalt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTankInhalt.setColumns(10);
			txtTankInhalt.setBounds(23, 311, 106, 21);
			txtTankInhalt.addKeyListener(new KeyAdapter() {
		         public void keyPressed(KeyEvent ke) {
		            String value = txtTankInhalt.getText();
		            int l = value.length();
		            if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyChar() == '.' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		            	txtTankInhalt.setEditable(true);
		            } else {
		            	txtTankInhalt.setEditable(false);
		            }
		         }
		      });
			contentPanel.add(txtTankInhalt);
		}
		
		JLabel lblKfz = new JLabel("KFZ-Typ");
		lblKfz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKfz.setBounds(23, 68, 106, 21);
		contentPanel.add(lblKfz);
		
		txtFahrzeugTyp = new JTextField();
		txtFahrzeugTyp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrzeugTyp.setEditable(false);
		txtFahrzeugTyp.setColumns(10);
		txtFahrzeugTyp.setBounds(23, 89, 106, 21);
		contentPanel.add(txtFahrzeugTyp);
		
		JLabel lblGesamtkosten = new JLabel("Gesamt-Kosten");
		lblGesamtkosten.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGesamtkosten.setBounds(293, 68, 106, 21);
		contentPanel.add(lblGesamtkosten);
		
		txtGesamtKosten = new JTextField();
		txtGesamtKosten.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGesamtKosten.setEditable(false);
		txtGesamtKosten.setColumns(10);
		txtGesamtKosten.setBounds(293, 89, 106, 21);
		contentPanel.add(txtGesamtKosten);
		
		JLabel lblGesamtverbrauch = new JLabel("Gesamt-Verbrauch");
		lblGesamtverbrauch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGesamtverbrauch.setBounds(293, 15, 106, 21);
		contentPanel.add(lblGesamtverbrauch);
		
		txtGesamtVerbrauch = new JTextField();
		txtGesamtVerbrauch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGesamtVerbrauch.setEditable(false);
		txtGesamtVerbrauch.setColumns(10);
		txtGesamtVerbrauch.setBounds(293, 36, 106, 21);
		contentPanel.add(txtGesamtVerbrauch);
		
		JLabel lblAnzahlVorbesitzer = new JLabel("");
		lblAnzahlVorbesitzer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAnzahlVorbesitzer.setBounds(147, 68, 106, 21);
		contentPanel.add(lblAnzahlVorbesitzer);
		
		JLabel lblAktImTank = new JLabel("Akt. im Tank");
		lblAktImTank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAktImTank.setBounds(147, 290, 117, 21);
		contentPanel.add(lblAktImTank);
		
		txtAktTankLevel = new JTextField();
		txtAktTankLevel.setEditable(false);
		txtAktTankLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAktTankLevel.setColumns(10);
		txtAktTankLevel.setBounds(147, 311, 117, 21);
		contentPanel.add(txtAktTankLevel);
		
		JLabel lblAktFahrzeughalter = new JLabel("Akt. Fahrzeughalter");
		lblAktFahrzeughalter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAktFahrzeughalter.setBounds(23, 121, 142, 21);
		contentPanel.add(lblAktFahrzeughalter);
		
		txtFahrzeughalter = new JTextField();
		txtFahrzeughalter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrzeughalter.setColumns(10);
		txtFahrzeughalter.setBounds(23, 142, 376, 21);
		contentPanel.add(txtFahrzeughalter);
		
		JLabel lblBasisverbrauch = new JLabel("Basisverbrauch");
		lblBasisverbrauch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBasisverbrauch.setBounds(293, 290, 102, 21);
		contentPanel.add(lblBasisverbrauch);
		
		txtGrundVerbrauch = new JTextField();
		txtGrundVerbrauch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGrundVerbrauch.setColumns(10);
		txtGrundVerbrauch.setBounds(293, 311, 106, 21);
		contentPanel.add(txtGrundVerbrauch);
		
		JLabel lblLeergewicht = new JLabel("Leergewicht");
		lblLeergewicht.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblLeergewicht.setBounds(147, 353, 94, 21);
		contentPanel.add(lblLeergewicht);
		
		JLabel lblMotorleistungkw = new JLabel("Motorleistung (KW)");
		lblMotorleistungkw.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMotorleistungkw.setBounds(293, 353, 129, 21);
		contentPanel.add(lblMotorleistungkw);
		
		txtLeistungKw = new JTextField();
		txtLeistungKw.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLeistungKw.setColumns(10);
		txtLeistungKw.setBounds(293, 374, 106, 21);
		contentPanel.add(txtLeistungKw);
		
		JLabel lblFahrzeugModell = new JLabel("FahrzeugModell");
		lblFahrzeugModell.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFahrzeugModell.setBounds(23, 237, 117, 21);
		contentPanel.add(lblFahrzeugModell);
		
		txtFahrzeugModell = new JTextField();
		txtFahrzeugModell.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrzeugModell.setColumns(10);
		txtFahrzeugModell.setBounds(23, 258, 376, 21);
		contentPanel.add(txtFahrzeugModell);
		
		JLabel lblFahrzeugHersteller = new JLabel("Fahrzeug Hersteller");
		lblFahrzeugHersteller.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFahrzeugHersteller.setBounds(23, 184, 117, 21);
		contentPanel.add(lblFahrzeugHersteller);
		
		txtFahrzeugHersteller = new JTextField();
		txtFahrzeugHersteller.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrzeugHersteller.setColumns(10);
		txtFahrzeugHersteller.setBounds(23, 205, 376, 21);
		contentPanel.add(txtFahrzeugHersteller);
		
		textLeerGewicht = new JTextField();
		textLeerGewicht.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLeerGewicht.setColumns(10);
		textLeerGewicht.setBounds(147, 374, 106, 21);
		contentPanel.add(textLeerGewicht);
		
		JLabel lblHubraum = new JLabel("Hubraum (ccm)");
		lblHubraum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHubraum.setBounds(23, 412, 106, 21);
		contentPanel.add(lblHubraum);
		
		txtHubraum = new JTextField();
		txtHubraum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtHubraum.setColumns(10);
		txtHubraum.setBounds(23, 433, 106, 21);
		contentPanel.add(txtHubraum);
		
		JLabel lblCwWert = new JLabel("CwWert");
		lblCwWert.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCwWert.setBounds(147, 412, 106, 21);
		contentPanel.add(lblCwWert);
		
		txtCwWert = new JTextField();
		txtCwWert.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCwWert.setColumns(10);
		txtCwWert.setBounds(147, 433, 106, 21);
		contentPanel.add(txtCwWert);
		
		JLabel lblSpezVerbrauch = new JLabel("Spez. Verbrauch");
		lblSpezVerbrauch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSpezVerbrauch.setBounds(293, 412, 106, 21);
		contentPanel.add(lblSpezVerbrauch);
		
		txtSpezVerbrauch = new JTextField();
		txtSpezVerbrauch.setEditable(false);
		txtSpezVerbrauch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtSpezVerbrauch.setColumns(10);
		txtSpezVerbrauch.setBounds(293, 433, 106, 21);
		contentPanel.add(txtSpezVerbrauch);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Save and return");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SetSuvData();
					}
				});
				
				JButton btnBerechne = new JButton("Berechne");
				btnBerechne.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						BerechneSpezifischenVerbrauch();
					}
				});
				btnBerechne.setActionCommand("Cancel");
				buttonPane.add(btnBerechne);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						AutoEdit.this.dispose();
					}
				});
				buttonPane.add(cancelButton);
			}
		}
		fensterZentrieren();
	}
	
	public void fensterZentrieren() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width;
		int y = dimension.height;
		int thisX = (x - this.getWidth()) / 2;
		int thisY = (y - this.getHeight()) / 2;
		this.setLocation(thisX - 20, thisY);
	}
	
	private double BerechneSpezifischenVerbrauch() {
			
		double SpezVerbrauch = 0.0;
		double ZusVbHub = 0.0;
		double ZusVbGewicht = 0.0;
		double ZusVbKw = 0.0;
		double SumVb= 0.0;
		ZusVbHub = 	(Double.parseDouble(txtHubraum.getText()) - 1000) * 0.00225;
		ZusVbKw =   (Double.parseDouble(txtLeistungKw.getText()) - 100) * 0.0075;
		ZusVbGewicht = Double.parseDouble(textLeerGewicht.getText()) * 0.0009;
		SpezVerbrauch = aktSUV.getGrundVerbrauch() + ZusVbHub + ZusVbKw + ZusVbGewicht;
		SumVb = SpezVerbrauch * (1 + Double.parseDouble(txtCwWert.getText()) / 2);
		SumVb = Math.round(SumVb * 100.0) / 100.0;
		txtSpezVerbrauch.setText(String.format("%.2f", SumVb)); 
		return SumVb;
		
	}
	
	private void SetSuvData() {
		aktSUV.setFahrzeughalter(txtFahrzeughalter.getText());
		aktSUV.setFahrzeugHersteller(txtFahrzeugHersteller.getText());
		aktSUV.setFahrzeugModell(txtFahrzeugModell.getText());
		aktSUV.setTankInhalt(Double.parseDouble(txtTankInhalt.getText()));
		aktSUV.setLeistungKw(Double.parseDouble(txtLeistungKw.getText()));
		aktSUV.setAnzahlSitze(Integer.parseInt(txtAnzahlSitze.getText()));
		aktSUV.setGrundVerbrauch(Double.parseDouble(txtGrundVerbrauch.getText()));
		aktSUV.setLeerGewicht(Integer.parseInt(textLeerGewicht.getText()));
		aktSUV.setCwWert(Double.parseDouble(txtCwWert.getText()));
		aktSUV.setHubraum(Integer.parseInt(txtHubraum.getText()));
		aktSUV.setSpezifischerVerbrauch(BerechneSpezifischenVerbrauch());
		AutoEdit.this.dispose();
	}
}


