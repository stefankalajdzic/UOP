package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaAutomobilima;
import model.Automobil;
import model.Musterija;

public class AutomobiliTabelaZaMusterije extends JTable {

	private static final long serialVersionUID = 1L;
	
	private Musterija musterija;
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Marka",
									   "Model", "Godina proizvodnje", "Zapremina motora", 
							   		   "Snaga motora", "Vrsta goriva"
							   		   };
	
	public AutomobiliTabelaZaMusterije(Musterija musterija) {
		super();
		this.musterija = musterija;
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
		ArrayList<Automobil> automobili = RadSaAutomobilima.ucitajAutomobilePoMusteriji(musterija);
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < automobili.size(); i++) {
			Automobil auto = automobili.get(i);
			model.addRow(new Object[] {
					auto.getId(),
					auto.getMarka(),
					auto.getModel(),
					auto.getGodinaProizvodnje(),
					auto.getZapreminaMotora(),
					auto.getSnagaMotora(),
					auto.getVrstaGoriva()
			});	
		}
		this.setModel(model);
	}
}
