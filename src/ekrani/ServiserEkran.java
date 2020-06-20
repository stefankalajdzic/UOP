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

import enumeracije.Pol;
import enumeracije.SpecijalizacijaServisera;
import izlaz.RadSaServiserima;
import model.Serviser;

public class ServiserEkran extends JDialog {

	private static final long serialVersionUID = 1L;

	private Serviser serviser;
	
	private JTextField id, ime, prezime, jmbg, 
		adresa, brojTelefona, korisnickoIme, lozinka, plataServisera;
	private JComboBox<Pol> pol;
	private JComboBox<SpecijalizacijaServisera> specijalizacija;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public ServiserEkran(Serviser serviser) {
		super(null, "Serviser", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 400));
		this.setLocationRelativeTo(null);
		
		id = new JTextField();
		ime = new JTextField();
		prezime = new JTextField();
		jmbg = new JTextField();
		adresa = new JTextField();
		pol = new JComboBox<Pol>(Pol.values());
		brojTelefona = new JTextField();
		korisnickoIme = new JTextField();
		lozinka = new JTextField();
		plataServisera = new JTextField();
		specijalizacija = new JComboBox<SpecijalizacijaServisera>(SpecijalizacijaServisera.values());
		obrisan = new JCheckBox();
		
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		if(serviser != null) {
			this.serviser = serviser;
			popuniPodatke();
		}
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {

		GridLayout gl = new GridLayout(13, 2);
		this.setLayout(gl);
		
		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);
		
		this.add(new JLabel("Ime: ", SwingConstants.RIGHT));
		this.add(ime);
		
		this.add(new JLabel("Prezime: ", SwingConstants.RIGHT));
		this.add(prezime);

		this.add(new JLabel("JMBG: ", SwingConstants.RIGHT));
		this.add(jmbg);
		
		this.add(new JLabel("Pol: ", SwingConstants.RIGHT));
		this.add(pol);
		
		this.add(new JLabel("Adresa: ", SwingConstants.RIGHT));
		this.add(adresa);

		this.add(new JLabel("Br. Tel.: ", SwingConstants.RIGHT));
		this.add(brojTelefona);

		this.add(new JLabel("Korisnicko ime: ", SwingConstants.RIGHT));
		this.add(korisnickoIme);

		this.add(new JLabel("Lozinka: ", SwingConstants.RIGHT));
		this.add(lozinka);
		
		this.add(new JLabel("Plata: ", SwingConstants.RIGHT));
		this.add(plataServisera);

		this.add(new JLabel("Specijalizacija: ", SwingConstants.RIGHT));
		this.add(specijalizacija);
		
		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
	}
	
	private void popuniPodatke() {
		id.setText(serviser.getId());
		ime.setText(serviser.getIme());
		prezime.setText(serviser.getPrezime());
		jmbg.setText(serviser.getJmbg());
		pol.setSelectedIndex(serviser.getPol().ordinal());
		adresa.setText(serviser.getAdresa());
		brojTelefona.setText(serviser.getBrojTelefona());
		korisnickoIme.setText(serviser.getKorisnickoIme());
		lozinka.setText(serviser.getLozinka());
		plataServisera.setText(Float.toString(serviser.getPlata()));
		obrisan.setSelected(serviser.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(serviser == null) {
					serviser = new Serviser();
					izmena = false;
				}
				Float plata = (float) 0.0;
				try {
					plata = Float.parseFloat(plataServisera.getText());
				} catch (Exception ex) { }
				
				serviser.setIme(ime.getText());
				serviser.setPrezime(prezime.getText());
				serviser.setJmbg(jmbg.getText());
				serviser.setPol(Pol.values()[pol.getSelectedIndex()]);
				serviser.setAdresa(adresa.getText());
				serviser.setBrojTelefona(brojTelefona.getText());
				serviser.setKorisnickoIme(korisnickoIme.getText());
				serviser.setLozinka(lozinka.getText());
				serviser.setPlata(plata);
				serviser.setSpecijalizacija(SpecijalizacijaServisera.values()[specijalizacija.getSelectedIndex()]);
				serviser.setObrisan(obrisan.isSelected());
				
				if(izmena) {
					RadSaServiserima.izmeniServisera(serviser);
				} else {
					RadSaServiserima.dodajServisera(serviser);
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
