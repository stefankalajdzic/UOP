package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modeli.Administrator;
import enumeracije.Pol;


public class UcitavanjeAdministratora {

	public static ArrayList<Administrator> ucitajAdministratore() {
		
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		
		
		try {
			File file = new File("src/fajlovi/administratori.txt");
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
				float plata = Float.parseFloat(lineSplit[9]);
				
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata);
				administratori.add(administrator);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return administratori;
	}
	
}
