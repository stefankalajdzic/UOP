package test;

import java.util.ArrayList;

import izlaz.UcitavanjeAdministratora;
import izlaz.UcitavanjeMusterija;
import izlaz.UcitavanjeServisera;
import modeli.Administrator;
import modeli.Musterija;
import modeli.Serviser;


public class Main {

	public static void main(String[] args) {
		
		ArrayList<Administrator> administratori = UcitavanjeAdministratora.ucitajAdministratore();
		ArrayList<Musterija> musterije = UcitavanjeMusterija.ucitajMusterije();
		ArrayList<Serviser> serviseri = UcitavanjeServisera.ucitajServisere();
		
		for (Administrator administrator : administratori) {
			System.out.println(administrator);
		}
		for (Musterija musterija : musterije) {
			System.out.println(musterija);
		}	
		for (Serviser serviser : serviseri) {
			System.out.println(serviser);
		}
		
		
		
		
	}

}
