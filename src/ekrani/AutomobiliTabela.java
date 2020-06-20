package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaAutomobilima;
import model.Automobil;

public class AutomobiliTabela extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Vlasnik", "Marka",
									   "Model", "Godina proizvodnje", "Zapremina motora", 
							   		   "Snaga motora", "Vrsta goriva", "Obrisan"
							   		   };
	
	public AutomobiliTabela() {
		super();
		postaviPodatke();
		this.setDefaultEditor(Object.class, null);
	}
	
	public void osveziTabelu() {
		DefaultTableModel dm = (DefaultTableModel) this.getModel();
		for(int i = this.getRowCount() - 1; i >= 0; i--) {
			dm.removeRow(i);
		}
		
		postaviPodatke();
	}
	
	private void postaviPodatke() {
		ArrayList<Automobil> automobili = RadSaAutomobilima.ucitajAutomobile();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < automobili.size(); i++) {
			Automobil auto = automobili.get(i);
			model.addRow(new Object[] {
					auto.getId(),
					auto.getVlasnik().getId() + "|" + auto.getVlasnik().getIme() + " " + auto.getVlasnik().getPrezime(),
					auto.getMarka(),
					auto.getModel(),
					auto.getGodinaProizvodnje(),
					auto.getZapreminaMotora(),
					auto.getSnagaMotora(),
					auto.getVrstaGoriva(),
					auto.getObrisan()
			});	
		}
		this.setModel(model);
	}
}
