package modeli;

import java.util.ArrayList;
import java.util.Date;

import enumeracije.StatusServisa;

public class Servis {

	private Automobil automobil;
	private Serviser serviser;
	private Date termin;
	private String opis;
	private ArrayList<Deo> delovi;
	private String id;
	private ServisnaKnjizica servisnaKnjizica;
	private StatusServisa status;
	
	public Servis() {
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.termin = new Date();
		this.opis = "";
		this.delovi = new ArrayList<Deo>();
		this.id = "";
		this.servisnaKnjizica = null;
		this.status = null;
	}
	
	public Servis(Automobil automobil, Serviser serviser, Date termin, String opis, String id,
			ServisnaKnjizica servisnaKnjizica, StatusServisa status) {
		super();
		this.automobil = automobil;
		this.serviser = serviser;
		this.termin = termin;
		this.opis = opis;
		this.id = id;
		this.servisnaKnjizica = servisnaKnjizica;
		this.status = status;
	}
	public ArrayList<Deo> getDelovi() {
		return delovi;
	}

	public void setDelovi(ArrayList<Deo> delovi) {
		this	.delovi = delovi;
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
	public Date getTermin() {
		return termin;
	}
	public void setTermin(Date termin) {
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
	@Override
	public String toString() {
		return "Servis [automobil=" + automobil + ", serviser=" + serviser + ", termin=" + termin + ", opis=" + opis
				+ "]";
	}
}
