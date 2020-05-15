package modeli;

import java.util.ArrayList;

import enumeracije.SpecijalizacijaServisera;

public class Serviser extends Korisnik {

	private float plata;
	private SpecijalizacijaServisera specijalizacija;
	private ArrayList<Servis> servisi;
	
	public Serviser() {
		this.plata = 0;
		this.specijalizacija = null;
		this.servisi = new ArrayList<Servis>();
	}
	
	
	public Serviser(String ime, String prezime, String jmbg, String pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, String id, float plata, SpecijalizacijaServisera specijalizacija) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
	}
	

	public ArrayList<Servis> getServisi() {
		return servisi;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}


	public float getPlata() {
		return plata;
	}
	public void setPlata(int plata) {
		this.plata = plata;
	}
	public SpecijalizacijaServisera getSpecijalizacija() {
		return specijalizacija;
	}
	public void setSpecijalizacija(SpecijalizacijaServisera specijalizacija) {
		this.specijalizacija = specijalizacija;
	}
	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", ime=" + ime + ", prezime="
				+ prezime + ", jmbg=" + jmbg + "]";
	}
	
}