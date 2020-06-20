package ekrani;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import izlaz.RadSaAdministratorima;
import model.Administrator;

public class GlavniEkranAdmin extends JTabbedPane {
	
	private AutomobiliTabela automobiliTabela;
	private JScrollPane automobiliTabelaWraper;
	
	private DeloviTabela deloviTabela;
	private JScrollPane deloviTabelaWraper;
	
	private MusterijeTabela musterijeTabela;
	private JScrollPane musterijeTabelaWraper;
	
	private ServisiTabela servisiTabela;
	private JScrollPane servisiTabelaWraper;
	
	private ServiseriTabela serviseriTabela;
	private JScrollPane serviseriTabelaWraper;
	
	private ServisneKnjiziceTabela servisneKnjiziceTabela;
	private JScrollPane servisneKnjiziceTabelaWraper;
	
	private AdministratoriTabela administratoriTabela;
	private JScrollPane administratoriTabelaWraper;

	public GlavniEkranAdmin() {
		super();
		
		// Automobili
		automobiliTabela = new AutomobiliTabela();
		automobiliTabelaWraper = new JScrollPane(automobiliTabela);
		this.addTab("Automobili", automobiliTabelaWraper);

		// Servisne Knjizice
		servisneKnjiziceTabela = new ServisneKnjiziceTabela();
		servisneKnjiziceTabelaWraper = new JScrollPane(servisneKnjiziceTabela);
		this.add("Servisne Knjizice", servisneKnjiziceTabelaWraper );

		// Servisi
		servisiTabela = new ServisiTabela();
		servisiTabelaWraper = new JScrollPane(servisiTabela);
		this.addTab("Servisi", servisiTabelaWraper);
		
		// Delovi
		deloviTabela = new DeloviTabela();
		deloviTabelaWraper = new JScrollPane(deloviTabela);
		this.addTab("Delovi", deloviTabelaWraper);

		// Musterije
		musterijeTabela = new MusterijeTabela();
		musterijeTabelaWraper = new JScrollPane(musterijeTabela);
		this.addTab("Musterije", musterijeTabelaWraper);

		// Serviseri
		serviseriTabela = new ServiseriTabela();
		serviseriTabelaWraper = new JScrollPane(serviseriTabela);
		this.addTab("Serviseri", serviseriTabelaWraper);
		
		// Administratori
		administratoriTabela = new AdministratoriTabela();
		administratoriTabelaWraper = new JScrollPane(administratoriTabela);
		this.addTab("Administratori", administratoriTabelaWraper);
	}
	
	public void dodajIzmeni(Boolean dodaj) {
		if(dodaj) {
			switch (this.getSelectedIndex()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				new AdministratorEkran(null);
				
				administratoriTabela.osveziTabelu();
				break;
			}
		} else {
			switch (this.getSelectedIndex()) {
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
			case 6:
				if(administratoriTabela.getSelectedRow() != -1) {
					int row = administratoriTabela.getSelectedRow();
					String id = (String)administratoriTabela.getModel().getValueAt(row, 0);	
					Administrator administrator = RadSaAdministratorima.ucitajAdministratora(id);
					new AdministratorEkran(administrator);
					
					administratoriTabela.osveziTabelu();
				}
				break;
			}
		}
	}
}
