	 package modeli;

import enumeracije.Pol;

public abstract class Korisnik {

	protected String id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected Pol pol;
	protected String adresa; 
	protected String brojTelefona;
	protected String korisnickoIme;
	protected String lozinka;
	protected Boolean obrisan;
	
	public Korisnik() {
		
		this.id = "";
		this.ime = "";
		this.prezime = "";
		this.jmbg = "";
		this.pol = null;
		this.adresa = "";
		this.brojTelefona = "";
		this.korisnickoIme = "";
		this.lozinka = "";
		this.obrisan = false;
	}
	
	public Korisnik(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, Boolean obrisan) {
		super();
		
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.pol = pol;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.obrisan = obrisan;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Pol getPol() {
		return pol;
	}
	public void setPol(Pol pol) {
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
	public Boolean getObrisan() {
		return obrisan;
	}
	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Korisnik [ime=" + ime + ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa="
				+ adresa + ", brojTelefona=" + brojTelefona + ", korisnickoIme=" + korisnickoIme + ", lozinka="
				+ lozinka + ", id=" + id + "]";
	}

	 
	
}
