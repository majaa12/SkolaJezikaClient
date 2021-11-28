package rs.ac.bg.fon.nprog.client.forms;

import javax.swing.JButton;
import javax.swing.JDialog;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FrmPretragaKurseva extends JDialog {

	/**
	 * Creates new form FrmPretragaKurseva
	 */
	public FrmPretragaKurseva(java.awt.Frame parent, boolean modal) {
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

		jPanel1 = new javax.swing.JPanel();
		lblNaziv = new javax.swing.JLabel();
		btnPretrazi = new javax.swing.JButton();
		lblNivo = new javax.swing.JLabel();
		lblTipKursa = new javax.swing.JLabel();
		lblJezik = new javax.swing.JLabel();
		txtNaziv = new javax.swing.JTextField();
		cmbNivo = new javax.swing.JComboBox();
		cmbTipKursa = new javax.swing.JComboBox();
		cmbJezik = new javax.swing.JComboBox();
		jScrollPane1 = new javax.swing.JScrollPane();
		tblKursevi = new javax.swing.JTable();
		btnDetalji = new javax.swing.JButton();
		btnIzaberiKurs = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("Pretraga kurseva");

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Pretrazi kurseve"));

		lblNaziv.setText("Naziv:");

		btnPretrazi.setText("Pretrazi");

		lblNivo.setText("Nivo:");

		lblTipKursa.setText("Tip kursa:");

		lblJezik.setText("Jezik:");

		cmbNivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		cmbTipKursa.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		cmbJezik.setModel(
				new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

		tblKursevi
				.setModel(new javax.swing.table.DefaultTableModel(
						new Object[][] { { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null } },
						new String[] { "Title 1", "Title 2", "Title 3", "Title 4" }));
		jScrollPane1.setViewportView(tblKursevi);

		btnDetalji.setText("Detalji");

		btnIzaberiKurs.setText("Izaberi kurs");

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								jPanel1Layout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE)
										.addComponent(btnIzaberiKurs).addGap(18, 18, 18).addComponent(btnDetalji))
						.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
								.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(jPanel1Layout.createSequentialGroup()
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(lblNaziv).addComponent(lblNivo)
														.addComponent(lblTipKursa).addComponent(lblJezik))
												.addGap(12, 12, 12)
												.addGroup(jPanel1Layout
														.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING,
																false)
														.addComponent(cmbTipKursa,
																javax.swing.GroupLayout.Alignment.LEADING, 0, 278,
																Short.MAX_VALUE)
														.addComponent(
																cmbNivo, javax.swing.GroupLayout.Alignment.LEADING, 0,
																javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(txtNaziv,
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(cmbJezik, 0, javax.swing.GroupLayout.DEFAULT_SIZE,
																Short.MAX_VALUE))
												.addGap(48, 48, 48).addComponent(btnPretrazi)
												.addGap(0, 0, Short.MAX_VALUE))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 575,
												Short.MAX_VALUE))))
						.addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup().addContainerGap()
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNaziv).addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblNivo).addComponent(cmbNivo, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblTipKursa).addComponent(cmbTipKursa,
										javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(lblJezik)
								.addComponent(cmbJezik, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(btnPretrazi))
						.addGap(18, 18, 18)
						.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 114,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(btnDetalji).addComponent(btnIzaberiKurs))
						.addContainerGap(13, Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(13, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap()
						.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>

	// Variables declaration - do not modify
	private javax.swing.JButton btnDetalji;
	private javax.swing.JButton btnIzaberiKurs;
	private javax.swing.JButton btnPretrazi;
	private javax.swing.JComboBox cmbJezik;
	private javax.swing.JComboBox cmbNivo;
	private javax.swing.JComboBox cmbTipKursa;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JLabel lblJezik;
	private javax.swing.JLabel lblNaziv;
	private javax.swing.JLabel lblNivo;
	private javax.swing.JLabel lblTipKursa;
	private javax.swing.JTable tblKursevi;
	private javax.swing.JTextField txtNaziv;
	// End of variables declaration

	public JButton getBtnDetalji() {
		return btnDetalji;
	}

	public JButton getBtnPretrazi() {
		return btnPretrazi;
	}

	public JComboBox getCmbJezik() {
		return cmbJezik;
	}

	public JComboBox getCmbNivo() {
		return cmbNivo;
	}

	public JComboBox getCmbTipKursa() {
		return cmbTipKursa;
	}

	public JTable getTblKursevi() {
		return tblKursevi;
	}

	public JTextField getTxtNaziv() {
		return txtNaziv;
	}

	public JButton getBtnIzaberiKurs() {
		return btnIzaberiKurs;
	}

	public void addBtnPretraziActionListener(ActionListener actionListener) {
		btnPretrazi.addActionListener(actionListener);
	}

	public void addBtnDetaljiActionListener(ActionListener actionListener) {
		btnDetalji.addActionListener(actionListener);
	}

	public void addBtnIzaberiKursActionListener(ActionListener actionListener) {
		btnIzaberiKurs.addActionListener(actionListener);
	}

}
