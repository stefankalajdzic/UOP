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

import enumeracije.StatusServisa;
import izlaz.RadSaAutomobilima;
import izlaz.RadSaDelovima;
import izlaz.RadSaServiserima;
import izlaz.RadSaServisima;
import model.Automobil;
import model.Servis;
import model.Serviser;

public class ServisEkran extends JDialog {
	
	private static final long serialVersionUID = 1L;
	
	private Servis servis;
	private Boolean flag;
	
	private ArrayList<Automobil> automobili;
	private ArrayList<Serviser> serviseri;
	
	private JTextField id, termin, opis, delovi;
	private JComboBox<String> automobil, serviser;
	private JComboBox<StatusServisa> status;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public ServisEkran(Servis servis, Boolean flag) {
		super(null, "Servis", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 300));
		this.setLocationRelativeTo(null);

		this.flag = flag;
		
		automobili = RadSaAutomobilima.ucitajAutomobile();
		serviseri = RadSaServiserima.ucitajServisere();

		id = new JTextField();
		automobil = new JComboBox<String>();
		for(Automobil automobil : automobili) {
			this.automobil.addItem(automobil.getId());
		}
		serviser = new JComboBox<String>();
		for(Serviser serviser : serviseri) {
			this.serviser.addItem(serviser.getId() + "|" + serviser.getIme() + " " + serviser.getPrezime());
		}
		termin = new JTextField();
		opis = new JTextField();
		delovi = new JTextField();
		status = new JComboBox<StatusServisa>(StatusServisa.values());
		obrisan = new JCheckBox();
		
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");

		if(servis != null) {
			this.servis = servis;
			popuniPodatke();
		}
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(9, 2);
		this.setLayout(gl);

		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);
		
		this.add(new JLabel("Automobil: ", SwingConstants.RIGHT));
		this.add(automobil);

		this.add(new JLabel("Serviser: ", SwingConstants.RIGHT));
		this.add(serviser);
		if(flag) {
			serviser.setEnabled(false);
		}

		this.add(new JLabel("Termin: ", SwingConstants.RIGHT));
		this.add(termin);

		this.add(new JLabel("Opis: ", SwingConstants.RIGHT));
		this.add(opis);
		
		this.add(new JLabel("Delovi: ", SwingConstants.RIGHT));
		this.add(delovi);
		
		this.add(new JLabel("Status: ", SwingConstants.RIGHT));
		if(servis == null) {
			status.setEnabled(false);
		}
		this.add(status);

		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);		
	}
	
	private void popuniPodatke() {		
		for(int i = 0; i < automobili.size(); i++) {
			if(this.servis.getAutomobil().getId().equals(automobili.get(i).getId())) {
				this.automobil.setSelectedIndex(i);
			}
		}
		
		for(int i = 0; i < serviseri.size(); i++) {
			if(this.servis.getServiser().getId().equals(serviseri.get(i).getId())) {
				this.serviser.setSelectedIndex(i);
			}
		}
		
		termin.setText(servis.getTermin());
		opis.setText(servis.getOpis());
		obrisan.setSelected(servis.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(servis == null) {
					servis = new Servis();
					izmena = false;
				}
				String automobilId = (String)automobil.getSelectedItem();
				servis.setAutomobil(RadSaAutomobilima.ucitajAutomobil(automobilId));
				
				String serviserId = ((String)serviser.getSelectedItem()).split("|")[0];
				servis.setServiser(RadSaServiserima.ucitajServisera(serviserId));
				servis.setTermin(termin.getText());
				servis.setOpis(opis.getText());
				servis.setDelovi(RadSaDelovima.ucitajDelove(delovi.getText().split(",")));
				servis.setStatus(StatusServisa.values()[status.getSelectedIndex()]);
				servis.setObrisan(obrisan.isSelected());

				if(izmena) {
					RadSaServisima.izmeniServis(servis);
				} else {
					RadSaServisima.dodajServis(servis);
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
