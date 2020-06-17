package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import modeli.Musterija;


public class RadSaMusterijama {

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
				Pol pol = Pol.values()[Integer.parseInt(lineSplit[4])];
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
	
	public static Musterija ucitajMusteriju(String ulazniId) {
		ArrayList<Musterija> musterije = RadSaMusterijama.ucitajMusterije();
		for(Musterija musterija : musterije) {
			if(musterija.getId().equals(ulazniId)) {
				return musterija;
			}
		}
		
		return null;
	}

	public static void dodajMusteriju(Musterija musterija) {
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/musterije.txt", true);
		    outputStream.write(musterija.toStringZaUpis().getBytes());
		    outputStream.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku musterije.txt");
		}
	}

	public static void izmeniMusteriju(Musterija ulaznaMusterija) {
		ArrayList<Musterija> musterije = RadSaMusterijama.ucitajMusterije();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/musterije.txt", false);
			outputStream.write("".getBytes());
			for (Musterija musterija : musterije) {
				if(musterija.getId().equals(ulaznaMusterija.getId())) {
					outputStream.write(ulaznaMusterija.toStringZaUpis().getBytes());
				} else {
					outputStream.write(musterija.toStringZaUpis().getBytes());
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
