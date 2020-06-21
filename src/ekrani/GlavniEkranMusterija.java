package ekrani;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import izlaz.RadSaAutomobilima;
import model.Automobil;
import model.Musterija;
import net.miginfocom.swing.MigLayout;

public class GlavniEkranMusterija extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private Musterija musterija;
	private Automobil automobil;
	
	private AutomobiliTabelaZaMusterije automobiliTabela;
	private JScrollPane automobiliTabelaWraper;
	
	private Boolean firstPass = true;
	
	private ServisiTabelaZaMusterije servisiTabela;
	private JScrollPane servisiTabelaWraper;
	
	private MigLayout migLayout;
	
	public GlavniEkranMusterija(Musterija musterija) {
		super();
		
		this.musterija = musterija;
		
		migLayout = new MigLayout("fill");

		this.setLayout(migLayout);
		
		automobiliTabela = new AutomobiliTabelaZaMusterije(musterija);
		automobiliTabelaWraper = new JScrollPane(automobiliTabela);
		this.add(automobiliTabelaWraper, "span 3 1,growx");
		
		ListSelectionModel selectionModel = automobiliTabela.getSelectionModel();
		
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(automobiliTabela.getSelectedRow() != -1) {
					String id = (String)automobiliTabela.getValueAt(automobiliTabela.getSelectedRow(), 0);
					Automobil automobil = RadSaAutomobilima.ucitajAutomobil(id);
					setAutomobil(automobil);
					if(firstPass) {
						servisiTabela = new ServisiTabelaZaMusterije(automobil);
						servisiTabelaWraper = new JScrollPane(servisiTabela);
						getThis().add(servisiTabelaWraper, "cell 0 3,growx");
						firstPass = false;
					} else {
						servisiTabela.osveziTabelu(automobil);
					}
				}
			}
		});
		
		automobiliTabela.setRowSelectionInterval(0, 0);
	}
	
	private void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}
	
	public void dodajAuto() {
		if(automobiliTabela.getSelectedRow() != -1) {
			new AutomobilEkran(null, this.musterija);
			
			this.automobiliTabela.osveziTabelu();
		}
	}
	
	public void dodajServis() {
		new ServisEkran(null, false, automobil);
		
		this.servisiTabela.osveziTabelu(automobil);
	}
	
	private GlavniEkranMusterija getThis() {
		return this;
	}
}
