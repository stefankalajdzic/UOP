package ekrani;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
import izlaz.RadSaMusterijama;
import izlaz.RadSaServisnimKnjizicama;
import model.Automobil;
import model.Musterija;
import model.ServisnaKnjizica;

public class AutomobilEkran extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private Automobil automobil;
	private Musterija musterija;
	private ArrayList<Musterija> musterije;
	
	private JTextField id, godinaProizvodnje, zapreminaMotora, snagaMotora;
	private JComboBox<String> vlasnik;
	private JComboBox<MarkaAutomobila> marka;
	private JComboBox<ModelAutomobila> model; 
	private JComboBox<Gorivo> gorivo;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public AutomobilEkran(Automobil automobil, Musterija musterija) {
		super(null, "Automobil", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);
		
		this.setMusterija(musterija);
		musterije = RadSaMusterijama.ucitajMusterije();
		
		id = new JTextField();
		vlasnik = new JComboBox<String>();
		for(int i = 0; i < musterije.size(); i++) {
			this.vlasnik.addItem(musterije.get(i).getId() + "|" + musterije.get(i).getIme() + " " + musterije.get(i).getPrezime());
			if(musterija != null) {
				if(musterije.get(i).getId().equals(musterija.getId())) {
					this.vlasnik.setSelectedIndex(i);
				}				
			}
		}
		marka = new JComboBox<MarkaAutomobila>(MarkaAutomobila.values());
		model = new JComboBox<ModelAutomobila>(ModelAutomobila.values());
		godinaProizvodnje = new JTextField();
		zapreminaMotora = new JTextField();
		snagaMotora = new JTextField();
		gorivo = new JComboBox<Gorivo>(Gorivo.values());
		obrisan = new JCheckBox();

		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		if(automobil != null) {
			this.automobil = automobil;
			popuniPodatke();
		}
		
		if(musterija != null) {
			this.vlasnik.setEnabled(false);
			this.obrisan.setEnabled(false);
		}
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(10, 2);
		this.setLayout(gl);
		
		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);
		
		this.add(new JLabel("Vlasnik: ", SwingConstants.RIGHT));
		this.add(vlasnik);
		
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
		for(int i = 0; i < musterije.size(); i++) {
			String item = vlasnik.getItemAt(i);
			Musterija vlasnik = automobil.getVlasnik();
			if(item.startsWith(vlasnik.getId() + "|") &&
			   item.contains(vlasnik.getIme()) &&
			   item.contains(vlasnik.getPrezime())) {
				this.vlasnik.setSelectedIndex(i);
			}
		}
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
 				
				String vlasnikId = ((String)vlasnik.getSelectedItem()).split("|")[0];
				automobil.setVlasnik(RadSaMusterijama.ucitajMusteriju(vlasnikId));
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
					Automobil povratniAutomobil = RadSaAutomobilima.dodajAutomobil(automobil);
					ServisnaKnjizica servisnaKnjizica = new ServisnaKnjizica();
					servisnaKnjizica.setAutomobil(povratniAutomobil);
					RadSaServisnimKnjizicama.dodajServisnuKnjizicu(servisnaKnjizica);
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

	public Musterija getMusterija() {
		return musterija;
	}

	public void setMusterija(Musterija musterija) {
		this.musterija = musterija;
	}
}
