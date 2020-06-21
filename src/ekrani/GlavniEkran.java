package ekrani;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.Administrator;
import model.Musterija;
import model.Serviser;
import net.miginfocom.swing.MigLayout;

public class GlavniEkran extends JFrame
{
	private static final long serialVersionUID = 1L;

	private Administrator ulogovanAdministrator;
	private Serviser ulogovanServiser;
	private Musterija ulogovanaMusterija;
	
	private static PrijavaEkran prijavaEkran;
	private GlavniEkranAdministrator glavniEkranAdministrator;
	private GlavniEkranServiser glavniEkranServiser;	
	private GlavniEkranMusterija glavniEkranMusterija;

	private MigLayout migLayout;
	private JButton dodaj;
	private JButton izmeni;
	private JButton izadji;
	
	public GlavniEkran(String ime, int sirina, int visina) {
		super(ime);

		this.setSize(new Dimension(sirina, visina));
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		prijavaEkran = new PrijavaEkran("Prijava", 300, 150);
		
		ulogovanAdministrator = prijavaEkran.ulogovanAdministrator;
		ulogovanServiser = prijavaEkran.ulogovanServiser;
		ulogovanaMusterija = prijavaEkran.ulogovanaMusterija;
		
		if(ulogovanAdministrator != null) {
			glavniEkranAdministrator = new GlavniEkranAdministrator();			
		} else if (ulogovanServiser != null) {
			glavniEkranServiser = new GlavniEkranServiser(ulogovanServiser);
		} else if (ulogovanaMusterija != null) {
			glavniEkranMusterija = new GlavniEkranMusterija(ulogovanaMusterija);
		}
	
		migLayout = new MigLayout("fill");
		dodaj = new JButton("Dodaj");
		izmeni = new JButton("Izmeni");
		izadji = new JButton("Izadji");
		
		postaviElemente();
		postaviAdminFunkcionalnosti();

		this.setVisible(true);
	}
	
	private void postaviElemente() {
		this.setLayout(migLayout);
		this.add(dodaj, "cell 0 0");
		this.add(izmeni, "cell 0 0,al left");
		this.add(izadji, "cell 2 0,wrap,al right");
		
		if(ulogovanAdministrator != null) {
			this.add(glavniEkranAdministrator, "span 3 1,growx");			
		} else if (ulogovanServiser != null) {
			this.add(glavniEkranServiser, "span 3 1,growx");
		} else if (ulogovanaMusterija != null) {
			// "dodaj" postaje "dodaj auto"
			// "izmeni" postaje "zakazi servis"
			dodaj.setText("Dodaj auto");
			izmeni.setText("Zakazi servis");
			this.add(glavniEkranMusterija, "span 3 1,growx");
		}
	}
	
	private void postaviAdminFunkcionalnosti() {
		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ulogovanAdministrator != null) {
					glavniEkranAdministrator.dodajIzmeni(true);
				} else if (ulogovanServiser != null) {
					glavniEkranServiser.dodajIzmeni(true);
				} else if(ulogovanaMusterija != null) {
					glavniEkranMusterija.dodajAuto();
				}
			}
		});
		
		izmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ulogovanAdministrator != null) {
					glavniEkranAdministrator.dodajIzmeni(false);					
				} else if (ulogovanServiser != null) {
					glavniEkranServiser.dodajIzmeni(false);
				} else if (ulogovanaMusterija != null) {
					glavniEkranMusterija.dodajServis();
				}
			}
		});
		izadji.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				ugasi();
			}
		});
	}


	private void ugasi() {
		this.dispose();
	}
}