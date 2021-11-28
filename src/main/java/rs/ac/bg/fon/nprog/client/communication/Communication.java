package rs.ac.bg.fon.nprog.client.communication;

import rs.ac.bg.fon.nprog.common.domain.Administrator;
import rs.ac.bg.fon.nprog.common.domain.Adresa;
import rs.ac.bg.fon.nprog.common.domain.Grad;
import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.common.domain.Upis;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import rs.ac.bg.fon.nprog.common.operation.Operation;
import rs.ac.bg.fon.nprog.common.transfer.Receiver;
import rs.ac.bg.fon.nprog.common.transfer.Request;
import rs.ac.bg.fon.nprog.common.transfer.Response;
import rs.ac.bg.fon.nprog.common.transfer.Sender;

public class Communication {

	Socket socket;
	Sender sender;
	Receiver receiver;
	private static Communication instance;

	private Communication() throws Exception {
		socket = new Socket(InetAddress.getLocalHost(), 9000);
		sender = new Sender(socket);
		receiver = new Receiver(socket);
	}

	public static Communication getInstance() throws Exception {
		if (instance == null) {
			instance = new Communication();
		}
		return instance;
	}

	public Administrator login(String username, String password) throws Exception {
		Administrator a = new Administrator();
		a.setKorisnickoIme(username);
		a.setLozinka(password);
		Request request = new Request(Operation.LOGIN, a);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (Administrator) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public void logout(Administrator administrator) throws Exception {
		Request request = new Request(Operation.LOGOUT, administrator);
		sender.send(request);
	}

	public void addPolaznik(Polaznik polaznik) throws Exception {
		Request request = new Request(Operation.ZAPAMTI_POLAZNIKA, polaznik);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}

	public ArrayList<Polaznik> pretraziPolaznike(Polaznik p) throws Exception {
		Request request = new Request(Operation.PRETRAZI_POLAZNIKE, p);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Polaznik>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public List<Jezik> vratiSveJezike() throws Exception {
		Jezik j = new Jezik();
		Request request = new Request(Operation.VRATI_JEZIKE, j);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Jezik>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public void addProfesor(Profesor profesor) throws Exception {
		Request request = new Request(Operation.ZAPAMTI_PROFESORA, profesor);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}

	public ArrayList<Profesor> pretraziProfesore(Profesor p) throws Exception {
		Request request = new Request(Operation.PRETRAZI_PROFESORE, p);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Profesor>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public List<Grad> vratiSveGradove() throws Exception {
		Grad g = new Grad();
		Request request = new Request(Operation.VRATI_GRADOVE, g);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Grad>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public ArrayList<Adresa> vratiAdreseIzabranogGrada(Adresa a) throws Exception {
		Request request = new Request(Operation.VRATI_ADRESE, a);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Adresa>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public void sacuvajKurs(Kurs kurs) throws Exception {
		Request request = new Request(Operation.SACUVAJ_KURS, kurs);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}

	public ArrayList<Kurs> pretraziKurseve(Kurs k) throws Exception {
		Request request = new Request(Operation.PRETRAZI_KURSEVE, k);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Kurs>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public void izmeniKurs(Kurs kurs) throws Exception {
		Request request = new Request(Operation.IZMENI_KURS, kurs);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}

	public void addUpis(Upis u) throws Exception {
		Request request = new Request(Operation.ZAPAMTI_UPIS, u);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}

	public ArrayList<Upis> pretraziUpise(Upis upis) throws Exception {
		Request request = new Request(Operation.PRETRAZI_UPISE, upis);

		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			return (ArrayList<Upis>) response.getResult();
		} else {
			throw response.getException();
		}
	}

	public void obrisiUpis(Upis u) throws Exception {
		Request request = new Request(Operation.OBRISI_UPIS, u);
		sender.send(request);
		Response response = (Response) receiver.receive();

		if (response.getException() == null) {
			System.out.println(response.getResult());
		} else {
			throw response.getException();
		}
	}
}
