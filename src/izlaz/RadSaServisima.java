package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import enumeracije.StatusServisa;
import model.Automobil;
import model.Servis;
import model.Serviser;
import model.ServisnaKnjizica;

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
	
	public static ArrayList<Servis> ucitajServise(String[] ulazniServisi) {
		List<String> prosledjeniServisiLista = Arrays.asList(ulazniServisi);
		ArrayList<Servis> sviServisi = ucitajServise();
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		
		for(Servis servis : sviServisi) {
			if(prosledjeniServisiLista.contains(servis.getId())) {
				servisi.add(servis);
			}
		}
		
		return servisi;
	}
	
	public static Servis ucitajServis(String ulazniId) {
		ArrayList<Servis> servisi = ucitajServise();
		for(Servis servis : servisi) {
			if(servis.getId().equals(ulazniId)) {
				return servis;
			}
		}
		
		return null;
	}
	
	public static ArrayList<Servis> ucitajServisePoServiseru(Serviser serviser) {
		ArrayList<Servis> sviServisi = ucitajServise();
		ArrayList<Servis> povratniServisi = new ArrayList<Servis>();
		for(Servis servis : sviServisi) {
			if(servis.getServiser().getId().equals(serviser.getId()) &&
					servis.getObrisan() == false) {
				povratniServisi.add(servis);
			}
		}
		
		return povratniServisi;
	}

	public static ArrayList<Servis> ucitajServisePoAutomobilu(Automobil automobil) {
		ServisnaKnjizica servisnaKnjizica = RadSaServisnimKnjizicama.ucitajServisnuKnjizicuPoAutomobilu(automobil.getId());
		if(servisnaKnjizica != null) {
			return servisnaKnjizica.getServisi();
		} else {
			return new ArrayList<Servis>();
		}
	}
	
	public static void dodajServis(Servis ulazniServis) {
		try {
			int id = 0;
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/servisi.txt", true);
			ArrayList<Servis> servisi = ucitajServise();
			
			for(Servis servis : servisi) {
				int trenutniId = Integer.parseInt(servis.getId());
				if(trenutniId > id) {
					id = trenutniId;
				}
			}
			
			id++;
			
			ulazniServis.setId(Integer.toString(id));
		   
			outputStream.write(ulazniServis.toStringZaUpis().getBytes());
		    outputStream.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku servisi.txt");
		}		
	}
	
	public static void izmeniServis(Servis ulazniServis) {
		ArrayList<Servis> servisi = ucitajServise();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/servisi.txt", false);
			outputStream.write("".getBytes());
			for (Servis servis : servisi) {
				if(servis.getId().equals(ulazniServis.getId())) {
					outputStream.write(ulazniServis.toStringZaUpis().getBytes());
				} else {
					outputStream.write(servis.toStringZaUpis().getBytes());
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
