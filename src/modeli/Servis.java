package modeli;

import java.util.ArrayList;

import enumeracije.StatusServisa;

public class Servis {
	
	private String id;
	private Automobil automobil;
	private Serviser serviser;
	private String termin;
	private String opis;
	private ArrayList<Deo> delovi;
	private ServisnaKnjizica servisnaKnjizica;
	private StatusServisa status;
	private Boolean obrisan;
	
	public Servis() {
		
		this.id = "";
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.termin = "";
		this.opis = "";
		this.delovi = new ArrayList<Deo>();
		this.servisnaKnjizica = null;
		this.status = null;
		this.obrisan = false;
	}
	
	public Servis(String id, Automobil automobil, Serviser serviser, String termin, String opis,	
				ServisnaKnjizica servisnaKnjizica, StatusServisa status, Boolean obrisan) {
		super();
		
		this.id = id;
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.servisnaKnjizica = servisnaKnjizica;
		this.status = status;
		this.obrisan = obrisan;
	}
	public ArrayList<Deo> getDelovi() {
		return delovi;
	}

	public void setDelovi(ArrayList<Deo> delovi) {
		this.delovi = delovi;
	}

	public StatusServisa getStatus() {
		return status;
	}
	public void setStatus(StatusServisa status) {
		this.status = status;
	}
	public ServisnaKnjizica getServisnaKnjizica() {
		return servisnaKnjizica;
	}
	public void setServisnaKnjizica(ServisnaKnjizica servisnaKnjizica) {
		this.servisnaKnjizica = servisnaKnjizica;
	}
	public Automobil getAutomobil() {
		return automobil;
	}
	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}
	public Serviser getServiser() {
		return serviser;
	}
	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}
	
	public String getTermin() {
		return termin;
	}

	public void setTermin(String termin) {
		this.termin = termin;
	}

	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Servis [id=" + id + ", automobil=" + automobil + ", serviser=" + serviser + ", termin=" + termin
				+ ", opis=" + opis + ", delovi=" + delovi + ", servisnaKnjizica=" + servisnaKnjizica + ", status="
				+ status + "]";
	}
}
