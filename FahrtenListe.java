package Auto_V_01;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class FahrtenListe extends JFrame {
	  private ArrayList<Fahrtenbuch> FahrtenBuchListe;
	  JTable  table = new JTable();
	  DefaultTableModel model = new DefaultTableModel();
	  JScrollPane scroll;
	  String headers[] = { "Datum",  "KFZ Nr", "Start", "Ziel", "Entfernung" };


	public FahrtenListe(ArrayList<Fahrtenbuch> myFahrtenbuch) {
		setTitle("Fahrtenbuch");
		FahrtenBuchListe = myFahrtenbuch;
		  table.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
		  model.setColumnIdentifiers(headers);   
		  table.setModel(model);
		  scroll = new JScrollPane(table);

		  insert();
		  
		  getContentPane().add(scroll, BorderLayout.CENTER);
		  setSize(734, 453);
		  setVisible(true);
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
	
	public void insert() {
		  for (int i = 0; i < (FahrtenBuchListe.size()); i++) {
			  System.out.println(FahrtenBuchListe.get(i).getKfzNr());
			  model.addRow(new Object[]{FahrtenBuchListe.get(i).getsDatum(), FahrtenBuchListe.get(i).getKfzNr()});
		  }
	  }
	  

}
