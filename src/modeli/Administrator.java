package modeli;

import enumeracije.Pol;

public class Administrator extends Korisnik {
	
	private float plata;
	
	public Administrator() {
		this.plata = 0;
	}

	public Administrator(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, float plata) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
		this.plata = plata;
	}



	public float getPlata() {
		return plata;
	}

	public void setPlata(int plata) {
		this.plata = plata;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol
				+ ", brojTelefona=" + brojTelefona + "]";
	}

	
	
}
