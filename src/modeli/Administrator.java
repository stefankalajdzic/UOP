package modeli;

public class Administrator extends Korisnik {
	
	private float plata;
	
	public Administrator() {
		this.plata = 0;
	}

	public Administrator(String ime, String prezime, String jmbg, String pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, String id, float plata) {
		super(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id);
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
		return "Administrator [plata=" + plata + ", ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + "]";
	}
	
}
