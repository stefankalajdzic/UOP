package ekrani;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

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
		
		// Delovi
		deloviTabela = new DeloviTabela();
		deloviTabelaWraper = new JScrollPane(deloviTabela);
		this.addTab("Delovi", deloviTabelaWraper);
		
		// Administratori
		administratoriTabela = new AdministratoriTabela();
		administratoriTabelaWraper = new JScrollPane(administratoriTabela);
		this.addTab("Administratori", administratoriTabelaWraper);
		
		// Musterije
		musterijeTabela = new MusterijeTabela();
		musterijeTabelaWraper = new JScrollPane(musterijeTabela);
		this.addTab("Musterije", musterijeTabelaWraper);
		
		servisiTabela = new ServisiTabela();
		servisiTabelaWraper = new JScrollPane(servisiTabela);
		this.addTab("Servisi", servisiTabelaWraper);
		
		serviseriTabela = new ServiseriTabela();
		serviseriTabelaWraper = new JScrollPane(serviseriTabela);
		this.addTab("Serviseri", serviseriTabelaWraper);
		
		servisneKnjiziceTabela = new ServisneKnjiziceTabela();
		servisneKnjiziceTabelaWraper = new JScrollPane(servisneKnjiziceTabela);
		this.add("Servisne Knjizie", servisneKnjiziceTabelaWraper );
	}
}
