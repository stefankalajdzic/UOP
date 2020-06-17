package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import modeli.Administrator;
import modeli.ServisnaKnjizica;

public class RadSaServisnimKnjizicama {

	public static ArrayList<ServisnaKnjizica> ucitajServisneKnjizice() {
		
		ArrayList<ServisnaKnjizica> servisneKnjizice = new ArrayList<ServisnaKnjizica>();
		
		try {
			File file = new File("src/fajlovi/servisneknjizice.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String automobilovId = lineSplit[1];
				String[] servisi = lineSplit[2].split(",");
				Boolean obrisan = Boolean.parseBoolean(lineSplit[3]);
				
				ServisnaKnjizica servisnaKnjizica = new ServisnaKnjizica(id, automobilovId, servisi, obrisan);
				servisneKnjizice.add(servisnaKnjizica);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return servisneKnjizice;
	}
	
	public static Administrator ucitajAdministratora(String ulazniId) {
		ArrayList<Administrator> administratori = RadSaAdministratorima.ucitajAdministratore();
		for(Administrator administrator : administratori) {
			if(administrator.getId().equals(ulazniId)) {
				return administrator;
			}
		}
		
		return null;
	}
	
	public static void dodajAdministratora(Administrator admin) {
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/administratori.txt", true);
		    outputStream.write(admin.toStringZaUpis().getBytes());
		    outputStream.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku korisnici.txt");
		}
	}
	
	public static void izmeniAdministratora(Administrator ulazniAdministrator) {
		ArrayList<Administrator> administratori = RadSaAdministratorima.ucitajAdministratore();
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
