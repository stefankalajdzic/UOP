package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import enumeracije.StatusServisa;
import model.Servis;

public class RadSaServisima {
	
	public static ArrayList<Servis> ucitajServise() {
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		
		try {
			File file = new File("src/fajlovi/servisi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String automobilovId = lineSplit[1];
				String serviserovId = lineSplit[2];
				String termin = lineSplit[3];
				String opis = lineSplit[4];
				String[] delovi = lineSplit[5].split(",");
				StatusServisa status = StatusServisa.values()[Integer.parseInt(lineSplit[6])];
				Boolean obrisan = Boolean.parseBoolean(lineSplit[7]);
				
				Servis servis = new Servis(id, automobilovId, serviserovId, termin, opis, delovi, status, obrisan);
				servisi.add(servis);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("Greska prilikom citanja servisa iz datoteke.");
			e.printStackTrace();
		}

		return servisi;
	}
	
	public static ArrayList<Servis> ucitajServise(String[] idServisa) {
		
		return null;
	}
}
