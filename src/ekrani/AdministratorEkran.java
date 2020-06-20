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
import izlaz.RadSaAdministratorima;
import model.Administrator;

public class AdministratorEkran extends JDialog {
	
	private Administrator administrator;
	
	private JTextField id, ime, prezime, jmbg, 
		adresa, brojTelefona, korisnickoIme, lozinka, plataAdministratora;
	private JComboBox<String> pol;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public AdministratorEkran(Administrator administrator) {
		super(null, "Administrator", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 365));
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
		plataAdministratora = new JTextField();
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
		
		this.add(new JLabel("Plata: ", SwingConstants.RIGHT));
		this.add(plataAdministratora);
		
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
		plataAdministratora.setText(Float.toString(administrator.getPlata()));
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
				Float plata = (float) 0.0;
				try {
					plata = Float.parseFloat(plataAdministratora.getText());
				} catch (Exception ex) { }
				
				administrator.setIme(ime.getText());
				administrator.setPrezime(prezime.getText());
				administrator.setJmbg(jmbg.getText());
				administrator.setPol(Pol.values()[pol.getSelectedIndex()]);
				administrator.setAdresa(adresa.getText());
				administrator.setBrojTelefona(brojTelefona.getText());
				administrator.setKorisnickoIme(korisnickoIme.getText());
				administrator.setLozinka(lozinka.getText());
				administrator.setPlata(plata);
				administrator.setObrisan(obrisan.isSelected());
				
				if(izmena) {
					RadSaAdministratorima.izmeniAdministratora(administrator);
				} else {
					RadSaAdministratorima.dodajAdministratora(administrator);
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
