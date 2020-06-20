package izlaz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Administrator;
import model.ServisnaKnjizica;

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
	
	public static ServisnaKnjizica ucitajServisnuKnjizicu(String ulazniId) {
		ArrayList<ServisnaKnjizica> servisneKnjizice = ucitajServisneKnjizice();
		for(ServisnaKnjizica servisnaKnjizica : servisneKnjizice) {
			if(servisnaKnjizica.getId().equals(ulazniId)) {
				return servisnaKnjizica;
			}
		}
		
		return null;
	}
	
	public static void dodajServisnuKnjizicu(ServisnaKnjizica ulaznaServisnaKnjizica) {
		try {
			int id = 0;
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/servisneknjizice.txt", true);
			ArrayList<ServisnaKnjizica> servisneKnjizice = ucitajServisneKnjizice();
			
			for(ServisnaKnjizica servisnaKnjizica : servisneKnjizice) {
				int trenutniId = Integer.parseInt(servisnaKnjizica.getId());
				if(trenutniId > id) {
					id = trenutniId;
				}
			}
			
			id++;
			
			ulaznaServisnaKnjizica.setId(Integer.toString(id));
			
		    outputStream.write(ulaznaServisnaKnjizica.toStringZaUpis().getBytes());
		    outputStream.close();
		} catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku servisneknjizice.txt");
		}
}
	
	public static void izmeniServisnuKnjizicu(ServisnaKnjizica ulaznaServisnaKnjizica) {
		ArrayList<ServisnaKnjizica> servisneKnjizice = ucitajServisneKnjizice();
		try {
			FileOutputStream outputStream = new FileOutputStream("src/fajlovi/servisneknjizice.txt", false);
			outputStream.write("".getBytes());
			for (ServisnaKnjizica servisnaKnjizica : servisneKnjizice) {
				if(servisnaKnjizica.getId().equals(ulaznaServisnaKnjizica.getId())) {
					outputStream.write(ulaznaServisnaKnjizica.toStringZaUpis().getBytes());
				} else {
					outputStream.write(servisnaKnjizica.toStringZaUpis().getBytes());
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