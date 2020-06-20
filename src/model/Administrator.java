package model;

import enumeracije.Pol;

public class Administrator extends Korisnik {
	
	private float plata;
	
	public Administrator() {
		this.plata = 0;
	}

	public Administrator(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, float plata, Boolean obrisan) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.plata = plata;
	}



	public float getPlata() {
		return plata;
	}

	public void setPlata(float plata) {
		this.plata = plata;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + "]";
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
				this.getObrisan() + "\n";
	}
}
