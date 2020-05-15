package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modeli.Administrator;


public class UcitavanjeAdministratora {

	public static ArrayList<Administrator> ucitajAdministratore() {
		
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		
		
		try {
			File file = new File("src/fajlovi/administratori.txt");
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
				float plata = Float.parseFloat(lineSplit[9]);
				
				Administrator administrator = new Administrator(ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, id, plata);
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
