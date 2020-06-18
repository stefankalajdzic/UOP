package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;

import izlaz.RadSaServisnimKnjizicama;
import modeli.ServisnaKnjizica;

public class ServisneKnjiziceTabela extends JTable {
	
	// Lista servisa izostavljena
	private static String[] kolone = { "ID", "ID Auta", "Obrisan" };
	
	private static Object[][] podaci = formatirajPodatke();
	
	public ServisneKnjiziceTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<ServisnaKnjizica> servisneKnjizice = RadSaServisnimKnjizicama.ucitajServisneKnjizice();
		Object[][] formatiraniPodaci = new Object[servisneKnjizice.size()][];
		for(int i = 0; i < servisneKnjizice.size(); i++) {
			ServisnaKnjizica servisnaKnjizica = servisneKnjizice.get(i);
			formatiraniPodaci[i] = new Object[] {
					servisnaKnjizica.getId(),
					servisnaKnjizica.getAutomobil().getId(),
					servisnaKnjizica.getObrisan()
			};
		}
		return formatiraniPodaci;
	}
}
