package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import modeli.Musterija;


public class UcitavanjeMusterija {

	public static ArrayList<Musterija> ucitajMusterije() {
		
		ArrayList<Musterija> musterije = new ArrayList<Musterija>();
		
		
		try {
			File file = new File("src/fajlovi/musterije.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jmbg = lineSplit[3];
				int polInt = Integer.parseInt(lineSplit[4]);
				Pol pol = Pol.values()[polInt];
				String adresa = lineSplit[5];
				String brojTelefona = lineSplit[6];
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				int brojNagradnihBodova = Integer.parseInt(lineSplit[9]);
				
				Musterija musterija = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, brojNagradnihBodova, null);
				musterije.add(musterija);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return musterije;
	}
	
}
