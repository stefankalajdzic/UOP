package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaDelovima;
import model.Deo;

public class DeloviTabela extends JTable {

	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Marka", "Model",
									   "Naziv", "Cena", "Obrisan"
									   };
	
	public DeloviTabela() {
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
		ArrayList<Deo> delovi = RadSaDelovima.ucitajDelove();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < delovi.size(); i++) {
			Deo deo = delovi.get(i);
			model.addRow(new Object[] {
				deo.getId(),
				deo.getMarka(),
				deo.getModel(),
				deo.getNaziv(),
				deo.getCena(),
				deo.getObrisan()
			});
		}
		this.setModel(model);;
	}
}
