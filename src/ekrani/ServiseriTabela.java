package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaServiserima;
import model.Serviser;

public class ServiseriTabela extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Spec.", "Plata",
									   "Obrisan"
									 };
	
	public ServiseriTabela() {
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
		ArrayList<Serviser> serviseri = RadSaServiserima.ucitajServisere();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < serviseri.size(); i++) {
			Serviser serviser = serviseri.get(i);
			model.addRow(new Object[] {
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
			});
		}
		this.setModel(model);
	}
}
