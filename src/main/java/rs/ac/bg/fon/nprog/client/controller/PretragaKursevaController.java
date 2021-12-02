package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Nivo;
import rs.ac.bg.fon.nprog.common.domain.TipKursa;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaKurseva;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.modeli.TblModelPretragaKurseva;

public class PretragaKursevaController {

	private final FrmPretragaKurseva frmPretragaKurseva;

	public PretragaKursevaController(FrmPretragaKurseva frmPretragaKurseva) {
		this.frmPretragaKurseva = frmPretragaKurseva;
		addActionListener();
	}

	private void addActionListener() {

		frmPretragaKurseva.addBtnPretraziActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretrazi();
			}

			private void pretrazi() {
				String naziv = frmPretragaKurseva.getTxtNaziv().getText().trim();
				Nivo nivo = (Nivo) frmPretragaKurseva.getCmbNivo().getSelectedItem();
				TipKursa tip = (TipKursa) frmPretragaKurseva.getCmbTipKursa().getSelectedItem();
				Jezik jezik = (Jezik) frmPretragaKurseva.getCmbJezik().getSelectedItem();

				Kurs k = new Kurs(-1, naziv, nivo, tip, jezik, null);
				/*k.setNaziv(naziv);
				k.setNivo(nivo);
				k.setTipKursa(tip);
				k.setJezik(jezik);*/

				try {
					ArrayList<Kurs> kursevi = Communication.getInstance().pretraziKurseve(k);
					if (kursevi.isEmpty()) {
						JOptionPane.showMessageDialog(frmPretragaKurseva,
								"Nisu pronadjeni kursevi po zadatim uslovima!", "Greska", JOptionPane.ERROR_MESSAGE);
					} else {
						TblModelPretragaKurseva tm = new TblModelPretragaKurseva(kursevi);
						frmPretragaKurseva.getTblKursevi().setModel(tm);
					}

				} catch (Exception ex) {
					Logger.getLogger(PretragaPolaznikaController.class.getName()).log(Level.SEVERE, null, ex);
					JOptionPane.showMessageDialog(frmPretragaKurseva, ex.getMessage());
				}
			}
		});

		frmPretragaKurseva.addBtnDetaljiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziDetalje();
			}

			private void prikaziDetalje() {
				int red = frmPretragaKurseva.getTblKursevi().getSelectedRow();
				if (red >= 0) {
					Kurs kurs = ((TblModelPretragaKurseva) frmPretragaKurseva.getTblKursevi().getModel())
							.vratiKurs(red);
					MainCoordinator.getInstance().addParam(Constants.KURS, kurs);
					MainCoordinator.getInstance().openFrmKurs(FrmMode.VIEW);
					TblModelPretragaKurseva tm = new TblModelPretragaKurseva();
					frmPretragaKurseva.getTblKursevi().setModel(tm);
				} else {
					JOptionPane.showMessageDialog(frmPretragaKurseva,
							"Sistem ne moze da pronadje podatke o kursu!\nSelektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmPretragaKurseva.addBtnIzaberiKursActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = frmPretragaKurseva.getTblKursevi().getSelectedRow();
				if (red >= 0) {
					Kurs kurs = ((TblModelPretragaKurseva) frmPretragaKurseva.getTblKursevi().getModel())
							.vratiKurs(red);
					MainCoordinator.getInstance().addParam(Constants.KURS, kurs);
					MainCoordinator.getInstance().openFrmKurs(FrmMode.SEARCH);
					TblModelPretragaKurseva tm = new TblModelPretragaKurseva();
					frmPretragaKurseva.getTblKursevi().setModel(tm);
				} else {
					JOptionPane.showMessageDialog(frmPretragaKurseva, "Selektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public void openForm(FrmMode frmMode) {
		TblModelPretragaKurseva tm = new TblModelPretragaKurseva();
		frmPretragaKurseva.getTblKursevi().setModel(tm);

		try {
			napuniCMBTipKursa();
			napuniCMBNivo();
			napuniCMBJezik();
		} catch (Exception ex) {
			Logger.getLogger(ProfesorController.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(frmPretragaKurseva, ex.getMessage());
		}

		setupComponents(frmMode);
		frmPretragaKurseva.setVisible(true);
	}

	private void napuniCMBJezik() throws Exception {
		frmPretragaKurseva.getCmbJezik().removeAllItems();
		List<Jezik> jezici = Communication.getInstance().vratiSveJezike();

		frmPretragaKurseva.getCmbJezik().setModel(new DefaultComboBoxModel<>(jezici.toArray()));
		frmPretragaKurseva.getCmbJezik().setSelectedIndex(-1);
	}

	private void napuniCMBTipKursa() {
		frmPretragaKurseva.getCmbTipKursa().removeAllItems();
		for (TipKursa tip : TipKursa.values()) {
			frmPretragaKurseva.getCmbTipKursa().addItem(tip);
		}
		frmPretragaKurseva.getCmbTipKursa().setSelectedIndex(-1);
	}

	private void napuniCMBNivo() {
		frmPretragaKurseva.getCmbNivo().removeAllItems();
		for (Nivo nivo : Nivo.values()) {
			frmPretragaKurseva.getCmbNivo().addItem(nivo);
		}
		frmPretragaKurseva.getCmbNivo().setSelectedIndex(-1);
	}

	private void setupComponents(FrmMode frmMode) {
		switch (frmMode) {
		case SEARCH:
			frmPretragaKurseva.getBtnIzaberiKurs().setVisible(false);
			break;
		case VIEW:
			frmPretragaKurseva.getBtnDetalji().setVisible(false);
			break;
		}
	}

}
