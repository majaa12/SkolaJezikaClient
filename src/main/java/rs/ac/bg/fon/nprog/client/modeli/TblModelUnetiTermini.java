package rs.ac.bg.fon.nprog.client.modeli;

import rs.ac.bg.fon.nprog.common.domain.Adresa;
import rs.ac.bg.fon.nprog.common.domain.Kurs;
import rs.ac.bg.fon.nprog.common.domain.Profesor;
import rs.ac.bg.fon.nprog.common.domain.TerminKursa;
import java.math.BigDecimal;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

public class TblModelUnetiTermini extends AbstractTableModel {

	private final Kurs kurs;
	private final String[] kolone = new String[] { "Datum pocetka", "Datum zavrsetka", "Raspored", "Kapacitet",
			"Broj casova", "Cena", "Adresa", "Profesor", "IDTermina" };
	private final Class[] klase = new Class[] { Date.class, Date.class, String.class, Integer.class, Integer.class,
			BigDecimal.class, Adresa.class, Profesor.class, Long.class };

	public TblModelUnetiTermini() {
		kurs = new Kurs();
	}

	public TblModelUnetiTermini(Kurs kurs) {
		this.kurs = kurs;
	}

	@Override
	public int getRowCount() {
		if (kurs == null) {
			return 0;
		}
		return kurs.getTermini().size();
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		TerminKursa tk = kurs.getTermini().get(rowIndex);
		switch (columnIndex) {

		case 0:
			return tk.getDatumPocetka();
		case 1:
			return tk.getDatumZavrsetka();
		case 2:
			return tk.getRaspored();
		case 3:
			return tk.getKapacitet();
		case 4:
			return tk.getBrojCasova();
		case 5:
			return tk.getCena();
		case 6:
			return tk.getAdresa();
		case 7:
			return tk.getProfesor();
		case 8:
			return tk.getIDTermina();
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

	public Kurs getKurs() {
		return kurs;
	}

	public boolean dodajTermin(TerminKursa termin) {
		TerminKursa tk = new TerminKursa();
		tk.setDatumPocetka(termin.getDatumPocetka());
		tk.setDatumZavrsetka(termin.getDatumZavrsetka());
		tk.setRaspored(termin.getRaspored());
		tk.setKapacitet(termin.getKapacitet());
		tk.setBrojCasova(termin.getBrojCasova());
		tk.setCena(termin.getCena());
		tk.setProfesor(termin.getProfesor());
		tk.setAdresa(termin.getAdresa());
		tk.setKurs(kurs);

		if (kurs.exist(termin) == true) {
			return false;
		} else {
			kurs.getTermini().add(tk);
			System.out.println("DODAO");
		}
		fireTableDataChanged();
		return true;
	}

	public void obrisiTermin(int red) {
		kurs.getTermini().remove(red);
		fireTableDataChanged();
	}

	public TerminKursa getTermin(int red) {
		return kurs.getTermini().get(red);
	}

	public boolean izmeniTermin(TerminKursa termin, int red) {
		TerminKursa tk = kurs.getTermini().get(red);

		termin.setKurs(kurs);

		if (kurs.exist(termin) == true) {
			System.out.println("NEMA IZMENA! " + kurs.exist(termin) + "!");
			return false;
		} else {
			tk.setDatumPocetka(termin.getDatumPocetka());
			tk.setDatumZavrsetka(termin.getDatumZavrsetka());
			tk.setRaspored(termin.getRaspored());
			tk.setKapacitet(termin.getKapacitet());
			tk.setBrojCasova(termin.getBrojCasova());
			tk.setCena(termin.getCena());
			tk.setProfesor(termin.getProfesor());
			tk.setAdresa(termin.getAdresa());
			System.out.println("IZMENIO");
		}
		fireTableDataChanged();
		return true;
	}
}
