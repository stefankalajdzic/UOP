package ekrani;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import enumeracije.Gorivo;
import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import izlaz.RadSaAutomobilima;
import model.Automobil;

public class AutomobilEkran extends JDialog {
	
	private Automobil automobil;
	
	private JTextField id, vlasnik, godinaProizvodnje, zapreminaMotora, snagaMotora;
	private JComboBox<String> marka, model, gorivo;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public AutomobilEkran(Automobil automobil) {
		super(null, "Automobil", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);
		
		id = new JTextField();
		vlasnik = new JTextField();
		marka = new JComboBox(MarkaAutomobila.values());
		model = new JComboBox(ModelAutomobila.values());
		godinaProizvodnje = new JTextField();
		zapreminaMotora = new JTextField();
		snagaMotora = new JTextField();
		gorivo = new JComboBox(Gorivo.values());
		obrisan = new JCheckBox();

		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		if(automobil != null) {
			this.automobil = automobil;
			popuniPodatke();
		}
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(9, 2);
		this.setLayout(gl);
		
		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);
		
		// Vlasnik
		
		this.add(new JLabel("Marka: ", SwingConstants.RIGHT));
		this.add(marka);
		
		this.add(new JLabel("Model: ", SwingConstants.RIGHT));
		this.add(model);
		
		this.add(new JLabel("Godina proizvodnje: ", SwingConstants.RIGHT));
		this.add(godinaProizvodnje);

		this.add(new JLabel("Zapremina motora: ", SwingConstants.RIGHT));
		this.add(zapreminaMotora);

		this.add(new JLabel("Snaga motora: ", SwingConstants.RIGHT));
		this.add(snagaMotora);

		this.add(new JLabel("Tip goriva: ", SwingConstants.RIGHT));
		this.add(gorivo);

		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
	}
	
	private void popuniPodatke() {
		id.setText(automobil.getId());
		// vlasnik
		marka.setSelectedIndex(automobil.getMarka().ordinal());
		model.setSelectedIndex(automobil.getModel().ordinal());
		godinaProizvodnje.setText(automobil.getGodinaProizvodnje());
		zapreminaMotora.setText(Float.toString(automobil.getZapreminaMotora()));
		snagaMotora.setText(Integer.toString(automobil.getSnagaMotora()));
		gorivo.setSelectedIndex(automobil.getVrstaGoriva().ordinal());
		obrisan.setSelected(automobil.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(automobil == null) {
					automobil = new Automobil();
					izmena = false;
				}
				
				Float zapremina = (float) 0.0;
				int snaga = 0;
				try {
					zapremina = Float.parseFloat(zapreminaMotora.getText());
					snaga = Integer.parseInt(snagaMotora.getText());
				} catch (Exception ex) { }
 				
				automobil.setMarka(MarkaAutomobila.values()[marka.getSelectedIndex()]);
				automobil.setModel(ModelAutomobila.values()[model.getSelectedIndex()]);
				automobil.setGodinaProizvodnje(godinaProizvodnje.getText());
				automobil.setZapreminaMotora(zapremina);
				automobil.setSnagaMotora(snaga);
				automobil.setVrstaGoriva(Gorivo.values()[gorivo.getSelectedIndex()]);
				automobil.setObrisan(obrisan.isSelected());
				
				if(izmena) {
					RadSaAutomobilima.izmeniAutomobil(automobil);
				} else {
					RadSaAutomobilima.dodajAutomobil(automobil);
				}
				
				ugasi();
			}
		});
		
		this.odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ugasi();
			}
		});
	}
	
	private void ugasi() {
		this.dispose();
	}
}
