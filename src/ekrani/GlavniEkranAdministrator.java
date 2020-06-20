package ekrani;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JViewport;

import izlaz.RadSaAdministratorima;
import izlaz.RadSaAutomobilima;
import izlaz.RadSaDelovima;
import izlaz.RadSaMusterijama;
import izlaz.RadSaServiserima;
import izlaz.RadSaServisima;
import izlaz.RadSaServisnimKnjizicama;
import model.Administrator;
import model.Automobil;
import model.Deo;
import model.Musterija;
import model.Servis;
import model.Serviser;
import model.ServisnaKnjizica;

public class GlavniEkranAdministrator extends JTabbedPane {
	
	private static final long serialVersionUID = 1L;
	
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

	public GlavniEkranAdministrator() {
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
			// Automobili
			case 0:
				new AutomobilEkran(null);
				
				automobiliTabela.osveziTabelu();
				break;
				
			// Servisne knjizice - kreiraju se sa unosenjem automobila u sistem
			// ne mogu da se dodaju same za sebe
			case 1:
				break;
				
			// Servisi
			case 2:
				new ServisEkran(null, false);
				
				servisiTabela.osveziTabelu();
				break;
				
			// Delovi
			case 3:
				new DeoEkran(null);
				
				deloviTabela.osveziTabelu();
				break;
				
			// Musterije
			case 4:
				new MusterijaEkran(null);
				
				musterijeTabela.osveziTabelu();
				break;
				
			// Serviseri
			case 5:
				new ServiserEkran(null);
				
				serviseriTabela.osveziTabelu();
				break;
				
			// Administratori
			case 6:
				new AdministratorEkran(null);
				
				administratoriTabela.osveziTabelu();
				break;
			}
		} else {
			int row = ((JTable)((JViewport)((JScrollPane)this.getSelectedComponent()).getComponents()[0]).getComponents()[0]).getSelectedRow();
			switch (this.getSelectedIndex()) {
			// Automobili
			case 0:
				if(row != -1) {
					String id = (String)automobiliTabela.getModel().getValueAt(row, 0);
					Automobil automobil = RadSaAutomobilima.ucitajAutomobil(id);
					new AutomobilEkran(automobil);
					
					automobiliTabela.osveziTabelu();
				}
				
				break;
				
			// Servisne knjizice
			case 1:
				if(row != -1) {
					String id = (String)servisneKnjiziceTabela.getModel().getValueAt(row, 0);
					ServisnaKnjizica servisnaKnjizica = RadSaServisnimKnjizicama.ucitajServisnuKnjizicu(id);
					new ServisnaKnjizicaEkran(servisnaKnjizica);
					
					automobiliTabela.osveziTabelu();
					servisiTabela.osveziTabelu();
					servisneKnjiziceTabela.osveziTabelu();
				}
				
				break;
				
			// Servisi
			case 2:
				if(row != -1) { 
					String id = (String)servisiTabela.getModel().getValueAt(row, 0);
					Servis servis = RadSaServisima.ucitajServis(id);
					new ServisEkran(servis, false);
					
					servisiTabela.osveziTabelu();
				}
				
				break;
				
			// Delovi
			case 3:
				if(row != -1) {
					String id = (String)deloviTabela.getModel().getValueAt(row, 0);
					Deo deo = RadSaDelovima.ucitajDeo(id);
					new DeoEkran(deo);
					
					deloviTabela.osveziTabelu();
				}
				
				break;
				
			// Musterije
			case 4:
				if(row != -1) {
					String id = (String)musterijeTabela.getModel().getValueAt(row, 0);
					Musterija musterija = RadSaMusterijama.ucitajMusteriju(id);
					new MusterijaEkran(musterija);
					
					musterijeTabela.osveziTabelu();
				}
				
				break;
				
			// Serviseri
			case 5:
				if(row != -1) {
					String id = (String)serviseriTabela.getModel().getValueAt(row, 0);
					Serviser serviser = RadSaServiserima.ucitajServisera(id);
					new ServiserEkran(serviser);
					
					serviseriTabela.osveziTabelu();
				}
				
				break;
				
			// Administratori
			case 6:
				if(row != -1) {
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
