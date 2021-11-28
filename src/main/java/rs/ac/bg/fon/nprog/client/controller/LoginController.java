package rs.ac.bg.fon.nprog.client.controller;

import rs.ac.bg.fon.nprog.client.communication.Communication;
import rs.ac.bg.fon.nprog.client.constants.Constants;
import rs.ac.bg.fon.nprog.client.coordinator.MainCoordinator;
import rs.ac.bg.fon.nprog.common.domain.Administrator;
import rs.ac.bg.fon.nprog.client.forms.FrmLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class LoginController {

	private final FrmLogin frmLogin;

	public LoginController(FrmLogin frmLogin) {
		this.frmLogin = frmLogin;
		addActionListener();
	}

	public void openForm() {
		frmLogin.setVisible(true);
		frmLogin.setLocationRelativeTo(null);
	}

	private void addActionListener() {

		frmLogin.addBtnLoginActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				login(event);
			}

			private void login(ActionEvent event) {
				try {
					String username = frmLogin.getTxtUsername().getText().trim();
					String password = String.copyValueOf(frmLogin.getTxtPassword().getPassword());

					if (username.equals("") || password.equals("")) {
						JOptionPane.showMessageDialog(frmLogin, "Sva polja su obavezna!", "Greska",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					Administrator admin = Communication.getInstance().login(username, password);
					MainCoordinator.getInstance().addParam(Constants.CURRENT_ADMIN, admin);
					JOptionPane.showMessageDialog(frmLogin,
							"Uspesno ste se prijavili!\nDobrodosli: " + admin.getIme() + " " + admin.getPrezime(),
							"Login", JOptionPane.INFORMATION_MESSAGE);

					frmLogin.dispose();
					MainCoordinator.getInstance().openMainForm();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(frmLogin, ex.getMessage(), "Login error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
