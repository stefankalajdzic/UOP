package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;

import izlaz.RadSaDelovima;
import model.Deo;

public class DeloviTabela extends JTable {

	private static String[] kolone = { "ID", "Marka", "Model",
									   "Naziv", "Cena", "Obrisan"
									   };
	private static Object[][] podaci = formatirajPodatke();
	
	public DeloviTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Deo> delovi = RadSaDelovima.ucitajDelove();
		Object[][] formatiraniPodaci = new Object[delovi.size()][];
		for(int i = 0; i < delovi.size(); i++) {
			Deo deo = delovi.get(i);
			formatiraniPodaci[i] = new Object[] {
				deo.getId(),
				deo.getMarka(),
				deo.getModel(),
				deo.getNaziv(),
				deo.getCena(),
				deo.getObrisan()
			};
		}
		return formatiraniPodaci;
	}
}
