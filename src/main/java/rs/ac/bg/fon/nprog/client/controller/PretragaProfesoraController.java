package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaProfesora;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.modeli.TblModelPretragaProfesora;

public class PretragaProfesoraController {

	private final FrmPretragaProfesora frmPretragaProfesora;

	public PretragaProfesoraController(FrmPretragaProfesora frmPretragaProfesora) {
		this.frmPretragaProfesora = frmPretragaProfesora;
		addActionListener();
	}

	private void addActionListener() {

		frmPretragaProfesora.addBtnPretraziActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretrazi();
			}

			private void pretrazi() {
				String ime = frmPretragaProfesora.getTxtIme().getText().trim();
				String prezime = frmPretragaProfesora.getTxtPrezime().getText().trim();
				Jezik jezik = (Jezik) frmPretragaProfesora.getCmbJezik().getSelectedItem();

				Profesor p = new Profesor();
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setJezik(jezik);

				try {
					ArrayList<Profesor> profesori = Communication.getInstance().pretraziProfesore(p);
					if (profesori.isEmpty()) {
						JOptionPane.showMessageDialog(frmPretragaProfesora,
								"Nisu pronadjeni profesori po zadatim uslovima", "Greska", JOptionPane.ERROR_MESSAGE);
					} else {
						TblModelPretragaProfesora mpp = new TblModelPretragaProfesora(profesori);
						frmPretragaProfesora.getTblProfesori().setModel(mpp);
					}

				} catch (Exception ex) {
					Logger.getLogger(PretragaPolaznikaController.class.getName()).log(Level.SEVERE, null, ex);
					JOptionPane.showMessageDialog(frmPretragaProfesora, ex.getMessage());
				}
			}
		});

		frmPretragaProfesora.addBtnDetaljiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziDetalje();
			}

			private void prikaziDetalje() {
				int red = frmPretragaProfesora.getTblProfesori().getSelectedRow();
				if (red >= 0) {
					Profesor profesor = ((TblModelPretragaProfesora) frmPretragaProfesora.getTblProfesori().getModel())
							.vratiProfesora(red);
					MainCoordinator.getInstance().addParam(Constants.PROFESOR, profesor);
					MainCoordinator.getInstance().openFrmProfesor(FrmMode.VIEW);
				} else {
					JOptionPane.showMessageDialog(frmPretragaProfesora,
							"Sistem ne moze da pronadje podatke o profesoru!\nSelektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	public void openForm() {
		TblModelPretragaProfesora mpp = new TblModelPretragaProfesora();
		frmPretragaProfesora.getTblProfesori().setModel(mpp);
		// combo
		try {
			napuniCMBJezik();
		} catch (Exception ex) {
			Logger.getLogger(ProfesorController.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(frmPretragaProfesora, ex.getMessage());
		}
		frmPretragaProfesora.setVisible(true);

	}

	private void napuniCMBJezik() throws Exception {
		frmPretragaProfesora.getCmbJezik().removeAllItems();
		List<Jezik> jezici = Communication.getInstance().vratiSveJezike();

		frmPretragaProfesora.getCmbJezik().setModel(new DefaultComboBoxModel<>(jezici.toArray()));
		frmPretragaProfesora.getCmbJezik().setSelectedIndex(-1);
	}
}
