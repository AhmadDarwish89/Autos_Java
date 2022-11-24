package Auto_V_01;


import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CreateAuto extends JFrame {
	private JPanel contentPane;
	private JTextField txtKfzKennzeichen;
	private JTextField txtFahrzeugHalter;
	private JButton btnCreateAuto;
	private JRadioButton rbTypSuv;
	private JButton btnAutoBearbeiten;
	private ArrayList<Tanken> TankListe = new ArrayList<>();
	private ArrayList<SUV> SuvListe = new ArrayList<>();
	private ArrayList<Fahrtenbuch> FahrtenListe = new ArrayList<>();
	private SUV aktSuv;
	private JButton btnAutoTanken;
	private JButton btnTankListe;
	private JButton btnAutoListe;
	JButton btnFahrtenbuchAnzeigen;
	private JTextField txtAutoId;
	

	public CreateAuto() {
		System.out.println("constructor CreateAuto");
		setTitle("Auto_01");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCreateAuto = new JButton("AutoAnlegen");
		btnCreateAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
	    		if (rbTypSuv.isSelected() == true) {
	    			ceateSuv();
	    		} else {
	    			JOptionPane.showMessageDialog(null, "Fahrzeugtyp muss selectiert sein !");
	    		}
			}
		});
		btnCreateAuto.setBounds(22, 223, 129, 52);
		contentPane.add(btnCreateAuto);
		
		txtKfzKennzeichen = new JTextField();
		txtKfzKennzeichen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtKfzKennzeichen.setBounds(22, 44, 157, 27);
		contentPane.add(txtKfzKennzeichen);
		txtKfzKennzeichen.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("KFZ-Kennzeichen:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(26, 17, 113, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblKontoInhaber = new JLabel("Halter:");
		lblKontoInhaber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKontoInhaber.setBounds(30, 87, 134, 27);
		contentPane.add(lblKontoInhaber);
		
		txtFahrzeugHalter = new JTextField();
		txtFahrzeugHalter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFahrzeugHalter.setColumns(10);
		txtFahrzeugHalter.setBounds(22, 113, 434, 27);
		contentPane.add(txtFahrzeugHalter);
		
		JLabel lblKfztyp = new JLabel("KFZ-Typ:");
		lblKfztyp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblKfztyp.setBounds(208, 24, 113, 27);
		contentPane.add(lblKfztyp);
		
		rbTypSuv = new JRadioButton("   SUV");
		rbTypSuv.setBounds(208, 48, 109, 23);
		contentPane.add(rbTypSuv);
		
		btnAutoBearbeiten = new JButton("Auto bearbeiten");
		btnAutoBearbeiten.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAuto();
			}
		});
		btnAutoBearbeiten.setBounds(318, 223, 138, 52);
		contentPane.add(btnAutoBearbeiten);
		
		btnAutoTanken = new JButton("Auto tanken");
		btnAutoTanken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AutoTanken();
			}
		});
		btnAutoTanken.setBounds(22, 302, 129, 52);
		contentPane.add(btnAutoTanken);
		
		btnTankListe = new JButton("Tankliste anzeigen");
		btnTankListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTankListe();
			}
		});
		btnTankListe.setBounds(318, 302, 138, 52);
		contentPane.add(btnTankListe);
		
		JLabel lblAutoid = new JLabel("AutoId:");
		lblAutoid.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAutoid.setBounds(390, 17, 66, 27);
		contentPane.add(lblAutoid);
		
		txtAutoId = new JTextField();
		txtAutoId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAutoId.setColumns(10);
		txtAutoId.setBounds(390, 44, 66, 27);
		contentPane.add(txtAutoId);
		
		JButton btnFahrtEintragen = new JButton("Fahrt eintragen");
		btnFahrtEintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FahrtEintragen();
			}
		});
		btnFahrtEintragen.setBounds(22, 379, 129, 52);
		contentPane.add(btnFahrtEintragen);
		
		btnFahrtenbuchAnzeigen = new JButton("Fahrtenbuch anzeigen");
		btnFahrtenbuchAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowFahrtenListe();
			}
		});
		btnFahrtenbuchAnzeigen.setBounds(279, 379, 177, 52);
		contentPane.add(btnFahrtenbuchAnzeigen);
		
		btnAutoListe = new JButton("AutoListe");
		btnAutoListe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowAutoListe();
			}
		});

		btnAutoListe.setBounds(172, 223, 129, 52);
		contentPane.add(btnAutoListe);
		fensterZentrieren();
	}
	
	public void fensterZentrieren() {
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = dimension.width;
		int y = dimension.height;
		int thisX = (x - this.getWidth()) / 2;
		int thisY = (y - this.getHeight()) / 2;
		this.setLocation(thisX -50, thisY - 100);
	}
	
	
    private void ceateSuv() {
    	try {
    		aktSuv = new SUV(txtKfzKennzeichen.getText());
    		txtAutoId.setText(String.valueOf(aktSuv.getAutoIdNr()));
    		aktSuv.setFahrzeughalter(txtFahrzeugHalter.getText());
    		aktSuv.setFahrzeugTyp("SUV");
    		SuvListe.add(aktSuv);
    		JOptionPane.showMessageDialog(null, "SUV erfolgreich angelegt !");
    		txtAutoId.setText("0");
    		txtKfzKennzeichen.setText("");
    		txtFahrzeugHalter.setText("");
    	} catch (Exception e){
			JOptionPane.showMessageDialog(null, e.toString());
		}
    }
    
    private void ShowAuto() {
        for (int i = 0;i < SuvListe.size(); i++){
        	if(SuvListe.get(i).getKfzNr().equals(txtKfzKennzeichen.getText())) {
        		aktSuv = SuvListe.get(i);
        		AutoEdit dialog = new AutoEdit();
        		dialog.StartMe(aktSuv);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		dialog.setVisible(true);
        		break;
        	}
        }	
    }
    
    private void ShowAutoListe() {
    	AutoListe dialog = new AutoListe(SuvListe);
    }
    
    private void ShowFahrtenListe() {
    	System.out.println("Show Fahrtenliste Listengröße= " + String.valueOf(FahrtenListe.size()));
    	FahrtenListe dialog = new FahrtenListe(FahrtenListe);
    }
    
    private void AutoTanken() {
        for (int i = 0;i < SuvListe.size(); i++){
        	if(SuvListe.get(i).getKfzNr().equals(txtKfzKennzeichen.getText())) {
        		aktSuv = SuvListe.get(i);
        		AutoTanken dialog = new AutoTanken();
        		dialog.StartMe(aktSuv, TankListe);
        		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        		dialog.setVisible(true);
        		break;
        	}
        }	
    }
    
    private void ShowTankListe() {
    	System.out.println("ShowTankListe");
    	System.out.println("CreateAuto Größe TankListe: " + TankListe.size());
    	TankenListe MyTankenListe = new TankenListe(TankListe);
    	
    }
    
	private boolean CheckEmptyTank() {
		boolean RetWert = false;
		if (aktSuv.getAktTankLevel() > 0) {
			RetWert = false;
		} else {
			RetWert = true;
			JOptionPane.showMessageDialog(null, "Wenn kein Benzin im Tank Ist, kann man nicht fahren !");
		}
		return RetWert;
	}
    
    private void FahrtEintragen() {
    	for (int i = 0;i < SuvListe.size(); i++){
    		if(SuvListe.get(i).getKfzNr().equals(txtKfzKennzeichen.getText())) {
    			aktSuv = SuvListe.get(i);
    	    	if (CheckEmptyTank() == false) {
    	    		AutoFahren dialog = new AutoFahren();
    	    		dialog.StartMe(aktSuv, FahrtenListe);
    	    		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    	    		dialog.setVisible(true);
    	    	}
    			break;
    		}
    	}
    	
    }

}

