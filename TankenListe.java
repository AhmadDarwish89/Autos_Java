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

public class TankenListe extends JFrame {
	  private ArrayList<Tanken> myTankenListe;
	  JTable  table = new JTable();
	  DefaultTableModel model = new DefaultTableModel();
	  JScrollPane scroll;
	  String headers[] = { "Datum", "KFZNr", "Liter", "Preis/Liter"};


	public TankenListe(ArrayList<Tanken> theTankenListe) {
		  myTankenListe = theTankenListe;
		  for (int i = 0; i < (myTankenListe.size()); i++) {
			  System.out.println(myTankenListe.get(i).getsDatum());
		  }
		  table.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 14));
		  model.setColumnIdentifiers(headers);   
		  table.setModel(model);
		  scroll = new JScrollPane(table);

		  insert();
		  
		  getContentPane().add(scroll, BorderLayout.CENTER);
		  setSize(515, 400);
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
		  for (int i = 0; i < (myTankenListe.size()); i++) {
			  System.out.println(myTankenListe.get(i).getKfzNr());
			  model.addRow(new Object[]{myTankenListe.get(i).getsDatum(), myTankenListe.get(i).getKfzNr(), myTankenListe.get(i).getLiter(), myTankenListe.get(i).getPreisProLiter()});
			  TankenListe.this.dispose();
		  }
	  }
	  

}