package model;

import java.util.ArrayList;

import izlaz.RadSaAutomobilima;
import izlaz.RadSaServisima;

public class ServisnaKnjizica {

	private String id;
	private Automobil automobil;
	private ArrayList<Servis> servisi;
	private Boolean obrisan;
	
	public ServisnaKnjizica() {
		this.id = "";
		this.automobil = null;
		this.servisi = new ArrayList<Servis>();
		this.obrisan = false;
	}
	
	public ServisnaKnjizica(String id, String automobilovId, String[] servisi, Boolean obrisan) {
		super();
		this.id = id;
		this.automobil = RadSaAutomobilima.ucitajAutomobil(automobilovId);
		this.servisi = RadSaServisima.ucitajServise(servisi);
		this.obrisan = obrisan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ServisnaKnjizica(Automobil automobil) {
		super();
		this.automobil = automobil;
	
	}
	public Automobil getAutomobil() {
		return automobil;
	}
	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}
	
	public ArrayList<Servis> getServisi() {
		return servisi;
	}
	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "ServisnaKnjizica [identifikator=" + id + ", automobil=" + automobil + ", servisi=" + servisi
				+ "]";
	}
}
