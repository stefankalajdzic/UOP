package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaServisnimKnjizicama;
import model.ServisnaKnjizica;

public class ServisneKnjiziceTabela extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "ID Auta", "ID Servisa", "Obrisan" };
	
	public ServisneKnjiziceTabela() {
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
		ArrayList<ServisnaKnjizica> servisneKnjizice = RadSaServisnimKnjizicama.ucitajServisneKnjizice();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < servisneKnjizice.size(); i++) {
			ServisnaKnjizica servisnaKnjizica = servisneKnjizice.get(i);
			model.addRow(new Object[] {
					servisnaKnjizica.getId(),
					servisnaKnjizica.getAutomobil().getId(),
					servisnaKnjizica.toStringServisi(),
					servisnaKnjizica.getObrisan()
			});
		}
		this.setModel(model);
	}
}
