package Auto_V_01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AutoFahren<FahrtenListe> extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtKfzNr;
	private JTextField txtFahrtDatum;
	private JTextField txtAktTankLevel;
	private JTextField txtAbfahrtOrt;
	private JTextField txtZielOrt;
	private JTextField txtDistanz;
	private JTextField txtGrund;
	private SUV aktSUV;
	private ArrayList<Fahrtenbuch> myFahrtenbuch;
	private Fahrtenbuch aktFahrt;
	private Date date = new Date();
	private JTextField txtReichweite;
	private JTextField textField_1;
	
	public void StartMe( SUV theSUV, ArrayList<Fahrtenbuch> theFahrtenbuch) {
		double dReichweite;
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		aktSUV = theSUV;
		txtFahrtDatum.setText(formatter.format(date));
		aktSUV = theSUV;
		myFahrtenbuch = theFahrtenbuch;
		txtAktTankLevel.setText(String.valueOf(aktSUV.getAktTankLevel()));
		txtKfzNr.setText(aktSUV.getKfzNr());
		dReichweite = aktSUV.getAktTankLevel() / aktSUV.getSpezifischerVerbrauch() * 100;
		dReichweite = Math.round(dReichweite * 100.0) / 100.0;
		txtReichweite.setText(String.format("%.2f", dReichweite));
	}

	public AutoFahren() {
		setTitle("Auto fahren");
		setBounds(100, 100, 565, 274);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("KFZ-Kennzeichen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 106, 21);
		contentPanel.add(lblNewLabel);
		
		txtKfzNr = new JTextField();
		txtKfzNr.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKfzNr.setEditable(false);
		txtKfzNr.setColumns(10);
		txtKfzNr.setBounds(10, 36, 106, 21);
		contentPanel.add(txtKfzNr);
		
		JLabel lblDatumUhrzeit = new JLabel("Datum / Uhrzeit");
		lblDatumUhrzeit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatumUhrzeit.setBounds(254, 11, 117, 21);
		contentPanel.add(lblDatumUhrzeit);
		
		txtFahrtDatum = new JTextField();
		txtFahrtDatum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrtDatum.setColumns(10);
		txtFahrtDatum.setBounds(254, 36, 149, 21);
		contentPanel.add(txtFahrtDatum);
		
		JLabel lblAktImTank = new JLabel("Akt. im Tank");
		lblAktImTank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAktImTank.setBounds(424, 15, 101, 21);
		contentPanel.add(lblAktImTank);
		
		txtAktTankLevel = new JTextField();
		txtAktTankLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAktTankLevel.setEditable(false);
		txtAktTankLevel.setColumns(10);
		txtAktTankLevel.setBounds(424, 36, 106, 21);
		contentPanel.add(txtAktTankLevel);
		
		JLabel lblAbfahrtort = new JLabel("AbfahrtOrt");
		lblAbfahrtort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAbfahrtort.setBounds(10, 121, 117, 21);
		contentPanel.add(lblAbfahrtort);
		
		txtAbfahrtOrt = new JTextField();
		txtAbfahrtOrt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAbfahrtOrt.setColumns(10);
		txtAbfahrtOrt.setBounds(10, 142, 184, 21);
		contentPanel.add(txtAbfahrtOrt);
		
		JLabel lblZielort = new JLabel("ZielOrt");
		lblZielort.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblZielort.setBounds(218, 121, 117, 21);
		contentPanel.add(lblZielort);
		
		txtZielOrt = new JTextField();
		txtZielOrt.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtZielOrt.setColumns(10);
		txtZielOrt.setBounds(218, 142, 184, 21);
		contentPanel.add(txtZielOrt);
		
		JLabel lblDistanz = new JLabel("Distanz");
		lblDistanz.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDistanz.setBounds(431, 121, 94, 21);
		contentPanel.add(lblDistanz);
		
		txtDistanz = new JTextField();
		txtDistanz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtDistanz.setColumns(10);
		txtDistanz.setBounds(431, 142, 94, 21);
		contentPanel.add(txtDistanz);
		
		JLabel lblGrund = new JLabel("Grund");
		lblGrund.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGrund.setBounds(138, 68, 94, 21);
		contentPanel.add(lblGrund);
		
		txtGrund = new JTextField();
		txtGrund.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGrund.setColumns(10);
		txtGrund.setBounds(138, 89, 387, 21);
		contentPanel.add(txtGrund);
		
		JLabel lblRecihweite = new JLabel("Recihweite");
		lblRecihweite.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblRecihweite.setBounds(10, 70, 101, 21);
		contentPanel.add(lblRecihweite);
		
		txtReichweite = new JTextField();
		txtReichweite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtReichweite.setEditable(false);
		txtReichweite.setColumns(10);
		txtReichweite.setBounds(10, 91, 106, 21);
		contentPanel.add(txtReichweite);
		
		JLabel lblFahrzeug = new JLabel("Fahrzeug");
		lblFahrzeug.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFahrzeug.setBounds(138, 11, 106, 21);
		contentPanel.add(lblFahrzeug);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(138, 36, 106, 21);
		contentPanel.add(textField_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			JButton btnCheckIt = new JButton("CheckIt");
			btnCheckIt.setActionCommand("OK");
			buttonPane.add(btnCheckIt);
			{
				JButton okButton = new JButton("Save und Return");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SaveFahrt();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
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
		this.setLocation(thisX, thisY);
	}
	
	public void SaveFahrt() {
		aktFahrt = new Fahrtenbuch(txtKfzNr.getText());
		aktFahrt.setsDatum(txtFahrtDatum.getText());
		aktFahrt.setFahrtGrund(txtGrund.getText());
		aktFahrt.setAbfahrtOrt(txtAbfahrtOrt.getText());
		aktFahrt.setAnkunftOrt(txtZielOrt.getText());
		myFahrtenbuch.add(aktFahrt);
		AutoFahren.this.dispose();
	}
}
