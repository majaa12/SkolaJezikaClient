package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmPolaznik;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

public class PolaznikController {

	private final FrmPolaznik frmPolaznik;

	public PolaznikController(FrmPolaznik frmPolaznik) {
		this.frmPolaznik = frmPolaznik;
		addActionListener();
	}

	private void addActionListener() {

		frmPolaznik.addBtnUnesiActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int response = JOptionPane.showConfirmDialog(frmPolaznik, "Da li ste sigurni?", "Izaberi opciju",
						JOptionPane.YES_NO_OPTION);
				if (response == JOptionPane.YES_OPTION) {
					unesi();
				}
			}

			private void unesi() {
				try {
					Polaznik polaznik = getPolaznikFromForm();
					Communication.getInstance().addPolaznik(polaznik);

					JOptionPane.showMessageDialog(frmPolaznik, "Polaznik uspesno sacuvan");
					frmPolaznik.dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmPolaznik, "\n" + ex.getMessage(), "Greska",
							JOptionPane.ERROR_MESSAGE);
				}

			}

			private Polaznik getPolaznikFromForm() throws Exception {

				String ime = frmPolaznik.getTxtIme().getText().trim();
				String prezime = frmPolaznik.getTxtPrezime().getText().trim();
				String jmbg = frmPolaznik.getTxtJMBG().getText().trim();
				String telefon = frmPolaznik.getTxtTelefon().getText().trim();
				String email = frmPolaznik.getTxtEMail().getText().trim();
				String adresa = frmPolaznik.getTxtAdresa().getText().trim();

				if (ime.equals("") || prezime.equals("") || jmbg.equals("") || telefon.equals("") || email.equals("")
						|| adresa.equals("")) {
					throw new Exception("Sva polja su obavezna");
				}

				if (!email.contains("@")) {
					throw new Exception("Email mora sadrzati @");
				}

				Polaznik polaznik = new Polaznik(-1, ime, prezime, jmbg, telefon, email, adresa);
				return polaznik;
			}
		});

		frmPolaznik.addBtnZatvoriActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frmPolaznik.dispose();
			}
		});

	}

	public void openForm(FrmMode frmMode) {
		frmPolaznik.setLocationRelativeTo(null);
		prepareView(frmMode);
		frmPolaznik.setVisible(true);
	}

	private void prepareView(FrmMode frmMode) {
		switch (frmMode) {
		case ADD:
			frmPolaznik.setTitle("Unos polaznika");
			frmPolaznik.getPnlPolaznik().setBorder(new TitledBorder("Unesi polaznika"));
			frmPolaznik.getBtnZatvori().setVisible(false);
			frmPolaznik.getBtnUnesiPolaznika().setEnabled(true);
			break;
		case VIEW:
			frmPolaznik.setTitle("Pregled polaznika");
			frmPolaznik.getPnlPolaznik().setBorder(new TitledBorder("Pregled polaznika"));
			frmPolaznik.getBtnZatvori().setEnabled(true);
			frmPolaznik.getBtnUnesiPolaznika().setVisible(false);
			frmPolaznik.getTxtIme().setEnabled(false);
			frmPolaznik.getTxtPrezime().setEnabled(false);
			frmPolaznik.getTxtJMBG().setEnabled(false);
			frmPolaznik.getTxtTelefon().setEnabled(false);
			frmPolaznik.getTxtEMail().setEnabled(false);
			frmPolaznik.getTxtAdresa().setEnabled(false);

			Polaznik p = (Polaznik) MainCoordinator.getInstance().getParam(Constants.POLAZNIK);
			frmPolaznik.getTxtIme().setText(p.getIme());
			frmPolaznik.getTxtPrezime().setText(p.getPrezime());
			frmPolaznik.getTxtJMBG().setText(p.getJmbg());
			frmPolaznik.getTxtTelefon().setText(p.getTelefon());
			frmPolaznik.getTxtEMail().setText(p.getEmail());
			frmPolaznik.getTxtAdresa().setText(p.getAdresa());
			break;
		}
	}
}
