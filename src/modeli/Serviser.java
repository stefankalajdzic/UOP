package modeli;

import java.util.ArrayList;

import enumeracije.Pol;
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
	

	public Serviser(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, float plata, SpecijalizacijaServisera specijalizacija,
			ArrayList<Servis> servisi, Boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.plata = plata;
		this.specijalizacija = specijalizacija;
		this.servisi = servisi;
	
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
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", servisi=" + servisi + ", id="
				+ id + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + "]";
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
			   Float.toString(this.getPlata()) + "|" +
			   Integer.toString(this.getSpecijalizacija().ordinal()) + "\n";
 	}
}
