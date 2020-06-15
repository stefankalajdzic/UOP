package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import enumeracije.SpecijalizacijaServisera;
import modeli.Serviser;


public class UcitavanjeServisera {

	public static ArrayList<Serviser> ucitajServisere() {
		
		ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
		
		
		try {
			File file = new File("src/fajlovi/serviseri.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String ime = lineSplit[1];
				String prezime = lineSplit[2];
				String jmbg = lineSplit[3];
				Pol pol = Pol.valueOf(lineSplit[4]);
				String adresa = lineSplit[5];
				String brojTelefona = lineSplit[6];
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				float plata = Float.parseFloat(lineSplit[9]);
				SpecijalizacijaServisera specijalizacija = SpecijalizacijaServisera.valueOf(lineSplit[10]);
				Serviser serviser = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija, null);
				serviseri.add(serviser);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return serviseri;
	}
	
}
