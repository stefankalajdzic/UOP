	 package modeli;

public abstract class Korisnik {

	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String pol;
	protected String adresa; 
	protected String brojTelefona;
	protected String korisnickoIme;
	protected String lozinka;
	protected String id;
	
	public Korisnik() {
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = "";
		this.adresa = "";
		this.brojTelefona = "";
		this.korisnickoIme = "";
		this.lozinka = "";
		this.id = "";
	}
	
	public Korisnik(String ime, String prezime, String jmbg, String pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, String id) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.id = id;
	}

	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public String getPol() {
		return pol;
	}
	public void setPol(String pol) {
		this.pol = pol;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa="
				+ adresa + ", brojTelefona=" + brojTelefona + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", id=" + id + "]";
	}

	 
	
}
