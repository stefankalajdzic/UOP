package ekrani;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import net.miginfocom.swing.MigLayout;

public class GlavniEkran extends JFrame
{
	private GlavniEkranAdmin glavniEkranAdmin;
	private MigLayout migLayout;
	private JButton dodaj;
	private JButton izmeni;
	private JButton izlaz;
	
	public GlavniEkran(String ime, int sirina, int visina) {
		super(ime);

		this.setSize(new Dimension(sirina, visina));
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		glavniEkranAdmin = new GlavniEkranAdmin();
	
		migLayout = new MigLayout("fill");
		dodaj = new JButton("Dodaj");
		izmeni = new JButton("Izmeni");
		izlaz = new JButton("Izlaz");
		
		postaviElemente();
		postaviFunkcionalnosti();
	}
	
	private void postaviElemente() {

		this.setLayout(migLayout);
		this.add(dodaj, "cell 0 0");
		this.add(izmeni, "cell 0 0,al left");
		this.add(izlaz, "cell 2 0,wrap,al right");
		
		// IF ELSE ULOGOVANI KORISNIK (Serviser, Musterija, Admin)
		
		this.add(glavniEkranAdmin, "span 3 1,growx");
		
		this.setVisible(true);
	}
	
	private void postaviFunkcionalnosti() {
		dodaj.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				glavniEkranAdmin.dodajIzmeni(true);
			}
		});
		
		izmeni.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				glavniEkranAdmin.dodajIzmeni(false);
			}
		});
	}
}