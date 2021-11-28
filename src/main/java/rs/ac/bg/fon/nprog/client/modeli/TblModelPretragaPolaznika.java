package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.common.domain.Polaznik;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TblModelPretragaPolaznika extends AbstractTableModel {

	private final ArrayList<Polaznik> lista;
	private final String[] kolone = new String[] { "ID polaznika", "Ime", "Prezime", "JMBG", "Telefon", "Email",
			"Adresa" };
	private final Class[] klase = new Class[] { Long.class, String.class, String.class, String.class, String.class,
			String.class, String.class };

	public TblModelPretragaPolaznika() {
		lista = new ArrayList<>();
	}

	public TblModelPretragaPolaznika(ArrayList<Polaznik> lista) {
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
		Polaznik p = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getIDPolaznika();
		case 1:
			return p.getIme();
		case 2:
			return p.getPrezime();
		case 3:
			return p.getJmbg();
		case 4:
			return p.getTelefon();
		case 5:
			return p.getEmail();
		case 6:
			return p.getAdresa();
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

	public ArrayList<Polaznik> vratiPolaznike() {
		return lista;
	}

	public Polaznik vratiPolaznika(int red) {
		return lista.get(red);
	}
}
