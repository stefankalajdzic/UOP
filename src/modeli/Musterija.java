package modeli;

import java.util.ArrayList;

public class Musterija extends Korisnik {
	
	private int brojNagradnihBodova;
	private ArrayList<Automobil> automobili;
	
	public Musterija() {
		this.brojNagradnihBodova = 0;
		this.automobili = new ArrayList<Automobil>();
	}
		
	
	public Musterija(String ime, String prezime, String jmbg, String pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, String id, int brojNagradnihBodova) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id);
		this.brojNagradnihBodova = brojNagradnihBodova;
	}



	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}

	
	public void setAutomobili(ArrayList<Automobil> automobili) {
		this.automobili = automobili;
	}



	public int getBrojNagradnihBodova() {
		return brojNagradnihBodova;
	}

	public void setBrojNagradnihBodova(int brojNagradnihBodova) {
		this.brojNagradnihBodova = brojNagradnihBodova;
		
		
	}

	@Override
	public String toString() {
		return "Musterija [brojNagradnihBodova=" + brojNagradnihBodova + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + "]";
	}
	
}
