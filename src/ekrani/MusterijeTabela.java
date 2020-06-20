package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaMusterijama;
import model.Musterija;

public class MusterijeTabela extends JTable {

	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Poeni", "Obrisan",
									 };
	
	public MusterijeTabela() {
		super();
		postaviPodatke();
		this.setDefaultEditor(Object.class, null);
	}

	public void osveziTabelu() {
		DefaultTableModel dm = (DefaultTableModel) this.getModel();
		for(int i = this.getRowCount() - 1; i >= 0; i-- ) {
			dm.removeRow(i);
		}
		
		postaviPodatke();
	}

	private void postaviPodatke() {
		ArrayList<Musterija> musterije= RadSaMusterijama.ucitajMusterije();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < musterije.size(); i++) {
			Musterija musterija = musterije.get(i);
			model.addRow(new Object[] {
					musterija.getId(),
					musterija.getIme(),
					musterija.getPrezime(),
					musterija.getJmbg(),
					musterija.getPol(),
					musterija.getAdresa(),
					musterija.getBrojTelefona(),
					musterija.getKorisnickoIme(),
					musterija.getLozinka(),
					musterija.getBrojNagradnihBodova(),
					musterija.getObrisan()
			});
		}
		this.setModel(model);
	}

}
