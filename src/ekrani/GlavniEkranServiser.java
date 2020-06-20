package ekrani;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import izlaz.RadSaServisima;
import model.Servis;
import model.Serviser;

public class GlavniEkranServiser extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private ServisiTabelaZaServisere servisiTabela;
	private JScrollPane servisiTabelaWraper;
	
	public GlavniEkranServiser(Serviser serviser) {
		super();
		
		servisiTabela = new ServisiTabelaZaServisere(serviser);
		servisiTabelaWraper = new JScrollPane(servisiTabela);
		this.add("Servisi", servisiTabelaWraper);
	}
	
	public void dodajIzmeni(Boolean dodaj) {
		if(dodaj) {
			new ServisEkran(null, true);
			
			servisiTabela.osveziTabelu();
		} else {
			int row = servisiTabela.getSelectedRow();
			if(row != -1) { 
				String id = (String)servisiTabela.getModel().getValueAt(row, 0);
				Servis servis = RadSaServisima.ucitajServis(id);
				new ServisEkran(servis, false);
				
				servisiTabela.osveziTabelu();
			}
		}
	}
}
