package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Administrator;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmMain;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController {

	private final FrmMain frmMain;

	public MainController(FrmMain frmMain) {
		this.frmMain = frmMain;
		addActionListener();
	}

	public void openForm() {
		Administrator admin = (Administrator) MainCoordinator.getInstance().getParam(Constants.CURRENT_ADMIN);
		frmMain.getLblUlogovaniAdmin().setText(admin.getIme() + " " + admin.getPrezime());
		frmMain.setVisible(true);
	}

	private void addActionListener() {

		frmMain.addJMIUnosPolaznikaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPolaznik(FrmMode.ADD);
			}
		});

		frmMain.addJMIPretragaPolaznikaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPretragaPolaznika(FrmMode.SEARCH);
			}
		});

		frmMain.addJMIUnosProfActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmProfesor(FrmMode.ADD);
			}
		});

		frmMain.addJMIPretragaProfActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPretragaProfesora();
			}
		});

		frmMain.addJMIDodavanjeKursaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmKurs(FrmMode.ADD);
			}
		});

		frmMain.addJMIPretragaIzmenaKursaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPretragaKurseva(FrmMode.SEARCH);
			}
		});

		frmMain.addJMIDodavanjeUpisaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmUpis(FrmMode.ADD);
			}
		});

		frmMain.addJMIBrisanjeUpisaActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MainCoordinator.getInstance().openFrmPretragaUpisa();
			}
		});

		frmMain.addJMILogoutActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					frmMain.dispose();
					Administrator admin = (Administrator) MainCoordinator.getInstance()
							.getParam(Constants.CURRENT_ADMIN);
					Communication.getInstance().logout(admin);

				} catch (Exception ex) {
					Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});

		frmMain.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Administrator admin = (Administrator) MainCoordinator.getInstance().getParam(Constants.CURRENT_ADMIN);
				try {
					Communication.getInstance().logout(admin);
				} catch (Exception ex) {
					Logger.getLogger(MainController.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		});
	}

	public FrmMain getFrmMain() {
		return frmMain;
	}
}
