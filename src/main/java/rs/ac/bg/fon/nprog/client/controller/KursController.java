package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Adresa;
import rs.ac.bg.fon.nprog.common.domain.Grad;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Nivo;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.common.domain.TerminKursa;
import rs.ac.bg.fon.nprog.common.domain.TipKursa;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmKurs;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.nprog.client.modeli.TblModelUnetiTermini;

public class KursController {

	private final FrmKurs frmKurs;

	public KursController(FrmKurs frmKurs) {
		this.frmKurs = frmKurs;
		addActionListener();
	}

	private void addActionListener() {

		frmKurs.getCmbJezik().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Jezik j = (Jezik) e.getItem();

					Profesor p = new Profesor();
					p.setJezik(j);

					try {
						ArrayList<Profesor> profesori = Communication.getInstance().pretraziProfesore(p);
						if (profesori.isEmpty()) {
							JOptionPane.showMessageDialog(frmKurs, "Za izabrani jezik ne postoji profesor!", "Greska",
									JOptionPane.ERROR_MESSAGE);
						} else {
							frmKurs.getCmbProfesor().removeAllItems();
							for (Profesor profesor : profesori) {
								frmKurs.getCmbProfesor().addItem(profesor);
							}
							frmKurs.getCmbProfesor().setSelectedIndex(-1);
						}
					} catch (Exception ex) {
						Logger.getLogger(PretragaPolaznikaController.class.getName()).log(Level.SEVERE, null, ex);
						JOptionPane.showMessageDialog(frmKurs, ex.getMessage());
					}
				}
			}
		});

		frmKurs.getCmbGrad().addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Grad g = (Grad) e.getItem();

					Adresa a = new Adresa();
					a.setGrad(g);

					try {
						ArrayList<Adresa> adrese = Communication.getInstance().vratiAdreseIzabranogGrada(a);
						if (adrese.isEmpty()) {
							JOptionPane.showMessageDialog(frmKurs, "Za izabrani grad ne postoje adrese!", "Greska",
									JOptionPane.ERROR_MESSAGE);
						} else {
							frmKurs.getCmbAdresa().removeAllItems();
							for (Adresa adresa : adrese) {
								frmKurs.getCmbAdresa().addItem(adresa);
							}
						}
					} catch (Exception ex) {
						Logger.getLogger(PretragaPolaznikaController.class.getName()).log(Level.SEVERE, null, ex);
						JOptionPane.showMessageDialog(frmKurs, ex.getMessage());
					}
				}
			}
		});

		frmKurs.addBtnUnesiTermineActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String naziv = frmKurs.getTxtNaziv().getText().trim();
				Nivo nivo = (Nivo) frmKurs.getCmbNivo().getSelectedItem();
				TipKursa tip = (TipKursa) frmKurs.getCmbTipKursa().getSelectedItem();
				Jezik jezik = (Jezik) frmKurs.getCmbJezik().getSelectedItem();

				if (naziv.equals("") || nivo == null || tip == null || jezik == null) {
					JOptionPane.showMessageDialog(frmKurs, "Sva polja su obavezna!", "Greska pri unosu",
							JOptionPane.ERROR_MESSAGE);
				} else {
					frmKurs.getPnlUnosTermina().setVisible(true);
					frmKurs.getBtnSacuvaj().setVisible(true);
				}
			}
		});

		frmKurs.addBtnObrisiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				obrisiUnetiTermin();
			}

			private void obrisiUnetiTermin() {
				int red = frmKurs.getTblUnetiTermini().getSelectedRow();
				if (red != -1) {
					TblModelUnetiTermini tm = (TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel();
					tm.obrisiTermin(red);
				} else {
					JOptionPane.showMessageDialog(frmKurs, "Selektujte zeljeni red!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmKurs.addBtnDodajActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dodajTermin();
			}

			private void dodajTermin() {
				TerminKursa tk = validacija();
				TblModelUnetiTermini model = (TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel();

				if (tk != null) {
					if (!model.dodajTermin(tk)) {
						JOptionPane.showMessageDialog(frmKurs, "Uneti termin vec postoji u okviru kursa!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});

		frmKurs.addBtnIzmeniTermin(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				izmeniTermin();
			}

			private void izmeniTermin() {
				int red = frmKurs.getTblUnetiTermini().getSelectedRow();
				if (red != -1) {
					TblModelUnetiTermini tm = (TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel();
					TerminKursa termin = tm.getTermin(red);
					postaviNaFormu(termin);

					frmKurs.getBtnPotvrdiIzmene().setVisible(true);
					frmKurs.getBtnDodajNoviTermin().setEnabled(false);
					frmKurs.getBtnObrisiUnetiTermin().setEnabled(false);
					frmKurs.getTxtNaziv().setEnabled(false);
					frmKurs.getCmbNivo().setEnabled(false);
					frmKurs.getCmbTipKursa().setEnabled(false);
					frmKurs.getCmbJezik().setEnabled(false);
					frmKurs.getBtnIzmeniKurs().setEnabled(false);

				} else {
					JOptionPane.showMessageDialog(frmKurs, "Selektujte zeljeni red!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}

			private void postaviNaFormu(TerminKursa termin) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				frmKurs.getTxtDatumPocetka().setText(sdf.format(termin.getDatumPocetka()));
				frmKurs.getTxtDatumZavrsetka().setText(sdf.format(termin.getDatumZavrsetka()));
				frmKurs.getTxtRaspored().setText(termin.getRaspored());
				frmKurs.getTxtKapacitet().setText(Integer.toString(termin.getKapacitet()));
				frmKurs.getTxtBrojCasova().setText(Integer.toString(termin.getBrojCasova()));
				frmKurs.getTxtCena().setText(termin.getCena().toString());
				frmKurs.getCmbGrad().setSelectedItem(termin.getAdresa().getGrad());
				frmKurs.getCmbProfesor().setSelectedItem(termin.getProfesor());
				frmKurs.getCmbAdresa().setSelectedItem(termin.getAdresa());
			}

		});

		frmKurs.addBtnPotvrdiIzmeneActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				potvrdiIzmene();
			}

			private void potvrdiIzmene() {
				TerminKursa tk = validacija();
				TblModelUnetiTermini model = (TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel();
				int red = frmKurs.getTblUnetiTermini().getSelectedRow();

				if (tk != null) {
					if (!model.izmeniTermin(tk, red)) {
						JOptionPane.showMessageDialog(frmKurs, "Uneti termin vec postoji u okviru kursa!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					} else {
						ocistiUnosTermina();
					}
				}
			}
		});

		frmKurs.addBtnSacuvajActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmKurs, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					sacuvaj();
				}
			}

			private void sacuvaj() {
				try {
					Kurs kurs = napraviKursSaForme();

					Communication.getInstance().sacuvajKurs(kurs);
					JOptionPane.showMessageDialog(frmKurs, "Uspesno sacuvano!", "Dodavanje kursa",
							JOptionPane.INFORMATION_MESSAGE);
					ocistiFormu();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmKurs, "Nije uspelo cuvanje!\n" + ex.getMessage(),
							"Dodavanje kursa", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmKurs.addBtnOmoguciIzmeneActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setupComponents(FrmMode.EDIT);
				ocistiUnosTermina();
			}
		});

		frmKurs.addBtnIzmeniActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmKurs, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					izmeni();
				}
			}

			private void izmeni() {
				try {
					Kurs kurs = napraviKursSaForme();
					Communication.getInstance().izmeniKurs(kurs);
					JOptionPane.showMessageDialog(frmKurs, "Kurs je uspesno izmenjen!\n", "Izmena kursa",
							JOptionPane.INFORMATION_MESSAGE);
					frmKurs.dispose();

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmKurs, "Greska u izmeni kursa!\n" + ex.getMessage(), "Izmena kursa",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		frmKurs.addBtnIzaberiTerminActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int red = frmKurs.getTblUnetiTermini().getSelectedRow();
				if (red >= 0) {
					TerminKursa termin = ((TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel())
							.getTermin(red);
					MainCoordinator.getInstance().addParam(Constants.TERMIN, termin);
					frmKurs.dispose();
				} else {
					JOptionPane.showMessageDialog(frmKurs, "Selektujte red", "Greska", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

	}

	private TerminKursa validacija() {
		String datPoc = frmKurs.getTxtDatumPocetka().getText().trim();
		String datZav = frmKurs.getTxtDatumZavrsetka().getText().trim();
		String raspored = frmKurs.getTxtRaspored().getText().trim();
		String kap = frmKurs.getTxtKapacitet().getText().trim();
		String brojCasova = frmKurs.getTxtBrojCasova().getText().trim();
		String c = frmKurs.getTxtCena().getText().trim();
		Grad grad = (Grad) frmKurs.getCmbGrad().getSelectedItem();
		Profesor prof = (Profesor) frmKurs.getCmbProfesor().getSelectedItem();
		Adresa adresa = (Adresa) frmKurs.getCmbAdresa().getSelectedItem();

		if (datPoc.equals("") || datZav.equals("") || raspored.equals("") || kap.equals("") || brojCasova.equals("")
				|| c.equals("") || grad == null || prof == null || adresa == null) {
			JOptionPane.showMessageDialog(frmKurs, "Sva polja su obavezna!", "Greska", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		int kapacitet = Integer.parseInt(kap);
		if (kapacitet < 6 || kapacitet > 10) {
			JOptionPane.showMessageDialog(frmKurs, "Kapacitet mora biti izmedju 6 i 10!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

		BigDecimal cena = new BigDecimal(c);
		if (cena.compareTo(BigDecimal.ZERO) <= 0) {
			JOptionPane.showMessageDialog(frmKurs, "Cena mora biti veca od 0!", "Greska", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		TipKursa tip = (TipKursa) frmKurs.getCmbTipKursa().getSelectedItem();
		int brCasova = Integer.parseInt(brojCasova);
		if (tip.toString().equals("Deciji") && (brCasova > 45 || brCasova < 35)) {
			JOptionPane.showMessageDialog(frmKurs, "Deciji kursevi treba da imaju izmedju 35 i 45 casova!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
		if (!tip.toString().equals("Deciji") && (brCasova < 45 || brCasova > 60)) {
			JOptionPane.showMessageDialog(frmKurs, "Svi kursevi osim 'Decijeg' treba da imaju izmedju 45 i 60 casova!",
					"Greska", JOptionPane.ERROR_MESSAGE);
			return null;
		}

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date datumPocetka = sdf.parse(datPoc);
			Date datumZavrsetka = sdf.parse(datZav);

			if (datumPocetka.after(datumZavrsetka)) {
				JOptionPane.showMessageDialog(frmKurs, "Datum pocetka kursa mora biti pre datuma zavrsetka!", "Greska",
						JOptionPane.ERROR_MESSAGE);
				return null;
			}

			TerminKursa tk = new TerminKursa();
			tk.setDatumPocetka(datumPocetka);
			tk.setDatumZavrsetka(datumZavrsetka);
			tk.setRaspored(raspored);
			tk.setKapacitet(kapacitet);
			tk.setBrojCasova(brCasova);
			tk.setCena(cena);
			tk.setProfesor(prof);
			tk.setAdresa(adresa);
			return tk;

		} catch (ParseException e) {
			Logger.getLogger(KursController.class.getName()).log(Level.SEVERE, null, e);
			JOptionPane.showMessageDialog(frmKurs, "Datum nije u odgovarajucem formatu (yyyy-MM-dd)!", "Greska",
					JOptionPane.ERROR_MESSAGE);
			return null;
		}

	}

	private Kurs napraviKursSaForme() throws Exception {
		String naziv = frmKurs.getTxtNaziv().getText().trim();
		Nivo nivo = (Nivo) frmKurs.getCmbNivo().getSelectedItem();
		TipKursa tip = (TipKursa) frmKurs.getCmbTipKursa().getSelectedItem();
		Jezik jezik = (Jezik) frmKurs.getCmbJezik().getSelectedItem();

		TblModelUnetiTermini tm = (TblModelUnetiTermini) frmKurs.getTblUnetiTermini().getModel();
		Kurs kurs = tm.getKurs();
		if (kurs.getTermini().isEmpty()) {
			throw new Exception("Kurs mora da sadrzi makar jedan termin!");
		}
		if (naziv.equals("") || nivo == null || tip == null || jezik == null) {
			throw new Exception("Sva polja su obavezna!");
		} else {
			kurs.setNivo(nivo);
			kurs.setTipKursa(tip);
			kurs.setJezik(jezik);
			kurs.setNaziv(naziv);
		}
		return kurs;
	}

	public void openForm(FrmMode frmMode) {
		frmKurs.setLocationRelativeTo(null);
		prepareView(frmMode);
		frmKurs.setVisible(true);
	}

	private void prepareView(FrmMode frmMode) {
		napuniCMBNivo();
		napuniCMBTipKursa();
		frmKurs.getCmbProfesor().removeAllItems();
		frmKurs.getCmbAdresa().removeAllItems();
		TblModelUnetiTermini tm = new TblModelUnetiTermini();
		frmKurs.getTblUnetiTermini().setModel(tm);

		try {
			napuniCMBJezik();
			napuniCMBGrad();
		} catch (Exception ex) {
			Logger.getLogger(ProfesorController.class.getName()).log(Level.SEVERE, null, ex);
			JOptionPane.showMessageDialog(frmKurs, ex.getMessage());
		}

		setupComponents(frmMode);
	}

	private void napuniCMBJezik() throws Exception {
		frmKurs.getCmbJezik().removeAllItems();
		List<Jezik> jezici = Communication.getInstance().vratiSveJezike();

		frmKurs.getCmbJezik().setModel(new DefaultComboBoxModel<>(jezici.toArray()));
		frmKurs.getCmbJezik().setSelectedIndex(-1);
	}

	private void napuniCMBGrad() throws Exception {
		frmKurs.getCmbGrad().removeAllItems();
		List<Grad> gradovi = Communication.getInstance().vratiSveGradove();

		frmKurs.getCmbGrad().setModel(new DefaultComboBoxModel<>(gradovi.toArray()));
		frmKurs.getCmbGrad().setSelectedIndex(-1);
	}

	private void napuniCMBNivo() {
		frmKurs.getCmbNivo().removeAllItems();
		for (Nivo nivo : Nivo.values()) {
			frmKurs.getCmbNivo().addItem(nivo);
		}
		frmKurs.getCmbNivo().setSelectedIndex(-1);
	}

	private void napuniCMBTipKursa() {
		frmKurs.getCmbTipKursa().removeAllItems();
		for (TipKursa tip : TipKursa.values()) {
			frmKurs.getCmbTipKursa().addItem(tip);
		}
		frmKurs.getCmbTipKursa().setSelectedIndex(-1);
	}

	private void setupComponents(FrmMode frmMode) {
		switch (frmMode) {
		case ADD:
			frmKurs.setTitle("Dodavanje novog kursa");
			frmKurs.getBtnIzmeniKurs().setVisible(false);
			frmKurs.getBtnSacuvaj().setVisible(false);
			frmKurs.getBtnIzaberiTermin().setVisible(false);
			frmKurs.getBtnOmoguciIzmene().setVisible(false);
			frmKurs.getBtnPotvrdiIzmene().setVisible(false);
			frmKurs.getBtnIzmeniTermin().setVisible(false);
			frmKurs.getPnlUnosTermina().setVisible(false);
			break;
		case EDIT:
			frmKurs.setTitle("Izmena kursa");
			frmKurs.getBtnIzmeniKurs().setEnabled(true);
			frmKurs.getBtnIzaberiTermin().setVisible(false);
			frmKurs.getBtnDodajNoviTermin().setEnabled(true);
			frmKurs.getBtnObrisiUnetiTermin().setEnabled(true);
			frmKurs.getBtnIzmeniTermin().setEnabled(true);
			frmKurs.getBtnPotvrdiIzmene().setVisible(false);
			frmKurs.getTxtNaziv().setEnabled(true);
			frmKurs.getCmbNivo().setEnabled(true);
			frmKurs.getCmbTipKursa().setEnabled(true);
			frmKurs.getCmbJezik().setEnabled(true);
			frmKurs.getCmbGrad().setEnabled(true);
			frmKurs.getCmbAdresa().setEnabled(true);
			frmKurs.getCmbProfesor().setEnabled(true);
			frmKurs.getTxtDatumPocetka().setEnabled(true);
			frmKurs.getTxtDatumZavrsetka().setEnabled(true);
			frmKurs.getTxtRaspored().setEnabled(true);
			frmKurs.getTxtKapacitet().setEnabled(true);
			frmKurs.getTxtBrojCasova().setEnabled(true);
			frmKurs.getTxtCena().setEnabled(true);

			frmKurs.getTblUnetiTermini().setEnabled(true);
			break;
		case VIEW:
			frmKurs.setTitle("Pregled kursa");
			frmKurs.getBtnUnesiTermine().setVisible(false);
			frmKurs.getBtnIzaberiTermin().setVisible(false);
			frmKurs.getBtnIzmeniKurs().setVisible(true);
			frmKurs.getBtnIzmeniKurs().setEnabled(false);
			frmKurs.getBtnSacuvaj().setVisible(false);
			frmKurs.getBtnPotvrdiIzmene().setVisible(false);
			frmKurs.getBtnDodajNoviTermin().setEnabled(false);
			frmKurs.getBtnObrisiUnetiTermin().setEnabled(false);
			frmKurs.getBtnIzmeniTermin().setEnabled(false);
			frmKurs.getBtnOmoguciIzmene().setVisible(true);
			frmKurs.getBtnOmoguciIzmene().setEnabled(true);
			frmKurs.getCmbGrad().setEnabled(false);
			frmKurs.getCmbAdresa().setEnabled(false);
			frmKurs.getCmbProfesor().setEnabled(false);
			frmKurs.getTxtDatumPocetka().setEnabled(false);
			frmKurs.getTxtDatumZavrsetka().setEnabled(false);
			frmKurs.getTxtRaspored().setEnabled(false);
			frmKurs.getTxtKapacitet().setEnabled(false);
			frmKurs.getTxtBrojCasova().setEnabled(false);
			frmKurs.getTxtCena().setEnabled(false);
			frmKurs.getPnlUnosTermina().setVisible(true);

			Kurs k = (Kurs) MainCoordinator.getInstance().getParam(Constants.KURS);
			frmKurs.getTxtNaziv().setText(k.getNaziv());
			frmKurs.getCmbNivo().setSelectedItem(k.getNivo());
			frmKurs.getCmbTipKursa().setSelectedItem(k.getTipKursa());
			frmKurs.getCmbJezik().setSelectedItem(k.getJezik());
			frmKurs.getTxtNaziv().setEnabled(false);
			frmKurs.getCmbNivo().setEnabled(false);
			frmKurs.getCmbTipKursa().setEnabled(false);
			frmKurs.getCmbJezik().setEnabled(false);
			// popunjena tabela termina
			TblModelUnetiTermini tm = new TblModelUnetiTermini(k);
			frmKurs.getTblUnetiTermini().setModel(tm);
			frmKurs.getTblUnetiTermini().setEnabled(false);
			break;
		case SEARCH:
			frmKurs.setTitle("Pregled kursa/Biranje termina");
			frmKurs.getBtnIzaberiTermin().setVisible(true);
			frmKurs.getBtnUnesiTermine().setVisible(false);
			frmKurs.getBtnIzmeniKurs().setVisible(false);
			frmKurs.getBtnSacuvaj().setVisible(false);
			frmKurs.getBtnPotvrdiIzmene().setVisible(false);
			frmKurs.getBtnDodajNoviTermin().setEnabled(false);
			frmKurs.getBtnObrisiUnetiTermin().setEnabled(false);
			frmKurs.getBtnIzmeniTermin().setEnabled(false);
			frmKurs.getBtnOmoguciIzmene().setVisible(false);

			frmKurs.getCmbGrad().setEnabled(false);
			frmKurs.getCmbAdresa().setEnabled(false);
			frmKurs.getCmbProfesor().setEnabled(false);
			frmKurs.getTxtDatumPocetka().setEnabled(false);
			frmKurs.getTxtDatumZavrsetka().setEnabled(false);
			frmKurs.getTxtRaspored().setEnabled(false);
			frmKurs.getTxtKapacitet().setEnabled(false);
			frmKurs.getTxtBrojCasova().setEnabled(false);
			frmKurs.getTxtCena().setEnabled(false);
			frmKurs.getPnlUnosTermina().setVisible(true);

			Kurs kurs = (Kurs) MainCoordinator.getInstance().getParam(Constants.KURS);
			frmKurs.getTxtNaziv().setText(kurs.getNaziv());
			frmKurs.getCmbNivo().setSelectedItem(kurs.getNivo());
			frmKurs.getCmbTipKursa().setSelectedItem(kurs.getTipKursa());
			frmKurs.getCmbJezik().setSelectedItem(kurs.getJezik());
			frmKurs.getTxtNaziv().setEnabled(false);
			frmKurs.getCmbNivo().setEnabled(false);
			frmKurs.getCmbTipKursa().setEnabled(false);
			frmKurs.getCmbJezik().setEnabled(false);

			TblModelUnetiTermini model = new TblModelUnetiTermini(kurs);
			frmKurs.getTblUnetiTermini().setModel(model);
			frmKurs.getTblUnetiTermini().setEnabled(true);
			break;
		}
	}

	private void ocistiFormu() {
		frmKurs.getTxtNaziv().setText("");
		frmKurs.getCmbNivo().setSelectedIndex(-1);
		frmKurs.getCmbTipKursa().setSelectedIndex(-1);
		frmKurs.getCmbJezik().setSelectedIndex(-1);

		ocistiUnosTermina();
		TblModelUnetiTermini model = new TblModelUnetiTermini();
		frmKurs.getTblUnetiTermini().setModel(model);
	}

	private void ocistiUnosTermina() {
		frmKurs.getTxtDatumPocetka().setText("");
		frmKurs.getTxtDatumZavrsetka().setText("");
		frmKurs.getTxtRaspored().setText("");
		frmKurs.getTxtKapacitet().setText("");
		frmKurs.getTxtBrojCasova().setText("");
		frmKurs.getTxtCena().setText("");
		frmKurs.getCmbGrad().setSelectedIndex(-1);
		frmKurs.getCmbProfesor().setSelectedIndex(-1);
		frmKurs.getCmbAdresa().setSelectedIndex(-1);
	}
}
