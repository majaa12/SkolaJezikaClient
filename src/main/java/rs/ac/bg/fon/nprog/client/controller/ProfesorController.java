package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmProfesor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

public class ProfesorController {

	private final FrmProfesor frmProfesor;

	public ProfesorController(FrmProfesor frmProfesor) {
		this.frmProfesor = frmProfesor;
		addActionListener();
	}

	private void addActionListener() {

		frmProfesor.addBtnUnesiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmProfesor, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					unesi();
				}
			}

			private void unesi() {
				try {
					Profesor profesor = getProfesorFromForm();
					Communication.getInstance().addProfesor(profesor);

					JOptionPane.showMessageDialog(frmProfesor, "Profesor uspesno sacuvan");
					frmProfesor.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmProfesor, "\n" + ex.getMessage(), "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private Profesor getProfesorFromForm() throws Exception {
				String ime = frmProfesor.getTxtIme().getText().trim();
				String prezime = frmProfesor.getTxtPrezime().getText().trim();
				String telefon = frmProfesor.getTxtTelefon().getText().trim();
				String email = frmProfesor.getTxtEmail().getText().trim();
				Jezik jezik = (Jezik) frmProfesor.getCmbJezik().getSelectedItem();

				if (ime.equals("") || prezime.equals("") || telefon.equals("") || email.equals("")) {
					throw new Exception("Sva polja su obavezna!");
				}

				if (!email.contains("@")) {
					throw new Exception("Email mora sadrzati @");
				}

				Profesor p = new Profesor(-1, ime, prezime, telefon, email, jezik);
				return p;
			}
		});

		frmProfesor.addBtnZatvoriActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmProfesor.dispose();
			}
		});
	}

	public void openForm(FrmMode frmMode) {
		frmProfesor.setLocationRelativeTo(null);
		prepareView(frmMode);
		frmProfesor.setVisible(true);
	}

	private void prepareView(FrmMode frmMode) {
		try {
			napuniCMBJezik();
		} catch (Exception ex) {
			Logger.getLogger(ProfesorController.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(frmProfesor, ex.getMessage());
		}

		setupComponents(frmMode);
	}

	private void napuniCMBJezik() throws Exception {
		frmProfesor.getCmbJezik().removeAllItems();
		List<Jezik> jezici = Communication.getInstance().vratiSveJezike();

		frmProfesor.getCmbJezik().setModel(new DefaultComboBoxModel<>(jezici.toArray()));

	}

	private void setupComponents(FrmMode frmMode) {
		switch (frmMode) {
		case ADD:
			frmProfesor.setTitle("Unos profesora");
			frmProfesor.getPnlProfesor().setBorder(new TitledBorder("Unesi profesora"));
			frmProfesor.getBtnZatvori().setVisible(false);
			frmProfesor.getBtnUnosProfesora().setEnabled(true);
			frmProfesor.getCmbJezik().setEnabled(true);
			break;
		case VIEW:
			frmProfesor.setTitle("Pregled profesora");
			frmProfesor.getPnlProfesor().setBorder(new TitledBorder("Pregled profesora"));
			frmProfesor.getBtnZatvori().setEnabled(true);
			frmProfesor.getBtnUnosProfesora().setVisible(false);
			frmProfesor.getTxtIme().setEnabled(false);
			frmProfesor.getTxtPrezime().setEnabled(false);
			frmProfesor.getTxtTelefon().setEnabled(false);
			frmProfesor.getTxtEmail().setEnabled(false);
			frmProfesor.getCmbJezik().setEnabled(false);

			Profesor p = (Profesor) MainCoordinator.getInstance().getParam(Constants.PROFESOR);
			frmProfesor.getTxtIme().setText(p.getIme());
			frmProfesor.getTxtPrezime().setText(p.getPrezime());
			frmProfesor.getTxtTelefon().setText(p.getTelefon());
			frmProfesor.getTxtEmail().setText(p.getEmail());
			frmProfesor.getCmbJezik().setSelectedItem(p.getJezik());
			break;
		}
	}

}
