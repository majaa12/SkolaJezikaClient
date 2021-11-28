package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TblModelPretragaProfesora extends AbstractTableModel {

	private final ArrayList<Profesor> lista;
	private final String[] kolone = new String[] { "ID profesora", "Ime", "Prezime", "Telefon", "Email", "Jezik" };
	private final Class[] klase = new Class[] { Long.class, String.class, String.class, String.class, String.class,
			Jezik.class };

	public TblModelPretragaProfesora() {
		lista = new ArrayList<>();
	}

	public TblModelPretragaProfesora(ArrayList<Profesor> lista) {
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
		Profesor p = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getIDProfesora();
		case 1:
			return p.getIme();
		case 2:
			return p.getPrezime();
		case 3:
			return p.getTelefon();
		case 4:
			return p.getEmail();
		case 5:
			return p.getJezik();
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

	public ArrayList<Profesor> vratiProfesore() {
		return lista;
	}

	public Profesor vratiProfesora(int red) {
		return lista.get(red);
	}
}
