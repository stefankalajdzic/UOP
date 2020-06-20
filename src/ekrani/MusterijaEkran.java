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
import izlaz.RadSaMusterijama;
import model.Musterija;

public class MusterijaEkran extends JDialog {

	private static final long serialVersionUID = 1L;

	private Musterija musterija;
	
	private JTextField id, ime, prezime, jmbg, 
		adresa, brojTelefona, korisnickoIme, lozinka, brojBodova;
	private JComboBox<Pol> pol;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public MusterijaEkran(Musterija musterija) {
		super(null, "Musterija", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 365));
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
		brojBodova = new JTextField();
		obrisan = new JCheckBox();
		
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		if(musterija != null) {
			this.musterija = musterija;
			popuniPodatke();
		}
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {

		GridLayout gl = new GridLayout(12, 2);
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
		
		this.add(new JLabel("Broj bodova: ", SwingConstants.RIGHT));
		this.add(brojBodova);
		
		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
	}
	
	private void popuniPodatke() {
		id.setText(musterija.getId());
		ime.setText(musterija.getIme());
		prezime.setText(musterija.getPrezime());
		jmbg.setText(musterija.getJmbg());
		pol.setSelectedIndex(musterija.getPol().ordinal());
		adresa.setText(musterija.getAdresa());
		brojTelefona.setText(musterija.getBrojTelefona());
		korisnickoIme.setText(musterija.getKorisnickoIme());
		lozinka.setText(musterija.getLozinka());
		brojBodova.setText(Integer.toString(musterija.getBrojNagradnihBodova()));
		obrisan.setSelected(musterija.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(musterija == null) {
					musterija = new Musterija();
					izmena = false;
				}
				int brojNagradnihBodova = 0;
				try {
					brojNagradnihBodova = Integer.parseInt(brojBodova.getText());
				} catch (Exception ex) { }
				
				musterija.setIme(ime.getText());
				musterija.setPrezime(prezime.getText());
				musterija.setJmbg(jmbg.getText());
				musterija.setPol(Pol.values()[pol.getSelectedIndex()]);
				musterija.setAdresa(adresa.getText());
				musterija.setBrojTelefona(brojTelefona.getText());
				musterija.setKorisnickoIme(korisnickoIme.getText());
				musterija.setLozinka(lozinka.getText());
				musterija.setBrojNagradnihBodova(brojNagradnihBodova);
				musterija.setObrisan(obrisan.isSelected());
				
				if(izmena) {
					RadSaMusterijama.izmeniMusteriju(musterija);
				} else {
					RadSaMusterijama.dodajMusteriju(musterija);
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
