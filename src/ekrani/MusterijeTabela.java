package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import izlaz.RadSaMusterijama;
import model.Musterija;

public class MusterijeTabela extends JTable {

	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Poeni", "Obrisan",
									 };
	private static Object[][] podaci = formatirajPodatke();
	
	public MusterijeTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Musterija> musterije= RadSaMusterijama.ucitajMusterije();
		Object[][] formatiraniPodaci = new Object[musterije.size()][];
		for(int i = 0; i < musterije.size(); i++) {
			Musterija musterija = musterije.get(i);
			formatiraniPodaci[i] = new Object[] {
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
			};
		}
		return formatiraniPodaci;
	}

}
