package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Administrator;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.common.domain.TerminKursa;
import rs.ac.bg.fon.nprog.common.domain.Upis;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmUpis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class UpisController {

	private final FrmUpis frmUpis;
	Polaznik p;
	TerminKursa t;

	public UpisController(FrmUpis frmUpis) {
		this.frmUpis = frmUpis;
		addActionListener();
	}

	private void addActionListener() {

		frmUpis.addBtnIzaberiPolaznikaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPretragaPolaznika(FrmMode.VIEW);
				p = (Polaznik) MainCoordinator.getInstance().getParam(Constants.POLAZNIK);
				frmUpis.getTxtIme().setText(p.getIme());
				frmUpis.getTxtPrezime().setText(p.getPrezime());
				frmUpis.getTxtJmbg().setText(p.getJmbg());
				frmUpis.getTxtTelefon().setText(p.getTelefon());
				frmUpis.getTxtEmail().setText(p.getEmail());
				frmUpis.getTxtAdresa().setText(p.getAdresa());
			}
		});

		frmUpis.addBtnIzaberiKursActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				MainCoordinator.getInstance().openFrmPretragaKurseva(FrmMode.VIEW);
				t = (TerminKursa) MainCoordinator.getInstance().getParam(Constants.TERMIN);
				frmUpis.getTxtNaziv().setText(t.getKurs().getNaziv());
				frmUpis.getTxtNivo().setText(t.getKurs().getNivo().toString());
				frmUpis.getTxtTip().setText(t.getKurs().getTipKursa().toString());
				frmUpis.getTxtJezik().setText(t.getKurs().getJezik().toString());
				frmUpis.getTxtDatPoc().setText(sdf.format(t.getDatumPocetka()));
				frmUpis.getTxtDatZav().setText(sdf.format(t.getDatumZavrsetka()));
				frmUpis.getTxtProf().setText(t.getProfesor().toString());
				frmUpis.getTxtAdr().setText(t.getAdresa().toString());
				frmUpis.getTxtCena().setText(t.getCena().toString());
				frmUpis.getTxtBrCasova().setText(t.getBrojCasova() + "");
				frmUpis.getTxtRaspored().setText(t.getRaspored());
			}
		});

		frmUpis.addBtnKreirajUpisActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmUpis, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					kreirajUpis();
				}
			}

			private void kreirajUpis() {
				String datum = frmUpis.getTxtDatumUpisa().getText().trim();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Administrator a = (Administrator) MainCoordinator.getInstance().getParam(Constants.CURRENT_ADMIN);

				if (p == null || t == null || a == null || datum.equals("")) {
					JOptionPane.showMessageDialog(frmUpis, "Izbarite polaznika i termin kursa i unesite datum upisa!",
							"Greska", JOptionPane.ERROR_MESSAGE);
					return;
				}

				try {
					Date datumUpisa = sdf.parse(datum);
					if (datumUpisa.after(t.getDatumPocetka())) {
						JOptionPane.showMessageDialog(frmUpis, "Datum upisa kursa mora biti pre datuma pocetka!",
								"Greska", JOptionPane.ERROR_MESSAGE);
						return;
					}

					Upis u = new Upis(datumUpisa, p, a, t);
					Upis ups = new Upis();
					ups.setTerminKursa(t);
					ArrayList<Upis> upisani = Communication.getInstance().pretraziUpise(ups);

					if (t.getKapacitet() > upisani.size()) {
						Communication.getInstance().addUpis(u);
						JOptionPane.showMessageDialog(frmUpis, "Uspesno sacuvano!", "Dodavanje upisa",
								JOptionPane.INFORMATION_MESSAGE);
						ocistiFormu();
					} else {
						JOptionPane.showMessageDialog(frmUpis, "Popunjen kapacitet za ovaj termin", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (ParseException ex) {
					JOptionPane.showMessageDialog(frmUpis, "Datum nije u odgovarajucem formatu (yyyy-MM-dd)!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmUpis, "Sistem ne moze da sacuva upis!\n" + ex.getMessage(),
							"Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmUpis.addBtnObrisiUpisActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmUpis, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					obrisiUpis();
				}
			}

			private void obrisiUpis() {
				Upis u = (Upis) MainCoordinator.getInstance().getParam(Constants.UPIS);
				try {
					Communication.getInstance().obrisiUpis(u);
					JOptionPane.showMessageDialog(frmUpis, "Upis je obrisan!");
					frmUpis.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmUpis, "Neuspesno brisanje\n" + ex.getMessage(), "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	public void openForm(FrmMode frmMode) {
		prepareView(frmMode);
		frmUpis.setVisible(true);

	}

	private void prepareView(FrmMode frmMode) {

		frmUpis.getTxtIme().setEnabled(false);
		frmUpis.getTxtPrezime().setEnabled(false);
		frmUpis.getTxtJmbg().setEnabled(false);
		frmUpis.getTxtTelefon().setEnabled(false);
		frmUpis.getTxtEmail().setEnabled(false);
		frmUpis.getTxtAdresa().setEnabled(false);

		frmUpis.getTxtNaziv().setEnabled(false);
		frmUpis.getTxtNivo().setEnabled(false);
		frmUpis.getTxtTip().setEnabled(false);
		frmUpis.getTxtJezik().setEnabled(false);
		frmUpis.getTxtDatPoc().setEnabled(false);
		frmUpis.getTxtDatZav().setEnabled(false);
		frmUpis.getTxtProf().setEnabled(false);
		frmUpis.getTxtAdr().setEnabled(false);
		frmUpis.getTxtCena().setEnabled(false);
		frmUpis.getTxtBrCasova().setEnabled(false);
		frmUpis.getTxtRaspored().setEnabled(false);

		setupComponents(frmMode);
	}

	private void setupComponents(FrmMode frmMode) {
		switch (frmMode) {
		case ADD:
			frmUpis.setTitle("Dodavanje upisa");
			frmUpis.getBtnObrisi().setVisible(false);
			break;
		case VIEW:
			frmUpis.setTitle("Brisanje upisa");
			frmUpis.getBtnKreirajUpis().setVisible(false);
			frmUpis.getBtnIzaberiKurs().setVisible(false);
			frmUpis.getBtnIzaberiPolaznika().setVisible(false);
			Upis u = (Upis) MainCoordinator.getInstance().getParam(Constants.UPIS);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			frmUpis.getTxtDatumUpisa().setText(sdf.format(u.getDatumUpis()));
			frmUpis.getTxtDatumUpisa().setEnabled(false);

			frmUpis.getTxtIme().setText(u.getPolaznik().getIme());
			frmUpis.getTxtPrezime().setText(u.getPolaznik().getPrezime());
			frmUpis.getTxtJmbg().setText(u.getPolaznik().getJmbg());
			frmUpis.getTxtTelefon().setText(u.getPolaznik().getTelefon());
			frmUpis.getTxtEmail().setText(u.getPolaznik().getEmail());
			frmUpis.getTxtAdresa().setText(u.getPolaznik().getAdresa());

			frmUpis.getTxtNaziv().setText(u.getTerminKursa().getKurs().getNaziv());
			frmUpis.getTxtNivo().setText(u.getTerminKursa().getKurs().getNivo().toString());
			frmUpis.getTxtTip().setText(u.getTerminKursa().getKurs().getTipKursa().toString());
			frmUpis.getTxtJezik().setText(u.getTerminKursa().getKurs().getJezik().toString());
			frmUpis.getTxtDatPoc().setText(sdf.format(u.getTerminKursa().getDatumPocetka()));
			frmUpis.getTxtDatZav().setText(sdf.format(u.getTerminKursa().getDatumZavrsetka()));
			frmUpis.getTxtProf().setText(u.getTerminKursa().getProfesor().toString());
			frmUpis.getTxtAdr().setText(u.getTerminKursa().getAdresa().toString());
			frmUpis.getTxtCena().setText(u.getTerminKursa().getCena().toString());
			frmUpis.getTxtBrCasova().setText(u.getTerminKursa().getBrojCasova() + "");
			frmUpis.getTxtRaspored().setText(u.getTerminKursa().getRaspored());
			break;
		}
	}

	private void ocistiFormu() {
		frmUpis.getTxtDatumUpisa().setText("");

		frmUpis.getTxtIme().setText("");
		frmUpis.getTxtPrezime().setText("");
		frmUpis.getTxtJmbg().setText("");
		frmUpis.getTxtTelefon().setText("");
		frmUpis.getTxtEmail().setText("");
		frmUpis.getTxtAdresa().setText("");

		frmUpis.getTxtNaziv().setText("");
		frmUpis.getTxtNivo().setText("");
		frmUpis.getTxtTip().setText("");
		frmUpis.getTxtJezik().setText("");
		frmUpis.getTxtDatPoc().setText("");
		frmUpis.getTxtDatZav().setText("");
		frmUpis.getTxtProf().setText("");
		frmUpis.getTxtAdr().setText("");
		frmUpis.getTxtCena().setText("");
		frmUpis.getTxtBrCasova().setText("");
		frmUpis.getTxtRaspored().setText("");
	}
}
