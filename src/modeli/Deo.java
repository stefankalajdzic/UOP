package modeli;

import java.util.ArrayList;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;

public class Deo {
	
	private String id;
	private MarkaAutomobila marka;
	private ModelAutomobila model;
	private String naziv;
	private float cena;
	private ArrayList<Servis> servisi;
	
	public Deo() {
		this.id = "";
		this.marka = null;
		this.model = null;
		this.naziv = "";
		this.cena = 0;
		this.servisi = new ArrayList<Servis>();
	}
	
	public Deo(String id, MarkaAutomobila marka, ModelAutomobila model, String naziv, float cena) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.naziv = naziv;
		this.cena = cena;
		this.servisi = new ArrayList<Servis>();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ArrayList<Servis> getServisi() {
		return servisi;
	}


	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}


	public MarkaAutomobila getMarka() {
		return marka;
	}
	public void setMarka(MarkaAutomobila marka) {
		this.marka = marka;
	}
	public ModelAutomobila getModel() {
		return model;
	}
	public void setModel(ModelAutomobila model) {
		this.model = model;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public float getCena() {
		return cena;
	}
	public void setCena(float cena) {
		this.cena = cena;
	}

	@Override
	public String toString() {
		return "Deo [id=" + id + ", marka=" + marka + ", model=" + model + ", naziv=" + naziv + ", cena=" + cena
				+ ", servisi=" + servisi + "]";
	}
	
	
	
}
