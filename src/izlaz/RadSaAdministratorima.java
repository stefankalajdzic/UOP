package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import model.Administrator;


public class RadSaAdministratorima {

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
				Pol pol = Pol.values()[Integer.parseInt(lineSplit[4])];
				String adresa = lineSplit[5];
				String brojTelefona = lineSplit[6];
				String korisnickoIme = lineSplit[7];
				String lozinka = lineSplit[8];
				float plata = Float.parseFloat(lineSplit[9]);
				Boolean obrisan = Boolean.parseBoolean(lineSplit[10]);
				
				Administrator administrator = new Administrator(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, obrisan);
				administratori.add(administrator);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja administratora iz datoteke.");
			e.printStackTrace();
		}
		
		return administratori;
	}
	
	public static Administrator ucitajAdministratora(String ulazniId) {
		ArrayList<Administrator> administratori = ucitajAdministratore();
		for(Administrator administrator : administratori) {
			if(administrator.getId().equals(ulazniId)) {
				return administrator;
			}
		}
		
		return null;
	}
	
	public static void dodajAdministratora(Administrator ulazniAdministrator) {
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/administratori.txt", true);
			ArrayList<Administrator> administratori = ucitajAdministratore();
			int id = 0;
			for(Administrator administrator : administratori) {
				int trenutniId = Integer.parseInt(administrator.getId());
				if(trenutniId > id) {
					id = trenutniId;
				}
				ulazniAdministrator.setId(Integer.toString(id + 1));
			}
		    outputStream.write(ulazniAdministrator.toStringZaUpis().getBytes());
		    outputStream.close();
		} catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku administratori.txt");
		}
	}
	
	public static void izmeniAdministratora(Administrator ulazniAdministrator) {
		ArrayList<Administrator> administratori = ucitajAdministratore();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/administratori.txt", false);
			outputStream.write("".getBytes());
			for (Administrator administrator : administratori) {
				if(administrator.getId().equals(ulazniAdministrator.getId())) {
					outputStream.write(ulazniAdministrator.toStringZaUpis().getBytes());
				} else {
					outputStream.write(administrator.toStringZaUpis().getBytes());
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
