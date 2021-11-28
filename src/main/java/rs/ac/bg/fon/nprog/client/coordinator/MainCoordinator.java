package rs.ac.bg.fon.nprog.client.coordinator;

import rs.ac.bg.fon.nprog.client.controller.KursController;
import rs.ac.bg.fon.nprog.client.controller.LoginController;
import rs.ac.bg.fon.nprog.client.controller.MainController;
import rs.ac.bg.fon.nprog.client.controller.PolaznikController;
import rs.ac.bg.fon.nprog.client.controller.PretragaKursevaController;
import rs.ac.bg.fon.nprog.client.controller.PretragaPolaznikaController;
import rs.ac.bg.fon.nprog.client.controller.PretragaProfesoraController;
import rs.ac.bg.fon.nprog.client.controller.PretragaUpisaController;
import rs.ac.bg.fon.nprog.client.controller.ProfesorController;
import rs.ac.bg.fon.nprog.client.controller.UpisController;
import rs.ac.bg.fon.nprog.client.form_mode.FrmMode;
import rs.ac.bg.fon.nprog.client.forms.FrmKurs;
import rs.ac.bg.fon.nprog.client.forms.FrmLogin;
import rs.ac.bg.fon.nprog.client.forms.FrmMain;
import rs.ac.bg.fon.nprog.client.forms.FrmPolaznik;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaKurseva;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaPolaznika;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaProfesora;
import rs.ac.bg.fon.nprog.client.forms.FrmPretragaUpisa;
import rs.ac.bg.fon.nprog.client.forms.FrmProfesor;
import rs.ac.bg.fon.nprog.client.forms.FrmUpis;
import java.util.HashMap;
import java.util.Map;

public class MainCoordinator {

	private static MainCoordinator instance;
    private final MainController mainController;
    
    private final Map<String, Object> params;

    private MainCoordinator() {
        mainController = new MainController(new FrmMain());
        params = new HashMap<>();
    }

    public static MainCoordinator getInstance() {
        if (instance == null) {
            instance = new MainCoordinator();
        }
        return instance;
    }

    public void openLoginForm() {
        LoginController loginController = new LoginController(new FrmLogin());
        loginController.openForm();
    }

    public void openMainForm() {
        mainController.openForm();
    }

    //POLAZNIK CONTROLLER
    public void openFrmPolaznik(FrmMode frmMode) {
        PolaznikController polaznikController = new PolaznikController(new FrmPolaznik(mainController.getFrmMain(), true));
        polaznikController.openForm(frmMode);
    }

    //PRETRAGA POLAZNIKA CONTROLLER
    public void openFrmPretragaPolaznika(FrmMode frmMode) {
        PretragaPolaznikaController pretragaPolazController = new PretragaPolaznikaController(new FrmPretragaPolaznika(mainController.getFrmMain(), true));
        pretragaPolazController.openForm(frmMode);

    }

    //PROFESOR CONTROLLER
    public void openFrmProfesor(FrmMode frmMode) {
        ProfesorController profesorController = new ProfesorController(new FrmProfesor(mainController.getFrmMain(), true));
        profesorController.openForm(frmMode);
    }

    //PRETRAGA PROFESORA CONTROLLER
    public void openFrmPretragaProfesora() {
        PretragaProfesoraController pretragaProfController = new PretragaProfesoraController(new FrmPretragaProfesora(mainController.getFrmMain(), true));
        pretragaProfController.openForm();
    }

    //KURS CONTROLLER
    public void openFrmKurs(FrmMode frmMode) {
        KursController kursController = new KursController(new FrmKurs(mainController.getFrmMain(), true));
        kursController.openForm(frmMode);
    }

    //PRETRAGA KURSEVA CONTROLLER
    public void openFrmPretragaKurseva(FrmMode frmMode) {
        PretragaKursevaController pretragaKursevaController = new PretragaKursevaController(new FrmPretragaKurseva(mainController.getFrmMain(), true));
        pretragaKursevaController.openForm(frmMode);
    }

    
    //UPIS CONTROLLER
    public void openFrmUpis(FrmMode frmMode) {
        UpisController upisController = new UpisController(new FrmUpis(mainController.getFrmMain(), true));
        upisController.openForm(frmMode);
    }

    //PRETRAGA UPISA CCONTROLLER
    public void openFrmPretragaUpisa() {
        PretragaUpisaController pretragaUpicaController = new PretragaUpisaController(new FrmPretragaUpisa(mainController.getFrmMain(), true));
        pretragaUpicaController.openForm();
    }

    public void addParam(String key, Object value) {
        params.put(key, value);
    }

    public Object getParam(String key) {
        return params.get(key);
    }

    public MainController getMainController() {
        return mainController;
    }
}
