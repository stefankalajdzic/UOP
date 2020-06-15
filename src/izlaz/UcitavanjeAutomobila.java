package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import enumeracije.Pol;
import modeli.Automobil;
import modeli.Musterija;
import modeli.ServisnaKnjizica;


public class UcitavanjeAutomobila {

	public static ArrayList<Automobil> ucitajAutomobile() {
		
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		
		
		try {
			File file = new File("src/fajlovi/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] lineSplit = line.split("\\|");
				
				String id = lineSplit[0];
				Musterija vlasnik = new Musterija();
				MarkaAutomobila marka = MarkaAutomobila.valueOf(lineSplit[2]);
				ModelAutomobila model = ModelAutomobila.valueOf(lineSplit[3]);
				String godinaProizvodnje = lineSplit[4];
				float zapreminaMotora = Float.parseFloat(lineSplit[5]);
				int snagaMotora = Integer.parseInt(lineSplit[6]);
				String vrstaGoriva = lineSplit[8];
				ServisnaKnjizica knjizica = new ServisnaKnjizica();
				knjizica.setIdentifikator(lineSplit[9]);
				/*for(ServisnaKnjizica sk : servisneKnjizice) {
					if(sk.getIdentifikator().equals(lineSplit[9])) {
						knjizica = sk;
					}
				}*/
				
				
				//Servisna knjizica id
				
				Automobil automobil = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva, knjizica);
				automobili.add(automobil);
				
			}
			reader.close();
		} catch (IOException e) {
			System.out.println("Greska prilikom citanja korisnika iz datoteke.");
			e.printStackTrace();
		}
		
		return automobili;
	}
	
}
