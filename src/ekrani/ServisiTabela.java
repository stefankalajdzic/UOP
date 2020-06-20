package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaServisima;
import model.Servis;

public class ServisiTabela extends JTable{
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "ID Auta", "Serviser",
									   "Termin", "Opis", "Delovi", 
									   "Status", "Obrisan"
									 };
	
	public ServisiTabela() {
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
		ArrayList<Servis> servisi = RadSaServisima.ucitajServise();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < servisi.size(); i++) {
			Servis servis = servisi.get(i);
			model.addRow(new Object[] {
					servis.getId(),
					servis.getAutomobil().getId(),
					servis.getServiser().getId() + "|" + servis.getServiser().getIme() + " " + servis.getServiser().getPrezime(),
					servis.getTermin(),
					servis.getOpis(),
					servis.toStringDelovi(),
					servis.getStatus(),
					servis.getObrisan()
			});
		}
		this.setModel(model);
	}
}
