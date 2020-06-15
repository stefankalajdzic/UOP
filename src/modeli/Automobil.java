package modeli;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;

public class Automobil {

	private String id;
	private Musterija vlasnik;
	private MarkaAutomobila marka;
	private ModelAutomobila model;
	private String godinaProizvodnje;
	private float zapreminaMotora;
	private int snagaMotora;
	private String vrstaGoriva;
	private ServisnaKnjizica servisnaKnjizica;
	
	public Automobil() {
		
		this.id = "";
		this.vlasnik = new Musterija();
		this.marka = null;
		this.model = null;
		this.godinaProizvodnje = "";
		this.zapreminaMotora = 0;
		this.snagaMotora = 0;
		this.vrstaGoriva = "";
		this.servisnaKnjizica = null;
		
	}
	
	
	public Automobil(String id, Musterija vlasnik, MarkaAutomobila marka, ModelAutomobila model, String godinaProizvodnje,
			float zapreminaMotora, int snagaMotora, String vrstaGoriva, ServisnaKnjizica servisnaKnjizica) {
		super();
		this.id = id;
		this.vlasnik = vlasnik;
		this.marka = marka;
		this.model = model;
		this.godinaProizvodnje = godinaProizvodnje;
		this.zapreminaMotora = zapreminaMotora;
		this.snagaMotora = snagaMotora;
		this.vrstaGoriva = vrstaGoriva;
		this.servisnaKnjizica = servisnaKnjizica;
	}
	public ServisnaKnjizica getServisnaKnjizica() {
		return servisnaKnjizica;
	}
	public void setServisnaKnjizica(ServisnaKnjizica servisnaKnjizica) {
		this.servisnaKnjizica = servisnaKnjizica;
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
	public String getVrstaGoriva() {
		return vrstaGoriva;
	}
	public void setVrstaGoriva(String vrstaGoriva) {
		this.vrstaGoriva = vrstaGoriva;
	}


	@Override
	public String toString() {
		return "Automobil [id=" + id + ", vlasnik=" + vlasnik + ", marka=" + marka + ", model=" + model
				+ ", godinaProizvodnje=" + godinaProizvodnje + ", zapreminaMotora=" + zapreminaMotora + ", snagaMotora="
				+ snagaMotora + ", vrstaGoriva=" + vrstaGoriva + ", servisnaKnjizica=" + servisnaKnjizica + "]";
	}
	
	
}
