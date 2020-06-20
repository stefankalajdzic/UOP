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
	
	private AutomobiliTabelaZaMusterije automobiliTabela;
	private JScrollPane automobiliTabelaWraper;
	
	private Boolean firstPass = true;
	
	private ServisiTabelaZaMusterije servisiTabela;
	private JScrollPane servisiTabelaWraper;
	
	private MigLayout migLayout;
	
	public GlavniEkranMusterija(Musterija musterija) {
		super();
		
		migLayout = new MigLayout("fill");

		this.setLayout(migLayout);
		
		automobiliTabela = new AutomobiliTabelaZaMusterije(musterija);
		automobiliTabelaWraper = new JScrollPane(automobiliTabela);
		this.add(automobiliTabelaWraper, "span 3 1,growx");
		
		ListSelectionModel selectionModel = automobiliTabela.getSelectionModel();
		
		selectionModel.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				String id = (String)automobiliTabela.getValueAt(automobiliTabela.getSelectedRow(), 0);
				Automobil automobil = RadSaAutomobilima.ucitajAutomobil(id);
				if(firstPass) {
					servisiTabela = new ServisiTabelaZaMusterije(automobil);
					servisiTabelaWraper = new JScrollPane(servisiTabela);
					getThis().add(servisiTabelaWraper, "cell 0 3,growx");
					firstPass = false;
				} else {
					servisiTabela.osveziTabelu(automobil);
				}
			}
		});
		
		automobiliTabela.setRowSelectionInterval(0, 0);
	}
	
	private GlavniEkranMusterija getThis() {
		return this;
	}
}
