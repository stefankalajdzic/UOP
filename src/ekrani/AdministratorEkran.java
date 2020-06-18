package ekrani;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import enumeracije.Pol;
import izlaz.RadSaAdministratorima;
import modeli.Administrator;

public class AdministratorEkran extends JFrame {
	
	private Administrator administrator;
	
	private JTextField id, ime, prezime, jmbg, 
		adresa, brojTelefona, korisnickoIme, lozinka, plata;
	private JComboBox<String> pol;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public AdministratorEkran(int sirina, int visina, Administrator administrator) {
		super("Administrator");
		
		this.setSize(new Dimension(sirina, visina));
		this.setLocationRelativeTo(null);
		
		id = new JTextField();
		ime = new JTextField();
		prezime = new JTextField();
		jmbg = new JTextField();
		adresa = new JTextField();
		pol = new JComboBox(Pol.values());
		brojTelefona = new JTextField();
		korisnickoIme = new JTextField();
		lozinka = new JTextField();
		plata = new JTextField();
		obrisan = new JCheckBox();
		
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		if(administrator != null) {
			this.administrator = administrator;
			popuniPodatke();
		}
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {

		GridLayout gl = new GridLayout(11, 2);
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
		
		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
	}
	
	private void popuniPodatke() {
		id.setText(administrator.getId());
		ime.setText(administrator.getIme());
		prezime.setText(administrator.getPrezime());
		jmbg.setText(administrator.getJmbg());
		pol.setSelectedIndex(administrator.getPol().ordinal());
		adresa.setText(administrator.getAdresa());
		brojTelefona.setText(administrator.getBrojTelefona());
		korisnickoIme.setText(administrator.getKorisnickoIme());
		lozinka.setText(administrator.getLozinka());
		obrisan.setSelected(administrator.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(administrator == null) {
					administrator = new Administrator();
					izmena = false;
				}
				
				administrator.setIme(ime.getText());
				administrator.setPrezime(prezime.getText());
				administrator.setJmbg(jmbg.getText());
				administrator.setPol(Pol.values()[pol.getSelectedIndex()]);
				administrator.setAdresa(adresa.getText());
				administrator.setBrojTelefona(brojTelefona.getText());
				administrator.setKorisnickoIme(korisnickoIme.getText());
				administrator.setLozinka(lozinka.getText());
				administrator.setObrisan(obrisan.isSelected());
				
				if(izmena) {
					RadSaAdministratorima.izmeniAdministratora(administrator);
				} else {
					
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
