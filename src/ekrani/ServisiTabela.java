package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;

import izlaz.RadSaServisima;
import modeli.Servis;

public class ServisiTabela extends JTable{
	
	// Delovi se ne prikazuju u tabeli
	private static String[] kolone = { "ID", "ID Auta", "Serviser",
									   "Termin", "Opis", "Status",
									   "Obrisan"
									 };
	private static Object[][] podaci = formatirajPodatke();
	
	public ServisiTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Servis> servisi = RadSaServisima.ucitajServise();
		Object[][] formatiraniPodaci = new Object[servisi.size()][];
		for(int i = 0; i < servisi.size(); i++) {
			Servis servis = servisi.get(i);
			formatiraniPodaci[i] = new Object[] {
					servis.getId(),
					servis.getAutomobil().getId(),
					servis.getServiser().getId() + "|" + servis.getServiser().getIme() + " " + servis.getServiser().getPrezime(),
					servis.getTermin(),
					servis.getOpis(),
					servis.getStatus(),
					servis.getObrisan()
			};
		}
		return formatiraniPodaci;
	}
}
