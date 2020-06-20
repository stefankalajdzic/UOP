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

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import model.Deo;

public class RadSaDelovima {

	public static ArrayList<Deo> ucitajDelove() {
		
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		
		try {
			File file = new File("src/fajlovi/delovi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				MarkaAutomobila marka = MarkaAutomobila.values()[Integer.parseInt(lineSplit[1])];
				ModelAutomobila model = ModelAutomobila.values()[Integer.parseInt(lineSplit[2])];
				String naziv = lineSplit[3];
				Float cena = Float.parseFloat(lineSplit[4]);
				Boolean obrisan = Boolean.parseBoolean(lineSplit[5]);
				
				Deo deo = new Deo(id, marka, model, naziv, cena, obrisan);
				delovi.add(deo);
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja dela iz datoteke.");
			e.printStackTrace();
		}
		
		return delovi;
	}

	public static ArrayList<Deo> ucitajDelove(String[] ulazniDelovi) {
		List<String> prosledjeniDeloviLista = Arrays.asList(ulazniDelovi);
		ArrayList<Deo> sviDelovi = RadSaDelovima.ucitajDelove();
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		
		for(Deo deo : sviDelovi) {
			if(prosledjeniDeloviLista.contains(deo.getId())) {
				delovi.add(deo);
			}
		}
		
		return delovi;
	}
	
	public static Deo ucitajDeo(String ulazniId) {
		ArrayList<Deo> delovi = ucitajDelove();
		for(Deo deo : delovi) {
			if(deo.getId().equals(ulazniId)) {
				return deo;
			}
		}
		
		return null;
	}
	
	public static void dodajDeo(Deo ulazniDeo) {
		try {
			int id = 0;
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/delovi.txt", true);
			ArrayList<Deo> delovi = ucitajDelove();
			
			for(Deo deo : delovi) {
				int trenutniId = Integer.parseInt(deo.getId());
				if(trenutniId > id) {
					id = trenutniId;
				}
			}
			
			id++;
			
			ulazniDeo.setId(Integer.toString(id));
		    
			outputStream.write(ulazniDeo.toStringZaUpis().getBytes());
		    outputStream.close();
		} catch(IOException ex) {
			System.out.println("Greska prilikom upisa u datotoeku delovi.txt");
		}	
	}
	
	public static void izmeniDeo(Deo ulazniDeo) {
		ArrayList<Deo> delovi = ucitajDelove();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/delovi.txt", false);
			outputStream.write("".getBytes());
			for (Deo deo : delovi) {
				if(deo.getId().equals(ulazniDeo.getId())) {
					outputStream.write(ulazniDeo.toStringZaUpis().getBytes());
				} else {
					outputStream.write(deo.toStringZaUpis().getBytes());
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