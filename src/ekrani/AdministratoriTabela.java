package ekrani;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTable;

import izlaz.RadSaAdministratorima;
import modeli.Administrator;

public class AdministratoriTabela extends JTable {
	
	private static String[] kolone = { "ID", "Ime", "Prezime",
									   "JMBG", "Pol", "Adresa",
									   "Br. Tel.", "Korisnicko ime",
									   "Lozinka", "Plata", "Obrisan",
									 };
	private static Object[][] podaci = formatirajPodatke();
	
	public AdministratoriTabela() {
		super(podaci, kolone);
		
		this.setDefaultEditor(Object.class, null);
		
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent mouseEvent) {
				if(mouseEvent.getClickCount() == 2) {
					JTable table = (JTable)mouseEvent.getSource();
					String id = (String)podaci[table.getSelectedRow()][0];
					Administrator administrator = RadSaAdministratorima.ucitajAdministratora(id);
					new AdministratorEkran(300, 400, administrator);
				}
			}
			@Override
			public void mouseReleased(MouseEvent arg0) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				
			}
		});
	}
	
	private static Object[][] formatirajPodatke() {
		ArrayList<Administrator> administratori = RadSaAdministratorima.ucitajAdministratore();
		Object[][] formatiraniPodaci = new Object[administratori.size()][];
		for(int i = 0; i < administratori.size(); i++) {
			Administrator administrator = administratori.get(i);
			formatiraniPodaci[i] = new Object[] {
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
			};
		}
		return formatiraniPodaci;
	}
}
