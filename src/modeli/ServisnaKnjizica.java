package modeli;

import java.util.ArrayList;

import izlaz.RadSaAutomobilima;
import izlaz.RadSaServisima;

public class ServisnaKnjizica {

	private String identifikator;
	private Automobil automobil;
	private ArrayList<Servis> servisi;
	private Boolean obrisan;
	
	public ServisnaKnjizica() {
		this.identifikator = "";
		this.automobil = null;
		this.servisi = new ArrayList<Servis>();
		this.obrisan = false;
	}
	
	public ServisnaKnjizica(String identifikator, String automobilovId, String[] servisi, Boolean obrisan) {
		super();
		this.identifikator = identifikator;
		this.automobil = RadSaAutomobilima.ucitajAutomobil(automobilovId);
		this.servisi = RadSaServisima.ucitajServise(servisi);
		this.obrisan = obrisan;
	}

	public String getIdentifikator() {
		return identifikator;
	}

	public void setIdentifikator(String identifikator) {
		this.identifikator = identifikator;
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
		return "ServisnaKnjizica [identifikator=" + identifikator + ", automobil=" + automobil + ", servisi=" + servisi
				+ "]";
	}
}
