package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.common.domain.Jezik;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Nivo;
import rs.ac.bg.fon.nprog.common.domain.TipKursa;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class TblModelPretragaKurseva extends AbstractTableModel {

	private final ArrayList<Kurs> lista;
	private final String[] kolone = new String[] { "ID Kursa", "Naziv", "Nivo", "Tip kursa", "Jezik" };
	private final Class[] klase = new Class[] { Long.class, String.class, Nivo.class, TipKursa.class, Jezik.class };

	public TblModelPretragaKurseva() {
		lista = new ArrayList<>();
	}

	public TblModelPretragaKurseva(ArrayList<Kurs> lista) {
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
		Kurs k = lista.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getIDKursa();
		case 1:
			return k.getNaziv();
		case 2:
			return k.getNivo();
		case 3:
			return k.getTipKursa();
		case 4:
			return k.getJezik();
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

	public ArrayList<Kurs> vratiKurseve() {
		return lista;
	}

	public Kurs vratiKurs(int red) {
		return lista.get(red);
	}
}
