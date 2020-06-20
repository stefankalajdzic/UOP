package izlaz;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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


	public static ArrayList<Deo> ucitajDelove(String[] prosledjeniDelovi) {
		List<String> prosledjeniDeloviLista = Arrays.asList(prosledjeniDelovi);
		ArrayList<Deo> sviDelovi = RadSaDelovima.ucitajDelove();
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		
		for(Deo deo : sviDelovi) {
			if(prosledjeniDeloviLista.contains(deo.getId())) {
				delovi.add(deo);
			}
		}
		
		return delovi;
	}
}