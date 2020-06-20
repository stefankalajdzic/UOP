package ekrani;

import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import izlaz.RadSaAdministratorima;
import model.Administrator;

public class AdministratoriTabela extends JTable {
	
	private static final long serialVersionUID = 1L;
	
	private static DefaultTableModel model;
	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Plata", "Obrisan",
									 };
	
	public AdministratoriTabela() {
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
		ArrayList<Administrator> administratori = RadSaAdministratorima.ucitajAdministratore();
		model = new DefaultTableModel(kolone, 0);
		for(int i = 0; i < administratori.size(); i++) {
			Administrator administrator = administratori.get(i);
			model.addRow(new Object[] {
					administrator.getId(),
					administrator.getIme(),
					administrator.getPrezime(),
					administrator.getJmbg(),
					administrator.getPol(),
					administrator.getAdresa(),
					administrator.getBrojTelefona(),
					administrator.getKorisnickoIme(),
					administrator.getLozinka(),
					administrator.getPlata(),
					administrator.getObrisan()
			});
		}
		this.setModel(model);
	}
}
