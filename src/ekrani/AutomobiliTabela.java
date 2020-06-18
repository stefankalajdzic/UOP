package ekrani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JTable;

import izlaz.RadSaAutomobilima;
import modeli.Automobil;

public class AutomobiliTabela extends JTable {
	
	private static String[] kolone = { "ID", "Vlasnik", "Marka",
									   "Model", "Godina proizvodnje", "Zapremina motora", 
							   		   "Snaga motora", "Vrsta goriva","S. Knjizica", "Obrisan"
							   		   };
	
	private static Object[][] podaci = formatirajPodatke();
	
	public AutomobiliTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Automobil> automobili = RadSaAutomobilima.ucitajAutomobile();
		Object[][] formatiraniPodaci = new Object[automobili.size()][];
		for(int i = 0; i < automobili.size(); i++) {
			Automobil auto = automobili.get(i);
			formatiraniPodaci[i] = new Object[] {
					auto.getId(),
					auto.getVlasnik().getId() + "|" + auto.getVlasnik().getIme() + " " + auto.getVlasnik().getPrezime(),
					auto.getMarka(),
					auto.getModel(),
					auto.getGodinaProizvodnje(),
					auto.getZapreminaMotora(),
					auto.getSnagaMotora(),
					auto.getVrstaGoriva(),
					auto.getServisnaKnjizica().getId(),
					auto.getObrisan()
			};	
		}
		return formatiraniPodaci;
	}
}
