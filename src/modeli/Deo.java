package modeli;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;

public class Deo {
	
	private String id;
	private MarkaAutomobila marka;
	private ModelAutomobila model;
	private String naziv;
	private float cena;
	private Boolean obrisan;
	
	public Deo() {
		this.id = "";
		this.marka = null;
		this.model = null;
		this.naziv = "";
		this.cena = 0;
		this.obrisan = false;
	}
	
	public Deo(String id, MarkaAutomobila marka, ModelAutomobila model, String naziv, float cena, Boolean obrisan) {
		super();
		this.id = id;
		this.marka = marka;
		this.model = model;
		this.naziv = naziv;
		this.cena = cena;
		this.obrisan = obrisan;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Boolean getObrisan() {
		return obrisan;
	}

	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Deo [id=" + id + ", marka=" + marka + ", model=" + model + ", naziv=" + naziv + ", cena=" + cena + "]";
	}
	
	
	
}
