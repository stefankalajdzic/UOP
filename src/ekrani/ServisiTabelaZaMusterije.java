package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaServisima;
import model.Automobil;
import model.Servis;

public class ServisiTabelaZaMusterije extends JTable {

	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Serviser",
									   "Termin", "Opis", "Delovi", 
									   "Status"
									 };
	
	public ServisiTabelaZaMusterije(Automobil automobil) {
		super();
		postaviPodatke(automobil);
		this.setDefaultEditor(Object.class, null);
	}
	
	public void osveziTabelu(Automobil automobil) {
		DefaultTableModel dm = (DefaultTableModel) this.getModel();
		for(int i = this.getRowCount() - 1; i >= 0; i-- ) {
			dm.removeRow(i);
		}
		
		postaviPodatke(automobil);
	}
	
	private void postaviPodatke(Automobil automobil) {
		ArrayList<Servis> servisi = RadSaServisima.ucitajServisePoAutomobilu(automobil);
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < servisi.size(); i++) {
			Servis servis = servisi.get(i);
			model.addRow(new Object[] {
					servis.getId(),
					servis.getServiser().getIme() + " " + servis.getServiser().getPrezime(),
					servis.getTermin(),
					servis.getOpis(),
					servis.toStringDelovi(),
					servis.getStatus()
			});
		}
		this.setModel(model);
	}
}
