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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class AutoTanken<TankListe> extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField txtKfzNr;
	private SUV aktSUV;
	private JTextField txtTankInhalt;
	private JTextField txtAktTankLevel;
	private JTextField txtFillIn;
	private JTextField txtMaxFillIn;
	private JTextField txtTankDatum;
	private JTextField txtLiterPreis;
	private JTextField txtGesamtPreis;
	private Date date = new Date(); 
	private ArrayList<Tanken> aktTankListe;
	private Tanken aktTanken;
	
	public void StartMe( SUV theSUV, ArrayList<Tanken> theTankListe) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		txtTankDatum.setText(formatter.format(date));
		aktSUV = theSUV;
		aktTankListe = theTankListe;
		double MaxMenge = 0.0;
		double TankInhalt = aktSUV.getTankInhalt();
		double TankLevel = aktSUV.getAktTankLevel();
		MaxMenge = TankInhalt - TankLevel;
		txtKfzNr.setText(aktSUV.getKfzNr());
		txtTankInhalt.setText(String.valueOf(aktSUV.getTankInhalt()));
		txtAktTankLevel.setText(String.valueOf(aktSUV.getAktTankLevel()));
		txtMaxFillIn.setText(String.valueOf(MaxMenge));
		txtLiterPreis.setText("0");
		txtFillIn.setText("0");
	}
	
	
	AutoTanken() {
		setTitle("Auto tanken");
		setBounds(500, 600, 450, 333);  // PosX, PosY, h,b
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
		
		JLabel lblNewLabel = new JLabel("KFZ-Kennzeichen");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(23, 11, 106, 21);
		contentPanel.add(lblNewLabel);
		{
			JLabel lblKontodispo = new JLabel("Tankinhalt");
			lblKontodispo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblKontodispo.setBounds(23, 69, 117, 21);
			contentPanel.add(lblKontodispo);
		}
		{
			txtTankInhalt = new JTextField();
			txtTankInhalt.setEditable(false);
			txtTankInhalt.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtTankInhalt.setColumns(10);
			txtTankInhalt.setBounds(23, 90, 106, 21);
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
		
		JLabel lblAktImTank = new JLabel("Akt. im Tank");
		lblAktImTank.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAktImTank.setBounds(147, 69, 117, 21);
		contentPanel.add(lblAktImTank);
		
		txtAktTankLevel = new JTextField();
		txtAktTankLevel.setEditable(false);
		txtAktTankLevel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAktTankLevel.setColumns(10);
		txtAktTankLevel.setBounds(147, 90, 117, 21);
		contentPanel.add(txtAktTankLevel);
		
		txtFillIn = new JTextField();
		txtFillIn.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CheckEmptyTankValuesFillIn();
			}
		});

		txtFillIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFillIn.setColumns(10);
		txtFillIn.setBounds(292, 151, 117, 21);
		contentPanel.add(txtFillIn);
		
		JLabel lblFillIn = new JLabel("TankMenge in Liter");
		lblFillIn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFillIn.setBounds(292, 130, 117, 21);
		contentPanel.add(lblFillIn);
		
		JLabel lblMaxLiter = new JLabel("max Liter");
		lblMaxLiter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblMaxLiter.setBounds(292, 69, 117, 21);
		contentPanel.add(lblMaxLiter);
		
		txtMaxFillIn = new JTextField();
		txtMaxFillIn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtMaxFillIn.setEditable(false);
		txtMaxFillIn.setColumns(10);
		txtMaxFillIn.setBounds(292, 90, 117, 21);
		contentPanel.add(txtMaxFillIn);
		
		JLabel lblDatumUhrzeit = new JLabel("Datum / Uhrzeit");
		lblDatumUhrzeit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDatumUhrzeit.setBounds(147, 15, 117, 21);
		contentPanel.add(lblDatumUhrzeit);
		
		txtTankDatum = new JTextField();
		txtTankDatum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTankDatum.setColumns(10);
		txtTankDatum.setBounds(147, 36, 261, 21);
		contentPanel.add(txtTankDatum);
		
		JLabel lblPreisliter = new JLabel("Preis/Liter");
		lblPreisliter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPreisliter.setBounds(147, 130, 117, 21);
		contentPanel.add(lblPreisliter);
		
		txtLiterPreis = new JTextField();
		txtLiterPreis.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				CheckEmptyTankValuesPreis();
			}
		});

		txtLiterPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtLiterPreis.setColumns(10);
		txtLiterPreis.setBounds(147, 151, 117, 21);
		contentPanel.add(txtLiterPreis);
		
		JLabel lblGesamtpreis = new JLabel("GesamtPreis");
		lblGesamtpreis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblGesamtpreis.setBounds(292, 183, 117, 21);
		contentPanel.add(lblGesamtpreis);
		
		txtGesamtPreis = new JTextField();
		txtGesamtPreis.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtGesamtPreis.setEditable(false);
		txtGesamtPreis.setColumns(10);
		txtGesamtPreis.setBounds(292, 204, 117, 21);
		contentPanel.add(txtGesamtPreis);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSaveTanken = new JButton("Save and return");
				btnSaveTanken.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SaveTanken();
					}
				});
				btnSaveTanken.setActionCommand("OK");
				buttonPane.add(btnSaveTanken);
				getRootPane().setDefaultButton(btnSaveTanken);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private void CheckEmptyTankValuesFillIn() {
		if (txtFillIn.getText() != null) {
			if (txtFillIn.getText().length() == 0 ) {
				txtFillIn.setText("0");
				JOptionPane.showMessageDialog(null, "Keine Angabe in getankte Menge !");
				txtFillIn.grabFocus();
			} else {
				BerechneGesamtPreis();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Literpreis und getankte Menge darf nicht null sein !");
		}
	}
	
	private void CheckEmptyTankValuesPreis() {
		if (txtLiterPreis.getText() != null) {
			if (txtLiterPreis.getText().length() == 0 ) {
				txtLiterPreis.setText("0");
				JOptionPane.showMessageDialog(null, "Keine Angabe in Preis/Liter !");
				txtLiterPreis.grabFocus();
			} else {
				BerechneGesamtPreis();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Literpreis und getankte Menge darf nicht null sein !");
		}
	}
	
	private void BerechneGesamtPreis() {
		double GesamtPreis = 0;
		GesamtPreis = Double.parseDouble(txtFillIn.getText()) * Double.parseDouble(txtLiterPreis.getText()); 
		txtGesamtPreis.setText(String.valueOf(GesamtPreis));
	}
	
	private void SaveTanken() {
		double aktImTank = 0;
        try {
        	aktImTank = aktSUV.getAktTankLevel() + Double.parseDouble(txtFillIn.getText());
        } catch (Exception e) {
            //do something clever with the exception
            System.out.println(e.getMessage());
        }
        
        aktTanken = new Tanken();
		aktTanken.setKfzNr(txtKfzNr.getText());
		aktTanken.setsDatum(txtTankDatum.getText());
		if (txtFillIn.getText() != null && txtLiterPreis.getText() != null) {
			if (txtFillIn.getText().length() > 0 && txtLiterPreis.getText().length() > 0) {
			    aktTanken.setLiter(Double.parseDouble(txtFillIn.getText()));
			    aktTanken.setPreisProLiter(Double.parseDouble(txtLiterPreis.getText()));
			} else {
				JOptionPane.showMessageDialog(null, "Keine Angabe in Literpreis und / oder getankte Menge !");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Literpreis und getankte Menge darf nicht null sein !");
		}
		if (txtGesamtPreis.getText() != null) {
			if (txtGesamtPreis.getText().length() > 0 ) {
				aktTanken.setGesamtPreis(Double.parseDouble(txtGesamtPreis.getText()));
				aktSUV.setAktTankLevel(aktImTank);
			} else {
				JOptionPane.showMessageDialog(null, "Keine Angabe in Gesamtpreis !");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Gesamtpreis darf nicht null sein !");
		}
		aktTankListe.add(aktTanken);
		System.out.println("Länge der aktTankliste in AutoTanken: " + Integer.toString(aktTankListe.size())) ;
		AutoTanken.this.dispose();
	}
		
}



