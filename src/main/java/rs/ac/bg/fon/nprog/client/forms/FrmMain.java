package rs.ac.bg.fon.nprog.client.forms;

import javax.swing.JFrame;
import java.awt.event.ActionListener;
import javax.swing.JLabel;


public class FrmMain extends JFrame {

	/**
	 * Creates new form FrmMain
	 */
	public FrmMain() {
		initComponents();
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jMenu1 = new javax.swing.JMenu();
		jPanelAdmin = new javax.swing.JPanel();
		lblUlogovaniAdmin = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenuPolaznik = new javax.swing.JMenu();
		jmiUnosPolaz = new javax.swing.JMenuItem();
		jmiPretragaPolaz = new javax.swing.JMenuItem();
		jMenuProfesor = new javax.swing.JMenu();
		jmiUnosProf = new javax.swing.JMenuItem();
		jmiPretragaProf = new javax.swing.JMenuItem();
		jMenuKurs = new javax.swing.JMenu();
		jmiDodavanjeKursa = new javax.swing.JMenuItem();
		jmiIzmenaPretragaKursa = new javax.swing.JMenuItem();
		jMenuUpis = new javax.swing.JMenu();
		jmiDodavanjeUpisa = new javax.swing.JMenuItem();
		jmiBrisanjeUpisa = new javax.swing.JMenuItem();
		jMenuLogout = new javax.swing.JMenu();
		jmiLogout = new javax.swing.JMenuItem();

		jMenu1.setText("jMenu1");

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Client application");
		addWindowListener(new java.awt.event.WindowAdapter() {
			public void windowClosed(java.awt.event.WindowEvent evt) {
				formWindowClosed(evt);
			}
		});

		jPanelAdmin.setBorder(javax.swing.BorderFactory.createTitledBorder("Ulogovani administrator"));

		javax.swing.GroupLayout jPanelAdminLayout = new javax.swing.GroupLayout(jPanelAdmin);
		jPanelAdmin.setLayout(jPanelAdminLayout);
		jPanelAdminLayout.setHorizontalGroup(jPanelAdminLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanelAdminLayout.createSequentialGroup().addContainerGap()
						.addComponent(lblUlogovaniAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
						.addContainerGap()));
		jPanelAdminLayout
				.setVerticalGroup(jPanelAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(jPanelAdminLayout.createSequentialGroup().addContainerGap()
								.addComponent(lblUlogovaniAdmin).addContainerGap(36, Short.MAX_VALUE)));

		jMenuPolaznik.setText("Polaznik");

		jmiUnosPolaz.setText("Unos");
		jMenuPolaznik.add(jmiUnosPolaz);

		jmiPretragaPolaz.setText("Pretraga");
		jMenuPolaznik.add(jmiPretragaPolaz);

		jMenuBar1.add(jMenuPolaznik);

		jMenuProfesor.setText("Profesor");

		jmiUnosProf.setText("Unos");
		jMenuProfesor.add(jmiUnosProf);

		jmiPretragaProf.setText("Pretraga");
		jMenuProfesor.add(jmiPretragaProf);

		jMenuBar1.add(jMenuProfesor);

		jMenuKurs.setText("Kurs");

		jmiDodavanjeKursa.setText("Dodavanje");
		jMenuKurs.add(jmiDodavanjeKursa);

		jmiIzmenaPretragaKursa.setText("Pretraga / Izmena");
		jMenuKurs.add(jmiIzmenaPretragaKursa);

		jMenuBar1.add(jMenuKurs);

		jMenuUpis.setText("Upis");

		jmiDodavanjeUpisa.setText("Dodavanje");
		jMenuUpis.add(jmiDodavanjeUpisa);

		jmiBrisanjeUpisa.setText("Brisanje");
		jMenuUpis.add(jmiBrisanjeUpisa);

		jMenuBar1.add(jMenuUpis);

		jMenuLogout.setText("Logout");

		jmiLogout.setText("Logout");
		jMenuLogout.add(jmiLogout);

		jMenuBar1.add(jMenuLogout);

		setJMenuBar(jMenuBar1);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jPanelAdmin,
						javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap()));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanelAdmin, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(281, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	private void formWindowClosed(java.awt.event.WindowEvent evt) {

	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new FrmMain().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenu jMenuKurs;
	private javax.swing.JMenu jMenuLogout;
	private javax.swing.JMenu jMenuPolaznik;
	private javax.swing.JMenu jMenuProfesor;
	private javax.swing.JMenu jMenuUpis;
	private javax.swing.JPanel jPanelAdmin;
	private javax.swing.JMenuItem jmiBrisanjeUpisa;
	private javax.swing.JMenuItem jmiDodavanjeKursa;
	private javax.swing.JMenuItem jmiDodavanjeUpisa;
	private javax.swing.JMenuItem jmiIzmenaPretragaKursa;
	private javax.swing.JMenuItem jmiLogout;
	private javax.swing.JMenuItem jmiPretragaPolaz;
	private javax.swing.JMenuItem jmiPretragaProf;
	private javax.swing.JMenuItem jmiUnosPolaz;
	private javax.swing.JMenuItem jmiUnosProf;
	private javax.swing.JLabel lblUlogovaniAdmin;
	// End of variables declaration

	public JLabel getLblUlogovaniAdmin() {
		return lblUlogovaniAdmin;
	}

	public void addJMIUnosPolaznikaActionListener(ActionListener actionListener) {
		jmiUnosPolaz.addActionListener(actionListener);
	}

	public void addJMIPretragaPolaznikaActionListener(ActionListener actionListener) {
		jmiPretragaPolaz.addActionListener(actionListener);
	}

	public void addJMIUnosProfActionListener(ActionListener actionListener) {
		jmiUnosProf.addActionListener(actionListener);
	}

	public void addJMIPretragaProfActionListener(ActionListener actionListener) {
		jmiPretragaProf.addActionListener(actionListener);
	}

	public void addJMIDodavanjeKursaActionListener(ActionListener actionListener) {
		jmiDodavanjeKursa.addActionListener(actionListener);
	}

	public void addJMIPretragaIzmenaKursaActionListener(ActionListener actionListener) {
		jmiIzmenaPretragaKursa.addActionListener(actionListener);
	}

	public void addJMIDodavanjeUpisaActionListener(ActionListener actionListener) {
		jmiDodavanjeUpisa.addActionListener(actionListener);
	}

	public void addJMIBrisanjeUpisaActionListener(ActionListener actionListener) {
		jmiBrisanjeUpisa.addActionListener(actionListener);
	}

	public void addJMILogoutActionListener(ActionListener actionListener) {
		jmiLogout.addActionListener(actionListener);
	}

}
