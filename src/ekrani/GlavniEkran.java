package ekrani;

import java.awt.Dimension;

import javax.swing.JFrame;

public class GlavniEkran extends JFrame
{
	public GlavniEkran(String ime, int sirina, int visina) {
		super(ime);
		
		this.setSize(new Dimension(sirina, visina));
		this.setLocationRelativeTo(null);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// IF ELSE ULOGOVANI KORISNIK (Serviser, Musterija, Admin)
		this.getContentPane().add(new GlavniEkranAdmin());
		
		this.setVisible(true);
	}
	
}