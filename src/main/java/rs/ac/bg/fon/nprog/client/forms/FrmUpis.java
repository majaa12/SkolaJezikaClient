package rs.ac.bg.fon.nprog.client.forms;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class FrmUpis extends JDialog {

	/**
	 * Creates new form FrmUpis
	 */
	public FrmUpis(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
		setLocationRelativeTo(null);
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		lblDatumUpisa = new javax.swing.JLabel();
		txtDatumUpisa = new javax.swing.JTextField();
		btnIzaberiPolaznika = new javax.swing.JButton();
		btnIzaberiKurs = new javax.swing.JButton();
		pnlPolaznik = new javax.swing.JPanel();
		lblIme = new javax.swing.JLabel();
		lblPrezime = new javax.swing.JLabel();
		lblJmbg = new javax.swing.JLabel();
		lblTelefon = new javax.swing.JLabel();
		lblEmail = new javax.swing.JLabel();
		lblAdr = new javax.swing.JLabel();
		txtIme = new javax.swing.JTextField();
		txtPrezime = new javax.swing.JTextField();
		txtJmbg = new javax.swing.JTextField();
		txtTelefon = new javax.swing.JTextField();
		txtEmail = new javax.swing.JTextField();
		txtAdresa = new javax.swing.JTextField();
		pnlKurs = new javax.swing.JPanel();
		lblNaziv = new javax.swing.JLabel();
		lblNivo = new javax.swing.JLabel();
		lblTip = new javax.swing.JLabel();
		lblJezik = new javax.swing.JLabel();
		lblDatPoc = new javax.swing.JLabel();
		lblDatZav = new javax.swing.JLabel();
		lblProf = new javax.swing.JLabel();
		lblAdresa = new javax.swing.JLabel();
		lblCena = new javax.swing.JLabel();
		lblBrCasova = new javax.swing.JLabel();
		txtNaziv = new javax.swing.JTextField();
		txtNivo = new javax.swing.JTextField();
		txtTip = new javax.swing.JTextField();
		txtJezik = new javax.swing.JTextField();
		txtDatPoc = new javax.swing.JTextField();
		txtDatZav = new javax.swing.JTextField();
		txtProf = new javax.swing.JTextField();
		txtAdr = new javax.swing.JTextField();
		txtCena = new javax.swing.JTextField();
		lblRaspored = new javax.swing.JLabel();
		txtRaspored = new javax.swing.JTextField();
		txtBrCasova = new javax.swing.JTextField();
		btnKreirajUpis = new javax.swing.JButton();
		btnObrisi = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Dodavanje upisa");

		lblDatumUpisa.setText("Datum upisa: ");

		btnIzaberiPolaznika.setText("Izaberi polaznika");

		btnIzaberiKurs.setText("Izaberi kurs");

		pnlPolaznik.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Polaznik",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 3, 11))); // NOI18N

		lblIme.setText("Ime:");

		lblPrezime.setText("Prezime:");

		lblJmbg.setText("Jmbg:");

		lblTelefon.setText("Telefon:");

		lblEmail.setText("Email:");

		lblAdr.setText("Adresa:");

		javax.swing.GroupLayout pnlPolaznikLayout = new javax.swing.GroupLayout(pnlPolaznik);
		pnlPolaznik.setLayout(pnlPolaznikLayout);
		pnlPolaznikLayout.setHorizontalGroup(pnlPolaznikLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlPolaznikLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblIme).addComponent(lblPrezime).addComponent(lblJmbg)
								.addComponent(lblTelefon).addComponent(lblEmail).addComponent(lblAdr))
						.addGap(34, 34, 34)
						.addGroup(
								pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(txtIme).addComponent(txtPrezime).addComponent(txtJmbg)
										.addComponent(txtTelefon).addComponent(txtEmail).addComponent(txtAdresa,
												javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnlPolaznikLayout.setVerticalGroup(pnlPolaznikLayout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlPolaznikLayout.createSequentialGroup().addGap(17, 17, 17)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblIme).addComponent(txtIme, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblPrezime)
								.addComponent(txtPrezime, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblJmbg).addComponent(txtJmbg, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTelefon)
								.addComponent(txtTelefon, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblEmail).addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(pnlPolaznikLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblAdr).addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pnlKurs.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Kurs",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 3, 11))); // NOI18N

		lblNaziv.setText("Naziv:");

		lblNivo.setText("Nivo:");

		lblTip.setText("Tip:");

		lblJezik.setText("Jezik:");

		lblDatPoc.setText("Datum pocetka:");

		lblDatZav.setText("Datum zavrsetka:");

		lblProf.setText("Profesor:");

		lblAdresa.setText("Adresa:");

		lblCena.setText("Cena:");

		lblBrCasova.setText("Broj casova:");

		lblRaspored.setText("Raspored:");

		javax.swing.GroupLayout pnlKursLayout = new javax.swing.GroupLayout(pnlKurs);
		pnlKurs.setLayout(pnlKursLayout);
		pnlKursLayout.setHorizontalGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlKursLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(lblNaziv).addComponent(lblNivo).addComponent(lblTip)
								.addComponent(lblJezik).addComponent(lblDatPoc).addComponent(lblDatZav)
								.addComponent(lblProf).addComponent(lblAdresa).addComponent(lblCena)
								.addComponent(lblBrCasova).addComponent(lblRaspored))
						.addGap(25, 25, 25)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(txtNaziv).addComponent(txtNivo).addComponent(txtTip)
								.addComponent(txtJezik).addComponent(txtDatPoc).addComponent(txtDatZav)
								.addComponent(txtProf).addComponent(txtAdr).addComponent(txtCena)
								.addComponent(txtRaspored)
								.addComponent(txtBrCasova, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE))
						.addContainerGap()));
		pnlKursLayout.setVerticalGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(pnlKursLayout.createSequentialGroup().addContainerGap()
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNaziv).addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtNivo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNivo))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtTip, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTip))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtJezik, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblJezik))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtDatPoc, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatPoc))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtDatZav, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDatZav))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtProf, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProf))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtAdr, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblAdresa))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(txtCena, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCena))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblBrCasova).addComponent(txtBrCasova,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(pnlKursLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(lblRaspored).addComponent(txtRaspored,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		btnKreirajUpis.setText("Kreiraj upis");

		btnObrisi.setText("Obrisi upis");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createSequentialGroup()
										.addComponent(btnKreirajUpis, javax.swing.GroupLayout.PREFERRED_SIZE, 159,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(69, 69, 69).addComponent(btnObrisi,
												javax.swing.GroupLayout.PREFERRED_SIZE, 182,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup()
												.addComponent(pnlPolaznik, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18).addComponent(pnlKurs,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(lblDatumUpisa)
												.addGap(32, 32, 32)
												.addGroup(layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addComponent(btnIzaberiPolaznika,
																javax.swing.GroupLayout.DEFAULT_SIZE, 184,
																Short.MAX_VALUE)
														.addComponent(txtDatumUpisa))
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(btnIzaberiKurs, javax.swing.GroupLayout.PREFERRED_SIZE,
														184, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18))))
						.addContainerGap(67, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(16, 16, 16)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(lblDatumUpisa).addComponent(txtDatumUpisa, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnIzaberiPolaznika).addComponent(btnIzaberiKurs))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
						.addComponent(pnlKurs, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(pnlPolaznik, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(btnKreirajUpis).addComponent(btnObrisi))
				.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

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
			java.util.logging.Logger.getLogger(FrmUpis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrmUpis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrmUpis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrmUpis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FrmUpis dialog = new FrmUpis(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify
	private javax.swing.JButton btnIzaberiKurs;
	private javax.swing.JButton btnIzaberiPolaznika;
	private javax.swing.JButton btnKreirajUpis;
	private javax.swing.JButton btnObrisi;
	private javax.swing.JLabel lblAdr;
	private javax.swing.JLabel lblAdresa;
	private javax.swing.JLabel lblBrCasova;
	private javax.swing.JLabel lblCena;
	private javax.swing.JLabel lblDatPoc;
	private javax.swing.JLabel lblDatZav;
	private javax.swing.JLabel lblDatumUpisa;
	private javax.swing.JLabel lblEmail;
	private javax.swing.JLabel lblIme;
	private javax.swing.JLabel lblJezik;
	private javax.swing.JLabel lblJmbg;
	private javax.swing.JLabel lblNaziv;
	private javax.swing.JLabel lblNivo;
	private javax.swing.JLabel lblPrezime;
	private javax.swing.JLabel lblProf;
	private javax.swing.JLabel lblRaspored;
	private javax.swing.JLabel lblTelefon;
	private javax.swing.JLabel lblTip;
	private javax.swing.JPanel pnlKurs;
	private javax.swing.JPanel pnlPolaznik;
	private javax.swing.JTextField txtAdr;
	private javax.swing.JTextField txtAdresa;
	private javax.swing.JTextField txtBrCasova;
	private javax.swing.JTextField txtCena;
	private javax.swing.JTextField txtDatPoc;
	private javax.swing.JTextField txtDatZav;
	private javax.swing.JTextField txtDatumUpisa;
	private javax.swing.JTextField txtEmail;
	private javax.swing.JTextField txtIme;
	private javax.swing.JTextField txtJezik;
	private javax.swing.JTextField txtJmbg;
	private javax.swing.JTextField txtNaziv;
	private javax.swing.JTextField txtNivo;
	private javax.swing.JTextField txtPrezime;
	private javax.swing.JTextField txtProf;
	private javax.swing.JTextField txtRaspored;
	private javax.swing.JTextField txtTelefon;
	private javax.swing.JTextField txtTip;
	// End of variables declaration

	public JButton getBtnIzaberiKurs() {
		return btnIzaberiKurs;
	}

	public JButton getBtnIzaberiPolaznika() {
		return btnIzaberiPolaznika;
	}

	public JButton getBtnKreirajUpis() {
		return btnKreirajUpis;
	}

	public JPanel getPnlKurs() {
		return pnlKurs;
	}

	public JPanel getPnlPolaznik() {
		return pnlPolaznik;
	}

	public JTextField getTxtAdr() {
		return txtAdr;
	}

	public JTextField getTxtAdresa() {
		return txtAdresa;
	}

	public JTextField getTxtBrCasova() {
		return txtBrCasova;
	}

	public JTextField getTxtCena() {
		return txtCena;
	}

	public JTextField getTxtDatPoc() {
		return txtDatPoc;
	}

	public JTextField getTxtDatZav() {
		return txtDatZav;
	}

	public JTextField getTxtDatumUpisa() {
		return txtDatumUpisa;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JTextField getTxtIme() {
		return txtIme;
	}

	public JTextField getTxtJezik() {
		return txtJezik;
	}

	public JTextField getTxtJmbg() {
		return txtJmbg;
	}

	public JTextField getTxtNaziv() {
		return txtNaziv;
	}

	public JTextField getTxtNivo() {
		return txtNivo;
	}

	public JTextField getTxtPrezime() {
		return txtPrezime;
	}

	public JTextField getTxtProf() {
		return txtProf;
	}

	public JTextField getTxtRaspored() {
		return txtRaspored;
	}

	public JTextField getTxtTelefon() {
		return txtTelefon;
	}

	public JTextField getTxtTip() {
		return txtTip;
	}

	public JButton getBtnObrisi() {
		return btnObrisi;
	}

	public void addBtnIzaberiPolaznikaActionListener(ActionListener actionListener) {
		btnIzaberiPolaznika.addActionListener(actionListener);
	}

	public void addBtnIzaberiKursActionListener(ActionListener actionListener) {
		btnIzaberiKurs.addActionListener(actionListener);
	}

	public void addBtnKreirajUpisActionListener(ActionListener actionListener) {
		btnKreirajUpis.addActionListener(actionListener);
	}

	public void addBtnObrisiUpisActionListener(ActionListener actionListener) {
		btnObrisi.addActionListener(actionListener);
	}

}
