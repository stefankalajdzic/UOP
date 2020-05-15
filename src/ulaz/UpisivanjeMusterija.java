package ulaz;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class UpisivanjeMusterija {
	
	public static void snimiPodatke(String ime, String prezime, String korisnickoIme, String sifra) {
		String prethodniSadrzaj = ucitajSadrzaj("src/fajlovi/musterije.txt");
		String noviSadrzaj = "\n" + ime + "|" + prezime + "|" + korisnickoIme + "|" + sifra;
		try {
			File korisniciFile = new File("src/txt/korisnici.txt");
			BufferedWriter writer = new BufferedWriter(new FileWriter(korisniciFile));
			writer.write(prethodniSadrzaj + noviSadrzaj);
			writer.close();
			System.out.println("Uspesno ste se registrovali!");
		}catch(IOException e) {
			System.out.println("Greska prilikom upisa u datotoeku korisnici.txt");
		}
	}
	
	public static String ucitajSadrzaj(String putanja) {
		String sadrzaj = "";
		try {
			File file = new File(putanja);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				sadrzaj += line + "\n";
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska prilikom citanja datoteke " + putanja);
		}
		return sadrzaj;
	}
}