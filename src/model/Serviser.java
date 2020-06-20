package model;

import enumeracije.Pol;
import enumeracije.SpecijalizacijaServisera;

public class Serviser extends Korisnik {

	private float plata;
	private SpecijalizacijaServisera specijalizacija;
	
	public Serviser() {
		this.plata = 0;
		this.specijalizacija = null;
	}
	

	public Serviser(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, float plata, SpecijalizacijaServisera specijalizacija, Boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.plata = plata;
		this.specijalizacija = specijalizacija;	
	}

	public float getPlata() {
		return plata;
	}
	public void setPlata(float plata) {
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
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija +  ", id="
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
			   Integer.toString(this.getSpecijalizacija().ordinal()) + "|" + 
			   this.getObrisan() + "\n";
 	}
}
