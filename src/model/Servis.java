package model;

import java.util.ArrayList;

import enumeracije.StatusServisa;
import izlaz.RadSaAutomobilima;
import izlaz.RadSaDelovima;
import izlaz.RadSaServiserima;

public class Servis {
	
	private String id;
	private Automobil automobil;
	private Serviser serviser;
	private String termin;
	private String opis;
	private ArrayList<Deo> delovi;
	private StatusServisa status;
	private Boolean obrisan;
	
	public Servis() {
		
		this.id = "";
		this.automobil = new Automobil();
		this.serviser = new Serviser();
		this.termin = "";
		this.opis = "";
		this.delovi = new ArrayList<Deo>();
		this.status = null;
		this.obrisan = false;
	}
	
	public Servis(String id, String automobilovID, String serviserovId, String termin, String opis, String[] delovi, StatusServisa status, Boolean obrisan) {
		super();
		
		this.id = id;
		this.automobil = RadSaAutomobilima.ucitajAutomobil(automobilovID);
		this.serviser = RadSaServiserima.ucitajServisera(serviserovId);
		this.termin = termin;
		this.opis = opis;
		this.delovi = RadSaDelovima.ucitajDelove(delovi);
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
				+ ", opis=" + opis + ", delovi=" + delovi +  ", status=" + status + "]";
	}
	
	public String toStringDelovi() {
		ArrayList<String> delovi = new ArrayList<String>();
		for(Deo deo : this.delovi) {
			delovi.add(deo.getId());
		}
		return String.join(",", delovi);
	}
	
	public String toStringZaUpis() {
		return this.getId() + "|" +
			   this.getAutomobil().getId() + "|" +
			   this.getServiser().getId() + "|" +
			   this.getTermin() + "|" +
			   this.getOpis() + "|" +
			   this.toStringDelovi() + "|" +
			   this.getStatus().ordinal() + "|" +
			   this.getObrisan() + "\n";
	}
}
