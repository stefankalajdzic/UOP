package model;

import java.util.ArrayList;

import enumeracije.Pol;

public class Musterija extends Korisnik {
	
	private int brojNagradnihBodova;
	
	public Musterija() {
		this.brojNagradnihBodova = 0;
	}

	public Musterija(String id, String ime, String prezime, String jmbg, Pol pol, String adresa,
				String brojTelefona, String korisnickoIme, String lozinka, int brojNagradnihBodova, Boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.brojNagradnihBodova = brojNagradnihBodova;
	}

	public int getBrojNagradnihBodova() {
		return brojNagradnihBodova;
	}

	public void setBrojNagradnihBodova(int brojNagradnihBodova) {
		this.brojNagradnihBodova = brojNagradnihBodova;
	}
	
	@Override
	public String toString() {
		return "Musterija [brojNagradnihBodova=" + brojNagradnihBodova + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + "]";
	}

	public String toStringZaUpis() {
		return this.getId() + "|" +
			   this.getIme() + "|" +
			   this.getPrezime() + "|" +
			   this.getJmbg() + "|" +
			   Integer.toString(this.getPol().ordinal()) + "|" +
			   this.getAdresa() + "|" +
			   this.getBrojTelefona() + "|" +
			   this.getKorisnickoIme() + "|" +
			   this.getLozinka() + "|" +
			   Integer.toString(this.getBrojNagradnihBodova()) + "\n";
 	}
}
