package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaPolaznika;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.modeli.TblModelPretragaPolaznika;

public class PretragaPolaznikaController {

	private final FrmPretragaPolaznika frmPretragaPolaznika;

	public PretragaPolaznikaController(FrmPretragaPolaznika frmPretragaPolaznika) {
		this.frmPretragaPolaznika = frmPretragaPolaznika;
		addActionListener();
	}

	private void addActionListener() {

		frmPretragaPolaznika.addBtnPretraziActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretrazi();
			}

			private void pretrazi() {
				String ime = frmPretragaPolaznika.getTxtIme().getText().trim();
				String prezime = frmPretragaPolaznika.getTxtPrezime().getText().trim();

				Polaznik p = new Polaznik();
				p.setIme(ime);
				p.setPrezime(prezime);

				try {
					ArrayList<Polaznik> polaznici = Communication.getInstance().pretraziPolaznike(p);
					if (polaznici.isEmpty()) {
						JOptionPane.showMessageDialog(frmPretragaPolaznika,
								"Nisu pronadjeni polaznici po zadatim uslovima", "Greska", JOptionPane.ERROR_MESSAGE);
					} else {
						TblModelPretragaPolaznika mpp = new TblModelPretragaPolaznika(polaznici);
						frmPretragaPolaznika.getTblPolaznici().setModel(mpp);
					}

				} catch (Exception ex) {
					Logger.getLogger(PretragaPolaznikaController.class.getName()).log(Level.SEVERE, null, ex);
					JOptionPane.showMessageDialog(frmPretragaPolaznika, ex.getMessage());
				}
			}
		});

		frmPretragaPolaznika.addBtnDetaljiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziDetalje();
			}

			private void prikaziDetalje() {
				int red = frmPretragaPolaznika.getTblPolaznici().getSelectedRow();
				if (red >= 0) {
					Polaznik polaznik = ((TblModelPretragaPolaznika) frmPretragaPolaznika.getTblPolaznici().getModel())
							.vratiPolaznika(red);
					MainCoordinator.getInstance().addParam(Constants.POLAZNIK, polaznik);
					MainCoordinator.getInstance().openFrmPolaznik(FrmMode.VIEW);
				} else {
					JOptionPane.showMessageDialog(frmPretragaPolaznika,
							"Sistem ne moze da pronadje podatke o polazniku!\nSelektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmPretragaPolaznika.addBtnIzaberiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = frmPretragaPolaznika.getTblPolaznici().getSelectedRow();
				if (red >= 0) {
					Polaznik polaznik = ((TblModelPretragaPolaznika) frmPretragaPolaznika.getTblPolaznici().getModel())
							.vratiPolaznika(red);
					MainCoordinator.getInstance().addParam(Constants.POLAZNIK, polaznik);
					frmPretragaPolaznika.dispose();
				} else {
					JOptionPane.showMessageDialog(frmPretragaPolaznika, "Selektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public void openForm(FrmMode frmMode) {
		TblModelPretragaPolaznika mpp = new TblModelPretragaPolaznika();
		frmPretragaPolaznika.getTblPolaznici().setModel(mpp);
		setupComponents(frmMode);
		frmPretragaPolaznika.setVisible(true);

	}

	private void setupComponents(FrmMode frmMode) {
		switch (frmMode) {
		case SEARCH:
			frmPretragaPolaznika.getBtnIzaberi().setVisible(false);
			break;
		case VIEW:
			frmPretragaPolaznika.getBtnDetalji().setVisible(false);
			break;
		}
	}
}
