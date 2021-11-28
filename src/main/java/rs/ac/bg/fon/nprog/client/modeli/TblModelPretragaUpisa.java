package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.common.domain.Adresa;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.common.domain.Upis;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class TblModelPretragaUpisa extends AbstractTableModel {

	private final ArrayList<Upis> lista;
	private final String[] kolone = new String[] { "Datum upisa", "Polaznik", "Kurs", "Pocetak", "Zavrsetak", "Adresa",
			"Cena", "Raspored", "Profesor" };
	private final Class[] klase = new Class[] { Date.class, Polaznik.class, Kurs.class, Date.class, Date.class,
			Adresa.class, BigDecimal.class, String.class, Profesor.class };

	public TblModelPretragaUpisa() {
		lista = new ArrayList<>();
	}

	public TblModelPretragaUpisa(ArrayList<Upis> lista) {
		this.lista = lista;
	}

	@Override
	public int getRowCount() {
		if (lista == null) {
			return 0;
		}
		return lista.size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Upis u = lista.get(rowIndex);
		switch (columnIndex) {

		case 0:
			return u.getDatumUpis();
		case 1:
			return u.getPolaznik();
		case 2:
			return u.getTerminKursa().getKurs().getTipKursa() + " " + u.getTerminKursa().getKurs().getJezik() + " "
					+ u.getTerminKursa().getKurs().getNivo();
		case 3:
			return u.getTerminKursa().getDatumPocetka();
		case 4:
			return u.getTerminKursa().getDatumZavrsetka();
		case 5:
			return u.getTerminKursa().getAdresa();
		case 6:
			return u.getTerminKursa().getCena();
		case 7:
			return u.getTerminKursa().getRaspored();
		case 8:
			return u.getTerminKursa().getProfesor();
		default:
			return "n/a";
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return klase[columnIndex];
	}

	public ArrayList<Upis> vratiUpise() {
		return lista;
	}

	public Upis vratiUpis(int red) {
		return lista.get(red);
	}
}
