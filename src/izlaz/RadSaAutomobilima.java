package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Gorivo;
import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import modeli.Automobil;
import modeli.ServisnaKnjizica;


public class RadSaAutomobilima {

	public static ArrayList<Automobil> ucitajAutomobile() {
		
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				String musterijinId = lineSplit[1];
				MarkaAutomobila marka = MarkaAutomobila.values()[Integer.parseInt(lineSplit[2])];
				ModelAutomobila model = ModelAutomobila.values()[Integer.parseInt(lineSplit[3])];
				String godinaProizvodnje = lineSplit[4];
				float zapreminaMotora = Float.parseFloat(lineSplit[5]);
				int snagaMotora = Integer.parseInt(lineSplit[6]);
				Gorivo vrstaGoriva = Gorivo.values()[Integer.parseInt(lineSplit[7])];
				ServisnaKnjizica knjizica = new ServisnaKnjizica();
				knjizica.setId(lineSplit[8]);
				Boolean obrisan = Boolean.parseBoolean(lineSplit[9]);
				
				Automobil automobil = new Automobil(id, musterijinId, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva, knjizica, obrisan);
				automobili.add(automobil);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja automobila iz datoteke.");
			e.printStackTrace();
		}
		
		return automobili;
	}
	
	public static Automobil ucitajAutomobil(String ulazniId) {
		ArrayList<Automobil> automobili = RadSaAutomobilima.ucitajAutomobile();
		for(Automobil automobil : automobili) {
			if(automobil.getId().equals(ulazniId)) {
				return automobil;
			}
		}
		
		return null;
	}

	public static void dodajAutomobil(Automobil automobil) {
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/automobili.txt", true);
		    outputStream.write(automobil.toStringZaUpis().getBytes());
		    outputStream.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku automobili.txt");
		}
	}
	
	public static void izmeniAutomobil(Automobil ulazniAutomobil) {
		ArrayList<Automobil> automobili = RadSaAutomobilima.ucitajAutomobile();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/automobili.txt", false);
			outputStream.write("".getBytes());
			for (Automobil automobil : automobili) {
				if(automobil.getId().equals(ulazniAutomobil.getId())) {
					outputStream.write(ulazniAutomobil.toStringZaUpis().getBytes());
				} else {
					outputStream.write(automobil.toStringZaUpis().getBytes());
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
