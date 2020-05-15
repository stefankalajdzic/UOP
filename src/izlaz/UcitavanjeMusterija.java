package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
				
				String ime = lineSplit[0];
				String prezime = lineSplit[1];
				String jmbg = lineSplit[2];
				String pol = lineSplit[3];
				String adresa = lineSplit[4];
				String brojTelefona = lineSplit[5];
				String korisnickoIme = lineSplit[6];
				String lozinka = lineSplit[7];
				String id = lineSplit[8];
				int brojNagradnihBodova = Integer.parseInt(lineSplit[9]);
				Musterija musterija = new Musterija(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id, brojNagradnihBodova);
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
