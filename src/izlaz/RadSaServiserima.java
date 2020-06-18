package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import enumeracije.SpecijalizacijaServisera;
import modeli.Serviser;


public class RadSaServiserima {

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
				Boolean obrisan = Boolean.parseBoolean(lineSplit[11]);

				Serviser serviser = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija, obrisan);
				serviseri.add(serviser);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return serviseri;
	}
	
	public static Serviser ucitajServisera(String ulazniId) {
		ArrayList<Serviser> serviseri = RadSaServiserima.ucitajServisere();
		for(Serviser serviser : serviseri) {
			if(serviser.getId().equals(ulazniId)) {
				return serviser;
			}
		}
		
		return null;
	}
	
	public static void dodajServisera(Serviser serviser) {
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/serviseri.txt", true);
		    outputStream.write(serviser.toStringZaUpis().getBytes());
		    outputStream.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku serviseri.txt");
		}
	}

	public static void izmeniServisera(Serviser ulazniServiser) {
		ArrayList<Serviser> serviseri = RadSaServiserima.ucitajServisere();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/serviseri.txt", false);
			outputStream.write("".getBytes());
			for (Serviser serviser : serviseri) {
				if(serviser.getId().equals(ulazniServiser.getId())) {
					outputStream.write(ulazniServiser.toStringZaUpis().getBytes());
				} else {
					outputStream.write(serviser.toStringZaUpis().getBytes());
				}
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
