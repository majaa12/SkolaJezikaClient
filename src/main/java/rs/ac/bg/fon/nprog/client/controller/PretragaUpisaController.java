package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Administrator;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Nivo;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.common.domain.TerminKursa;
import rs.ac.bg.fon.nprog.common.domain.TipKursa;
import rs.ac.bg.fon.nprog.common.domain.Upis;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaUpisa;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.modeli.TblModelPretragaUpisa;

public class PretragaUpisaController {

	private final FrmPretragaUpisa frmPretragaUpisa;

	public PretragaUpisaController(FrmPretragaUpisa frmPretragaUpisa) {
		this.frmPretragaUpisa = frmPretragaUpisa;
		addActionListener();
	}

	private void addActionListener() {

		frmPretragaUpisa.addBtnPretraziActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pretrazi();
			}

			private void pretrazi() {
				String naziv = frmPretragaUpisa.getTxtNaziv().getText().trim();
				Nivo nivo = (Nivo) frmPretragaUpisa.getCmbNivo().getSelectedItem();
				TipKursa tip = (TipKursa) frmPretragaUpisa.getCmbTip().getSelectedItem();
				Jezik jezik = (Jezik) frmPretragaUpisa.getCmbJezik().getSelectedItem();

				Kurs k = new Kurs();
				k.setNaziv(naziv);
				k.setNivo(nivo);
				k.setTipKursa(tip);
				k.setJezik(jezik);
				TerminKursa t = new TerminKursa();
				t.setKurs(k);

				String ime = frmPretragaUpisa.getTxtIme().getText().trim();
				String prezime = frmPretragaUpisa.getTxtPrezime().getText().trim();

				Polaznik p = new Polaznik();
				p.setIme(ime);
				p.setPrezime(prezime);

				Administrator a = (Administrator) MainCoordinator.getInstance().getParam(Constants.CURRENT_ADMIN);

				String datum = frmPretragaUpisa.getTxtDatumUpisa().getText().trim();

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Upis upis;

				try {
					if (!datum.equals("")) {
						Date datumUpisa = sdf.parse(datum);
						upis = new Upis(datumUpisa, p, a, t);
					} else {
						upis = new Upis(null, p, a, t);
					}

					ArrayList<Upis> upisi = Communication.getInstance().pretraziUpise(upis);
					if (upisi.isEmpty()) {
						JOptionPane.showMessageDialog(frmPretragaUpisa, "Nisu pronadjeni upisi po zadatim uslovima",
								"Greska", JOptionPane.ERROR_MESSAGE);
					} else {
						TblModelPretragaUpisa model = new TblModelPretragaUpisa(upisi);
						frmPretragaUpisa.getTblUpisi().setModel(model);
					}
				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(frmPretragaUpisa, "Datum nije u odgovarajucem formatu (yyyy-MM-dd)!",
							"Greska", JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmPretragaUpisa, ex.getMessage());
				}
			}
		});

		frmPretragaUpisa.addBtnDetaljiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				prikaziDetalje();
			}

			private void prikaziDetalje() {
				int red = frmPretragaUpisa.getTblUpisi().getSelectedRow();
				if (red >= 0) {
					Upis upis = ((TblModelPretragaUpisa) frmPretragaUpisa.getTblUpisi().getModel()).vratiUpis(red);
					MainCoordinator.getInstance().addParam(Constants.UPIS, upis);
					MainCoordinator.getInstance().openFrmUpis(FrmMode.VIEW);
					TblModelPretragaUpisa tm = new TblModelPretragaUpisa();
					frmPretragaUpisa.getTblUpisi().setModel(tm);
				} else {
					JOptionPane.showMessageDialog(frmPretragaUpisa,
							"Sistem ne moze da pronadje podatke o upisu!\nSelektujte red", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public void openForm() {
		TblModelPretragaUpisa tm = new TblModelPretragaUpisa();
		frmPretragaUpisa.getTblUpisi().setModel(tm);

		try {
			napuniCMBTipKursa();
			napuniCMBNivo();
			napuniCMBJezik();
		} catch (Exception ex) {
			Logger.getLogger(ProfesorController.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(frmPretragaUpisa, ex.getMessage());
		}
		frmPretragaUpisa.setVisible(true);
	}

	private void napuniCMBJezik() throws Exception {
		frmPretragaUpisa.getCmbJezik().removeAllItems();
		List<Jezik> jezici = Communication.getInstance().vratiSveJezike();

		frmPretragaUpisa.getCmbJezik().setModel(new DefaultComboBoxModel<>(jezici.toArray()));
		frmPretragaUpisa.getCmbJezik().setSelectedIndex(-1);
	}

	private void napuniCMBTipKursa() {
		frmPretragaUpisa.getCmbTip().removeAllItems();
		for (TipKursa tip : TipKursa.values()) {
			frmPretragaUpisa.getCmbTip().addItem(tip);
		}
		frmPretragaUpisa.getCmbTip().setSelectedIndex(-1);
	}

	private void napuniCMBNivo() {
		frmPretragaUpisa.getCmbNivo().removeAllItems();
		for (Nivo nivo : Nivo.values()) {
			frmPretragaUpisa.getCmbNivo().addItem(nivo);
		}
		frmPretragaUpisa.getCmbNivo().setSelectedIndex(-1);
	}
}
