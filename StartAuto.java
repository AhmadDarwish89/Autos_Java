package Auto_V_01;

import javax.swing.JDialog;

public class StartAuto {

	public static void main(String[] args) {
		try {
			CreateAuto AutoStart = new CreateAuto();
			AutoStart.setVisible(true);
		} catch (Exception e) {
				e.printStackTrace();
		}

	}

}
