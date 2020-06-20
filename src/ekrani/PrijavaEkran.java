package ekrani;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import izlaz.RadSaAdministratorima;
import izlaz.RadSaMusterijama;
import izlaz.RadSaServiserima;
import model.Administrator;
import model.Musterija;
import model.Serviser;

public class PrijavaEkran extends JDialog {

	private static final long serialVersionUID = 1L;

	public Musterija ulogovanaMusterija;
	public Serviser ulogovanServiser;
	public Administrator ulogovanAdministrator;
	
	private JTextField korisnickoIme;
	private JPasswordField lozinka;
	private JButton potvrdi, odustani;
	
	public PrijavaEkran(String ime, int sirina, int visina) {
		super(null, "Prijava", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(sirina, visina));
		this.setLocationRelativeTo(null);
		this.setUndecorated(true);
		
		korisnickoIme = new JTextField();
		lozinka = new JPasswordField();

		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(3, 2);
		this.setLayout(gl);
		
		this.add(new JLabel("Korisnicko ime: ", SwingConstants.RIGHT));
		this.add(korisnickoIme);
		
		this.add(new JLabel("Lozinka: ", SwingConstants.RIGHT));
		this.add(lozinka);

		this.add(potvrdi);
		this.add(odustani);
	}

	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ArrayList<Musterija> musterije = RadSaMusterijama.ucitajMusterije();
				for(Musterija musterija : musterije) {
					if(musterija.getKorisnickoIme().equals(korisnickoIme.getText()) &&
					   musterija.getLozinka().equals(new String(lozinka.getPassword()))) {
						ulogovanaMusterija = musterija;
						ugasi();
					}
				}
				
				ArrayList<Serviser> serviseri = RadSaServiserima.ucitajServisere();
				for(Serviser serviser : serviseri) {
					if(serviser.getKorisnickoIme().equals(korisnickoIme.getText()) &&
							serviser.getLozinka().equals(new String(lozinka.getPassword()))) {
						ulogovanServiser = serviser;
						ugasi();
					}
				}
				
				ArrayList<Administrator> administratori = RadSaAdministratorima.ucitajAdministratore();
				for(Administrator administrator : administratori) {
					if(administrator.getKorisnickoIme().equals(korisnickoIme.getText()) &&
							administrator.getLozinka().equals(new String(lozinka.getPassword()))) {
						ulogovanAdministrator = administrator;
						ugasi();
					}
				}
			}
		});
		this.odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void ugasi() {
		this.dispose();
	}
}
