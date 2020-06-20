package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;

import izlaz.RadSaAdministratorima;
import izlaz.RadSaServiserima;
import model.Administrator;
import model.Serviser;

public class ServiseriTabela extends JTable {
	
	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Spec.", "Plata",
									   "Obrisan"
									 };
	private static Object[][] podaci = formatirajPodatke();
	
	public ServiseriTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Serviser> serviseri = RadSaServiserima.ucitajServisere();
		Object[][] formatiraniPodaci = new Object[serviseri.size()][];
		for(int i = 0; i < serviseri.size(); i++) {
			Serviser serviser = serviseri.get(i);
			formatiraniPodaci[i] = new Object[] {
					serviser.getId(),
					serviser.getIme(),
					serviser.getPrezime(),
					serviser.getJmbg(),
					serviser.getPol(),
					serviser.getAdresa(),
					serviser.getBrojTelefona(),
					serviser.getKorisnickoIme(),
					serviser.getLozinka(),
					serviser.getSpecijalizacija(),
					serviser.getPlata(),
					serviser.getObrisan()
			};
		}
		return formatiraniPodaci;
	}
}
