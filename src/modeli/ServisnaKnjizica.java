package modeli;

import java.util.ArrayList;

public class ServisnaKnjizica {

	private String identifikator;
	private Automobil automobil;
	private ArrayList<Servis> servisi;
	
	public ServisnaKnjizica() {
		this.identifikator = "";
		this.automobil = null;
		this.servisi = new ArrayList<Servis>();
	}
	
	public ServisnaKnjizica(String identifikator, Automobil automobil, ArrayList<Servis> servisi) {
		super();
		this.identifikator = identifikator;
		this.automobil = automobil;
		this.servisi = servisi;
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

	@Override
	public String toString() {
		return "ServisnaKnjizica [identifikator=" + identifikator + ", automobil=" + automobil + ", servisi=" + servisi
				+ "]";
	}
	
	
}
