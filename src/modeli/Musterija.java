package modeli;

import java.util.ArrayList;

import enumeracije.Pol;

public class Musterija extends Korisnik {
	
	private int brojNagradnihBodova;
	private ArrayList<Automobil> automobili;
	
	public Musterija() {
		this.brojNagradnihBodova = 0;
		this.automobili = new ArrayList<Automobil>();
	}
		/*String listaAutomobila = "";
		if(musterija.getautomobili != null)
			for(Automobil a : musterija.getautomobili)
			listaAutomobila += String.valueOf(a.getId) + ",";
			ovako se upisuje u fajl: listaAutomobila.substring(0,listaAutomobila.length - 1);*/  


	public Musterija(String id, String ime, String prezime, String jmbg, Pol pol, String adresa,
				String brojTelefona, String korisnickoIme, String lozinka, int brojNagradnihBodova,
				ArrayList<Automobil> automobili) {
			super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka);
			this.brojNagradnihBodova = brojNagradnihBodova;
			this.automobili = automobili;
		}
	public ArrayList<Automobil> getAutomobili() {
		return automobili;
	}

	
	public void setAutomobili(ArrayList<Automobil> automobili) {
		this.automobili = automobili;
	}



	public int getBrojNagradnihBodova() {
		return brojNagradnihBodova;
	}

	public void setBrojNagradnihBodova(int brojNagradnihBodova) {
		this.brojNagradnihBodova = brojNagradnihBodova;
		
		
	}


	@Override
	public String toString() {
		return "Musterija [brojNagradnihBodova=" + brojNagradnihBodova + ", automobili=" + automobili + ", id=" + id
				+ ", ime=" + ime + ", prezime=" + prezime + ", pol=" + pol + "]";
	}

	public String toStringZaUpis() {
		return this.getId() + "|" +
			   this.getIme() + "|" +
			   this.getPrezime() + "|" +
			   this.getJmbg() + "|" +
			   Integer.toString(this.getPol().ordinal()) + "|" +
			   this.getAdresa() + "|" +
			   this.getBrojTelefona() + "|" +
			   this.getKorisnickoIme() + "|" +
			   this.getLozinka() + "|" +
			   Integer.toString(this.getBrojNagradnihBodova()) + "\n";
 	}
}
