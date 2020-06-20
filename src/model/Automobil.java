package model;

import enumeracije.Gorivo;
import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import izlaz.RadSaMusterijama;

public class Automobil {

	private String id;
	private Musterija vlasnik;
	private MarkaAutomobila marka;
	private ModelAutomobila model;
	private String godinaProizvodnje;
	private float zapreminaMotora;
	private int snagaMotora;
	private Gorivo vrstaGoriva;
	private Boolean obrisan;
	
	public Automobil() {
		
		this.id = "";
		this.vlasnik = new Musterija();
		this.marka = null;
		this.model = null;
		this.godinaProizvodnje = "";
		this.zapreminaMotora = 0;
		this.snagaMotora = 0;
		this.vrstaGoriva = null;
		this.obrisan = false;
	}
	
	
	public Automobil(String id, String vlasnikId, MarkaAutomobila marka, ModelAutomobila model, String godinaProizvodnje,
			float zapreminaMotora, int snagaMotora, Gorivo vrstaGoriva, Boolean obrisan) {
		super();
		this.id = id;
		this.vlasnik = RadSaMusterijama.ucitajMusteriju(vlasnikId);
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snagaMotora = snagaMotora;
		this.vrstaGoriva = vrstaGoriva;
		this.obrisan = obrisan;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Musterija getVlasnik() {
		return vlasnik;
	}
	public void setVlasnik(Musterija vlasnik) {
		this.vlasnik = vlasnik;
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
	public String getGodinaProizvodnje() {
		return godinaProizvodnje;
	}
	public void setGodinaProizvodnje(String godinaProizvodnje) {
		this.godinaProizvodnje = godinaProizvodnje;
	}
	public float getZapreminaMotora() {
		return zapreminaMotora;
	}
	public void setZapreminaMotora(float zapreminaMotora) {
		this.zapreminaMotora = zapreminaMotora;
	}
	public int getSnagaMotora() {
		return snagaMotora;
	}
	public void setSnagaMotora(int snagaMotora) {
		this.snagaMotora = snagaMotora;
	}
	public Gorivo getVrstaGoriva() {
		return vrstaGoriva;
	}
	public void setVrstaGoriva(Gorivo vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}
	public Boolean getObrisan() {
		return obrisan;
	}
	public void setObrisan(Boolean obrisan) {
		this.obrisan = obrisan;
	}

	@Override
	public String toString() {
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik.ime + " " + vlasnik.prezime + ", marka=" + marka + ", model=" + model
				+ ", godinaProizvodnje=" + godinaProizvodnje + ", zapreminaMotora=" + zapreminaMotora + ", snagaMotora="
				+ snagaMotora + ", vrstaGoriva=" + vrstaGoriva + "]";
	}
	
	public String toStringZaUpis() {
		return this.getId() + "|" +
			   this.getVlasnik().getId() + "|" +
			   Integer.toString(this.getMarka().ordinal()) + "|" +
			   Integer.toString(this.getModel().ordinal()) + "|" +
			   this.getGodinaProizvodnje() + "|" +
			   this.getZapreminaMotora() + "|" +
			   this.getSnagaMotora() + "|" +
			   Integer.toString(this.getVrstaGoriva().ordinal()) + "|" +
			   this.getObrisan() + "\n";
	}
}
